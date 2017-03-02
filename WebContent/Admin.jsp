

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
<script type="text/javascript" src="vendor/bootstrap.js"></script>
<script type="text/javascript" src="1.js"></script>
<link rel="stylesheet" href="vendor/bootstrap.css">
<link rel="stylesheet" href="1.css">
<link rel="stylesheet" href="vendor/font-awesome.css">
<script type="text/javascript" src="jquery.validate.min.js"></script>
<script>	
$(document).ready(function() {
	if($('.message_Error').text() != null)
		 $('.message_Error').hide();
     else	 
    	{
    	 if($('.message_Error').text()== 'Thành công')
			{
				$('.message_Error b').css({"color": "green", "font-size": "100%"});
				$('.message_Error').fadeIn(300).delay(5000).hide(400);
			}
			else
			{
				$('.message_Error b').css({"color": "red", "font-size": "100%"});
				$('.message_Error').fadeIn(300).delay(5000).hide(400);
			}
    	}
})
</script>
</head>
<body>
	<%
	String type = request.getParameter("type");
	String error="";
TaiKhoan_Controller tk=new TaiKhoan_Controller();
	if (request.getParameter("type") != null)
	{
		if(type.equals("cntt_1"))
			error = "Cập nhập thành công!";
		if(type.equals("cntt_0"))
			error = "Cập nhập thất bại!";
		if(type.equals("xoatk_1"))
			error = "Xóa tài khoản thành công!";
		if(type.equals("xoatk_0"))
			error = "Xóa tài khoản thất bại!";
		if(type.equals("ttk_1"))
			error = "Thêm thành công!";
		if(type.equals("ttk_0"))
			error = "Thêm thất bại!";
		
	}
%>
<script type="text/javascript">
   $(document).ready(function() {
       var x = $('.Mssg').text();
       var y = $('.TypeMssg').text();
    	if(x != "null" && x != "")
    	{
    		if(y=="cntt_1"||y=="xoatk_1")
    			$("#ModalSuccess").modal('show');
    		if(y=="cntt_0"||y=="xoatk_0")
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
			<div class="row">
				<div class="col-md-2">
					<ul class="nav nav-pills nav-stacked"
						style="background: white; border-radius: 3px">
						<li class="active"><a class="list-group-item" href="#QLTK"
							data-toggle="pill"> <span class="glyphicon glyphicon-user"></span>
								Quản lý tài khoản
						</a></li>
					</ul>
				</div>
				<div class="col-md-10">
					<div class="tab-content">
						<div class="tab-pane active" id="QLTK">
							<div class="row" style="margin-bottom: 7px;">
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
					</div>

				</div>
			</div>
		</div>
	</div>
	<div id='bttop'>
		<img src="images/backtotop.png" alt="backtotop" width="50px"
			height="50px">
	</div>
	<footer style="margin-bottom: 0px; margin-top: 3px;">
		<pre style="margin-bottom: 0px;">
                Copyright@ Phòng nghiên cứu khoa học và quan hệ quốc tế
            </pre>
	</footer>

</body>

</html>