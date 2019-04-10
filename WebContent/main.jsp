<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*,com.bbu.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
#loginbody {
	border: solid 1px grey;
	width: 500px;
	height: 400px;
	margin-top: 100px;
}
</style>
<!-- js弹出窗口 -->
<script type="text/javascript">
	function del() {
		return window.confirm("删除用户?");
	}

	//全选或全不选的方法

	function checkAll(checkall) {
		//这个info是子checkbox中的name值
		arr = document.getElementsByName('info');
		if (checkall.checked == true) {
			for (i = 0; i < arr.length; i++) {

				arr[i].checked = true;
			}

		} else {
			for (i = 0; i < arr.length; i++) {
				if ((arr[i]).checked == false) {
					arr[i].checked = true;
				} else {
					arr[i].checked = false;
				}
			}
		}
	}

	//多批量删除的方法
	function deleteAllBook() {
		// 获取input标签下type类型为checkbox的所有选中的checked框  
		var option = $("input:checkbox:checked");
		//取出checked框中的值
		var checkedId = "";
		var boo = true;
		for (var i = 0, len = option.length; i < len; i++) {
			if (boo) {
				boo = false;
				checkedId += option[i].value;
			} else
				checkedId += "," + option[i].value;
		}
		var flag = window.confirm("你确定要删除这条记录吗");
		//alert(checkedId);
		if (flag) {
			window.location.href = "UserServlet?type=allModify&bno="
					+ checkedId;
		}
	}
</script>

<meta charset="UTF-8">
<title>登录主页面</title>
</head>
<body>
	<table class="table table-hover" cellpadding="0" cellspacing="5">
		<tr class="info">
			<th><input type="checkbox" id="checkall" name="checkall"
				onclick="checkAll(checkall)" />全选</th>
			<th>id</th>
			<th>用户名</th>
			<th>密码</th>
			<th>等级</th>
			<th>邮箱</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${arraylist }" var="user">
			<tr>
				<!-- 关于多批量的使用方法 -->
				<td><input type="checkbox" value="${user.id }" name='info' /></td>
				<td>${user.id }</td>
				<td>${user.username }</td>
				<td>${user.password }</td>
				<td>${user.grade }</td>
				<td>${user.email }</td>
				<td><a onclick="return del()"
					href="UserServlet?type=delete&id=${user.id}">删除</a> &nbsp;&nbsp; <a
					href="UserServlet?type=modify&id=${user.id }">编辑</a></td>
			</tr>
		</c:forEach>
	</table>
	<button type="button" class="btn btn-primary"
		onclick="window.location.href='add.jsp'">添加用户</button>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 <ul class="pagination pagination-lg">
		<li><a href="">&laquo;</a>
		<li><a href="PageServlet?curpage=1">1</a>
		<li><a href="PageServlet?curpage=2">2</a>
		<li><a href="PageServlet?curpage=3">3</a>
		<li><a href="PageServlet?curpage=4">4</a>
		<li><a href="PageServlet?curpage=5">5</a>
		<li><a href="">&raquo;</a>
	</ul>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<button type="button" class="btn btn-primary" onclick="deleteAllBook()">批量删除</button>

</body>
</html>