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
	<script>
	$(function() {
		$('#ajax_content').load("mainPage_TrangChu.jsp");
	});
	</script>
	
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
				<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
					<div class="row">
						<div class="slide">
							<div id="carousel-id" class="carousel slide" data-ride="carousel">
								<ol class="carousel-indicators">
									<li data-target="#carousel-id" data-slide-to="0" class=""></li>
									<li data-target="#carousel-id" data-slide-to="1" class=""></li>
									<li data-target="#carousel-id" data-slide-to="2" class="active"></li>
								</ol>
								<div class="carousel-inner">
									<div class="item">
										<a href="http:/zing.vn">
											<img data-src="holder.js/900x500/auto/#777:#7a7a7a/text:First slide" alt="First slide" src="images/1.jpg" max-height="300px">
											<div class="container">
												<div class="carousel-caption">
													<h1>Example headline.</h1>
													<p>Note: If you're viewing this page via a <code>file://</code> URL, the "next" and "previous" Glyphicon buttons
														on the left and right might not load/display properly due to web browser security rules.
													</p>
												</div>
											</div>
										</a>
									</div>
									<div class="item">
										<a href="http://zing.vn">
											<img data-src="holder.js/900x500/auto/#666:#6a6a6a/text:Second slide" alt="Second slide" src="images/2.jpg">
											<div class="container">
												<div class="carousel-caption">
													<h1>Another example headline.</h1>
													<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.
														Nullam id dolor id nibh ultricies vehicula ut id elit.
													</p>
												</div>
											</div>
										</a>
									</div>
									<div class="item active">
										<a href="http://zing.vn">
											<img data-src="holder.js/900x500/auto/#666:#6a6a6a/text:Second slide" alt="Second slide" src="images/4.jpg">
											<div class="container">
												<div class="carousel-caption">
													<h1>Another example headline.</h1>
													<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.
														Nullam id dolor id nibh ultricies vehicula ut id elit.
													</p>
												</div>
											</div>
										</a>
									</div>
								</div>
								<a class="left carousel-control" href="#carousel-id" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
								<a class="right carousel-control" href="#carousel-id" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="noidung">
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<div class="thongqua" style="cursor:pointer">
										<div class="hinh_tq_kt">
											<h4>Đề tài thông qua</h4>
											<img src="images/thongqua.png" class="img-responsive" alt="Image">
										</div>
										<ul class="list-group">
											<li class="list-group-item">
												<p class="ltbao">
													Nghiên cứu quản lý công trình
												</p>
												<div id="dt1" class="collapse">
													<img src="images/ha3.jpg">
													<p>Đề tài đã hoàn thành vào tháng 11/2014...
													</p>
												</div>
											</li>

											<li class="list-group-item">
												<p class="ltbao">
													Nghiên cứu hệ thống
												</p>
												<div id="dt1" class="collapse">
													<img src="images/ha3.jpg">
													<p>Đề tài đã hoàn thành vào tháng 11/2014...
													</p>
												</div>
											</li>
											<li class="list-group-item">
												<p class="ltbao">
													Xây dựng website bán hàng
												</p>
												<div id="dt1" class="collapse">
													<img src="images/ha3.jpg">
													<p>Đề tài đã hoàn thành vào tháng 11/2014...
													</p>
												</div>
											</li>
										</ul>
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<div class="khenthuong" style="cursor:pointer">
										<div class="hinh_tq_kt">
											<h4>Đề tài khen thưởng</h4>
											<img src="images/khenthuong.png" class="img-responsive" alt="Image">
										</div>
										<ul class="list-group">
											<li class="list-group-item" id="main_dtkt1">
												<p class="ltbao">
													Xây dựng trang web quản lý NCKH
												</p>
												<div id="dt1" class="collapse">
													<img src="images/ha3.JPG">
													<p>Đề tài đã hoàn thành vào tháng 11/2014...
													</p>
												</div>
											</li>
											<li class="list-group-item" id="main_dtkt2">
												<p class="ltbao">
													Nghiên cứu về thực phẩm dinh dưỡng
												</p>
												<div id="dt2" class="collapse">
													<img src="images/ha4.JPG">
													<p>Đề tài đã hoàn thành vào tháng 4/2015...
													</p>
												</div>
											</li>
											<li class="list-group-item" id="main_dtkt3">
												<p class="ltbao">
													Nghiên cứu thiết kế nhà ở đẹp
												</p>
												<div id="dt3" class="collapse">
													<img src="images/ha2.JPG">
													<p>Đề tài được chứng nhận có thiết kế đẹp và lạ nhất...
													</p>
												</div>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
					<div class="thongbao" style="cursor:pointer">
						<div class="row">
							<div>
								<img src="images/thongbao.png" alt="Image">
							</div>
						</div>
						<div class="notice">
							<ul class="list-group">
								<li class="list-group-item" data-toggle="collapse" data-target="#demo">
									<p class="ltbao">
										Thông báo về việc bổ sung một số đề tài mới
									</p>
									<div id="demo" class="collapse">
										<p>Đề tài 1:Ứng dụng chỉ số Z-core để cảnh báo nguy cơ phá sản của các DN ngành thủy sản niêm yết</p>
										<p>Đềi tài 2: Quản trị TC của DN ngành xây dựng công trình viễn thông </p>
										<p>Đềi tài 3:Giải pháp nâng cao khả năng sinh lời tại CTCP Dược phẩm Trung ương 3 </p>
									</div>
								</li>
								<li class="list-group-item" data-toggle="collapse" data-target="#dthethan">
									<p class="ltbao">Thông báo các đề tài sắp hết hạn</p>
									<div id="dthethan" class="collapse">
										<p>Đề tài 1:Ứng dụng chỉ số Z-core để cảnh báo nguy cơ phá sản của các DN ngành thủy sản niêm yết</p>
										<p>Đềi tài 2: Quản trị TC của DN ngành xây dựng công trình viễn thông </p>
										<p>Đềi tài 3:Giải pháp nâng cao khả năng sinh lời tại CTCP Dược phẩm Trung ương 3 </p>
									</div>

								</li>
								<li class="list-group-item" data-toggle="collapse" data-target="#trocap">
									<p class="ltbao">
										Thông báo về trợ cấp NCKH
									</p>
									<div id="trocap" class="collapse">
										Ngày 20/10 sẽ phát tiền trợ cấp nghiên cứu khoa học đợt 1.
									</div>
								</li>
							</ul>
						</div>
					</div>
					<script>
					$(function() {
						$(".list-group-item").on("click", function() {
							$(this).find(".collapse").slideDown(1000);
							$(this).css({
								"background-color":"#3b5998",
								"color":"white"
							});
							$(".list-group-item>div").css({
								"background-color":"white",
								"color":"black"
							});
						});
						$(".list-group-item").on("mouseleave", function() {
							$(this).find(".collapse").slideUp(500);
							$(this).css({
								"background-color":"white",
								"color":"black"
							});
						});
					});
					</script>
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