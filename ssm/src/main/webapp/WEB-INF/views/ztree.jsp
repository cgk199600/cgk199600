<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/zTree_v3/js/jquery.ztree.all.js"></script>

</head>
<body>
<ul id="tree" class="ztree" style="width:230px; overflow:auto;"></ul>
<button type="button" id="btn">点</button>
</body>
<script type="text/javascript">
/*每次点击节点后， 弹出该节点的 tId、name 的信息  */
function zTreeOnClick(event, treeId, treeNode) {
    //alert(treeNode.tId + ", " + treeNode.name);
    alert(event+","+treeId);
};
$("#btn").click(function(){/*获取当前被勾选的节点集合  */
	//var treeObj = $.fn.zTree.getZTreeObj("tree");
	//var nodes = treeObj.getCheckedNodes(true);
	var treeObj = $.fn.zTree.getZTreeObj("tree");/*获取全部根节点数据  */
	var nodes = treeObj.getNodes();
	console.log(nodes);
})
var zTreeObj,
setting = {
		callback: {
			onClick: zTreeOnClick
		},
		check: {/*设置 zTree 的节点上是否显示 checkbox / radio  */
			enable: true,//默认复选
			chkStyle: "radio"//设置为单选
		},
	view: {
		selectedMulti: true//1、设置为 true时，按下 Ctrl 或 Cmd 键可以选中多个节点，2、设置为 true / false 都不影响按下 Ctrl 或 Cmd 键可以让已选中的节点取消选中状态

		
	},
data: {
	key: {
		name: "menuName"
	},/*zTree 节点数据保存节点名称的属性名称  */
	/*更改节点名  */
	simpleData: {
		enable: true,//true / false 分别表示 使用 / 不使用 简单数据模式
		idKey: "id",
		pIdKey: "pid",
		rootPId: 0
	}
}
},
zTreeNodes = [
	{"name":"网站导航", open:true, children: [
		{ "name":"google", "url":"http://g.cn", "target":"_blank"},
		{ "name":"baidu", "url":"http://baidu.com", "target":"_blank"},
		{ "name":"sina", "url":"http://www.sina.com.cn", "target":"_blank"}
		]
	}
];

$(document).ready(function(){
	$.ajax({
		type:"post",
		url:"<%=request.getContextPath() %>/ztree/getZtree.do",		
		dataType:"json",
		success:function(data){/*找到ID为tree的       setting配置放入      ztreenode数据放入  */
	       zTreeObj = $.fn.zTree.init($("#tree"), setting, data.data)

}
})
	})
	
</script>
</html>