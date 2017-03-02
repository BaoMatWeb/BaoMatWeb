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
import Controller.ThongBao_Controller;
import Model.CTNghiemThu;
import Model.DeTai;
import Model.TB_TK;
import Model.ThongBao;

/**
 * Servlet implementation class TB_TK_Servlet
 */
@WebServlet("/CTNghiemThu_Servlet")
public class CTNghiemThu_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CTNghiemThu_Controller crt= new CTNghiemThu_Controller();
	DeTai_Controller ctrl = new DeTai_Controller();
	TB_TK_Controller tb_tkctrl = new TB_TK_Controller();
	ThongBao_Controller thongbaoctrl = new ThongBao_Controller();

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CTNghiemThu_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		String command = request.getParameter("command");
		String quyen = request.getParameter("Quyen");
		String maDT= request.getParameter("MaDT");
		String maTK=request.getParameter("MaTK");
		int TongDiem = 0;
		CTNghiemThu ctnt=new CTNghiemThu();
		ctnt = crt.getCTNghiemThuByMaTK(maDT,maTK);
		ctnt.setTongQuan(Integer.parseInt(request.getParameter("diemtongquan")));
		ctnt.setMucTieu(Integer.parseInt(request.getParameter("diemmuctieu")));
		ctnt.setPhuongPhap(Integer.parseInt(request.getParameter("diemphuongphap")));
		ctnt.setNoiDung(Integer.parseInt(request.getParameter("diemnoidung")));
		ctnt.setDongGop(Integer.parseInt(request.getParameter("diemdonggop")));
		ctnt.setHinhThuc(Integer.parseInt(request.getParameter("diemhinhthuc")));
		ctnt.setDiemThuong(Integer.parseInt(request.getParameter("diemthuong")));
		TongDiem = ctnt.getTongQuan() + ctnt.getDiemThuong() + ctnt.getDongGop() + ctnt.getHinhThuc()+
				ctnt.getMucTieu()+ ctnt.getNoiDung()+ ctnt.getHinhThuc();
		ctnt.setTongDiem(TongDiem);
		ctnt.setYKien(request.getParameter("ykien"));
		System.out.println(TongDiem);
		
		DeTai dt=new DeTai();
		dt=ctrl.getDeTai(maDT);
		
		String url="", error="", type="";
		try{
			switch(command){
				case "update":
					System.out.println(ctnt.getMaTK()+"____"+ctnt.getMaDT());
					System.out.println("Vào update");
					int TongDiemChung = 0;
					if(crt.updateCTNT(ctnt) )
					{
						boolean f=true;
						System.out.println(ctnt.getDiemThuong()+"____"+ctnt.getNoiDung());
						for(CTNghiemThu ct:crt.getListCTNghiemThuMaDT(maDT))
						{
							TongDiemChung+=ct.getTongDiem();
							System.out.println(ct.getTongQuan()+"____"+ct.getMaTK());
							if((Integer.toString(ct.getTongQuan())=="0") || ct.getTongQuan() == 0 )
							{
								f=false;		
							}
						}
						TongDiemChung = (int)TongDiemChung/2;
						System.out.println(TongDiemChung);
						if(f)
						{	
							dt.setMaTT("tt9");
							if(ctrl.updateTrangThai_DeTai(dt))
								System.out.println("Update trạng thái của đề tài thành công");
						}	
				
						error = "Thành công";
						type ="ntdt_1";
						// Ä�Ã¡nh giÃ¡ thÃ nh cÃ´ng thÃ¬ gá»­i thÃ´ng bÃ¡o vá»� cho sinh viÃªn
						String nguoigui = request.getParameter("nguoigui");
						TB_TK tbtk = new TB_TK();
						ThongBao tb = thongbaoctrl.getThongBao(nguoigui,dt.getMaCN());
						
						if(tb.getMaTB()==null)
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
						tbtk.setTinTB("Thống báo đề tài "+maDT+" đã có kết quả thu");
						
						if(tb_tkctrl.insertTB_TK(tbtk))
							System.out.println(tbtk.getTinTB());
						System.out.println("Gá»­i thÃ´ng bÃ¡o thÃ nh cÃ´ng!");
						System.out.println("Quyen:" +quyen);
						if(quyen.equals("Lecturers"))
							url="giangvienPage.jsp?type="+type;
						if(quyen.equals("Manager"))
							url="quanlyPage.jsp?&type="+type;
						
					}
					
					else
					{
						error="Nghiệm thu thất bại";
						type = "ntdt_0";
						if(quyen.equals("Lecturers"))
							url="giangvienPage.jsp?type="+type;
						if(quyen.equals("Manager"))
							url="quanlyPage.jsp?type="+type;
					
					}
					break;
				case "updateql":
					System.out.println("VÃ o update QL");
					
					if(crt.updateCTNT(ctnt) && ctrl.updateTrangThai_DeTai(dt))
					{			
							type ="ntdt_1";
							url="quanlyPage.jsp?&type="+type;
					}
					else
					{
						error="Nghiá»‡m thu tháº¥t báº¡i";
						type ="ntdt_0";
							url="quanlyPage.jsp?type="+type;			
					}
					break;
			}
			
		}catch(Exception e){
			error="Xáº£y ra lá»—i ngáº«u nhiÃªn!";
		}
		System.out.println(url);
		request.setAttribute("error", error);
		request.setAttribute("type", type);
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
