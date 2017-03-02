package Servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TaiKhoan_Controller;
import Model.DeTai;
import Model.TaiKhoan;

/**
 * Servlet implementation class TruyenDi
 */
@WebServlet("/TruyenDi")
public class TruyenDi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       TaiKhoan_Controller tkctrl= new TaiKhoan_Controller();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TruyenDi() {
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
		System.out.println("Vào truyen di servlet thành công!");
		String duong = request.getParameter("duong");
		System.out.println("file "+duong);
		String[] mang=duong.split("\n");
		TaiKhoan_Controller ctrl=new TaiKhoan_Controller();
		String url="", error="", type="";
		for(int i=0;i<mang.length;i++){
			String[] cot=mang[i].split(",");			
				TaiKhoan tk=new TaiKhoan();
				try {
					tk = new TaiKhoan(ctrl.taoMaTD(),cot[0], cot[1], 
							cot[2], cot[3], cot[4], cot[5], cot[6], cot[7], cot[8]);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					tkctrl.insertTaiKhoan(tk);
					type="themtk_1";
					url="Admin_TTKTuFILE.jsp?type="+type;
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					type="themtk_0";
					url="Admin_TTKTuFILE.jsp?type="+type;
					e.printStackTrace();
				}
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
