layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    //用户列表
    var tableIns = table.render({
        elem: '#userList',//通过ID获取到页面表格
        url : '../../json/userList.json',//通过json获取数据
        cellMinWidth : 95,//最小宽度
        page : true,//分页启用
        height : "full-125",//高度满的
        limits : [10,15,20,25],//分页参数，几行几行分页
        limit : 20,
        id : "userListTable",//给表格起名
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'userName', title: '用户名', minWidth:100, align:"center"},
            {field: 'userEmail', title: '用户邮箱', minWidth:200, align:'center',templet:function(d){
                return '<a class="layui-blue" href="mailto:'+d.userEmail+'">'+d.userEmail+'</a>';//去json中拿email格式
            }},
            {field: 'userSex', title: '用户性别', align:'center'},
            {field: 'userStatus', title: '用户状态',  align:'center',templet:function(d){
                return d.userStatus == "0" ? "正常使用" : "限制使用";
            }},
            {field: 'userGrade', title: '用户等级', align:'center',templet:function(d){
                if(d.userGrade == "0"){
                    return "注册会员";
                }else if(d.userGrade == "1"){
                    return "中级会员";
                }else if(d.userGrade == "2"){
                    return "高级会员";
                }else if(d.userGrade == "3"){
                    return "钻石会员";
                }else if(d.userGrade == "4"){
                    return "超级会员";
                }
            }},
            {field: 'userEndTime', title: '最后登录时间', align:'center',minWidth:150},
            {title: '操作', minWidth:175, templet:'#userListBar',fixed:"right",align:"center"}
        ]]
    });

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''){//搜索条件为空
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
    function addUser(edit){
        var index = layui.layer.open({//这里用layui.layer是为了防止layer可能用父级layer确保本页面的layer
            title : "添加用户",
            type : 2,
            content : "userAdd.jsp",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);//展示弹出jsp中内容
                if(edit){//如果是编辑要求就回显数据
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
        window.sessionStorage.setItem("index",index);//sessionStorage前端缓存信息的使用
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(window.sessionStorage.getItem("index"));
        })
    }
    $(".addNews_btn").click(function(){
        addUser();
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

    //列表操作
    table.on('tool(userList)', function(obj){
        var layEvent = obj.event,//事件
            data = obj.data;//数据

        if(layEvent === 'edit'){ //编辑和add
            addUser(data);
        }else if(layEvent === 'usable'){ //启用禁用
            var _this = $(this),
                usableText = "是否确定禁用此用户？",
                btnText = "已禁用";
                color="layui-btn-disabled";//添加禁用颜色
                _this.removeClass("layui-btn layui-btn-warm");//删除启用样式
            if(_this.text()=="已禁用"){
                usableText = "是否确定启用此用户？",
                btnText = "已启用";
                color="layui-btn-warm";//添加启用样式，黄色按钮
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
