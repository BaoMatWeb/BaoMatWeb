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
	<script>
$( document ).ready(function() {
	$('#DSDeTai_SV tr').each(function() {
	    var customerId = $(this).find(".trangthaiDT").text();
	    if(customerId != "Đang tiến hành")
	    {
    		$(this).find(".dsDeTai_actionButton").attr("disabled",true);
    	}
	 });
});
</script>
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
	if (request.getParameter("MaDT") != null) {
		maDT = request.getParameter("MaDT");
		detai = dt.getListDeTaiByMaDT(maDT);
	}
	String type = request.getParameter("type");
	String error ="";
	if (request.getParameter("type") != null)
	{
		
		if(type.equals("dkdt_1"))
			error = "Đăng ký đề tài thành công!";
		if(type.equals("dkdt_0"))
			error = "Đăng ký đề tài thất bại!";
		if(type.equals("dkdtdx_1"))
			error = "Đăng ký đề tài thành công!";
		if(type.equals("dkdtdx_0"))
			error = "Đăng ký đề tài thất bại!";
		if(type.equals("ghdt_1"))
			error = "Gửi đơn gia hạn thành công!";
		if(type.equals("ghdt_0"))
			error = "Gửi dơn gia hạn thất bại!";
		if(type.equals("hdt_1"))
			error = "Gửi dơn hủy thành công!";
		if(type.equals("hdt_0"))
			error = "Gửi dơn hủy thất bại!";
		if(type.equals("cntt_1"))
			error = "Cập nhật thông tin thành công!";
		if(type.equals("cntt_0"))
			error = "Cập nhật thông tin thất bại!";
		if(type.equals("dmk_1"))
			error = "Đổi mật khẩu thành công!";
		if(type.equals("dmk_0"))
			error = "Đổi mật khẩu thất bại!";
		if(type.equals("xoatb_1"))
			error = "Xóa thông báo thành công!";
		if(type.equals("xoatb_0"))
			error = "Xóa thông báo thất bại!";
	}
%>
<body>
<script type="text/javascript">
   $(document).ready(function() {
       var x = $('.Mssg').text();
       var y = $('.TypeMssg').text();
    	if(x != "null" && x != "")
    	{
    		if( y == "dkdt_1" || y == "dkdtdx_1" || y == "ghdt_1" || y == "hdt_1" || y == "cntt_1" || y == "dmk_1"|| y == "xoatb_1")
    			$("#ModalSuccess").modal('show');
    		if( y == "dkdt_0" || y == "dkdtdx_0" || y == "ghdt_0" || y == "hdt_0" || y == "cntt_0" || y == "dmk_0"|| y == "xoatb_0")
    			$("#ModalFail").modal('show');
    	}
    });
</script>
<div class="modal fade" id="ModalSuccess">
   <div class="modal-dialog">
        <div class="modal-content panel panel-success">
              <div class="modal-header panel-heading" style="text-align:center">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h3><%=error %></h3>
                    <button class="btn btn-danger btn-md" data-dismiss="modal"></span>Cancel</button>
               </div>
         </div>
     </div>
</div>
<div class="modal fade" id="ModalFail">
   <div class="modal-dialog">
        <div class="modal-content panel panel-danger">
              <div class="modal-header panel-heading" style="text-align:center">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h3><%=error %></h3>
                    <button class="btn btn-danger btn-md" data-dismiss="modal"></span>Cancel</button>
               </div>
         </div>
     </div>
