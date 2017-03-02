package Servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.DeTai_Controller;
import Controller.DonGiaHan_Controller;
import Controller.DonHuy_Controller;
import Controller.TB_TK_Controller;
import Controller.TaiKhoan_Controller;
import Controller.ThongBao_Controller;
import Model.DeTai;
import Model.DonGiaHan;
import Model.DonHuy;
import Model.TB_TK;
import Model.ThongBao;

/**
 * Servlet implementation class GiaHanDT_Servlet
 */
@WebServlet("/GiaHanDT_Servlet")
public class GiaHanDT_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DeTai_Controller detaictrl = new DeTai_Controller();
	TaiKhoan_Controller taikhoanctrl = new TaiKhoan_Controller();
	TB_TK_Controller tb_tkctrl = new TB_TK_Controller();
	ThongBao_Controller thongbaoctrl = new ThongBao_Controller();
	DonGiaHan_Controller ghctr=new DonGiaHan_Controller();
	DonHuy_Controller hctr= new DonHuy_Controller();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiaHanDT_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Vào gia hạn đt servlet 2");
		String command = request.getParameter("command");
		String xuly = request.getParameter("xuly");
		String maDT = request.getParameter("MaDT");
		DeTai dt = detaictrl.getDeTai(maDT);
		String MaDonXin="";
		String url="", error="", type="";
		try{
			switch(command){
				case "insert":
					ThongBao tb = thongbaoctrl.getThongBao(dt.getMaCN(),dt.getGVHD());
					if(thongbaoctrl.getThongBao(dt.getMaCN(),dt.getGVHD()).getMaTB()==null)
				    {
						System.out.println("chua co hop thoai");
				    	int n =thongbaoctrl.getListThongBao().size();
					    tb.setMaTB("tb"+(n+1));
					    tb.setNguoiGui(dt.getMaCN());
					    tb.setNguoiNhan(dt.getGVHD());
					    if(thongbaoctrl.createThongBao(tb))
					    	System.out.println("Tạo hộp thoại thành công");
					    else
					    	System.out.println("Tạo hộp thoại thất bại");
				    }
					else
						System.out.println("Da co hop thoai");
					if(xuly.equals("guidongiahan"))
					{
						System.out.println("vào gửi đơn gia hạn! 2");
						DonGiaHan dongh=new DonGiaHan();
						int sodon=ghctr.getListDonGiaHan().size()+1;
						MaDonXin="dgh"+Integer.toString(sodon);
						dongh.setMaDonXin(MaDonXin);
						dongh.setMaDT(maDT);
						dongh.setLyDo(request.getParameter("lydo"));
						dongh.setGHDen(request.getParameter("ngay"));
						if(ghctr.insertDonGiaHan(dongh))
						{
							type = "ghdt_1";
							System.out.println("vào gửi thông báo!");
							dt.setMaTT("tt6");
							if(detaictrl.updateTrangThai_DeTai(dt))
							{
								error="Thành công";
								TB_TK tbtk = new TB_TK();	
								tbtk.setMaCTTB("cttb"+Integer.toString(tb_tkctrl.getListTB_TK().size()+5));
								tbtk.setMaLTB("ltt4");
								tbtk.setTinTB("Thông báo: yêu cầu gia hạn đề tài từ tài khoản "+dt.getMaCN());
								tbtk.setMaTB(tb.getMaTB());
								if(tb_tkctrl.insertTB_TK(tbtk))
								System.out.println("Gửi thông báo thành công!");
								else
									System.out.println("Gửi thông báo thất bại");
							}
							else
								System.out.println("Cập nhật trạng thái thất bại");
						}
						
						else
						{
							error="Thất bại";
							type = "ghdt_0";
						}
						url="sinhvienPage.jsp?type="+type;
						System.out.println(error+"__________"+url);
					}
					if(xuly.equals("guidonhuy"))
					{
						System.out.println("vào gửi đơn hủy!");
						DonHuy donh=new DonHuy();
						int sodon=hctr.getListDonHuy().size()+1;
						MaDonXin="dhuy"+Integer.toString(sodon);
						donh.setMaDonXin(MaDonXin);
						donh.setMaDT(maDT);
						donh.setLyDo(request.getParameter("lydo"));
						System.out.println(donh.getMaDonXin()+"__________"+donh.getMaDT()+"________"+donh.getLyDo());
						if(hctr.insertDonHuy(donh))
						{
							type = "hdt_1";
							System.out.println("vào gửi thông báo!");
							dt.setMaTT("tt4");
							if(detaictrl.updateTrangThai_DeTai(dt))
							{
								error="Thành công";
								TB_TK tbtk = new TB_TK();	
								tbtk.setMaCTTB("cttb"+Integer.toString(tb_tkctrl.getListTB_TK().size()+5));
								tbtk.setMaLTB("ltt3");
								tbtk.setTinTB("Thông báo: yêu cầu gia hạn đề tài từ tài khoản "+dt.getMaCN());
								tbtk.setMaTB(tb.getMaTB());
								if(tb_tkctrl.insertTB_TK(tbtk))
								System.out.println("Gửi thông báo thành công!");
								else
									System.out.println("Gửi thông báo thất bại");
							}
							else
								System.out.println("Cập nhật trạng thái thất bại");
						}
						
						else
						{
							type = "hdt_0";
							error="Thất bại";
						}
						url="sinhvienPage.jsp?type="+type;
						System.out.println(error+"__________"+url);
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
