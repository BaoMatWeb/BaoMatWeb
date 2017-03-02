
<%@page import="Model.TaiKhoan"%>
<%@page import="Model.ThongBao"%>
<%@page import="Controller.TaiKhoan_Controller"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
<title>Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="vendor/bootstrap.css">
<link rel="stylesheet" href="1.css">
<link rel="stylesheet" href="vendor/font-awesome.css">
<script type="text/javascript" src="vendor/bootstrap.js"></script>
<script type="text/javascript" src="1.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<%
		TaiKhoan_Controller tk = new TaiKhoan_Controller();
	%>
	<div class="page">
		<div class="menu">
			<div class="row">
				<div class="pictureMain">
					<img src="images/skpt_banner_2.jpg" class="img-responsive"
						alt="Image">
				</div>
				<div class="menuBar">
					<nav class="navbar navbar-default " role="navigation">
						<div class="container" id="container_menuBar">
							<div class="navbar-header">
								<button type="button" class="navbar-toggle"
									data-toggle="collapse" data-target=".navbar-ex1-collapse">
									<span class="sr-only">Toggle navigation</span> <span
										class="icon-bar"></span> <span class="icon-bar"></span> <span
										class="icon-bar"></span>
								</button>
							</div>

							<!-- Collect the nav links, forms, and other content for toggling -->
							<div class="collapse navbar-collapse navbar-ex1-collapse"
								id="menuMain">
								<ul class="nav navbar-nav">
									<li><a href="#">Trang chủ</a></li>
									<li><a href="#">Biểu Mẫu</a></li>
									<li><a href="#">Liên Hệ</a></li>
									<li><a href="#">Hướng dẫn</a></li>
								</ul>
								<ul class="nav navbar-nav navbar-right">
									<li><a href="#"><span style="color: blue"><%=session.getAttribute("Email") %></span></a></li>
									<li><a href="mainPage.jsp">Đăng xuất</a></li>
								</ul>
							</div>
							<!-- /.navbar-collapse -->
						</div>
					</nav>
				</div>
			</div>
		</div>

		<div class="svContent">
			<div class="row" style="">
				<div class="col-md-2">
					<ul class="nav nav-pills nav-stacked"
						style="background: white; border-radius: 3px">
						<li><a class="list-group-item" href="#QLTK"
							data-toggle="pill"> <span class="glyphicon glyphicon-user"></span>
								Quản lý tài khoản
						</a></li>

					</ul>

				</div>
				<div class="col-md-10">
					<div class="tab-content">
						<div class="tab-pane" id="QLTK">
							<div class="row">
								<div class="QLyTK"
									style="background: white; height: 480px; margin-right: 15px; border-radius: 3px; overflow: auto;">
									<h2
										style="margin-top: 0px; padding: 5px; text-align: center; font-family: sans-serif;">QUẢN
										LÝ TÀI KHOẢN</h2>
									<h5 style="float:left;margin-left:30px" class="message_Error"><b><%=request.getAttribute("error") %></b></h5>
									<a class="btn btn-default" href="Admin_ThemTK.jsp"
										role="button" style="float: right; margin: 0px 5px 5px 0px;">Thêm
										tài khoản</a>
									<div class="ad_table_qltk">
										<table class="table table-striped table-hover"
											style="margin: 0px 5px 0px 0px;">
											<thead class="thead-default">
												<tr class="success">
												
													<th>Tên tài khoản</th>
													<th>Mã số</th>
													<th>Tài khoản</th>
													<th>Quyền truy cập</th>
													<th>Ngành</th>
													<th>Chỉnh sửa</th>
													<th>Xóa</th>
												</tr>
											</thead>
											<tbody>
												<%
												for(TaiKhoan a:tk.getListTaiKhoan()){
											%>
												<tr>
													
													<td><%=a.getHoTen()%></td>
													<td><%=a.getMaTK()%></td>
													<td><%=a.getEmail()%></td>
													<td><%=a.getQuyen()%></td>
													<td><%=a.getNganh()%></td>
													<td><a href="Admin_XemCTTK.jsp?MaTK=<%=a.getMaTK()%>">Cập
															nhập</a></td>
 													<td><a href="TaiKhoan_Servlet?command=XoaTK&MaTK=<%=a.getMaTK()%>"> Xóa</a></td>
												</tr>
												<%
												}
												%>
											</tbody>
										</table>
									</div>
									
								</div>
								
							</div>
						</div>
						<div class="tab-pane active" id="ThemTK">
							<div class="row">
								<div class="ad_TTK"
									style="background: white; height: 500px; margin-right: 15px; border-radius: 3px">
									<h2
										style="text-aline: center; padding: 5px; text-align: center; font-family: sans-serif">QUẢN LÝ NGƯỜI DÙNG</h2>
								
									<hr>
									<div class="Ad_table_TTK">
										<div class="row">
												<form action="ThemTaiKhoan_Servlet" id="formtb" method="post" class="form-horizontal">
												<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
													<div style="margin: 15px 10px 30px 50px;">
														<div class="col-xs-10">
															<label for="name">Họ tên<span>:</span></label> 
															<input
																type="text" name="hoten"
																class="form-control required name"
																placeholder="Nhập tên người dùng" id="name" required
																minlength="3" data-placement="right"
																data-trigger="hover"
																data-content="Bạn cần phải nhập vào trường này.">
														</div>
														<br>
														<div class="col-xs-10">
															<label for="email">Email<span>:</span></label> <input
																type="text" name="email"
																class="form-control required email"
																placeholder="...@gmail.com" id="email" required
																data-placement="right" data-trigger="hover"
																data-content="Bạn cần phải nhập vào trường này">
																<span class="glyphicon form-control-feedback" id="email1"></span>	
														</div>
														<br>
														<div class="col-xs-10">
															<label for="sl_menu">Quyền<span>:</span>
															</label> <select id="sl_menu" name="quyen" class="form-control"
																required="required">
																<%
																	for (TaiKhoan b : tk.getListTKQuyen()) {
																%>
																<option value="<%=b.getQuyen() %>"><%=b.getQuyen() %></option>
																<%
																	}
																%>
															</select>
														</div>
														<br>
														<div class="col-xs-10">
															<label for="mota">Ngày sinh<span>:</span>
															</label>
															<input type="text" type="date" name="nsinh" class="form-control required ngay"  id="" required data-placement="right" data-trigger="hover" data-content="Vui lòng nhập theo định dạng yyyy/mm/dd" placeholder="yyyy/mm/dd" style="float:left; margin-left:10px; margin-top:10px;"required>
														</div>
													</div>
												</div>
												<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
													<div action="" onsubmit=""
														style="margin: 15px 0px 30px 20px;">
														<div class="col-xs-10">
															<label for="password1">Mật khẩu<span>:</span></label> <input
																type="password" name="password1"
																class="form-control required password1" id="password1"
																required minlength="3" data-placement="right"
																data-trigger="hover"
																data-content="Bạn cần phải nhập vào trường này.">
														</div>
														<br>
														<div class="col-xs-10">
															<label for="mssv">Chi nhánh ngân hàng<span>:</span></label> <input
																type="text" name="cnnganhang"
																class="form-control required mssv"
																placeholder="VCB" id="mssv" required minlength="3"
																data-placement="right" data-trigger="hover"
																data-content="Bạn cần phải nhập vào trường này.">
														</div>
														<br>
														<div class="col-xs-10">
															<label for="ngành">Ngành<span>:</span></label> <input
																type="text" name="nganh"
																class="form-control required mota" placeholder="CNTT"
																id="ngành" required minlength="3" data-placement="right"
																data-trigger="hover"
																data-content="Bạn cần phải nhập vào trường này.">
														</div>
														<br> <a class="btn btn-default"
															href="Admin_TTKTuFILE.jsp" role="button"
															style="margin: 25px 0px 5px 15px; width: 270px; height: 40px;">Thêm
															tài khoản từ file</a>
													</div>
												</div>
												<button type="submit" class="btn btn-primary"
													style="margin: 10px 0px 0px 330px; width: 150px; height: 40px;">
													<b>Thêm</b>
												</button>
											</form>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id='bttop'>
			<img src="images/backtotop.png" alt="backtotop" width="50px"
				height="50px">
		</div>
		<footer style="margin-bottom: 0px; margin-top: 10px;">
			<pre style="margin-bottom: 0px;">
                Copyright@ Phòng nghiên cứu khoa học và quan hệ quốc tế
            </pre>
		</footer>
	</div>
</body>
</html>