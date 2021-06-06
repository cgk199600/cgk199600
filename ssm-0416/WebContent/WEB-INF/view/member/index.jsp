<%@page import="com.oracle.bean.SearchBooks"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="${root }/resource/js/jquery-1.8.3.js"></script>
<style type="text/css">
#collectlist ul{
list-style: none;
}
</style>
<body>
<div>
<a href="${root }/member/cart/list">购物车</a>
<a href="${root }/member/collect/getcollect">收藏夹</a>
<form method="Post" action="${root }/member/indexview" id="myForm">
<input type="hidden" id="page" name="page" value="1" >
	图书名称<input type="text" name="boosName" value="${param.boosName }">
	单间区间<input type="number" name="minPrice" value="${param.minPrice }">-<input type="number" name="maxPrice" value="${param.maxPrice }">
	类型<select name="typeId" >
		<option value="" >请选择</option>
		<c:forEach items="${type }" var="t">
			<option ${t.typeid eq param.typeId?"selected='selected'":"" } value="${t.typeid }" >${t.typename }</option>
		</c:forEach>
		
	</select>
	<input type="submit" >
</form>
	<table>
		<tr>
			<th>图书名称</th>
			<th>价格</th>
			<th>数量</th>
			<th>简介</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${pageInfo.list }" var="c">
			<tr>
				<td>${c.bookName }</td>
				<td>${c.price }</td>
				<td>${c.bookNum }</td>
				<td>${c.bookInfo }</td>
				<td><a href="${root }/member/Book?bookId=${c.bookId }">详情</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
			<%
			SearchBooks searchBooks=(SearchBooks)request.getSession().getAttribute("searchbooks");
			
			if(searchBooks.getBoosName()!=null&&!"".equals(searchBooks.getBoosName())||searchBooks.getMinPrice()!=null||searchBooks.getMaxPrice()!=null||searchBooks.getTypeId()!=null&&!"".equals(searchBooks.getTypeId())){
			%>
			<c:if test="${pageInfo.pageIndex ne 1 }">
				<a href="javascript:;" onclick="changePage(1)">首页</a>
				<a href="javascript:;" onclick="changePage(${pageInfo.pageIndex-1})">上一页</a>
			</c:if>
			<c:if test="${pageInfo.pageIndex ne pageInfo.totalPage }">
			<a href="javascript:;" onclick="changePage(${pageInfo.pageIndex+1})">下一页</a>
			<a href="javascript:;" onclick="changePage(${pageInfo.totalPage})">末页</a>
			</c:if>
			<%
			}else{
			%>
			<c:if test="${pageInfo.pageIndex ne 1 }">
				<a href="${root }/member/index?page=1">首页</a>
				<a href="${root }/member/index?page=${pageInfo.pageIndex-1}">上一页</a>
			</c:if>
			<c:if test="${pageInfo.pageIndex ne pageInfo.totalPage }">
			<a href="${root }/member/index?page=${pageInfo.pageIndex+1}">下一页</a>
			<a href="${root }/member/index?page=${pageInfo.totalPage}">末页</a>
			</c:if>
			<% 
			}
			%>
			</td>
		</tr>
		
	</table>
	<div id="collectlist">
	<ul>
		
	</ul>
	</div>
	<script type="text/javascript">
		function changePage(index){
			document.getElementById("page").value=index;
			document.getElementById("myForm").submit();
			
		}
		$(function(){
			var collecturl="${root}/member/collect/getcollectByMaxbookid";
			
			$.get(collecturl,function(res){
				var list=res.list;
				for (var i = 0; i < list.length; i++) {
					var collectul=$("<ul></ul>");
					collectul.append("<li>"+list[i].bookname+"</li>");
					$("#collectlist").append(collectul);
				}	
			},'json')
		})
	</script>
</div>
</body>

</html>