package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TaiKhoan_Controller;
import Model.TaiKhoan;

/**
 * Servlet implementation class TaiKhoan_Servlet
 */
@WebServlet("/TaiKhoan_Servlet")
public class TaiKhoan_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    TaiKhoan_Controller crt = new   TaiKhoan_Controller(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaiKhoan_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String command = request.getParameter("command");
		
		
		String url="", error="", type="";
		
		try{
			switch(command){
			case "update":
				System.out.println("Vào update TT");
				String quyen = request.getParameter("Quyen");
				TaiKhoan tk=new TaiKhoan();
				String maTK = request.getParameter("MaTK");
				tk=crt.getTaiKhoanByMaTK(maTK);
				tk.setEmail(request.getParameter("email"));
				tk.setNganh(request.getParameter("nganh"));
				tk.setCNNH(request.getParameter("cnnganhang"));
				tk.setMSNH(request.getParameter("masoNH"));
				System.out.println(tk.getMaTK()+"______"+tk.getEmail()+"_________"+tk.getNganh()+"________"+tk.getCNNH()+"_____"+tk.getMSNH());
				boolean ktra=crt.updateTaiKhoan(tk);
				if(ktra)
				{
					type = "cntt_1";
					error="Thành công";
					if(quyen.equals("Admin"))
						url="Admin.jsp?type="+type;
					if(quyen.equals("Student"))
						url="sinhvienPage.jsp?type="+type;
				}
				else
				{
					type = "cntt_0";
					error="Thất bại";
					if(quyen.equals("Admin"))
						url="Admin.jsp?type="+type;
					if(quyen.equals("Student"))
						url="sinhvienPage.jsp?type="+type;
					
				}
				break;
			case "updateADMIN":
				System.out.println("Vào update TT");
				
				TaiKhoan tk5=new TaiKhoan();
				String matk5 = request.getParameter("MaTK");
				tk5=crt.getTaiKhoanByMaTK(matk5);
				tk5.setQuyen(request.getParameter("quyen"));
				tk5.setEmail(request.getParameter("email"));
				tk5.setNganh(request.getParameter("nganh"));
				tk5.setCNNH(request.getParameter("cnnganhang"));
				tk5.setMSNH(request.getParameter("masoNH"));
				System.out.println(tk5.getMaTK()+"______"+tk5.getEmail()+"_________"+tk5.getNganh()+"________"+tk5.getCNNH()+"_____"+tk5.getMSNH());
				boolean ktra1=crt.updateTaiKhoanAdmin(tk5);
				if(ktra1)
				{
					type = "cntt_1";
					error="Thành công";
					
						url="Admin.jsp?type="+type;
					
				}
				else
				{
					type = "cntt_0";
					error="Thất bại";
					
						url="Admin.jsp?type="+type;
					
					
				}
				break;
			case "doimk":
				System.out.println("Vào đổi mk");
				TaiKhoan tk1= new TaiKhoan();
				String maTK2=request.getParameter("MaTK");
				tk1=crt.getTaiKhoanByMaTK(maTK2);
				String mk=request.getParameter("pass");
				if(mk.equals(tk1.getMatKhau()))
				{	System.out.println("Mật Khẩu cũ khớp");
					tk1.setMatKhau(request.getParameter("npass"));
					if(crt.updateTKDoiMK(tk1))
					{
						type = "dmk_1";
						System.out.println("Vào update mật khẩu");
						error="Thành công";
					}
				}
				else
				{
					error="Thất bại";
					type = "dmk_0";
				}
				url="sinhvienPage.jsp?type="+type;
				System.out.println(error+"__________"+url);
				break;
			case "XoaTK":
				
				System.out.println("Vào đổi mk");
				TaiKhoan xoatk=new TaiKhoan();
				TaiKhoan_Controller tkctr=new TaiKhoan_Controller();
				String tkx=request.getParameter("MaTK");
				System.out.println("ma tk: "+tkx);
				xoatk.setMaTK(tkx);
				try{
					boolean fx=tkctr.deleteTaiKhoan(xoatk);
				if(fx)
				{
					type = "xoatk_1";
					error="Thành công";
				}
				else
				{
					error="Thất bại";
					type = "xoatk_0";
				}
				
				System.out.println(error+"__________"+url);
				}
				catch(Exception e)
				{
					error="loi ngau nhien";
					type = "xoatk_0";
				}
				url="Admin.jsp?type="+type;
				break;
			}
		}
		catch(Exception e)
		{
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
