<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${root }/member/emails/regop" method="Post">
<input type="hidden" value="${userId }" name="userId">
	邮箱名:<input type="text" name="email" ><br>
	密码:<input type="password" name="pwd"><br>
	<input type="submit" value="提交注册">
</form>
</body>
</html>