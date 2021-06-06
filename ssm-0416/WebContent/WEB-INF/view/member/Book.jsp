<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="${root }/resource/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
$(function(){
	updatecollect();
	function updatecollect(){
		var bookId=$("#addcollect").attr("name");
		$.ajax({
			url:"${root}/member/collect/getCollectBybookId?bookId="+bookId,
			dataType:'json',
			success:function(data){
				
				if(data.code==200){
					$("#addcollect").val("取消收藏");
				}
			}
		})
	}
	$("#addCart").click(function(){
		var bookId=$(this).attr("name");
		$.ajax({
			url:"${root}/member/cart/add?bookId="+bookId,
			dataType:'json',
			success:function(data){
				
				alert("加入购物车成功");
			}
		})
	})
	$("#addcollect").click(function(){
		var bookId=$(this).attr("name");
		var addtext=$(this).val();
		
		if(addtext=="加入收藏"){
		$.ajax({
			url:"${root}/member/collect/addcollect?bookId="+bookId,
			dataType:'json',
			success:function(data){
				
				if(data.code==200){
					$("#addcollect").val("取消收藏");
				}
			}
		})
		}else{
			$.ajax({
				url:"${root}/member/collect/deltecollect?bookId="+bookId,
				dataType:'json',
				success:function(data){
					if(data.code==200){
						$("#addcollect").val("加入收藏");
					}
				}
			})
		}
	})
})
</script>
<body>
${book.bookName }
${book.price }
<input type="button" value="加入购物车" id="addCart" name="${book.bookId }">
<input type="button" value="加入收藏" id="addcollect" name="${book.bookId }">
</body>
</html>