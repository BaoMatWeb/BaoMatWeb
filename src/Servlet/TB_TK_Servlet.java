package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Controller.TB_TK_Controller;

/**
 * Servlet implementation class TB_TK_Servlet
 */
@WebServlet("/TB_TK_Servlet")
public class TB_TK_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TB_TK_Controller crt= new TB_TK_Controller();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TB_TK_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String command = request.getParameter("command");
		String maCTTB= request.getParameter("MaCTTB");
		
		String url="", error="",type="";
		
		try{
			switch(command){
				case "delete":
					System.out.println("Vào delete");
					if(crt.deleteTB_TK(maCTTB))
					{
						type="xoatb_1";
						error="Thành công";
					}
						
					else
					{
						type="xoatb_0";
						error="Thất bại";
					}
						
					url="sinhvienPage.jsp?type="+type;
					System.out.println(error+"__________"+url);
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
