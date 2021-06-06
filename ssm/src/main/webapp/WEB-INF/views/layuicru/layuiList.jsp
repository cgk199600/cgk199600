<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/layui/layui/css/layui.css" media="all">
<script type="text/javascript" src="<%=request.getContextPath() %>/layui/layui/layui.js"></script>
</head>
<body>
 <button type="button" id="add" class="layui-btn layui-btn-primary layui-btn-sm">添加</button>
<table id="demo" lay-filter="test"></table>
<script type="text/html" id="barDemo">
<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="detail">查看</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</body>
<script type="text/javascript">
layui.use(['table','jquery','layer'], function(){
	  var table = layui.table;
	  $= layui.jquery;
	  layer=layui.layer;
	  
	  $('#add').click(function(){
		  layer.open({
			  type:2,//ifream嵌套一个页面，点击打开
			  title:'添加菜单 ',
			  content:"<%=request.getContextPath() %>/user/layuiadd.do",//跳转到哪里
			  area:['500px','300px'],
			  shadeClose:true//点空白可关闭窗口
		  })
	  })
	  //第一个实例
	  table.render({
	    elem: '#demo'
	    ,id:"reloadId"
	    ,width:1200
	    ,height: 312
	    ,url: '<%=request.getContextPath() %>/user/getJson.do' //数据接口
	    ,page:true
	    
	    ,cols: [[ //表头
	      {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
	      ,{field: 'username', title: '用户名', width:80}
	      ,{field: 'password', title: '密码', width:80, sort: true}
	      ,{field: 'preserve', title: '是否记录', width:80} 
	      ,{fixed: 'right', title:'操作', toolbar: '#barDemo',width:180} 
	    ]]
	  });
	  
	//监听工具条 
	  table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
	    var data = obj.data; //获得当前行数据
	    var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
	    var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）
	   
	    if(layEvent === 'detail'){ //查看
	      //do somehing
	      layer.msg('ID'+data.id+'的查看操作 ');
	    } else if(layEvent === 'del'){ //删除
	      layer.confirm('真的删除行么', function(index){
	    	  $.ajax({
	    			type:"post",
	    			url:"<%=request.getContextPath() %>/user/delete.do",
	    			data:{"id":data.id},//当前行的id
	    			dataType:"json",
	    			success:function(data){
	    			console.log(data);	
	    			}
	    	    })
	        obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
	        layer.close(index);
	        //向服务端发送删除指令
	      });
	    } else if(layEvent === 'edit'){ //编辑
	      //do something
	      //layer.alert('编辑行:<br>'+JSON.stringify(data))
	      
	      layer.open({
			  type:2,//ifream嵌套一个页面，点击打开
			  title:'修改菜单 ',
			  content:"<%=request.getContextPath() %>/user/layuiUpdate.do?id="+data.id,//带着id跳转到更改页面
			  area:['500px','300px'],
			  shadeClose:true//点空白可关闭窗口
		  })
	      //同步更新缓存对应的值
	      /* obj.update({
	        username: '123'
	        ,title: 'xxx'
	      }); */
	    } 
	  });
	});
</script>
</html>"