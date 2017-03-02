<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page import="Controller.*,Model.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title> Example </title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script type="text/javascript" src="vendor/bootstrap.js"></script>
	<script type="text/javascript" src="1.js"></script>
	<link rel="stylesheet" href="vendor/bootstrap.css">
	<link rel="stylesheet" href="1.css">
	<link rel="stylesheet" href="vendor/font-awesome.css">
	<script type="text/javascript" src="jquery.validate.min.js"></script>
</head>
<%  TB_TK_Controller cttb= new TB_TK_Controller();
	ThongBao_Controller tb= new ThongBao_Controller();
	DeTai_Controller dt= new DeTai_Controller();
	TrangThai_Controller tt=  new TrangThai_Controller();
	CTNghiemThu_Controller ctnt= new CTNghiemThu_Controller();
	TaiKhoan_Controller tk=new TaiKhoan_Controller();
	DonHuy_Controller dh= new DonHuy_Controller();
	DonGiaHan_Controller gh=new DonGiaHan_Controller();
	DeTai detai=new DeTai();
	String maDT = "";
	String maTT = "";
	String lydo="";
	String yeucauXuly="";
	String giahanDen="";
	if (request.getParameter("MaTT") != null){
		maTT = request.getParameter("MaTT");
		maDT = request.getParameter("MaDT");
		DonHuy dhdt=new DonHuy();
		DonGiaHan dgh=new DonGiaHan();
		dhdt=dh.getDonHuy(maDT);
		dgh=gh.getDGH(maDT);
		giahanDen=dgh.getGHDen();
		if(dgh.getLyDo()==null)
			lydo=dhdt.getLyDo();
		else
			lydo=dgh.getLyDo();
		detai=dt.getDeTai(maDT);
		if(maTT.equals("tt6"))
			yeucauXuly="ĐƠN GIA HẠN ĐỀ TÀI";
		else
			yeucauXuly="ĐƠN HỦY ĐỀ TÀI";
	}
%>
<script type="text/javascript">
$( document ).ready(function() {
	var tt=$('#trangthaiDT').val();
	  if(tt == "tt4")
		  $('#thoigianGiahan').addClass('hidden');
	});
