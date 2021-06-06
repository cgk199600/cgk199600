<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/webapp/layuicms/css/layui.css" media="all">
<script type="text/javascript" src="<%=request.getContextPath() %>/webapp/layuicms/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/webapp/js/jquery-1.8.3.js"></script>

</head>
<body>
<form class="layui-form" id="userfrom">
  <div class="layui-form-item">
    <label class="layui-form-label">输入框</label>
    <div class="layui-input-block">                    
      <input type="text" name="username" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">密码框</label>
    <div class="layui-input-inline"><!-- //required验证后面加上number验证数字 -->
      <input type="password" name="password" required lay-verify="required/number" placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
    <div class="layui-form-mid layui-word-aux">辅助文字</div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">单选框</label>
    <div class="layui-input-block">
      <input type="radio" name="preserve" value="0" title="是">
      <input type="radio" name="preserve" value="1" title="否" checked>
    </div>
  </div>
  
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>
 

      



</body>
<script type="text/javascript">
//Demo
layui.use('form', function(){
  var form = layui.form;//是用来监听开关和下拉列表等的，没有定义则开启不了这些功能
  $ = layui.jquery;
  //监听提交
  form.on('submit(formDemo)', function(data){
    layer.msg(JSON.stringify(data.field));//拿到整个表单中所有的name和属性
    $.ajax({
		type:"post",
		url:"<%=request.getContextPath() %>/user/form.do",
		data:$('#userform').serialize(),//取到formID中的序列化数据
		dataType:"json",
		success:function(data){
		console.log(data);	
		}
    })
    return false;//不提交
  });
});
</script>
</html>