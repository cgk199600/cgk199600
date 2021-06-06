<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/layui/layui/css/layui.css" media="all">
<script type="text/javascript" src="<%=request.getContextPath() %>/layui/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.3.js"></script>
</head>
<body>
<form class="layui-form" id="userform">
  <div class="layui-form-item">
    <label class="layui-form-label">请输入用户名</label>
    <div class="layui-input-block">                    
      <input type="text" name="username" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">请输入密码</label>
    <div class="layui-input-inline"><!-- //required验证后面加上number验证数字 -->
      <input type="password" name="password" required lay-verify="required/number" placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
   
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">是否记住</label>
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
			if(data.code==0){
				var index=parent.layer.getFrameIndex(window.name);//获取父级弹出页index
				parent.layer.close(index);//关闭弹窗
				parent.layui.table.reload("reloadId",
						{page:{curr:1}}//重新从第 1 页开始
				);
			}else{
				layer.msg(data.msg,{
					icon: 5,
					time: 500//2秒关闭，如果不配置
				})
			}
			
		}
    })
    return false;//不提交
  });
});
</script>
</html>