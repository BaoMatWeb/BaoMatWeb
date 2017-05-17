package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.HoiDong_Controller;
import Controller.Login_Controller;
import Controller.TaiKhoan_Controller;
import Model.DeTai;
import Model.HoiDong;
import javafx.print.Printer;

/**
 * Servlet implementation class HoiDong_Servlet
 */
@WebServlet("/Login_servlet")
public class Login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   // Set response content type
		   response.setContentType("text/html;charset=UTF-8"); 
		    request.setCharacterEncoding("UTF-8");
		    response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.println("dooo gettt");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		System.out.println("vao servlet");
	    response.setContentType("text/html;charset=UTF-8"); 
	    request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String error="";
		String type="";
		String url="";
		try{
		String Quyen = request.getParameter("phanquyen");
		String MatKhau = request.getParameter("password");
		String Email = request.getParameter("Email");
		Login_Controller logincrt = new Login_Controller();
		if(logincrt.loginTaiKhoan1(Email, MatKhau, Quyen))
		{
			
			HttpSession session=request.getSession();
			session.setAttribute("Email",Email);
			
			if(Quyen.equals("Manager"))
			{
				url="quanlyPage.jsp";
			};
			if(Quyen.equals("Student"))
			{
				url="sinhvienPage.jsp";
			};
			if(Quyen.equals("Admin"))
			{
				url="Admin.jsp";
			};
			if(Quyen.equals("Lecturers"))
			{
				url="giangvienPage.jsp";
			};
			System.out.println("Dang nhap thanh cong!");
		}
		else
		{
			System.out.println("Dang nhap that bai!");
			type = "dntb";
			url="mainPage_Login.jsp?type="+type;
			error="dang nhap lai!";
		}
					
		}
		catch (Exception e ) {
			
			url="loginPage.jsp";	
		}
		request.setAttribute("error", error);
		response.sendRedirect(url);
}}
