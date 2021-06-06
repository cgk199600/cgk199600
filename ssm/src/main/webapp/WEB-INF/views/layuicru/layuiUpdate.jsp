<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="<%=request.getContextPath() %>/layui/layui/css/layui.css" media="all">
<script type="text/javascript" src="<%=request.getContextPath() %>/layui/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.3.js"></script>
<body>
<form class="layui-form" lay-filter="formTest" id="userform"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
  <div class="layui-form-item">
    <label class="layui-form-label">用户名</label>
    <div class="layui-input-block">
    <input type="hidden" name="id">
      <input type="text" name="username" placeholder="请输入用户名"   autocomplete="off" class="layui-input">
    </div>
  </div>
 <div class="layui-form-item">
    <label class="layui-form-label">请输入密码</label>
    <div class="layui-input-inline"><!-- //required验证后面加上number验证数字 -->
      <input type="password" name="password" required lay-verify="required/number"  placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
   
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="formdemo">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
  <!-- 更多表单结构排版请移步文档左侧【页面元素-表单】一项阅览 -->
</form>

<script>
layui.use('form', function(){
	var form = layui.form;
	 $=layui.jquery;
	 initGetData();
	function initGetData(){
		console.log(location.href);//获取当前路径
		var id=location.href.split("=")[1];//截取路径上的id
		$.ajax({
			type:"post",
			url:"<%=request.getContextPath() %>/user/layuigetByid.do",
			data:{"id":id},
			dataType:"json",
			success:function(data){
				console.log(data);
				//给表单赋值
				form.val("formTest", { //formTest 即 form表单中 所在元素属性 lay-filter="" 对应的值
				  "username": data.data.username // "name": "value"	 
				  ,"password": data.data.password
				  ,"id":data.data.id
				});
			}
		})
	}
  
  form.on('submit(formdemo)',function(data){
	 
	  $.ajax({
			type:"post",
			url:"<%=request.getContextPath() %>/user/layuitoUpdate.do",
			data:$('#userform').serialize(),//取到formID中的序列化数据
			dataType:"json",
			success:function(data){
			console.log(data);	
			if(data.code==0){
				layer.msg(data.msg);
				var index=parent.layer.getFrameIndex(window.name);//获取父级弹出页index
				parent.layer.close(index);//关闭弹窗
				parent.layui.table.reload("reloadId",
						{page:{curr:1}}//重新从第 1 页开始,根据id刷新页面
				);
			}else{
				layer.msg(data.msg,{
					icon: 5,
					time: 500//2秒关闭，如果不配置
				})
			}
			}
	    })
  })
 
  //各种基于事件的操作，下面会有进一步介绍
});
</script>
</body>
</html>