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
<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">查看</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit" id="update">编辑</a>
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
			  type:2,//页面类型
			  title:'添加菜单 ',
			  content:"<%=request.getContextPath() %>/users/toAdd.do",//跳转的路径
			  area:['1000px','500px'],
			  shadeClose:true//点空白可关闭窗口
			
		  })
	  })
	  //第一个实例
	  table.render({
	    elem: '#demo'
	    ,width:1200
	    ,height: 312
	    ,url: '<%=request.getContextPath() %>/users/getListdata.do' //数据接口
	    ,page:true
	    ,id:'reloadId'
	    ,cols: [[ //表头
	      {field: 'id',hide:true, title: 'ID', width:80, sort: true, fixed: 'left'}
	      ,{field: 'name', title: '用户名', width:80}
	      ,{field: 'sex', title: '性别', width:80, sort: true}
	      ,{field: 'addr', title: '地址 ', width:80} 
	      ,{fixed: 'phone', title:'电话 ',width:80}
	      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:180, }
	    ]]
	  });
	  
		//监听工具条 
		  table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
			  var data = obj.data;
		   
		     if(obj.event === 'del'){ //删除
		      layer.confirm('真的删除行么', function(index){
		        $.ajax({
		        	type:"post",
		        url:"<%=request.getContextPath() %>/users/delete.do",
		        
		        data:{id:data.id},//穿入删除的ID
		        dataType:"json",
		        successs:function(data){
		        	if(data.code==0){
		        		layer.close(index);
		        		table.reload('reloadId',{page:{curr:1}});//根据ID刷新
		        	}
		        }
		        })
		      });
		    } else if(obj.event === 'edit'){ //编辑
		    	
		  		  layer.open({
		  			  type:2,//页面类型
		  			  title:'添加菜单 ',
		  			  content:"<%=request.getContextPath() %>/update.jsp?id="+data.id,//跳转的路径
		  			  area:['1000px','500px'],
		  			  shadeClose:true//点空白可关闭窗口
		  			
		  		  })
<%-- 		      location.href="<%=request.getContextPath() %>/update.jsp?id="+data.id;/*不通过controller跳转  */
 --%>	    } 
	  });
	});
</script>

</body>
</html>