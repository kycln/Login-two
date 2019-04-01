<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>
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
<meta charset="UTF-8">
<title>登录界面</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<!--12列栅格系统，div占用3，向右偏移3 -->
			<form action="LoginServlet" method="post">
			<div class="col-md-3 col-md-offset-3" id="loginbody">
				<!-- 居中对齐 -->
				<p class="text-center" style="font-size: 30px">登录</p>
				<label for="exampleInputEmail1">用户名</label> <input type="text"
					class="form-control" id="username" placeholder="用户名"> <label
					for="exampleInputEmail1">密码</label> <input type="password"
					class="form-control" id="password" placeholder="密码"><br />
				<br />
				<button type="submit" class="btn btn-success">登录</button>
				<button type="button" class="btn btn-info">重置</button>
			</div>
			</form>
		</div>
	</div>
</body>
</html>