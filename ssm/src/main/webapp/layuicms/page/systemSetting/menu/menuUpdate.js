layui.use(['form','layer'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
    
    selectdata();//调用方法
    function selectdata() {//先在List.js中付给隐藏域得ID值，再在update。js中取到进行赋值
    	var id=location.href.split("=")[1];//截取到menuList.js中的弹出页面时传入的ID
    	 $.ajax({
   	 type:"post",
   	 url:"/ssm/menu/getdataByid.do",
   	 data:{"id":id},
   	 dataType:"json",
   	 success:function(data){
   		form.val("formFilter",{//取到form中的值赋值回显(form是根据lay-filter拿赋值是根据name赋值)
   			"id":data.data.id,
   			"title":data.data.title,
   			"href":data.data.href,
   			"pid":data.data.pid,
   			"status":data.data.status,
   			"pName":data.data.pName
   		});
   		form.render()
   		 
   	 }
      })
	}
    function zTreeOnClick(event, treeId, treeNode) {
        $('#pid').val(treeNode.id);//被点击的节点 JSON 数据对象的ID
        $('#pName').val(treeNode.title);//被点击的节点 JSON 数据对象的name
    };
    function zTreeOnDblClick(event, treeId, treeNode) {
    	layui.layer.close(layui.layer.index);//双击后关闭弹出层
    };
    var setting = {//定义setting
    		callback: {//点击上级菜单的选项后
    			onClick: zTreeOnClick,//鼠标单击后的方法
    			onDblClick: zTreeOnDblClick//鼠标双击后的方法
    		},
    		check: {//开启选择框的样式
    			enable: true,
    			chkStyle:'checkbox',//样式设置为checkbox 复选框 也可以设置为单选框 radioButton
    		},
		view: {
			selectedMulti: false//设置是否允许同时选中多个节点
		},
	
	data: {
		key: {
			name: "title"
		},//zTree 节点数据保存节点名称的属性名称
		simpleData: {
			enable: true,
			idKey: "id",
			pIdKey: "pid",
			rootPId: 0//上级默认一级
		}
	}
    }
    function loadztree(){
    $.ajax({
    	type:"post",
    	url:"/ssm/menu/getztreeList.do",
    	dataType:"json",
    	success:function(data){
    		$.fn.zTree.init($("#tree"), setting, data.data);
    	}
    })
    }
    
    $('#pName').click(function() {
    	loadztree();//调用树状的方法
    	layui.layer.open({//弹出树状菜单
        	type: 1,
        	title:"上级菜单",
        	offset: 'auto',
        	content:$('#tree'),
        	shade: 0,
        	area: ['300px', '300px']
        })
	})
    
    form.on("submit(addObj)",function(data){
        //弹出loading
    	var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
    	$.ajax({
    		type:"post",
    		url:"/ssm/menu/update.do",
    		data:$('#menuform').serialize(),
    		dataType:"json",
    		success:function(data){
    			if(data.code==0){//添加成功显示成功的msg
    			setTimeout(function(){
    	            top.layer.close(index);
    	            top.layer.msg(data.msg);
    	            layer.closeAll("iframe");
    	            //刷新父页面
    	            parent.location.reload();
    	        },2000);
    		}else{
    			top.layer.msg(data.msg);
    		}
    	}
    		})
        return false;
    })

    //格式化时间
    function filterTime(val){
        if(val < 10){
            return "0" + val;
        }else{
            return val;
        }
    }
    //定时发布
    var time = new Date();
    var submitTime = time.getFullYear()+'-'+filterTime(time.getMonth()+1)+'-'+filterTime(time.getDate())+' '+filterTime(time.getHours())+':'+filterTime(time.getMinutes())+':'+filterTime(time.getSeconds());

})