</div>
<h4 class="Mssg hidden" style="text-align:center"><%=error%></h4>
<h4 class="TypeMssg hidden" style="text-align:center"><%=type%></h4>
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
									<li><a href="sinhvienPage.jsp">Trang chủ</a></li>
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
						<li class="active"><a class="list-group-item" href="#thongbao" data-toggle="pill">
							<span class="glyphicon glyphicon-home"></span> Thông báo</a>
						</li>
						<li style="margin-top:0px;"><a href="#dsDeTai" class="list-group-item" data-toggle="pill">
							<span class="glyphicon glyphicon-list-alt"></span> Danh sách đề tài</a>
						</li>
						<li style="margin-top:0px;"><a href="#dkDeTai" class="list-group-item" data-toggle="pill" style="border-radius:0px;">
							<span class="glyphicon glyphicon-inbox"></span> Đăng ký đề tài NCKH</a>
						</li>
						<li style="margin-top:0px;"><a href="#kqNghiemThu" class="list-group-item" data-toggle="pill">
							<span class="glyphicon glyphicon-check"></span> Kết quả nghiệm thu</a>
						</li>
						<li style="margin-top:0px;"><a href="#ttTaiKhoan" class="list-group-item" data-toggle="pill">
							<span class="glyphicon glyphicon-user"></span> Thông tin tài khoản</a>
						</li>
					</ul>
				</div>
				<div class="col-md-10">
					<div class="tab-content">
						<div class="tab-pane" id="thongbao">
									<div class="row">
										<div class="svThongBao " style="background:white;height:500px;margin-right:15px;border-radius:3px">
											<h2 class="tieude_theh" >THÔNG BÁO</h2><hr>
											<div class="sv_table_thongbao" ng-app="sortApp" ng-controller="mainController">
												<form>
													<div class="form-group">
														<div class="input-group col-xs-8" style="margin-left:50px;" >
															<div class="input-group-addon"><i class="fa fa-search"></i></div>
															<input type="text" class="form-control" placeholder="Search da Fish" ng-model="searchFish">
														</div>      
													</div>
												</form>
												<table class="table table-striped table-hover">
													<thead>
														<tr class="success">

															<th>
																<a href="#" ng-click="sortType = 'name'; sortReverse = !sortReverse">
																	Thông báo
																	<span ng-show="sortType == 'name' && !sortReverse" class="fa fa-caret-down"></span>
																	<span ng-show="sortType == 'name' && sortReverse" class="fa fa-caret-up"></span>
																</a>
															</th>
															<th>
																<a href="#" ng-click="sortType = 'fish'; sortReverse = !sortReverse">
																	Người gửi
																	<span ng-show="sortType == 'fish' && !sortReverse" class="fa fa-caret-down"></span>
																	<span ng-show="sortType == 'fish' && sortReverse" class="fa fa-caret-up"></span>
																</a>
															</th>
															<th>
																<a href="#" ng-click="sortType = 'fish'; sortReverse = !sortReverse">
																	Ngày gửi
																	<span ng-show="sortType == 'fish' && !sortReverse" class="fa fa-caret-down"></span>
																	<span ng-show="sortType == 'fish' && sortReverse" class="fa fa-caret-up"></span>
																</a>
															</th>
															<th>
																<a href="#" ng-click="sortType = 'tastiness'; sortReverse = !sortReverse">
																	Chi tiết 
																	<span ng-show="sortType == 'tastiness' && !sortReverse" class="fa fa-caret-down"></span>
																	<span ng-show="sortType == 'tastiness' && sortReverse" class="fa fa-caret-up"></span>
																</a>
															</th>
															<th><a href="">Xóa TB</a></th>
														</tr>
													</thead>
		
													<tbody>
														<%
				     										for (TB_TK tbtk2: cttb.getListTB_TKByMaTK(session.getAttribute("Email").toString())) {
														%>
														<tr >
																<td><%=tbtk2.getTinTB() %></td>
																<td><%=tbtk2.getTenNguoiGui() %></td>
																<td><%=tbtk2.getNgayGui() %></td>
																<td><a href="sinvien_XemThongBao.jsp?MaCTTB=<%=tbtk2.getMaCTTB() %>">Xem</a></td>
																<td><a href="TB_TK_Servlet?command=delete&MaCTTB=<%=tbtk2.getMaCTTB() %>">Xóa</a></td>
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
						<div class="tab-pane" id="dsDeTai"  >
										<div class="row" id="ttt">
											<div class="svdsDeTai" style="background:white;height:500px;margin-right:15px;border-radius:3px">
												<h2 class="tieude_theh">DANH SÁCH ĐỀ TÀI</h2><hr>
												<div class="sv_table_dsDeTai">
													<table class="table table-striped table-hover" id="DSDeTai_SV">
														<thead class="thead-default">
															<tr class="success">
																<th>Mã số</th>
																<th>Tên đề tài</th>
																<th>Ngày đăng ký</th>	
																<th>Hạn nghiệm thu</th>
																<th>Trạng thái</th>
																<th>Chi tiết</th>
																<th>Nộp báo cáo</th>
																<th>Chức năng</th>
															</tr>
														</thead>
														<tbody>
														<%
				     										for (DeTai detai1: dt.getListDeTaiByMaCN(session.getAttribute("Email").toString())) {
				     											
														%>
															<tr>
																<td><%=detai1.getMaDT() %></td>
																<td><%=detai1.getTenDT() %></td>
																<td><%=detai1.getNgayThucHien() %></td>
																<td><%=detai1.getNgayKetThuc()%></td>
																<td class="trangthaiDT"><%=detai1.getTenTT()%></td>
																<td><a href="sinhvien_XemCTDT.jsp?MaDT=<%=detai1.getMaDT()%>">Xem</a></td>
																<td><a href="sinhvien_NopBaoCao.jsp?MaDT=<%=detai1.getMaDT()%>">Nộp</a></td>
																<td class="dropdown"><a class="btn btn-default dsDeTai_actionButton" data-toggle="dropdown" href="#"> Action </a>
																<ul id="contextMenu" class="dropdown-menu" role="menu">
																<li><a tabindex="-1" href="sinhvien_GiaHanDT.jsp?MaDT=<%=detai1.getMaDT() %>" >Gia Hạn</a></li>
																<li><a tabindex="-1" href="sinhvien_LyDoHyGHDT.jsp?MaDT=<%=detai1.getMaDT() %>">Hủy</a></li>
																</ul>
																</td>
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
									<div class="tab-pane" id="kqNghiemThu">
										<div class="row">
											<div class="svkqNghiemThu" style="background:white;height:500px;margin-right:15px;border-radius:3px">
												<h2 class="tieude_theh">KẾT QUẢ NGHIỆM THU</h2><hr>
												<div class="sv_table_kqNghiemThu">
													<table class="table table-striped table-hover">
														<thead class="thead-default">
															<tr class="success">
																<th>Mã số đề tài</th>
																<th>Tên đề tài</th>
																<th>Ngày đăng ký</th>
																<th>Ngày nghiệm thu</th>
																<th>Xếp loại</th>
																<th>Kết quả chi tiết</th>
															</tr>
														</thead>
														<tbody>
															<%
				     										for (DeTai detai2: dt.getListDeTaiNT(session.getAttribute("Email").toString())) {
															%>
															<tr>
																<td><%=detai2.getMaDT() %></td>
																<td><%=detai2.getTenDT() %></td>
																<td><%=detai2.getNgayThucHien() %></td>
																<td><%=detai2.getNgayNT() %></td>
																<td><%=detai2.getTrangThaiNT()%></td>
																<td><a href="sinhvien_KetQuaNT.jsp?MaDT=<%=detai2.getMaDT()%>">Xem</a></td>
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
						
									<div class="tab-pane" id="ttTaiKhoan">
										<div class="row">
											<div class="svttTaiKhoan" style="background:white;height:500px;margin-right:15px;border-radius:3px">
												<h2 class="tieude_theh">THÔNG TIN TÀI KHOẢN</h2><hr>
												<div class="ttTaiKhoan_content">
													<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
														<div class="svAnhDaiDien">
															<img src="images/daidien.jpg" alt="Image" width="85%" height="250px" style="margin-left:18px; margin-top:15px;">
															<form action="">
																<input type="file" name="pic" accept="image/*">
															</form>
														</div>
													</div>
													<div class="col-xs-7 col-sm-7 col-md-7 col-lg-7">
														<div class="row">
														<%
				     										TaiKhoan taikhoan= tk.getTaiKhoanByMaTK(session.getAttribute("Email").toString());
															%>
															<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
																<br>
																
																	<b>
																		<p>Tên chủ nhiệm: <%=taikhoan.getHoTen() %></p>
																		<p>MSSV: <%=taikhoan.getMatKhau() %></p>
																		<p>Ngày sinh: <%=taikhoan.getNgaySinh() %></p>
																		<p>Thuộc khoa: <%=taikhoan.getNganh() %></p>
																		<p>Quê quán: Quảng Ngãi</p>
																	</b>
																
															</div>
															<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
																<br>
																
																	<b>
																		<p>Mail: <%=taikhoan.getEmail() %></p>
																		<p>Ngành:<%=taikhoan.getNganh() %></p>
																		<p>Mã số ngân hàng: <%=taikhoan.getMSNH() %></p>
																		<p>Chi nhánh ngân hàng: <%=taikhoan.getCNNH() %></p>
																		<p>Đơn vị công tác: ZXC</p>
																	</b>
															</div>
															<%
				     										
																%>
														</div>
														<div class="row">
															<div class="container">
																<a class="btn btn-warning" style="margin-top:40px;margin-left:80px;" data-toggle="modal" href='#modal-id'>Đổi mật khẩu</a>
																<div class="modal fade" id="modal-id">
																	<div class="modal-dialog">
																		<div class="modal-content">
																			<div class="modal-header">
																				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
																				<h4 class="modal-title">Modal title</h4>
																			</div>
																			<div class="modal-body panel panel-success">
																				<div class="title panel-heading" style=" text-align:center; margin-bottom:15px;">
																					<h2> ĐỔI MẬT KHẨU </h2>
																					
																				</div>
																				<div class="doi panel-body">
																					<form action="TaiKhoan_Servlet" id="register-form" name="doipass" method="POST" class="form-horizontal" role="form">
																						<input type="hidden" name="command" value="doimk">
																						<input type="hidden" name="MaTK" value="<%=session.getAttribute("Email").toString()%>">
																						
																						<div class="form-group has-feedback" style="margin-left:65px;">
																							<div class="col-xs-10">
																								<label for="pass">Mật khẩu cũ<span>:</span></label> 
																								<input class="form-control" name="pass" id="pass" type="password"  required />
																								<span class="glyphicon form-control-feedback" id="pass1"></span>
																								<span class="message" style="color:red;"" >Mật khẩu cũ không đúng. Vui lòng nhập lại mật khẩu!</span>
																							</div>
																						</div>
																						<div class="form-group has-feedback" style="margin-left:65px;">
																							<div class="col-xs-10">
																								<label for="npass">Mật khẩu mới<span>:</span></label> 
																								<input class="form-control " name="npass"  type="password" id="npass" required />
																								<span class="glyphicon form-control-feedback" id="npass1"></span>
																							</div>
																						</div>
																						<div class="form-group has-feedback" style="margin-left:65px;">
																							<div class="col-xs-10">
																								<label for="cfpass">Nhập lại mật khẩu mới<span>:</span></label> 
																								<input class="form-control" name="cfpass" id="cfpass"  type="password" required />
																								<span class="glyphicon form-control-feedback" id="cfpass1"></span>
																							</div>
																						</div>
																						<div class="modal-footer">
																							<button type="button" class="btn btn-danger"  data-dismiss="modal">Hủy</button>
																							<button type="submit" class="btn btn-primary" >Lưu</button>
																						</div>
																					</form>
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
																<a class="btn btn-primary" data-toggle="modal" href="#modaltt" style="margin-top:40px; margin-left:30px;">Cập nhật thông tin</a>
																<div class="modal fade" id="modaltt">
																	<div class="modal-dialog">
																		<div class="modal-content">
																			<div class="modal-header">
																				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
																				<h4 class="modal-title">Modal title</h4>
																			</div>
																			<div class="modal-body">
																				<div class="row">
																					<div class="title " style=" text-align:center; margin-bottom:15px;">
																						<h2> CẬP NHẬT THÔNG TIN </h2>
																					</div>
																				</div>
																				<div class="row">
																					<div class="col-xs-5 col-sm-5 col-md-5 col-lg-5" style="padding-right:0px;">
																						<div class="svAnhDaiDien" style="margin-top:20px;" >
																							<img src="images/daidien.jpg" alt="Image" width="90%" height="250px" style="margin-left:10px; margin-top:10px;">
																							<form action="">
																								<input type="file" name="pic" accept="image/*">
																							</form>
																						</div>
																					</div>
																					<div class="col-xs-7 col-sm-7 col-md-7 col-lg-7">
																						<form action="TaiKhoan_Servlet" id="formcntt" method="post" class="form-horizontal">
																							<input type="hidden" name="command" value="update">
																							<input type="hidden" name="MaTK" value=<%=session.getAttribute("Email").toString()%>>
																							<input type="hidden" name="Quyen" value="Student">
																							<div class="form-group has-feedback" style="margin-left:20px;">
																								<div class="col-xs-11">
																									<label for="email">Mail<span>:</span></label> 
																									<input class="form-control" name="email" id="email" type="email" required/>
																									<span class="glyphicon form-control-feedback" id="email1"></span>
																								</div>
																							</div>
																							<div class="form-group has-feedback" style="margin-left:20px;">
																								<div class="col-xs-11">
																									<label for="sodt">Ngành<span>:</span></label>
																									<input class="form-control" name="nganh" id="nganh" type="text"  required/>
																									<span class="glyphicon form-control-feedback" id="nganh1"></span>
																								</div>
																							</div>
																							<div class="form-group has-feedback" style="margin-left:20px;">
																								<div class="col-xs-11">
																									<label for="cnnganhang">Chi nhánh ngân hàng<span>:</span></label> 
																									<input class="form-control" name="cnnganhang" id="cnnganhang" type="text" required/>
																									<span class="glyphicon form-control-feedback" id="cnnganhang1"></span>
																								</div>
																							</div>
																							<div class="form-group has-feedback" style="margin-left:20px;">
																								<div class="col-xs-11">
																									<label for="donvi">Mã số ngân hàng<span>:</span></label> 
																									<input class="form-control" name="masoNH" id="donvi" type="text" required/>
																									<span class="glyphicon form-control-feedback" id="donvi1"></span>
																								</div>
																							</div>
																							
																							<div class="modal-footer">
																								<button type="button" class="btn btn-danger" data-dismiss="modal">Hủy</button>
																								<button type="submit" class="btn btn-primary" >Lưu</button>
																							</div>
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
													</div>
												</div>
											</div>
										</div>
									
				<div class="tab-pane active" id="GHDT">
							<div class="row">
								<div class="QLyTK" style="background:white;height:550px;margin-right:15px;border-radius:3px">
									<h2 class="tieude_theh">GIA HẠN ĐỀ TÀI</h2>
									<hr>
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
												
													<tr >
														<td><%=detai.getMaDT() %></td>
														<td><%=detai.getTenDT() %></td>
 													  	<td><%=detai.getNgayThucHien() %></td>
														<td><%=detai.getNgayKetThuc() %></td>
														<td><%=detai.getTenTT() %></td>
													</tr>
												
											</tbody>
										</table>
									</div>
									<form  action="GiaHanDT_Servlet" method="get">
									<input type="hidden" name="command" value="insert" />
									<input type="hidden" name="xuly" value="guidongiahan" />
									<input type="hidden" name="MaDT" value="<%=detai.getMaDT() %>"/>
										<div class="form-inline">
											<div class="col-xs-6">
											<label class="fieldinput" style="margin-left:10px;">Họ tên: </label>
											<input class="form-control" id="" type="text" name="tenCN" value="<%=detai.getTenCN() %>" readonly>
											</div>
										</div>
										<div class="form-inline">
											<div class="col-xs-6">
											<label>MSSV: </label>
											<input class="form-control" id="" type="text" value="<%=detai.getMSSVCN() %>" readonly>
											
											</div>
										</div>
										<div >
											<label class="col-sm-3" for="mota" style="margin-top:10px; margin-left:10px;">Lý do gia hạn đề tài </label><br>
											<div class="col-sm-12">
												<textarea type="text" name="lydo" class="form-control required mota" placeholder="Lý do cá nhân"  id="" required  data-placement="right" data-trigger="hover" data-content="Bạn cần phải nhập vào trường này" rows="3" required style="margin-left:10px;"></textarea>
											</div>
										</div>
											<div class="form-group">
												<label class="col-sm-3" for="ngay" style="float:left; margin-left:10px; margin-top:15px;">Gia hạn đến ngày:</label>
												<div class="col-sm-4">
													<input type="text" type="text" name="ngay" class="form-control required ngay"  id="" required data-placement="right" data-trigger="manual" data-content="Vui lòng nhập theo định dạng mm/dd/yy" placeholder="mm/dd/yy" style="float:left; margin-left:10px; margin-top:10px;"required>
												</div>
											</div>
											<button type="submit" id="btn_GuiDon"  class="btn btn-info" style="float:right; margin-right:10px; margin-top:380px;">Gửi đơn</button>
									</form>
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