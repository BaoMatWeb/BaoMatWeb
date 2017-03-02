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
import Model.DeTai;
import Model.HoiDong;
import javafx.print.Printer;

/**
 * Servlet implementation class HoiDong_Servlet
 */
@WebServlet("/HoiDong_Servlet")
public class HoiDong_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HoiDong_Servlet() {
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
		String ChuTich = request.getParameter("ChuTich");
		String PhanBien = request.getParameter("PhanBien");
		String UyVien = request.getParameter("UyVien");
		String MaHD = request.getParameter("MaHD");
		String NgayThanhLap = request.getParameter("bday");
		HoiDong_Controller HoiDongDao = new HoiDong_Controller();
		if(HoiDongDao.kiemTra(MaHD))
		{
			type="themhd_t";
			url="quanlyPage.jsp?type="+type;	
		}
		else{		
			HoiDongDao.insert(MaHD, PhanBien, ChuTich, UyVien, NgayThanhLap);
			type="themhd_1";
			url="quanlyPage.jsp?type="+type;	
		}
		}
		catch (Exception e ) {
			type="themhd_0";
			url="quanlyPage.jsp?type="+type;	
		}
		request.setAttribute("error", error);
		response.sendRedirect(url);
}}
