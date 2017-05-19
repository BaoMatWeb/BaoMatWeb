package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.DeTai_Controller;
import Controller.HoiDong_Controller;
import Controller.TaiKhoan_Controller;
import Model.DeTai;
import Model.HoiDong;
import Model.TaiKhoan;
import Object.MD5Library;

/**
 * Servlet implementation class ThemTaiKhoan_Servlet
 */
@WebServlet("/ThemTaiKhoan_Servlet")
public class ThemTaiKhoan_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemTaiKhoan_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("vao servlet");
		response.setContentType("text/html;charset=UTF-8"); 
	    request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
		TaiKhoan_Controller tkctl= new TaiKhoan_Controller();
		TaiKhoan tk=new TaiKhoan();
	    
		String error="";
		String type="";
		String url="";
		try{
			int i=tkctl.getListTaiKhoan().size()+1;
			String maTk="tk"+Integer.toString(i);
			while(tkctl.kiemTraTrungtk(maTk))
			{
				i++;
				 maTk="tk"+Integer.toString(i);
			}
		tk.setMaTK(maTk);
		tk.setMatKhau(request.getParameter(MD5Library.md5("password1")));
		tk.setQuyen(request.getParameter("quyen"));
		tk.setHoTen(request.getParameter("hoten"));
		tk.setNgaySinh(request.getParameter("nsinh"));
		tk.setCNNH(request.getParameter("cnnganhang"));
		tk.setNganh(request.getParameter("nganh"));
		tk.setEmail(request.getParameter("email"));
		
		System.out.println("1"+tk.getMaTK());
		System.out.println("1"+	tk.getQuyen());
		System.out.println("1"+tk.getHoTen());
		System.out.println("1"+tk.getCNNH());
		System.out.println("1"+tk.getNgaySinh());
		System.out.println("1"+tk.getEmail());
		System.out.println("1"+tk.getNganh());
		System.out.println("1"+tk.getMatKhau());
		if(tkctl.insertTaiKhoan2(tk))
		{
			System.out.println("Th�m th�nh c�ng");
			type="ttk_1";
		}
		else
		{
			System.out.println("Th�m th�nh c�ng");
			type="ttk_0";
		}
		url="Admin.jsp?type="+type;	
		}
		catch (Exception e ) {
			System.out.println("loiCATCH");
			type="ttk_0";
			url="Admin.jsp?type="+type;	
		}
		request.setAttribute("error", error);
		response.sendRedirect(url);
	}

}
