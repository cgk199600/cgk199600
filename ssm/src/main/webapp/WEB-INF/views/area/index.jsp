<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.3.js"></script>
<title>Insert title here</title>

</head>
<body>
<!--省  -->
<select id="province">
<option value="">请选择。。</option>
<c:forEach items="${list}" var="province">
<option value="${province.province_id}">${province.province_name}</option>
</c:forEach>
</select>
<!-- 市 -->
<select id="city">
<option value=''>请选择...</option>
</select>
<!--区  -->
<select id="area">
<option value=''>请选择...</option>
</select>
</body>
<script type="text/javascript">
//切换省显示市
$(function(){
	$('#province').change(function() {
		$.ajax({
			type:"post",
			url:"<%=request.getContextPath() %>/area/getCity.do",
			data:{"province_id":$("#province").val()},//传入province下的province_id
			dataType:"json",
			success:function(data){
				//console.log(data);用于输出数据
				var str="<option value=''>请选择...</option>";
				for (var i = 0; i < data.data.length; i++) {//这里data.data才真正取到值
					str+="<option value='"+data.data[i].city_id+"'>"+data.data[i].city_name+"</option>"
					
				}
				$("#city").html(str);//这里用html是替换数据不能用append
				$("#area").html("<option value=''>请选择...</option>");
			}
		})
		
		
	})
	$('#city').change(function() {
		$.ajax({
			type:"post",
			url:"<%=request.getContextPath() %>/area/getArea.do",
			data:{"city_id":$("#city").val()},
			dataType:"json",
			success:function(data){
				//console.log(data);用于输出数据
				var str="<option value=''>请选择...</option>";
				for (var i = 0; i < data.data.length; i++) {//这里data.data才真正取到值
					str+="<option value='"+data.data[i].area_id+"'>"+data.data[i].area_name+"</option>"
					
				}
				$("#area").html(str);//这里用html是替换数据不能用append
			}
		})
		
		
	})
})

	

</script>
</html>