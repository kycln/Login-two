<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="com.bbu.model.*" %>
<%request.setCharacterEncoding("utf-8"); response.setCharacterEncoding( "utf-8" ); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增用户</title>
<link rel="stylesheet" type="text/css"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
#mybody {
	/*border: solid 1px grey;*/
	width: 980px;
	height: 500px;
	margin-top: 50px;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12" style="background: #4072B1; color: white">
				<h1 style="text-align: center">用户信息管理系统</h1>
			</div>
			<div class="col-md-2 col-md-offset-10">
				<h4>
					欢迎您,${arraylist.user.userName}&nbsp;&nbsp;&nbsp;&nbsp;<a href="login.jsp">安全退出</a>
				</h4>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2 col-md-offset-2" id="mybody">
				<!-- <div style="float:left;margin-right:550px"> -->
				<h2 style="text-align: center">新增用户信息</h2>
				<!-- </div> -->
				<hr />
				<form class="form-horizontal" action="UserServlet?type=add"
					method="post">
					<div class="form-group">
						<label for="inputUserName" class="col-sm-2 control-label">姓名:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="username"
								id="inputUserName" placeholder=" 姓名 ">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-sm-2 control-label">密码:</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" name="password"
								id="inputPassword" placeholder=" 密码 ">
						</div>
					</div>
					<div class="form-group">
						<label for="inputGrade" class="col-sm-2 control-label">等级:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="grade"
								id="inputGrade" placeholder=" 等级 ">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail" class="col-sm-2 control-label">邮箱:</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" name="email"
								id="inputEmail" placeholder=" 邮箱 ">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-success">确定</button>
							<button type="reset" class="btn btn-warning">取消</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>