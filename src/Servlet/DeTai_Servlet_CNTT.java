package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class DeTai_Servlet_CNTT
 */
@WebServlet("/DeTai_Servlet_CNTT")
public class DeTai_Servlet_CNTT extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CTNghiemThu_Controller crt= new CTNghiemThu_Controller();
	DeTai_Controller detaictrl = new DeTai_Controller();
	TaiKhoan_Controller taikhoanctrl = new TaiKhoan_Controller();
	TB_TK_Controller tb_tkctrl = new TB_TK_Controller();
	ThongBao_Controller thongbaoctrl = new ThongBao_Controller();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeTai_Servlet_CNTT() {
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
		System.out.println("Vao servlet!");
		String error="";
		String url="";
		String type="";
				System.out.println("VÃ o phÃª duyá»‡t");
				String MaDT = request.getParameter("chonmdt");
				String chontt=request.getParameter("chontt");
				DeTai dtql = detaictrl.getDeTai(MaDT);
				System.out.println("Ma de tai: "+MaDT);
					dtql.setMaDT(MaDT);
					dtql.setMaTT(chontt);
				try{
						switch(command){
						case "updatett":
							System.out.println("VÃ o update");
							
							if(detaictrl.updateTrangThai_DeTai(dtql))
							{
								type = "updatett_1";
								url="quanlyPage.jsp?type="+type;
								System.out.println("Update thành công");
							}
							else
							{
								System.out.println("THất bại");
								type = "updatett_0";
								url="quanlyPage.jsp?type="+type;
								System.out.println("Update thành công");
							}
							break;
				
						}
					}
			
			
		catch(Exception e){
			error="Xáº£y ra lá»—i ngáº«u nhiÃªn!";
			type = "updatett_0";
			url="quanlyPage.jsp?type="+type;
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
