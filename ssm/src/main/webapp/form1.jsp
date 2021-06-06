<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
<table>
	<tr>
		<th>id</th>
		<th>name</th>
		<th>age</th>
		<th>sex</th>
		<th>操作</th>
		
	</tr>
	<c:forEach items="${list}" var="user">
		<tr>
			<th>${user.id}</th>
			<th>${user.name}</th>
			<th>${user.age}</th>
			<th>${user.sex}</th>
		</tr>
	</c:forEach>	
</table>
</body>
</html>