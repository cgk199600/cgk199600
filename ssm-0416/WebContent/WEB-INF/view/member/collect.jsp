<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<table>
	<tr>
		<th>收藏书名</th>
		<th>用户名</th>
		<th>价格</th>
	</tr>
	<c:forEach items="${list }" var="li">
		<tr>
			<td>${li.bookName }</td>
			<td>${li.username }</td>
			<td>${li.price }</td>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>