<%@page import="Model.TaiKhoan"%>
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
	<title> Example </title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script type="text/javascript" src="vendor/bootstrap.js"></script>
	<script type="text/javascript" src="1.js"></script>
	<link rel="stylesheet" href="vendor/bootstrap.css">
	<link rel="stylesheet" href="1.css">
	<link rel="stylesheet" href="vendor/font-awesome.css">
</head>

<body>
<%
TaiKhoan_Controller tk=new TaiKhoan_Controller();
String type = request.getParameter("type");
	String error ="";
	if (request.getParameter("type") != null)
	{
		
		if(type.equals("themtk_1"))
			error = "Thêm tài khoản từ file thành công!";
		if(type.equals("themtk_0"))
			error = "Thêm tài khoản từ file thất bại!";
		
	}
%>
<body>
<script type="text/javascript">
   $(document).ready(function() {
       var x = $('.Mssg').text();
       var y = $('.TypeMssg').text();
    	if(x != "null" && x != "")
    	{
    		if( y == "themtk_1" )
    			$("#ModalSuccess").modal('show');
    		if( y == "themtk_0")
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
									<li><a href="#">Trang chủ</a></li>
									<li><a href="#">Biểu Mẫu</a></li>
									<li><a href="#">Liên Hệ</a></li>
									<li><a href="#">Hướng dẫn</a></li>
								</ul>
								<ul class="nav navbar-nav navbar-right">
									<li><a href="#"><span  style="color:blue">Admin</span></a></li>
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
			<div class="row" style="margin-bottom:9px;">
				<div class="col-md-2">
					<ul class="nav nav-pills nav-stacked" style="background:white;border-radius:3px">
						<li ><a class="list-group-item" href="#QLTK" data-toggle="pill">
							<span class="glyphicon glyphicon-user"></span> Quản lý tài khoản</a>
						</li>
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
						<div class="tab-pane active" id="ThemTKTF">
							<div class="row">
								<div class="QLyTK" style="background:white;height:380px;margin-right:15px;border-radius:3px;overflow:auto;">
									<h2 style="margin-top:0px;padding:5px;text-align:center;font-family:sans-serif">QUẢN LÝ NGƯỜI DÙNG</h2>
									<hr>
									<div class="input-group">
										<label class="input-group-btn"> <span
											class="btn btn-primary"> Duyệt... <input type="file"
												 name="xlfile" id="xlf"  style="display: none;"					
												accept=".xls">
										</span>
										</label> <input id="thongtin" type="text" class="form-control" readonly >
									</div>
									<h3 id="soluong" style="color:yellow" ></h3>
									<form action="TruyenDi" method="POST">
									<input type="hidden" id="out" name="duong" >
									<input type="submit" class="btn btn-success" id="upload-button"
										value="Tải lên danh sách" />
									</form>
									<div class="ad_table_qltk" style="margin:0px 5px 0px 5px;">
										<table class="table table-striped table-hover">
											<thead class="thead-default">
												<tr class="success">
													<th>Tên tài khoản</th>
													<th>Mã số</th>
													<th>Tài khoản</th>
													<th>Quyền truy cập</th>
													<th>Ngành</th>
												</tr>
											</thead>
											<tbody>
											<%
											for (TaiKhoan c:tk.getListTaiKhoan()){
											%>
												<tr>
													<td><%=c.getHoTen()%></td>
													<td><%=c.getMaTK()%></td>
													<td><%=c.getEmail()%></td>
													<td><%=c.getQuyen()%></td>
													<td><%=c.getNganh()%></td>

												</tr>
												<%
											}
												%>

											</tbody>
										</table>
									</div>
									<!-- <pre id="out"></pre> -->
									<input type="hidden" name="command" value="themnhieusv">
									
									<script src="xls.min.js"></script>
<script>

</script>
<script>
var X = XLS;
var XW = {
	msg: 'xls',	
};

var rABS = typeof FileReader !== "undefined" && typeof FileReader.prototype !== "undefined" && typeof FileReader.prototype.readAsBinaryString !== "undefined";


function fixdata(data) {
	var o = "", l = 0, w = 10240;
	for(; l<data.byteLength/w; ++l) o+=String.fromCharCode.apply(null,new Uint8Array(data.slice(l*w,l*w+w)));
	o+=String.fromCharCode.apply(null, new Uint8Array(data.slice(l*w)));
	return o;
}

function to_csv(workbook) {
	var result = [];
	workbook.SheetNames.forEach(function(sheetName) {
		var csv = X.utils.sheet_to_csv(workbook.Sheets[sheetName]);
		if(csv.length > 0){
			/*result.push("SHEET: " + sheetName);*/
			 /* result.push(""); */			
			result.push(csv);
			
		}
	});
	return result;
}
function countLine() {
	  var text = $('#out').val();
	  var lines = text.split("\n");
	  var count = 0;
	  for (var i = 0; i < lines.length-1; i++) {
	    if (lines[i].trim()!="" && lines[i].trim()!=null) {
	      count += 1;
	    }
	  }
	 $('#soluong').html("Số tài khoản từ file: "+count);
	}
function process_wb(wb) {
	if(use_worker) XLS.SSF.load_table(wb.SSF);
	var output =to_csv(wb);
	
	if(out.value === undefined) out.textContent = output;
	else out.value = output;
	if(typeof console !== 'undefined') console.log("output", new Date());
}

var xlf = document.getElementById('xlf');
function handleFile(e) {
	rABS = 0;
	use_worker = 0;
	var files = e.target.files;
	var f = files[0];
	{
		var reader = new FileReader();
		var name = f.name;
		reader.onload = function(e) {
			if(typeof console !== 'undefined') console.log("onload", new Date(), rABS, use_worker);
			var data = e.target.result;
				var arr = fixdata(data);
				var	wb = X.read(btoa(arr), {type: 'base64'});
					process_wb(wb);
					countLine();
			
		};
		if(rABS) reader.readAsBinaryString(f);
		else reader.readAsArrayBuffer(f);
	}
}

if(xlf.addEventListener) xlf.addEventListener('change', handleFile, false);
</script>
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
            <pre style="margin-bottom:0px;" >
                Copyright@ Phòng nghiên cứu khoa học và quan hệ quốc tế
            </pre>
        </footer>
	</div>


</body>

</html>