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
<form class="layui-form" id="userfrom">
   <div class="layui-form-item">
    <label class="layui-form-label">姓名</label>
    <div class="layui-input-block">
      <input type="text" name="name" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">性别</label>
    <div class="layui-input-block">
      <input type="radio" name="sex" value="1" title="男">
      <input type="radio" name="sex" value="0" title="女" checked>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">手机号码</label>
    <div class="layui-input-block"><!--required|phone|number验证电话  -->
      <input type="text" name="phone" required  lay-verify="required|phone|number" placeholder="请输入手机号码" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">邮箱</label>
    <div class="layui-input-block"><!--验证email  -->
      <input type="text" name="email" required  lay-verify="required|email" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">联动选择框</label>
    <input type="hidden" name="addr" id="addr" /><!--以便获取省市区联动的值 required lay-verify="required"必填  -->
    <div class="layui-input-inline">
      <select id="province" lay-filter="province" required lay-verify="required">
        <option value="">请选择省</option>
      </select>
    </div>
    <div class="layui-input-inline">
      <select id="city" lay-filter="city" required lay-verify="required">
        <option value="">请选择市</option>
      </select>
    </div>
    <div class="layui-input-inline">
      <select id="area" required lay-verify="required">
        <option value="">请选择县/区</option>
      </select>
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
 layui.use(['form','layer'], function(){
	  var form = layui.form,
	  $ = layui.jquery;
	  
	  initProvince();
	  
	  function initProvince(){
		  $.ajax({
			  type:"post",//请求格式
			  url:"<%=request.getContextPath()%>/users/getProvince.do",//请求地址
			  dataType:"json",//返回数据格式
			  success:function(data){//成功请求到后端，后端返回给前端内容data
				  var str = "<option value=''>请选择省</option>";
				  for(var i=0; i<data.length; i++){
					  str += "<option value='"+data[i].province_id+"'>"+data[i].province_name+"</option>";
				  }
				  $('#province').html(str);
				  form.render();
			  }
		  })
	  }
	  
	  //监听省下拉菜单发生的改变并对城市下拉菜单进行赋值
	  form.on('select(province)', function(data){//监听的是lay-filter
		  $.ajax({
			  type:"post",//请求格式
			  url:"<%=request.getContextPath()%>/users/getCity.do",//请求地址
			  data:{"province_id":data.value},//data.value得到被选中的值
			  dataType:"json",//返回数据格式
			  success:function(data){//成功请求到后端，后端返回给前端内容data
				  var str = "<option value=''>请选择城市</option>";
				  for(var i=0;i<data.data.length; i++){
					  str += "<option value='"+data.data[i].city_id+"'>"+data.data[i].city_name+"</option>";
				  }
				  $('#city').html(str);
				  form.render();//重新加载
			  }
		  })
	  });  
	  
	  //监听城市下拉菜单发生的改变并对区/县下拉菜单进行赋值
	  form.on('select(city)', function(data){
		  $.ajax({
			  type:"post",//请求格式
			  url:"<%=request.getContextPath()%>/users/getArea.do",//请求地址
			  data:{"city_id":data.value},
			  dataType:"json",//返回数据格式
			  success:function(data){//成功请求到后端，后端返回给前端内容data
				  var str = "<option value=''>请选择区/县</option>";
				  for(var i=0;i<data.data.length;i++){
					  str += "<option value='"+data.data[i].area_id+"'>"+data.data[i].area_name+"</option>";
				  }
				  $('#area').html(str);
				  form.render();
			  }
		  })
	  });  
	  
	//监听提交
	  form.on('submit(formDemo)', function(data){
		  var addr = $('#province').find("option:selected").text()+
		  $('#city').find("option:selected").text()+
		  $('#area').find("option:selected").text();
		  $('#addr').val(addr);//通过ID获取省市区联动值付给隐藏域
	    $.ajax({
	    	type:"post",
	    	url:"<%=request.getContextPath()%>/users/add.do",
	    	data:$('#userform').serialize(),
	    	dataType:"json",
	    	success:function(data){
	    		if(data.code == 0){
	    			layer.msg(data.msg);//弹出成功与否
	    			var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		    		parent.layer.close(index);//关闭索引所在层
		    		parent.layui.table.reload('reloadId',{page:{curr:1}});//刷新表格根据表格加载中的ID刷新并再分页
	    		}else{
	    			layer.msg(data.msg, {//关闭页面
		    			  icon: 5,//添加失败出现个哭脸
		    			  time: 1500 //2秒关闭（如果不配置，默认是3秒）
		    			}, function(){
		    			  
		    		});
	    		}
	    	}
	    })
	    return false;
	  });
	});
 <%-- layui.use(['form','layer'], function(){
  var form = layui.form;//是用来监听开关和下拉列表等的，没有定义则开启不了这些功能
  $ = layui.jquery;
  //监听提交
  initfunction();
  function initProvince(){
	  $.ajax({
		  type:"post",//请求格式
		  url:"<%=request.getContextPath()%>/users/getProvince.do",//请求地址
		  dataType:"json",//返回数据格式
		  success:function(data){//成功请求到后端，后端返回给前端内容data
			  var str = "<option value=''>请选择省</option>";
			  for(var i=0; i<data.length; i++){
				  str += "<option value='"+data[i].province_id+"'>"+data[i].province_name+"</option>";
			  }
			  $('#province').html(str);
			  form.render();
		  }
	  })
  }
  form.on("select(province)",function(data){
	  $.ajax({
		  type:"post",
		  url:"<%=request.getContextPath() %>/users/getCity.do",
		  data:{"province_id":data.value},
		  dataType:"json",
		  success:function(data){
			  var str="<option value=''>清选择。。。 </option>";
			  for ( var i=0; i<data.data.length;i++) {
				str+="<option value='"data.data[i].city_id"'>"+data.data[i].city_name+"</option>";
				
			}
			  $('#city').html(str);
			 form.render();
		  }
	  })
  })
  form.on("select(city)",function(data){
	  $.ajax({
		  type:"post",
		  url:"<%=request.getContextPath() %>/users/getArea.do",
		  data:{"area_id":data.value},
		  dataType:"json",
		  success:function(data){
			  var str="<option value=''>清选择。。。 </option>";
			  for ( var i=0; i<data.data.length;i++) {
				str+="<option value='"data.data[i].area_id"'>"+data.data[i].area_name+"</option>";
				
			}
			  $('#area').html(str);
			 form.render();
		  }
	  })
  })
  
  form.on('submit(formDemo)', function(data){
	  var addr=$("#province").find("option.selected").text()+$("#city").find("option.selected").text
	  +$("#area").find("option.selected").text;
	  $("#addr").val(addr);
   // layer.msg(JSON.stringify(data.field));//拿到整个表单中所有的name和属性
    $.ajax({
		type:"post",
		url:"<%=request.getContextPath() %>/users/add.do",
		data:$('#userform').serialize(),//取到formID中的序列化数据
		dataType:"json",
		success:function(data){
			layer.msg(data.msg);
			var index=parent.layer.getFrameIndex(window.name);
			parent.layer.close();
			parent.layui.table.reload('reloadId',{page:{curr:1}});
		//console.log(data);	
		}else{
			layer.msg(data.msg, {//关闭页面
  			  icon: 5,//添加失败出现个哭脸
  			  time: 1500 //2秒关闭（如果不配置，默认是3秒）
  			}, function(){
  			  
  		});
		}
    })
    return false;//不提交
  });
});  --%>
</script>
</html>