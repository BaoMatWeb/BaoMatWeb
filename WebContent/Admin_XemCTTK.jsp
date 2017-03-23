<%@page import="Model.TaiKhoan"%>
<%@page import="Controller.TaiKhoan_Controller"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

  <%  
	TaiKhoan_Controller crltkkiemtra=new TaiKhoan_Controller();
	
	TaiKhoan tkktra=new TaiKhoan();
	tkktra=crltkkiemtra.getTaiKhoanByMaTK(session.getAttribute("Email").toString());
	if(!tkktra.getQuyen().equals("Admin"))
	{
		String redirectURL="mainPage.jsp";
		response.sendRedirect(redirectURL);
	}
%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="vendor/bootstrap.js"></script>
<script type="text/javascript" src="1.js"></script>
<link rel="stylesheet" href="vendor/bootstrap.css">
<link rel="stylesheet" href="1.css">
<link rel="stylesheet" href="vendor/font-awesome.css">

</head>
<%
TaiKhoan c= new TaiKhoan();

String MaTK;
if (request.getParameter("MaTK") != null) {
	MaTK = request.getParameter("MaTK");
    c =tk.gettk(MaTK);
}

%>
<body>
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
									<li><a href="#"><span style="color: blue"><%=session.getAttribute("Email") %>	</span></a></li>
									 <li id="logout"><a id="logout1" href="Logout.jsp">Đăng xuất</a></li>
								</ul>
							</div>
							<!-- /.navbar-collapse -->
						</div>
					</nav>
				</div>
			</div>
		</div>
		<div class="svContent">
			<div class="row">
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
							<div class="row" style="">
								<div class="QLyTK"
									style="background: white; height: 380px; margin-right: 15px; border-radius: 3px; overflow: auto;">
									<h2
										style="margin-top: 0px; padding: 5px; text-align: center; font-family: sans-serif">QUẢN
										LÝ TÀI KHOẢN</h2>
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
						<div class="tab-pane active" id="ttTaiKhoan">
							<div class="row">
								<div class="svttTaiKhoan"
									style="background: white; height: 380px; margin-right: 15px; border-radius: 3px; overflow: auto;">
									<h2
										style="margin-top: 0px; padding: 5px; text-align: center; font-family: sans-serif">THÔNG
										TIN TÀI KHOẢN</h2>
									<div class="ttTaiKhoan_content">
										<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
											<div class="svAnhDaiDien">
												<img src="images/daidien.jpg" alt="Image" width="95%"
													height="280px">
												<form action="">
													<input type="file" name="pic" accept="image/*">
												</form>
											</div>
										</div>
										<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
											<div class="row">
												<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
													<br> <br> <b>
														<p>Tên chủ nhiệm:<%=c.getHoTen() %> </p>
														<p>MSSV: <%=c.getMatKhau() %></p>
														<p>Ngày sinh: <%=c.getNgaySinh() %></p>
														<p>Thuộc khoa: <%=c.getNganh() %></p>
														<p>Quê quán: Quảng Ngãi</p>
													</b>
													
												</div>
												<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
												
													<br> <br> <b><p>Mail:<%=c.getEmail() %> </p>
														<p>Nganh:<%=c.getNganh() %></p>
														<p>Mã số ngân hàng: <%=c.getMSNH() %></p>
														<p>Chi nhánh ngân hàng:<%=c.getCNNH() %></p>
														<p>Đơn vị công tác: ZXC</p> </b>
													
												</div>
											</div>
											<div class="row">
												<div class="">
													<a class="btn btn-primary" data-toggle="modal"
														href='#modal-id'
														style="margin-left: 150px; margin-top: 10px;">Cập nhập
														thông tin</a>
													<div class="modal fade" id="modal-id">
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button type="button" class="close"
																		data-dismiss="modal" aria-hidden="true">&times;</button>
																</div>
																<div class="modal-body">
																	<div class="row">
																		<div class="title"
																			style="text-align: center; margin-bottom: 15px;">
																			<h2>CẬP NHẬP THÔNG TIN</h2>
																			<hr>
																		</div>
																	</div>
																	<div class="row">
																		<form action="TaiKhoan_Servlet"  method="POST"
																			class="form-horizontal" role="form">
																			<input type="hidden" name="command" value="updateADMIN">
																			<input type="hidden" name="MaTK" value=<%=c.getEmail() %>>
																			<input type="hidden" name="Quyen" value="Admin">
																			<div class="form-group"
																				style="margin-left: 5px; margin-left: 65px;">

																				<div class="col-xs-10">
																									<label for="email">Mail<span>:</span></label> 
																									<input class="form-control" name="email" id="email" type="email" required/>
																									<span class="glyphicon form-control-feedback" id="email1"></span>
																								</div>
																				<br>
																				<div class="col-xs-10">
																					<label for="sdt">Ngành<span>:</span></label>
																					<input class="form-control" name="nganh" id="nganh" type="text"
																						required="required">
																				</div>
																				<br>
																				<div class="col-xs-10">
																					<label for="cnnh">Chi nhánh ngân hàng<span>:</span></label>
																					<input class="form-control" name="cnnganhang" id="cnnh" type="text"
																						required="required">
																				</div>
																				<br>
																				<div class="col-xs-10">
																					<label for="dvct">Mã số ngân hàng<span>:</span></label>
																					<input class="form-control" name="masoNH" id="dvct" type="text"
																						required="required">
																				</div>
																				<br>
																				
																				<div style="margin-top:10px;" class="col-xs-10">
																					<label for="mail">Quyền<span>:</span></label> 
																					<select style="height:30px" name="quyen">
						                                                            <option value='<%=c.getQuyen() %>>' selected><%=c.getQuyen() %></option>
						                                                            <%for(TaiKhoan tk1:tk.getListTKQuyen()){ %>
						                                                            <option value='<%=tk1.getQuyen() %>'><%=tk1.getQuyen() %></option>
						                                                            <%} %>
						                                                            </select>
																				</div>
																				<br>
																			</div>
																			<div class="modal-footer">
																				<button type="button" class="btn btn-danger"
																					data-dismiss="modal">Hủy</button>
																				<button type="submit" class="btn btn-primary" >Lưu</button>
																			</div>
																		</form>
																	</div>
																</div>

															</div>
														</div>
													</div>
													<!-- <a class="btn btn-info" href="sinhvien_CapNhatThongTin.jsp" role="button" style="margin-left:150px">Cập nhật thông tin</a> -->
												</div>
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
	</div>

</body>

</html>