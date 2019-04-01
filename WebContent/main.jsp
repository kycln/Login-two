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
</script>
<meta charset="UTF-8">
<title>登录主页面</title>
</head>
<body>
	<table class="table table-hover" cellpadding="0" cellspacing="5">
		<tr class="info">
			<th><input type="checkbox" />全选</th>
			<th>id</th>
			<th>用户名</th>
			<th>密码</th>
			<th>等级</th>
			<th>邮箱</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${arraylist }" var="user">
			<tr>
				<td><input type="checkbox" />选择</td>
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
	<button type="button" class="btn btn-primary" onclick=
	"window.location.href='add.jsp'" >添加用户</button>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</body>
</html>