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
	<script type="text/javascript" src="jquery.validate.min.js"></script>
	
	
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
								<ul class="nav navbar-nav" >
									<li ajaxid="mainPage_TrangChu.jsp"><a href="">Trang chủ</a></li>
									<li ajaxid="mainPage_BieuMau.jsp"><a href="">Biểu Mẫu</a></li>
									<li ajaxid="mainPage_LienHe.jsp"><a href="">Liên Hệ</a></li>
									<li ajaxid="mainPage_HuongDan.jsp"><a href="">Hướng dẫn</a></li>
								</ul>
								<ul class="nav navbar-nav navbar-right">
									<li ajaxid="mainPage_Login.jsp"><a href>Đăng nhập</a></li>
								</ul>
							</div>
							<script>
							$(function() {
								$("#menuMain li").on("click", function(e) {
									e.preventDefault(); 
									var x = $(this).attr("ajaxid");
									$('#ajax_content').load(x);
								});
							});
							</script>
							<!-- /.navbar-collapse -->
						</div>
					</nav>
				</div>
			</div>
		</div>
		<div class="content">
			<div class="row" id="ajax_content">
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

	<%
	String type = request.getParameter("type");
	String error="";

	if (request.getParameter("type") != null)
	{
		if(type.equals("dntb"))
			error = "Tài khoản hoặc mật khẩu không đúng!";
	}
%>
<script type="text/javascript">
   $(document).ready(function() {
       var x = $('.Mssg').text();
       var y = $('.TypeMssg').text();
    	if(x != "null" && x != "")
    	{
    		if(y=="dntb")
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
<div class="row" style="heigth:390px">
	<div class="col-md-6 col-md-offset-3">
		<div class="panel panel-default box_shadow" style="margin-top:40px;height:330px">
			<div class="panel-heading">
				<h3 class="panel-title" style="text-align:center"><b>Sign In</b></h3>
			</div>
			<div class="panel-body">
				<form action="Login_servlet" method="post" id="">
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

								<div class="">
									<input class="form-control" id="svLogin_Email" placeholder="E-mail" name="Email" type="" >
								
								</div>
								<div class="">
									<input class="form-control" id="svLogin_Pass" placeholder="Password" name="password" type="Password" value="">
									
								</div>
								<div class="checkbox">
									<label>
										<input name="remember" type="checkbox" value="Remember Me"> Remember Me
									</label>
								</div>
								<input type="submit" value="Login" class="btn-lg col-lg-12" />
							
					</form>	
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
		<footer style="margin-bottom:0px;margin-top:0px;;">
			<pre style="margin-bottom:0px;">
				Copyright@ Phòng nghiên cứu khoa học và quan hệ quốc tế
			</pre>
		</footer>
	</div>
</div>
</body>

</html>