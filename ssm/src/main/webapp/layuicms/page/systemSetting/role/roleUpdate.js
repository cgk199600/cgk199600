layui.use(['form','layer'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
    
    selectdata();//调用方法
    function selectdata() {//先在List.js中付给隐藏域得ID值，再在update。js中取到进行赋值
    	var id=location.href.split("=")[1];//截取到menuList.js中的弹出页面时传入的ID
    	 $.ajax({
   	 type:"post",
   	 url:"/ssm/role/getdataByid.do",
   	 data:{"id":id},
   	 dataType:"json",
   	 success:function(data){
   		form.val("formFilter",{//取到form中的值赋值回显(form是根据lay-filter拿赋值是根据name赋值)
   			"id":data.data.id,
   			"rolename":data.data.rolename,
   			"status":data.data.status,
   			"ids":data.data.ids,
   			"mName":data.data.mName
   			
   		});
   		form.render()
   		 
   	 }
      })
	}
   
    var setting = {//定义setting
    		
    		check: {//开启选择框的样式
    			enable: true,
    			
    		},
		view: {
			selectedMulti: true//设置是否允许同时选中多个节点
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
    function loadztree(){//加载树状图
    $.ajax({
    	type:"post",
    	url:"/ssm/menu/getDataByRoleid.do",
    	data:{"roleid":$('#id').val()},//获取id的值传入
    	dataType:"json",
    	success:function(data){
    		$.fn.zTree.init($("#tree"), setting, data.data);
    		$.fn.zTree.getZTreeObj("tree").expandAll(true);//把打开树状图菜单式默认吧选中的都打开
    	}
    })
    }
    
    $('#mName').click(function() {
    	loadztree();//调用树状的方法
    	layui.layer.open({//弹出树状菜单
        	type: 1,
        	title:"上级菜单",
        	offset: 'auto',
        	content:$('#tree'),
        	shade: 0,
        	area: ['300px', '300px']
    		,btn: ['确定', '取消']
    		,yes: function(index, layero){
    	    //按钮【按钮一】的回调
    		var treeObj = $.fn.zTree.getZTreeObj("tree");//获取到勾选当前选中的节点
    		var nodes = treeObj.getSelectedNodes(true);
    		var ids="";
    		var mName="";
    		for (var i = 0; i < nodes.length; i++) {//把获取到的节点数据循环遍历
				ids+=nodes[i].id+",";
				mName+=nodes[i].title+"|";
				
			}
    		//mName.substring(0,mName.length-1)//通过截取方法截取没有|的值
    		$("#mName").val(mName.substring(0,mName.length-1));//赋值到只读的状态框
    		$("#ids").val(ids.substring(0,ids.length-1));
    		layui.layer.close(layui.layer,index);
    	  }
    	  ,btn2: function(index, layero){
    	    //按钮【按钮二】的回调
    		  layui.layer.close(layui.layer,index);
    	    //return false 开启该代码可禁止点击该按钮关闭
    	  }
        })
	})
    
    form.on("submit(UpdateObj)",function(data){
        //弹出loading
    	var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
    	$.ajax({
    		type:"post",
    		url:"/ssm/role/update.do",
    		data:$('#roleform').serialize(),
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