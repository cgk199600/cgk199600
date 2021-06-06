<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/user/update.do" method="post">
<input type="hidden" name="id" value="${user.id}">
请设置用户名：<input type="text" name="username" value="${user.username}">
请设置密码：<input type="text" name="password" value="${user.password}">
是否保存:<input type="radio" name="preserve" value="1" <c:if test="${user.preserve==1}">checked="checked"</c:if>>是
<input type="radio" name="preserve" value="0" <c:if test="${user.preserve==0}">checked="checked"</c:if>>否
<input type="submit" value="提交">
</form>
</body>
</html>