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
<table>
<tr>
<th>编号</th>
<th>用户名</th>
<th>是否保存</th>
<th>操作</th>
<th><a href="<%=request.getContextPath() %>/user/toAdd.do">添加</a>
</tr>
<c:forEach items="${lists}" var="user">
<tr>
<th>${user.id}</th>
<th>${user.username}</th>
<th>${user.password}</th>
<th>${user.preserve}</th>
<th><a href="<%=request.getContextPath() %>/user/toUpdate.do?id=${user.id}">修改</a>
<a href="<%=request.getContextPath() %>/user/delete.do?id=${user.id}">删除</a></th>
</tr>
</c:forEach>

</table>

</body>
</html>