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
<script type="text/javascript">
$(function(){
	totalMoney();
	//全选事件
	$("#all").click(function(){
		$(".ck").prop("checked",$(this).prop("checked"));
		var carStatus=$(this).prop("checked");
		var ck=$(".ck");
		var modifycarUrl="${root}/member/cart/modifyCarStatus?carStatus="+carStatus;
		$.get(modifycarUrl,function(res){
			
		},'json')
	})
	//单选事件
	$(".ck").click(function(){
		var carId=$(this).attr("name");
		var carStatus=$(this).prop("checked");
		$("#all").prop("checked",$(".ck").length==$(".ck:checked").length);
		var modifycarUrl="${root}/member/cart/modifyCarStatusById?carStatus="+carStatus+"&carId="+carId;
		$.get(modifycarUrl,function(res){
			
		},'json')
	})
	//删除
	$(".del").click(function(){
		var delobj=$(this).parent().parent();
		var carId=$(this).attr("name");
			if(confirm("你确定删除么")){
				var delcarurl="${root}/member/cart/delcar?carId="+carId;
				$.get(delcarurl,function(res){
					//window.location.reload();
					if(res.code==200){
						
						delobj.remove();
					}
				},'json')
			}
	})
	//创建订单
	$("#submit").click(function(){
		window.location.href="${root}/member/order/create";
	})
	//总计	
	function totalMoney(){
		var trlength=$(".ck").length;
		var trarr=$("#tBody_html").children();
		var sum=0.0;
		for (var i = 0; i < trlength; i++) {
			
			if($(".ck").eq(i).prop("checked")==true){
				sum+=(trarr.eq(i).children().eq(5).text()*1);
				/* alert($("#Nummoney").eq(i).text());
				sum+= ($("#Nummoney").eq(i).text()*1); */
			}
		}
		$("#sunSpan").text(sum);
	}	
	
})


</script>
<body>
<table>
<tr>
	<th><input type="checkbox" id="all"  >全选</th>
	<th>用户名</th>
	<th>商品</th>
	<th>数量</th>
	<th>单价</th>
	<th>小计</th>
	<th>操作</th>
</tr>
<tbody id="tBody_html">
<c:forEach items="${cart }" var="ca">
	<tr>
		<td><input type="checkbox" name="${ca.carId }" class="ck"  <c:if test="${ca.carStatus==1}">checked="checked"</c:if> /> </td>
		<td>${ca.user.name }</td>
		<td>${ca.book.bookName }</td>
		<td  >${ca.buyNum }</td>
		<td>${ca.book.price }</td>
		<td >${ca.book.price*ca.buyNum }</td>
		<td><a href="javascript:void(0)" name="${ca.carId }" class="del">删除</a> </td>
	</tr>
</c:forEach>
</tbody>
</table>
<h2><span id="sunSpan"></span></h2>
<input type="button" id="submit" value="提交">

</body>
</html>