<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<link rel="stylesheet" href="vendor/bootstrap.css">
<link rel="stylesheet" href="1.css">
<link rel="stylesheet" href="vendor/font-awesome.css">
<script type="text/javascript" src="vendor/bootstrap.js"></script>
<script type="text/javascript" src="jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="1.js"></script>
<script type="text/javascript" src="jquery.validate.min.js"></script>
<script type="text/javascript" src="angular.min.js"></script>

<div class="row" style="heigth:390px">
	<div class="col-md-6 col-md-offset-3">
		<div class="panel panel-default box_shadow" style="margin-top:40px;height:330px">
			<div class="panel-heading">
				<h3 class="panel-title" style="text-align:center"><b>Sign In</b></h3>
			</div>
			<div class="panel-body">
				<form action="login.jsp" method="post" id="loginform">
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

								<div class="form-group has-feedback">
									<input class="form-control" id="svLogin_Email" placeholder="E-mail" name="Email" type="email" >
									<span class="glyphicon form-control-feedback" id="svLogin_Email1"></span>
								</div>
								<div class="form-group has-feedback">
									<input class="form-control" id="svLogin_Pass" placeholder="Password" name="password" type="Password" value="">
									<span class="glyphicon form-control-feedback" id="svLogin_Pass1"></span>
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