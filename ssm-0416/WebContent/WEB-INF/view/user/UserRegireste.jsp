<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${root }/user/AddUser" method="Post">
	用户名<input type="text" name="name" >
	密码<input type="password" name="password">
	邮箱:<input type="text" name="emails">
	<input type="submit" value="注册">
</form>

</body>
</html>