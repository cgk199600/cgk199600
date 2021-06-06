<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/user/add.do" method="post">
用户名：<input type="text" name="username">
密码：<input type="text" name="password">
是否保存:<input type="radio" name="preserve" value="1">是<input type="radio" name="preserve" value="0">否
<input type="submit" value="提交">
</form>

</body>
</html>