</script>
<body>
	<div class="page">
		<div class="menu">
			<div class="row">
				<div class="pictureMain">
					<img src="images/skpt_banner_2.jpg" class="img-responsive" alt="Image">
				</div>
				<div class="menuBar">
					<nav class="navbar navbar-default " role="navigation">
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
									<li><a href="giangvienPage.jsp">Trang chủ</a></li>
									<li><a href="#">Biểu Mẫu</a></li>
									<li><a href="#">Liên Hệ</a></li>
									<li><a href="#">Hướng dẫn</a></li>
								</ul>
								<ul class="nav navbar-nav navbar-right">
									<li><a href="#"><span  style="color:blue"><%=session.getAttribute("Email") %></span></a></li>
									<li><a href="mainPage.jsp">Đăng xuất</a></li>
								</ul>
							</div>
							<!-- /.navbar-collapse -->
						</div>
					</nav>
				</div>
			</div>
		</div>
		<div class="gvContent">
			<div class="row">
				<div class="col-md-2">
					<ul class="nav nav-pills nav-stacked">
						<li>
							<a href="#dsDeTaiPhanBien" class="list-group-item" data-toggle="pill" style="border-radius:0px;">
								<span class="glyphicon glyphicon-th-list"></span> DSĐT được phân công phản biện</a>
						</li>
						<li style="margin-top:0px;">
							<a href="#dsDeTaiPheDuyet" class="list-group-item" data-toggle="pill">
								<span class="glyphicon glyphicon-list-alt"></span> DSĐT được phân công phê duyệt</a>
						</li>
						<li style="margin-top:0px;">
							<a href="#dsDeTaiHuongDan" class="list-group-item" data-toggle="pill">
								<span class="glyphicon glyphicon-th-list"></span> DS đề tài hướng dẫn</a>
						</li>
						<li style="margin-top:0px;">
							<a class="list-group-item" href="#dkDeTai" data-toggle="pill">
								<span class="glyphicon glyphicon-inbox"></span> Đăng ký đề tài</a>
						</li>
						<li style="margin-top:0px;">
							<a href="#dsDeTaiDK" class="list-group-item" data-toggle="pill">
								<span class="glyphicon glyphicon-list-alt"></span> DS đề tài đã đăng ký</a>
						</li>
						<li style="margin-top:0px;">
							<a href="#duyetHuy_GianHan" class="list-group-item" data-toggle="pill" style="border-radius:0px;">
								<span class="glyphicon glyphicon-check"></span> Duyệt đơn hủy/gia hạn đề tài</a>
						</li>
					</ul>
				</div>
				<div class="col-md-10">
					<div class="tab-content">
						<div class="tab-pane" id="dsDeTaiPhanBien">
							<div class="row">
								<div class="gv_dsDeTaiPhanBien" style="background:white;height:390px;margin-right:15px;border-radius:3px;overflow:auto;">
									<h2 class="tieude_theh">DANH SÁCH ĐỀ TÀI ĐƯỢC PHÂN CÔNG PHẢN BIỆN</h2><hr>
									<div class="gv_tb_dsDeTaiPhanBien">
										<table class="table table-striped table-hover">
											<thead class="thead-default">
												<tr class="success">
													<th>Mã đề tài</th>
													<th>Tên đề tài</th>
													<th>Chủ nghiệm đề tài</th>
													<th>Giảng viên hướng dẫn</th>
													<th>Chi tiết</th>
													<th>Báo cáo</th>
													<th>Đánh giá</th>
												</tr>
											</thead>
											<tbody>
											   <%
				     							for (DeTai ct: dt.getListDeTaiPhanCongPhanBien(session.getAttribute("Email").toString())) {
												%>
												<tr>
													<th><%=ct.getMaDT() %></th>
													<th><%=ct.getTenDT() %></th>
													<th><%=ct.getTenCN() %></th>
													<th><%=ct.getTenGVHD() %></th>
													<th><a href="giangvienPage_ChiTiet.jsp?MaDT=<%=ct.getMaDT() %>">Chi tiết</a></th>
													<th><a href="giangvienPage_XemBC.jsp?MaDT=<%=ct.getMaDT() %>">Xem báo cáo</a></th>
													<th><a href="giangvienPage_DanhGia.jsp?MaDT=<%=ct.getMaDT() %>">Đánh giá</a></th>
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
						<div class="tab-pane" id="dsDeTaiPheDuyet">
							<div class="row">
								<div class="gv_dsDeTaiPheDuyet" style="background:white;height:390px;margin-right:15px;border-radius:3px;overflow:auto;">
									<h2 class="tieude_theh">DANH SÁCH ĐỀ TÀI ĐƯỢC PHÂN CÔNG PHÊ DUYỆT</h2><hr>
									<div class="gv_tb_dsDeTaiPheDuyet">
										<table class="table table-striped table-hover">
											<thead class="thead-default">
												<tr class="success">
													<th>Mã đề tài</th>
													<th>Tên đề tài</th>
													<th>Lĩnh vực</th>
													<th>Chủ nghiệm đề tài</th>
													<th>Phê duyệt</th>
												</tr>
											</thead>
											<tbody>
											<%
											for (DeTai ct: dt.getListDeTaiPhanCongPheDuyet(session.getAttribute("Email").toString())) {
											%>
												<tr>
													<th><%=ct.getMaDT() %></th>
													<th><%=ct.getTenDT() %></th>
													<th><%=ct.getLinhVuc() %></th>
													<th><%=ct.getTenCN() %></th>
													<th><a href="giangvien_PheDuyet.jsp?MaDT=<%=ct.getMaDT() %>">Phê duyệt</a></th>
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
						<div class="tab-pane" id="dsDeTaiHuongDan">
							<div class="row">
								<div class="gv_dsDeTaiHuongDan" style="background:white;height:390px;margin-right:15px;border-radius:3px;overflow:auto;">
									<h2 class="tieude_theh">DANH SÁCH ĐỀ TÀI HƯỚNG DẪN</h2><hr>
									<div class="gv_tb_dsDeTaiHuongDan">
										<table class="table table-striped table-hover">
											<thead class="thead-default">
												<tr class="success">
													<th>Mã đề tài</th>
													<th>Tên đề tài</th>
													<th>Chủ nghiệm đề tài</th>
													<th>Chi tiết</th>
													<th>Báo cáo</th>
												</tr>
											</thead>
											<tbody>
											<%
											for (DeTai ct: dt.getListDeTaiHuongDan(session.getAttribute("Email").toString())) {
											%>
												<tr>
													<th><%=ct.getMaDT() %></th>
													<th><%=ct.getTenDT() %></th>
													<th><%=ct.getTenCN() %></th>
													<th><a href="giangvienPage_ChiTiet.jsp?MaDT=<%=ct.getMaDT() %>">Chi tiết</a></th>
													<th><a href="giangvienPage_XemBC.jsp?MaDT=<%=ct.getMaDT() %>">Xem báo cáo</a></th>
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
						<div class="tab-pane" id="dkDeTai">
							<div class="row" style="margin-right:0px;">
								<div class="svdkDeTai" style="background:white;height:1600px;border-radius:3px">
									<h2 class="tieude_theh">ĐĂNG KÝ ĐỀ TÀI</h2>
									<hr>
									<div class="container" style="width:800px">
										<div class="row">
											<div class="mota">
												<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
													<form action=" " onsubmit="" method="POST" role="form" class="form-horizontal">
														<div class="form-group">
															<label class="col-sm-2 control-label" for="tendetai">Tên đề tài:</label>
															<div class="col-sm-10" style="margin-bottom:5px">
																<input class="form-control" id="tendetai" type="text" required>
															</div>
															<label class="col-sm-2 control-label" for="mota">Mô tả:</label>
															<div class="col-sm-10">
																<textarea name="" id="mota" class="form-control" rows="2" required="required"></textarea>
															</div>
															<br>
															<br>
															<label class="col-sm-2 control-label" for="linhvucnghiencuu">Lĩnh vực nghiên cứu:</label>
															<div class="col-sm-10" id="linhvucnghiencuu">
																<label class="radio-inline"><input type="radio" value="tunhien" name="linhvucnghiencuu" checked="checked"> Tự nhiên</label>
																<label class="radio-inline"><input type="radio" value="xhnv" name="linhvucnghiencuu">Xã hội nhân văn</label>
																<label class="radio-inline"><input type="radio" value="giaoduc" name="linhvucnghiencuu">Giáo dục</label>
																<label class="radio-inline"><input type="radio" value="kythuat" name="linhvucnghiencuu">Kỹ thuật</label>
																<label class="radio-inline"><input type="radio" value="nong_ngulam" name="linhvucnghiencuu">Nông-ngư lâm</label>
																<label class="radio-inline"><input type="radio" value="yduoc" name="linhvucnghiencuu">Y dược</label>
																<label class="radio-inline"><input type="radio" value="moitruong" name="linhvucnghiencuu">Môi trường</label>
															</div>
															<br>
															<br>
															<label class="col-sm-2 control-label" for="loaihinhnghiencuu">Loại hình nghiên cứu:</label>
															<div class="col-sm-10" id="loaihinhnghiencuu">
																<label class="radio-inline"><input type="radio" value="coban" name="loaihinhnghiencuu" checked="checked"> Cơ bản:</label>
																<label class="radio-inline"><input type="radio" value="ungdung" name="loaihinhnghiencuu">Ứng dụng:</label>
																<label class="radio-inline"><input type="radio" value="trienkhai" name="loaihinhnghiencuu">Triển khai:</label>
															</div>
															<br>
															<br><br>
															<div class="container" style="margin-top:35px; margin-left:20px;width:800px">
																<div class="row">
																	<label class="col-sm-2 control-label" for="thoigianthuchien">Thời gian thực hiện:</label>
																	<div class="col-sm-10" id="thoigianthuchien">
																		<div class="row">
																			<label class="col-sm-2 control-label" for="thoigianbatdau">Từ:</label>
																			<div class="col-sm-4" style="margin-bottom:5px;">
																				<input type="date" name="" id="thoigianbatdau" class="form-control" value="" required="required" title="" style="padding:0px;">
																			</div>
																			<label class="col-sm-2 control-label" for="thoigianketthuc">Đến:</label>
																			<div class="col-sm-4" style="margin-bottom:5px;">
																				<input type="date" name="" id="thoigianketthuc" class="form-control" value="" required="required" title="" style="padding:0px;">
																			</div>
																		</div>
																	</div>
																</div>
															</div>
															<label class="col-sm-2 control-label" for="coquanchutri">Cơ quan chủ trì:</label>
															<div class="col-sm-10">
																<input class="form-control" id="tendetai" type="text" placeholder="Khoa/Bộ môn trực thuộc">
															</div>
															<br>
															<div class="container" style="margin-top:35px;width:800px">
																<div class="row">
																	<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
																		<label style="margin-left:60px">Chủ nhiệm đề tài:</label><br>
																		<div class="row" style="margin-bottom:5px">
																			<label class="col-sm-4 control-label" for="hoten1">Họ và tên:</label>
																			<div class="col-sm-8">
																				<input class="form-control" id="hoten1" type="text" required>
																			</div>
																		</div>
																		<div class="row" style="margin-bottom:5px">
																			<label class="col-sm-4 control-label" for="mssv1">MSSV:</label>
																			<div class="col-sm-8">
																				<input class="form-control" id="mss1" type="text" required>
																			</div>
																		</div>
																		<div class="row" style="margin-bottom:5px">
																			<label class="col-sm-4 control-label" for="mail1">Email:</label>
																			<div class="col-sm-8">
																				<input class="form-control" id="mail1" type="text" required>
																			</div>
																		</div>
																		<br>
																		<label style="margin-left:60px">Sinh viên cùng thực hiện:</label><br>
																		<div class="row" style="margin-bottom:5px">
																			<label class="col-sm-4 control-label" for="hoten1">Họ và tên:</label>
																			<div class="col-sm-8">
																				<input class="form-control" id="hoten1" type="text">
																			</div>
																		</div>
																		<div class="row" style="margin-bottom:5px">
																			<label class="col-sm-4 control-label" for="mssv1">MSSV:</label>
																			<div class="col-sm-8">
																				<input class="form-control" id="mss1" type="text">
																			</div>
																		</div>
																	</div>
																	<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
																		<label style="margin-left:60px">Giảng viên hướng dẫn:</label><br>
																		<div class="row" style="margin-bottom:5px">
																			<label class="col-sm-4 control-label" for="hoten1">Họ và tên:</label>
																			<div class="col-sm-8">
																				<input class="form-control" id="hoten1" type="text" required>
																			</div>
																		</div>
																		<div class="row" style="margin-bottom:5px">
																			<label class="col-sm-4 control-label" for="mssv1">Email:</label>
																			<div class="col-sm-8">
																				<input class="form-control" id="mss1" type="text" required>
																			</div>
																			<br><br><br><br><br><br>
																			<label style="margin-left:60px">Sinh viên cùng thực hiện(2):</label><br>
																			<div class="row" style="margin-bottom:5px">
																				<label class="col-sm-4 control-label" for="hoten1">Họ và tên:</label>
																				<div class="col-sm-8">
																					<input class="form-control" id="hoten1" type="text">
																				</div>
																			</div>
																			<div class="row" style="margin-bottom:5px">
																				<label class="col-sm-4 control-label" for="mssv1">MSSV:</label>
																				<div class="col-sm-8">
																					<input class="form-control" id="mss1" type="text">
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
															<label class="control-label" for="">Tình hình nghiên cứu trong và ngoài nước:</label><br>
															<label class="col-sm-2 control-label" for="mota">Trong nước:</label>
															<div class="col-sm-10" style="margin-bottom:5px">
																<textarea name="" id="mota" class="form-control" rows="2" required="required"></textarea>
															</div>
															<label class="col-sm-2 control-label" for="mota">Ngoài nước:</label><br><br>
															<div class="col-sm-10" style="margin-bottom:5px">
																<textarea name="" id="mota" class="form-control" rows="2" required="required"></textarea>
															</div>

															<label class="col-sm-2 control-label" for="mota">Tính cấp thiết của đề tài:</label>
															<div class="col-sm-10" style="margin-bottom:5px">
																<textarea name="" id="mota" class="form-control" rows="2" required="required"></textarea>
															</div>

															<label class="col-sm-2 control-label" for="mota">Mục tiêu của đề tài:</label>
															<div class="col-sm-10" style="margin-bottom:5px">
																<textarea name="" id="mota" class="form-control" rows="2" required="required"></textarea>
															</div>

															<label class="col-sm-2 control-label" for="mota">Phương pháp và phạm vi nghiên cứu:</label>
															<div class="col-sm-10" style="margin-bottom:5px">
																<textarea name="" id="mota" class="form-control" rows="2" required="required"></textarea>
															</div>

															<label class="col-sm-2 control-label" for="mota">Nội dung nghiên cứu và tiến độ thực hiện:</label>
															<div class="col-sm-10" style="margin-bottom:5px">
																<textarea name="" id="mota" class="form-control" rows="2" required="required"></textarea>
															</div>

															<label class="col-sm-2 control-label" for="sanphamdukiem">Sản phẩm dự kiến:</label>
															<div class="col-sm-10" style="margin-bottom:5px">
																<input class="form-control" id="sanphamdukiem" type="text" required>
															</div>


															<label class="col-sm-2 control-label" for="diachiungdung">Địa chỉ ứng dụng:</label>
															<div class="col-sm-10" style="margin-bottom:5px">
																<input class="form-control" id="diachiungdung" type="text" required>
															</div>

															<label class="col-sm-2 control-label" for="dxuatkinhphi">Đề xuất kinh phí:</label>
															<div class="col-sm-10" style="margin-bottom:5px">
																<input class="form-control" id="dxuatkinhphi" type="text" required>
															</div>

															<label class="col-sm-2 control-label" for="tendetai">Tải file chi tiết:</label>
															<div class="col-sm-10" style="margin-bottom:10px">
																<input class="form-control" id="tendetai" type="file">
															</div>

															<div id="guidon" style="">
																<button type="submit" id="btn_GuiDon" style="color: #fff;background-color: #5bc0de;border-color: #46b8da; height:35px;width:150px;background-image: none;border: 1px solid transparent;border-radius: 4px; margin-right:15px;float:right;">Gửi đơn đăng ký</button>
																<a class="btn btn-warning" href="sinhvien_DeTaiDeXuat.jsp" role="button" style="margin-left:10px">Đăng ký đề tài được đề xuất</a>

															</div>
														</div>
													</div>
												</form>
											</div>
										</div>
									</div>
								</div><hr>
							</div>
						</div>
						<div class="tab-pane" id="dsDeTaiDK">
							<div class="row">
								<div class="gv_dsDeTaiDK" style="background:white;height:390px;margin-right:15px;border-radius:3px;overflow:auto;">
									<h2 class="tieude_theh">DANH SÁCH ĐỀ TÀI ĐÃ ĐĂNG KÝ</h2><hr>
									<div class="gv_tb_dsDeTaiDK">
										<table class="table table-striped table-hover">
											<thead class="thead-default">
											<thead class="thead-default">
												<tr class="success">
													<th>Mã đề tài</th>
													<th>Tên đề tài</th>
													<th>Giảng viên hướng dẫn</th>
													<th>Chi tiết</th>
													<th>Trạng thái</th>
												</tr>
											</thead>
											<tbody>
											<%
											for (DeTai ct: dt.getListDeTaiGV_DK(session.getAttribute("Email").toString())) {
											%>
												<tr>
													<th><%=ct.getMaDT() %></th>
													<th><%=ct.getTenDT() %></th>
													<th><%=ct.getLinhVuc() %></th>
													<th><%=ct.getTenTT() %></th>
													<th><a href="giangvienPage_ChiTiet.jsp?MaDT=<%=ct.getMaDT() %>">Chi tiết</a></th>
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
						<div class="tab-pane" id="duyetHuy_GianHan">
							<div class="row">
								<div class="gv_duyetHuy_GianHan" style="background:white;height:390px;margin-right:15px;border-radius:3px">
									<h2 class="tieude_theh">DUYỆT HỦY/GIA HẠN ĐỀ TÀI</h2><hr>
									<div class="gv_tb_dsDeTaiDK">
										<table class="table table-striped table-hover">
											<thead class="thead-default">
												<tr class="success">
													<th>Mã đề tài</th>
													<th>Tên đề tài</th>
													<th>Chủ nhiệm đề tài</th>
													<th>Yêu cầu</th>
													<th>Xử lý</th>
												</tr>
											</thead>
											<tbody>
											<%
											for (DeTai ct: dt.getListDeTai_YC_Huy_GiaHan(session.getAttribute("Email").toString())) {
											%>
												<tr>
													<th><%=ct.getMaDT() %></th>
													<th><%=ct.getTenDT() %></th>
													<th><%=ct.getTenCN() %></th>
													<th><%=ct.getTenTT() %></th>
													<th><a href="giangvien_DuyetDon.jsp?MaDT=<%=ct.getMaDT() %>&MaTT=<%=ct.getMaTT() %>">Xử lý</a></th>
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
			<div class="tab-pane active" id="DDHGH">
							<div class="row">
								<div class="QLyTK" style="background:white;height:500px; margin-right:15px;border-radius:3px;">
									<h2 class="tieude_theh"><%=yeucauXuly %></h2><hr>

									<div class="ad_table_qltk" style="margin:0px 5px 0px 5px;">
										<table class="table table-striped table-hover">
											<thead class="thead-default">
												<tr class="success">
													<th>Mã đề tài</th>
													<th>Tên đề tài</th>
													<th>Ngày đăng ký</th>
													<th>Hạn nghiệm thu</th>
													<th>Trạng thái</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td> <%=detai.getMaDT() %></td>
													<td> <%=detai.getTenDT() %></td>
													<td> <%=detai.getNgayThucHien() %></td>
													<td> <%=detai.getNgayKetThuc() %></td>
													<td> <%=detai.getMaTT() %></td>
													
												</tr>

											</tbody>
										</table>
									</div>
									<form>
										<label style="margin-left:15px;margin-right:5px;">Tên chủ nhiệm đề tài:</label>
										<input type="text" name="firstname" style="margin-right:50px;" value="<%=detai.getTenCN()%>"  readonly>
										<label style="margin-left:10px;margin-right:5px;">MSSV:</label>
										<input type="text" name="lastname" value="14110180" readonly>
										<input type="hidden" id="trangthaiDT" value=<%=maTT%>>
									</form><br>
									<div id="thoigianGiahan">
									<label style="margin-left:15px;margin-right:5px;">Gia hạn đến ngày:</label>
									<input type="text" name="lastname" value=<%=giahanDen%> readonly>
									</div>
									<label class="col-sm-4 control-label" for="mota">Lý do:</label><br>
									<div class="col-sm-12">
										<textarea name="" id="mota" class="form-control" rows="3" required="required" readonly><%=lydo%></textarea>
									</div>
									<div class="row">
									<a href="DeTai_Servlet?command=GV_pheduyeHuy_GiaHan&xuly=dongy&MaDT=<%=detai.getMaDT()%>&yeucau=<%=detai.getMaTT()%>&MaGV=<%=detai.getGVHD()%>"><button style="margin-top:380px;margin-right:150px;" type="button" class="btn btn-lg btn-info">Phê duyệt</button></a>
									<a href="DeTai_Servlet?command=GV_pheduyeHuy_GiaHan&xuly=khongdongy&MaDT=<%=detai.getMaDT()%>&yeucau=<%=detai.getMaTT()%>&MaGV=<%=detai.getGVHD()%>"><button style="margin-top:15px;margin-left:150px;" type="button" class="btn btn-lg btn-danger">Không đồng ý</button></a>
									</div>
								</div>
							</div>
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