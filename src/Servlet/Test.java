package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.CTNghiemThu_Controller;
import Controller.DeTai_Controller;
import Controller.TB_TK_Controller;
import Controller.TaiKhoan_Controller;
import Controller.ThongBao_Controller;
import Model.DeTai;
import Model.TB_TK;
import Model.ThongBao;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CTNghiemThu_Controller crt= new CTNghiemThu_Controller();
	DeTai_Controller detaictrl = new DeTai_Controller();
	TaiKhoan_Controller taikhoanctrl = new TaiKhoan_Controller();
	TB_TK_Controller tb_tkctrl = new TB_TK_Controller();
	ThongBao_Controller thongbaoctrl = new ThongBao_Controller();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
					String cndetaiql=request.getParameter("cndetaiql");
					DeTai dt = detaictrl.getDeTai(MaDT);
					
					if(xuly.equals("dongy"))
					{
						if(cndetaiql.equals("") || cndetaiql.equals(null)||cndetaiql.equals("null"))
						{
							dt.setMaHienThi(dt.getMaDT());
							if(detaictrl.updateMaHienThiDT(dt))
							{
								System.out.println("Cấp mã đề tài thành công");
							}
							dt.setMaTT("tt11");
							if(detaictrl.updateTrangThai_DeTai(dt))
							{
								type = "pddt_1";
								System.out.println("Update trạng thái đề tài thành công");
							}
						}
						else
						{
							dt.setMaHienThi(dt.getMaDT());
							if(detaictrl.updateMaHienThiDT(dt))
							{
								System.out.println("Cấp mã đề tài thành công");
							}
							dt.setMaTT("tt3");
							if(detaictrl.updateTrangThai_DeTai(dt))
							{
								type = "pddt_1";
								String nguoigui = request.getParameter("nguoigui");
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
								url="quanlyPage.jsp?type="+type;
								
							}
							
						}
					}
						
					if(xuly.equals("khongdongy"))
						dt.setMaTT("tt12");
 					
					else
					{
						error="Thất bại";
						type="pddt_0";
						url="quanlyPage.jsp?type="+type;
					
					}
					break;
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
