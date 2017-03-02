<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html lang="en"><head>
<title> Example </title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">  
<script type="text/javascript" src="vendor/bootstrap.js"></script>
<script type="text/javascript" src="1.js"></script>
<link rel="stylesheet" href="vendor/bootstrap.css">
<link rel="stylesheet" href="1.css">
</head>
<body>
	<div class="page">
		<div class="menu">
			<div class="row">
				<div class="pictureMain">
					<img src="images/skpt_banner_2.jpg" class="img-responsive" alt="Image">
				</div>
				<div class="menuBar">
					<nav class="navbar navbar-default" role="navigation">
						<div class="container" id="container_menuBar">
							<div class="navbar-header">
								<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
									<span class="sr-only">Toggle navigation</span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
								</button>
							</div>

							<!-- Collect the nav links, forms, and other content for toggling -->
							<div class="collapse navbar-collapse navbar-ex1-collapse" id="menuMain">
								<ul class="nav navbar-nav">
									<li><a href="#">Trang Chủ</a></li>
									<li><a href="#">Biểu mẫu</a></li>
									<li><a href="#">Liên hệ</a></li>
									<li><a href="#">Hướng dẫn</a></li>
								</ul>
								<ul class="nav navbar-nav navbar-right">
									<li><a href="#">Đăng nhập</a></li>
								</ul>
							</div><!-- /.navbar-collapse -->
						</div>
					</nav>
				</div>
			</div>	
		</div>	
		<div class="loginPage">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div class="panel panel-default" style="margin-top:40px">
						<div class="panel-heading">
							<h3 class="panel-title" style="text-align:center"><b>Sign In</b></h3>
						</div>
						<div class="panel-body">
							<form action="login.jsp">
									<div class="form-inline" style="margin-left:70px">
									<label>
										<input type="radio" id="input_sv" name="phanquyen" value="Student" checked>
										Sinh viên
									</label>
									<label>
										<input type="radio"  id="input_gv" name="phanquyen" value="Lecturers">
										Giảng viên
									</label>
									<label>
										<input type="radio" id="input_ql" name="phanquyen" value="Manager">
										Quản lý
									</label>
									<label>
										<input type="radio" id="input_ad" name="phanquyen" value="Admin">
										Admin
									</label>
								</div>

								<div class="form-group">
									<input class="form-control" id="svLogin_Email" placeholder="E-mail" name="Email" type="text" >
								</div>
								<div class="form-group">
									<input class="form-control" id="svLogin_Pass" placeholder="Password" name="password" type="Password" value="">
								</div>
								<div class="checkbox">
									<label>
										<input name="remember" type="checkbox" value="Remember Me"> Remember Me
									</label>
								</div>
								<input type="submit" value="Login" class="btn-lg col-lg-12" />
								<font color="red"><c:if test="${not empty param.errMsg}">
				            <c:out value="${param.errMsg}" />
				            </c:if></font>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>	
		<div id='bttop'>
			<img src="images/backtotop.png" alt="backtotop" width="50px" height="50px">
		</div>
		<footer style="margin-bottom:0px;margin-top:10px;">
			<pre style="margin-bottom:0px;">
				Copyright@ Phòng nghiên cứu khoa học và quan hệ quốc tế
			</pre>
		</footer>

	
	</div>



</body>
</html>