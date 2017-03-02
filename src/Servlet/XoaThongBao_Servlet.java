package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.CTNghiemThu_Controller;
import Controller.HoiDong_Controller;
import Controller.ThongBao_Controller;

/**
 * Servlet implementation class XoaThongBao_Servlet
 */
@WebServlet("/XoaThongBao_Servlet")
public class XoaThongBao_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaThongBao_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ThongBao_Controller crt= new ThongBao_Controller();
		String command = request.getParameter("command");
		String MaCTTB= request.getParameter("MaCTTB");
		String url="", error="";
		String type="";
		try{
			switch(command){
				case "deleteTB":
					System.out.println("macttb: "+MaCTTB);
					//boolean g=crt.deleteThongBao(maTB);
					boolean f=crt.deleteThongBao_TaiKhoan(MaCTTB);
					if(f)
					{
						type="xoatb_1";
						error="Thành công";
						url="quanlyPage.jsp?type="+type;
					}	
					else
					{
						type="xoatb_0";
						error="Thất bại";
						url="quanlyPage.jsp?type="+type;
					}
					System.out.println(error+"__________"+url);
					break;
			}
			
		}catch(Exception e){
			type="xoatb_0";
			url="quanlyPage.jsp?type="+type;
			error="Xảy ra lỗi ngẫu nhiên!";
			System.out.println(error+"__________"+url);
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
