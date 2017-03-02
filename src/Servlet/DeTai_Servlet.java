 package Servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

import Controller.CTNghiemThu_Controller;
import Controller.DeTai_Controller;
import Controller.TB_TK_Controller;
import Controller.TaiKhoan_Controller;
import Controller.ThongBao_Controller;
import Model.CTNghiemThu;
import Model.DeTai;
import Model.TB_TK;
import Model.TaiKhoan;
import Model.ThongBao;

/**
 * Servlet implementation class TB_TK_Servlet
 */
@WebServlet("/DeTai_Servlet")
public class DeTai_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CTNghiemThu_Controller crt= new CTNghiemThu_Controller();
	DeTai_Controller detaictrl = new DeTai_Controller();
	TaiKhoan_Controller taikhoanctrl = new TaiKhoan_Controller();
	TB_TK_Controller tb_tkctrl = new TB_TK_Controller();
	ThongBao_Controller thongbaoctrl = new ThongBao_Controller();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeTai_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("Vào đề tài servlet thành công!");
		String MaDT="";
		String xuly="";
		String command = request.getParameter("command");
		
		
		String url="", error="", type="";
		try{
			switch(command){
				case "GV_pheduyetDT":
					System.out.println("Vào phê duyệt");
					xuly = request.getParameter("xuly");
					MaDT = request.getParameter("MaDT");
					String quyen = request.getParameter("Quyen");
					DeTai dt = detaictrl.getDeTai(MaDT);
					
					if(xuly.equals("dongy"))
						dt.setMaTT("tt3");
					if(xuly.equals("khongdongy"))
						dt.setMaTT("tt12");
 					
					if(detaictrl.updateTrangThai_DeTai(dt))
					{
						type = "pddt_1";
						String nguoigui = dt.getGVHD();
						TB_TK tbtk = new TB_TK();
						ThongBao tb = thongbaoctrl.getThongBao(nguoigui,dt.getMaCN());
						
						if(thongbaoctrl.getThongBao(nguoigui,dt.getMaCN()).getMaTB()==null)
					    {
							System.out.println("chua co hop thoai");
					    	int n =thongbaoctrl.getListThongBao().size();
						    tb.setMaTB("tb"+(n+1));
						    tb.setNguoiGui(nguoigui);	
						    tb.setNguoiNhan(dt.getMaCN());
						    if(thongbaoctrl.createThongBao(tb))
						    	System.out.println("Tạo hộp thoại thành công");
					    }
						tbtk.setMaCTTB("cttb"+Integer.toString(tb_tkctrl.getListTB_TK().size()+5));
						tbtk.setMaLTB("ltt1");
						tbtk.setMaTB(tb.getMaTB());
							
						System.out.println(nguoigui+"_______"+tb.getMaTB()+"______"+dt.getMaCN());
						tbtk.setTinTB("Thông báo đăng ký thành công đề tài "+MaDT+"");
						
						if(tb_tkctrl.insertTB_TK(tbtk))
							System.out.println(tbtk.getTinTB());
						System.out.println("Gửi thông báo thành công!");
						if(quyen.equals("Lecturers"))
							url="giangvienPage.jsp?type="+type;  
						if(quyen.equals("Manager"))
							url="quanlyPage.jsp?type="+type;
						
					}
					
					else
					{
						error="Thất bại";
						type="pddt_0";
						if(quyen.equals("Lecturers"))
							url="giangvienPage.jsp?type="+type;
						if(quyen.equals("Manager"))
							url="quanlyPage.jsp?type="+type;
					
					}
					break;
				case "dkDT":
					System.out.println("Vào đăng ký đề tài");
					DeTai dkDT=new DeTai();
					int sodt=detaictrl.getListDeTai().size()+1;
					MaDT="dt"+Integer.toString(sodt);
					dkDT.setMaDT(MaDT);
					dkDT.setMaHienThi(null);
					dkDT.setMaTT("tt1");
					
					TaiKhoan tk=new TaiKhoan();
					TaiKhoan tkphu=new TaiKhoan();
					tkphu = taikhoanctrl.getTaiKhoanByTen(request.getParameter("tenCN"));
					tk = taikhoanctrl.getTaiKhoanByTen(request.getParameter("tenCN"));
					dkDT.setMaCN(tk.getMaTK());
					tk = taikhoanctrl.getTaiKhoanByTen(request.getParameter("tenSV1"));
					System.out.println(request.getParameter("tenSV1"));
					dkDT.setSinhVien1(tk.getMaTK());
					tk = taikhoanctrl.getTaiKhoanByTen(request.getParameter("tenSV2"));
					System.out.println(request.getParameter("tenSV2"));
					dkDT.setSinhVien2(tk.getMaTK());
					tk = taikhoanctrl.getTaiKhoanByTen(request.getParameter("tenGVHD"));
					dkDT.setGVHD(tk.getMaTK());
					dkDT.setTenDT(request.getParameter("tenDT"));
					dkDT.setMoTa(request.getParameter("mota"));
					dkDT.setLinhVuc("Tự nhiên");
					dkDT.setLoaiHinh("Cơ bản");
					dkDT.setNgayThucHien(request.getParameter("ngaybatdau"));
					dkDT.setNgayKetThuc(request.getParameter("ngayketthuc"));
					dkDT.setCoQuanChuTri(request.getParameter("coquanchutri"));
					dkDT.setTinhHinhTrong(request.getParameter("tinhhinhTrong"));
					dkDT.setTinhHinhNgoai(request.getParameter("tinhhinhNgoai"));
					dkDT.setTinhCapThiet(request.getParameter("tinhcapThiet"));
					dkDT.setMucTieu(request.getParameter("muctieu"));
					dkDT.setPPNC(request.getParameter("PPNC"));
					dkDT.setNoiDungNC(request.getParameter("NoiDungNC"));
					dkDT.setSPDuKien(request.getParameter("SPDuKien"));
					dkDT.setDiaChiUD(request.getParameter("DiaChiUD"));
					dkDT.setKinhPhi(Double.parseDouble(request.getParameter("kinhphi")));
					
					if(detaictrl.insert_DeTaiSVDK(dkDT))
					{
						error="Thành công!";
						type = "dkdt_1";
						System.out.println("Đăng ký đề tài thành công!");
						String nguoidk = request.getParameter("nguoidk");
						if(nguoidk.equals("Student"))
						{
							url="sinhvienPage.jsp";
//							// đăng ký thành công thì gởi thông báo có đề tài mới cho quản lý
//							TB_TK tbtk = new TB_TK();
//							ThongBao tb =new ThongBao();
//							int i=thongbaoctrl.getListThongBao().size()+1;
//							int j=tb_tkctrl.getListTB_TK().size()+1;
//							String maTb="tb"+Integer.toString(i);
//							String macttb="cttb"+Integer.toString(j);
//							while(thongbaoctrl.kiemTraKhoaChinhTB(maTb))
//							{
//								i=thongbaoctrl.getListThongBao().size()+1;
//								maTb="tb"+Integer.toString(i);
//							}
//							while(thongbaoctrl.kiemTraKhoaChinhTBTK(macttb))
//							{
//								j=tb_tkctrl.getListTB_TK().size()+1;
//								macttb="cttb"+Integer.toString(j);
//							}
//							tb.setMaTB(maTb);
//							tb.setNguoiGui(tkphu.getMaTK());
//							tb.setNguoiNhan("tk1");
//							thongbaoctrl.insert_thongbao(tb);
//							tbtk.setMaCTTB(macttb);
//							tbtk.setMaLTB("ltt2");
//							tbtk.setTinTB("Thông báo đăng ký đề tài mới từ tài khoản "+dkDT.getMaCN());
//							tbtk.setMaTB(tb.getMaTB());
//							if(tb_tkctrl.insertTB_TK(tbtk))
//							System.out.println("Gửi thông báo thành công!");
						}	
						if(nguoidk.equals("Student"))
							url="sinhvienPage.jsp?type="+type;
						if(nguoidk.equals("Lecturers"))
							url="giangvienPage.jsp?type="+type;
						if(nguoidk.equals("Manager"))
							url="quanlyPage.jsp?type="+type;
						
					}
					else{
						error="Thất bại!";
						type = "dkdt_0";
						String nguoidk = request.getParameter("nguoidk");
						if(nguoidk.equals("Student"))
							url="sinhvienPage.jsp?type="+type;
						if(nguoidk.equals("Lecturers"))
							url="giangvienPage.jsp?type="+type;
						else
							url="quanlyPage.jsp?type="+type;
					}
					
					break;
				case "GV_DKDT":		
					System.out.println("Vào gv đăng ký đề tài");
					DeTai gv_dkDT=new DeTai();
					int sodt1=detaictrl.getListDeTai().size()+1;
					MaDT="dt"+Integer.toString(sodt1);
					gv_dkDT.setMaDT(MaDT);
					gv_dkDT.setMaHienThi(null);
					gv_dkDT.setMaTT("tt10");
					TaiKhoan tk1=new TaiKhoan();
//					tk1 = taikhoanctrl.getTaiKhoanByTen(request.getParameter("tenCN"));
//					gv_dkDT.setMaCN(tk1.getMaTK());
//					tk1 = taikhoanctrl.getTaiKhoanByTen(request.getParameter("tenSV1"));
//					gv_dkDT.setSinhVien1(tk1.getMaTK());
//					tk1 = taikhoanctrl.getTaiKhoanByTen(request.getParameter("tenSV2"));
//					gv_dkDT.setSinhVien2(tk1.getMaTK());
					tk1 = taikhoanctrl.getTaiKhoanByTen(request.getParameter("tenGVHD"));
					gv_dkDT.setGVHD(tk1.getMaTK());
					System.out.println(gv_dkDT.getGVHD());
					gv_dkDT.setTenDT(request.getParameter("tenDT"));
					gv_dkDT.setMoTa(request.getParameter("mota"));
					gv_dkDT.setLinhVuc("Tự nhiên");
					gv_dkDT.setLoaiHinh("Cơ bản");
					gv_dkDT.setNgayThucHien(request.getParameter("ngaybatdau"));
					gv_dkDT.setNgayKetThuc(request.getParameter("ngayketthuc"));
					gv_dkDT.setCoQuanChuTri(request.getParameter("coquanchutri"));
					gv_dkDT.setTinhHinhTrong(request.getParameter("tinhhinhTrong"));
					gv_dkDT.setTinhHinhNgoai(request.getParameter("tinhhinhNgoai"));
					gv_dkDT.setTinhCapThiet(request.getParameter("tinhcapThiet"));
					gv_dkDT.setMucTieu(request.getParameter("muctieu"));
					gv_dkDT.setPPNC(request.getParameter("PPNC"));
					gv_dkDT.setNoiDungNC(request.getParameter("NoiDungNC"));
					gv_dkDT.setSPDuKien(request.getParameter("SPDuKien"));
					gv_dkDT.setDiaChiUD(request.getParameter("DiaChiUD"));
					gv_dkDT.setKinhPhi(Double.parseDouble(request.getParameter("kinhphi")));
					
					if(detaictrl.insert_DeTaiSVDK(gv_dkDT))
					{
						error="Thành công!";
						type = "dkdt_1";
						System.out.println("Đăng ký đề tài thành công!");
						String nguoidk = request.getParameter("nguoidk");
						if(nguoidk.equals("Lecturers"))
						{
							url="giangvienPage.jsp?type="+type;
							// đăng ký thành công thì gởi thông báo có đề tài mới cho quản lý
							TB_TK tbtk = new TB_TK();
							ThongBao tb = thongbaoctrl.getListThongBao(gv_dkDT.getGVHD());
							tbtk.setMaCTTB("cttb"+Integer.toString(tb_tkctrl.getListTB_TK().size()+5));
							tbtk.setMaLTB("ltt2");
							tbtk.setTinTB("Thông báo đăng ký đề tài mới từ tài khoản "+gv_dkDT.getGVHD());
							tbtk.setMaTB(tb.getMaTB());
							if(tb_tkctrl.insertTB_TK(tbtk))
							System.out.println("Gửi thông báo thành công!");
						}	
						if(nguoidk.equals("Manager"))
						{
							url="quanlyPage.jsp?type="+type;
						}
						
					}
					else{
						System.out.println("Đăng ký thất bại");
						error="Thất bại!";
						type = "dkdt_0";
						String nguoidk = request.getParameter("nguoidk");
						if(nguoidk.equals("Student"))
							url="sinhvienPage.jsp";
						if(nguoidk.equals("Lecturers"))
							url="giangvienPage.jsp?type="+type;
						if(nguoidk.equals("Manager"))
							url="quanlyPage.jsp?type="+type;
					}
					System.out.println(url);
					break;
				case "QL_DKDT":		
					System.out.println("Vào ql đăng ký đề tài");
					DeTai ql_dkDT=new DeTai();
	
					int sodt5=detaictrl.getListDeTai().size()+1;
					MaDT="dt"+Integer.toString(sodt5);
					ql_dkDT.setMaDT(MaDT);
					ql_dkDT.setMaTT("tt11");
					TaiKhoan tk5=new TaiKhoan();
					tk5 = taikhoanctrl.getTaiKhoanByTen(request.getParameter("tenGVHD"));
					System.out.println("tk5= "+tk5.getMaTK());
					ql_dkDT.setGVHD(tk5.getMaTK());
					ql_dkDT.setTenDT(request.getParameter("tenDT"));
					ql_dkDT.setMoTa(request.getParameter("mota"));
					ql_dkDT.setLinhVuc("Tự nhiên");
					ql_dkDT.setLoaiHinh("Cơ bản");
					ql_dkDT.setCoQuanChuTri(request.getParameter("coquanchutri"));
					ql_dkDT.setTinhHinhTrong(request.getParameter("tinhhinhTrong"));
					ql_dkDT.setTinhHinhNgoai(request.getParameter("tinhhinhNgoai"));
					ql_dkDT.setTinhCapThiet(request.getParameter("tinhcapThiet"));
					ql_dkDT.setMucTieu(request.getParameter("muctieu"));
					ql_dkDT.setPPNC(request.getParameter("PPNC"));
					ql_dkDT.setNoiDungNC(request.getParameter("NoiDungNC"));
					ql_dkDT.setSPDuKien(request.getParameter("SPDuKien"));
					ql_dkDT.setDiaChiUD(request.getParameter("DiaChiUD"));
					ql_dkDT.setKinhPhi(Double.parseDouble(request.getParameter("kinhphi")));
					System.out.println("chuan bi update");
					if(detaictrl.insert_DeTaiQLDK(ql_dkDT))
					{
						error="Thành công!";
						type = "dkdt_1";
						System.out.println("Đăng ký đề tài thành công!");
						url="quanlyPage.jsp?type="+type;	
					}
					else
					{
						System.out.println("Đăng ký thất bại");
						error="Thất bại!";
						type = "dkdt_0";
						url="quanlyPage.jsp?type="+type;
					}
					
					break;
			
				case "GV_pheduyeHuy_GiaHan":
					String ycau = request.getParameter("yeucau");
					xuly = request.getParameter("xuly");
					MaDT = request.getParameter("MaDT");
					DeTai dtai = detaictrl.getDeTai(MaDT);
					TB_TK tbtk_gv = new TB_TK();
					ThongBao tb_gv = new ThongBao();
					tb_gv=thongbaoctrl.getThongBao(dtai.getGVHD(),dtai.getMaCN());
					if(thongbaoctrl.getThongBao(dtai.getGVHD(),dtai.getMaCN()).getMaTB()==null)
				    {
						System.out.println("chua co hop thoai");
				    	int n =thongbaoctrl.getListThongBao().size();
				    	tb_gv.setMaTB("tb"+(n+1));
				    	tb_gv.setNguoiGui(dtai.getMaCN());
				    	tb_gv.setNguoiNhan(dtai.getMaCN());
					    if(thongbaoctrl.createThongBao(tb_gv))
					    	System.out.println("Tạo hộp thoại thành công");
				    }
					tbtk_gv.setMaCTTB("cttb"+Integer.toString(tb_tkctrl.getListTB_TK().size()+5));
					tbtk_gv.setMaLTB("ltt1");
					tbtk_gv.setMaTB(tb_gv.getMaTB());
					System.out.println(dtai.getGVHD()+"_______"+tb_gv.getMaTB()+"______"+dtai.getMaCN());
					if(xuly.equals("khongdongy"))
					{
						dtai.setMaTT("tt3"); System.out.println("Yêu cầu không được đồng ý, đề tài vẫn được tiến hành");
						if(ycau.equals("tt6"))
						{
							tbtk_gv.setTinTB("Thông báo: yêu cầu gia hạn đề tài "+MaDT+" không được đồng ý");
							type="ghdt_0";
						}
						else if(ycau.equals("tt4"))
						{
							tbtk_gv.setTinTB("Thông báo: yêu cầu hủy đề tài "+MaDT+" không được đồng ý");
							type="huydt_0";
						}
					}
					else if(xuly.equals("dongy"))
					{
						if(ycau.equals("tt6"))
						{
							dtai.setMaTT("tt7"); System.out.println("Gia hạn đề tài thành công");
							tbtk_gv.setTinTB("Thông báo: gia hạn đề tài "+MaDT+" thành công");
							type="ghdt_1";
						}
						else if(ycau.equals("tt4"))
						{
							dtai.setMaTT("tt5"); System.out.println("Hủy đề tài thành công");
							tbtk_gv.setTinTB("Thông báo: hủy đề tài "+MaDT+" thành công");
							type="huydt_1";
						}
					}
					if(tb_tkctrl.insertTB_TK(tbtk_gv))
						System.out.println(tbtk_gv.getTinTB());
					if(detaictrl.updateTrangThai_DeTai(dtai))
						error="thành công!";
					else
						error="Thất bại";
					System.out.println(error);
					url="giangvienPage.jsp?type="+type;
					
					break;
				case "QL_pheduyeHuy_GiaHan":
					String ycau1 = request.getParameter("yeucau2");
					xuly = request.getParameter("xuly");
					MaDT = request.getParameter("MaDT");
					DeTai dtai1 = detaictrl.getDeTai(MaDT);
					TB_TK tbtk_ql = new TB_TK();
					ThongBao tb_ql = new ThongBao();
					tb_ql=thongbaoctrl.getThongBao(dtai1.getGVHD(),dtai1.getMaCN());
					if(thongbaoctrl.getThongBao(dtai1.getGVHD(),dtai1.getMaCN()).getMaTB()==null)
				    {
						System.out.println("chua co hop thoai");
				    	int n =thongbaoctrl.getListThongBao().size();
				    	tb_ql.setMaTB("tb"+(n+1));
				    	tb_ql.setNguoiGui(dtai1.getMaCN());
				    	tb_ql.setNguoiNhan(dtai1.getMaCN());
					    if(thongbaoctrl.createThongBao(tb_ql))
					    	System.out.println("Tạo hộp thoại thành công");
				    }
					tbtk_ql.setMaCTTB("cttb"+Integer.toString(tb_tkctrl.getListTB_TK().size()+5));
					tbtk_ql.setMaLTB("ltt1");
					tbtk_ql.setMaTB(tb_ql.getMaTB());
					System.out.println(dtai1.getGVHD()+"_______"+tb_ql.getMaTB()+"______"+dtai1.getMaCN());
					if(xuly.equals("khongdongy"))
					{
						dtai1.setMaTT("tt3"); 
						System.out.println("Yêu cầu không được đồng ý, đề tài vẫn được tiến hành");
						if(ycau1.equals("tt6"))
						{
							tbtk_ql.setTinTB("Thông báo: yêu cầu gia hạn đề tài "+MaDT+" không được đồng ý");
							type="ghdt_kdy";
						}
						else if(ycau1.equals("tt4"))
						{
							tbtk_ql.setTinTB("Thông báo: yêu cầu hủy đề tài "+MaDT+" không được đồng ý");
							type="huydt_kdy";
						}
					}
					else if(xuly.equals("dongy"))
					{
						if(ycau1.equals("tt6"))
						{
							dtai1.setMaTT("tt7"); System.out.println("Gia hạn đề tài thành công");
							tbtk_ql.setTinTB("Thông báo: gia hạn đề tài "+MaDT+" thành công");
							type="ghdt_1";
						}
						else if(ycau1.equals("tt4"))
						{
							dtai1.setMaTT("tt5"); System.out.println("Hủy đề tài thành công");
							tbtk_ql.setTinTB("Thông báo: hủy đề tài "+MaDT+" thành công");
							type="huydt_1";
						}
					}
					if(tb_tkctrl.insertTB_TK(tbtk_ql))
						System.out.println(tbtk_ql.getTinTB());
					if(detaictrl.updateTrangThai_DeTai(dtai1))
						error="thành công!";
					else
						error="Thất bại";
					System.out.println(error);
					url="quanlyPage.jsp?type="+type;
					
					break;
				case "dkdtdexuat":
					System.out.println("Vào đăng ký đề tài đề xuất");
					DeTai dkDT2=new DeTai();
					MaDT = request.getParameter("MaDT");
					
					
					dkDT2.setMaDT(MaDT);
					TaiKhoan tk2=new TaiKhoan();
					tk2 = taikhoanctrl.getTaiKhoanByTen(request.getParameter("tenCN"));
					dkDT2.setMaCN(tk2.getMaTK());
					tk2 = taikhoanctrl.getTaiKhoanByTen(request.getParameter("tenSV1"));
					dkDT2.setSinhVien1(tk2.getMaTK());
					tk2 = taikhoanctrl.getTaiKhoanByTen(request.getParameter("tenSV2"));
					dkDT2.setSinhVien2(tk2.getMaTK());
					System.out.println(MaDT+"______"+dkDT2.getMaCN()+"________"+dkDT2.getSinhVien1()+"_______"+dkDT2.getSinhVien2());
					if(detaictrl.DangKyDTDX(dkDT2))
					{
						type = "dkdtdx_1";
						System.out.println("Đăng ký đề tài thành công!");
						 dkDT2 = detaictrl.getDeTai(MaDT);
						TaiKhoan taikhoan =taikhoanctrl.gettk("tk1") ;
						String nguoinhan=taikhoan.getMaTK();
						TB_TK tbtk3 = new TB_TK();
						ThongBao tb3 = thongbaoctrl.getThongBao(dkDT2.getMaCN(),nguoinhan);
						
						if(tb3.getMaTB()==null)
					    {
							System.out.println("chua co hop thoai");
					    	int n =thongbaoctrl.getListThongBao().size();
					    	tb3.setMaTB("tb"+(n+1));
					    	tb3.setNguoiGui(dkDT2.getMaCN());	
					    	tb3.setNguoiNhan(nguoinhan);
						    if(thongbaoctrl.createThongBao(tb3))
						    	System.out.println("Tạo hộp thoại thành công");
					    }
						tbtk3.setMaCTTB("cttb"+Integer.toString(tb_tkctrl.getListTB_TK().size()+5));
						tbtk3.setMaLTB("ltt2");
						tbtk3.setMaTB(tb3.getMaTB());
							
						System.out.println(dkDT2.getMaCN()+"_______"+tb3.getMaTB()+"______"+nguoinhan);
						tbtk3.setTinTB("Thông báo đăng ký đề tài "+MaDT+"");
						
						if(tb_tkctrl.insertTB_TK(tbtk3))
							System.out.println(tbtk3.getTinTB());
						dkDT2.setMaTT("tt1");
						if(detaictrl.updateTrangThai_DeTai(dkDT2))
						{
							System.out.println("Trang thái "+dkDT2.getMaTT());
							error="Thành công!";
							type = "dkdtdx_1";
							
								url="sinhvienPage.jsp?type="+type;
					
						}
						
					
					}
					else
					{
						error="Thất bại";
					type = "dkdtdx_0";
					System.out.println(error);
					String nguoidk = request.getParameter("nguoidk");
					if(nguoidk.equals("Student"))
						url="sinhvienPage.jsp?type="+type;
					if(nguoidk.equals("Lecturers"))
						url="giangvienPage.jsp?type="+type;
					if(nguoidk.equals("Manager"))
						url="quanlyPage.jsp?type="+type;
					
					break;
					}
					System.out.println(""+type);
			}
			
		}catch(Exception e){
			error="Xảy ra lỗi ngẫu nhiên!";
		}
		
		request.setAttribute("error", error);
		response.sendRedirect(url);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
