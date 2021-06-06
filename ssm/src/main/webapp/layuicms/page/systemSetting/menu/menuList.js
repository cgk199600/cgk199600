layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;
    
    function zTreeOnClick(event, treeId, treeNode) {//定义单击树状图后的选项的方法(右边的数据会刷新)
    	table.reload("reloadListTable",{//userListTable指的是ID
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
                  "pid": treeNode.id  //搜索的关键字
            }
        })
    };
    loadztree();
    var setting = {//定义setting
    		callback: {//点击上级菜单的选项后
    			onClick: zTreeOnClick,//鼠标单击后的方法
    		},
		view: {
			selectedMulti: false//设置是否允许同时选中多个节点
		},
	
	data: {
		key: {
			name: "title"//直接赋值title到树状图
		},//zTree 节点数据保存节点名称的属性名称
		simpleData: {
			enable: true,
			idKey: "id",
			pIdKey: "pid",
			rootPId: 0//上级默认一级
		}
	}
    }
    function loadztree(){//用以显示左边区域的树状图
    $.ajax({
    	type:"post",
    	url:"/ssm/menu/getztreeList.do",
    	dataType:"json",
    	success:function(data){
    		$.fn.zTree.init($("#tree"), setting, data.data);//设置setting只让其显示数据中的title
    	}
    })
    }
    
    //用户列表
    var tableIns = table.render({
        elem: '#menuList',//通过ID获取到页面表格
        url : '/ssm/menu/gettableList.do',//通过json获取数据
        cellMinWidth : 95,//最小宽度
        page : true,
        height : "full-125",//高度满的
        limits : [10,15,20,25],
        limit : 20,
        id : "reloadListTable",//给表格起名
        cols : [[
            {field: 'title', title: '标题', minWidth:100, align:"center"},
            {field: 'href', title: '地址', minWidth:200, align:'center'},         
            {field: 'status', title: '用户状态',  align:'center',templet:function(d){
                return d.userStatus == "0" ? "启用" : "禁止";
            }},            
            {title: '操作', minWidth:175, templet:'#menuListBar',fixed:"right",align:"center"}
        ]]
    });

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''){
            table.reload("userListTable",{//userListTable指的是ID
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    key: $(".searchVal").val()  //搜索的关键字
                }
            })
        }else{
            layer.msg("请输入搜索的内容");
        }
    });

    //添加用户
    function addObj(edit){
        var index = layui.layer.open({//这里用layui.layer是为了防止layer可能用父级layer确保本页面的layer
            title : "添加用户",
            type : 2,
            content : "menuAdd.html",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".userName").val(edit.userName);  //登录名
                    body.find(".userEmail").val(edit.userEmail);  //邮箱
                    body.find(".userSex input[value="+edit.userSex+"]").prop("checked","checked");  //性别原型扩展
                    body.find(".userGrade").val(edit.userGrade);  //会员等级
                    body.find(".userStatus").val(edit.userStatus);    //用户状态
                    body.find(".userDesc").text(edit.userDesc);    //用户简介
                    form.render();
                }
                setTimeout(function(){//设置点击
                    layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            }
        })
        layui.layer.full(index);//设置弹出层最大化
        window.sessionStorage.setItem("index",index);//sessionStorage前段缓存信息的使用
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(window.sessionStorage.getItem("index"));
        })
    }
    $(".add_btn").click(function(){//通过layui-btn查找
        addObj();
    })

    //批量删除
    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('userListTable'),
            data = checkStatus.data,
            newsId = [];
        if(data.length > 0) {
            for (var i in data) {
                newsId.push(data[i].newsId);
            }
            layer.confirm('确定删除选中的用户？', {icon: 3, title: '提示信息'}, function (index) {
                // $.get("删除文章接口",{
                //     newsId : newsId  //将需要删除的newsId作为参数传入
                // },function(data){
                tableIns.reload();
                layer.close(index);
                // })
            })
        }else{
            layer.msg("请选择需要删除的用户");
        }
    })
    
    function updateObj(edit){//主页面
        var index = layui.layer.open({//这里用layui.layer是为了防止layer可能用父级layer确保本页面的layer
            title : "更改用户",
            type : 2,
            content : "menuUpdate.html?id="+edit.id,//页面开启时传入ID
            success : function(layero, index){
            
            }
        })
        setTimeout(function(){//设置点击
                    layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
        layui.layer.full(index);//设置弹出层最大化
        window.sessionStorage.setItem("index",index);//sessionStorage前段缓存信息的使用
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(window.sessionStorage.getItem("index"));
        })
    }
    //列表操作
    table.on('tool(userList)', function(obj){
        var layEvent = obj.event,//事件
            data = obj.data;//数据

        if(layEvent === 'edit'){ //编辑和add
        	updateObj(data);
        }else if(layEvent === 'usable'){ //启用禁用
            var _this = $(this),
                usableText = "是否确定禁用此用户？",
                btnText = "已禁用";
                color="layui-btn-disabled";//添加禁用颜色
                _this.removeClass("layui-btn layui-btn-warm");
            if(_this.text()=="已禁用"){
                usableText = "是否确定启用此用户？",
                btnText = "已启用";
                color="layui-btn-warm";//添加不禁用样式
                _this.removeClass("layui-btn-disabled");//删除不启用颜色
            }
            layer.confirm(usableText,{
                icon: 3,
                title:'系统提示',
                cancel : function(index){
                    layer.close(index);
                }
            },function(index){
                _this.text(btnText);
                _this.addClass(color);//无论成功与否设置颜色
                layer.close(index);
            },function(index){
                layer.close(index);
            });
        }else if(layEvent === 'del'){ //删除
            layer.confirm('确定删除此用户？',{icon:3, title:'提示信息'},function(index){
                // $.get("删除文章接口",{
                //     newsId : data.newsId  //将需要删除的newsId作为参数传入
                // },function(data){
                    tableIns.reload();
                    layer.close(index);
                // })
            });
        }
    });

})
