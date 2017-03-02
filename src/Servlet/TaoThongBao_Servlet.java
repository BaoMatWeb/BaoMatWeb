package Servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.DeTai_Controller;
import Controller.HoiDong_Controller;
import Controller.TB_TK_Controller;
import Controller.ThongBao_Controller;
import Model.DeTai;
import Model.TB_TK;
import Model.ThongBao;

/**
 * Servlet implementation class TaoThongBao_Servlet
 */
@WebServlet("/TaoThongBao_Servlet")
public class TaoThongBao_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ThongBao_Controller thongbaoDao=new ThongBao_Controller();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaoThongBao_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("vao servlet");
		ThongBao_Controller tbcrt= new ThongBao_Controller();
		TB_TK_Controller tbtkcrt=new TB_TK_Controller();
		ThongBao tb= new ThongBao();
		TB_TK tbtk=new TB_TK();
	    response.setContentType("text/html;charset=UTF-8"); 
	    request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
		String error="";
		String type="";
		String url="";
		String maTB="";
		String maCTTB="";
		int i=tbcrt.getListThongBao().size()+1;
		int j=tbtkcrt.getListTB_TK().size()+1;
	
		try{
			maTB="tb"+Integer.toString(i);
			maCTTB="cttb"+Integer.toString(j);
			while(thongbaoDao.kiemTraKhoaChinhTB(maTB))
			{
				i++;
				maTB="tb"+Integer.toString(i);
			}
			while(thongbaoDao.kiemTraKhoaChinhTBTK(maCTTB))
			{
				j++;
				maCTTB="cttb"+Integer.toString(j);
			}
			
			String NguoiGui = request.getParameter("MaTK");
			String NguoiNhan = request.getParameter("nguoinhan");
			String TinThongBao=request.getParameter("noidungtb");
				
			tb.setMaTB(maTB);
			tb.setNguoiGui(NguoiGui);
			tb.setNguoiNhan(NguoiNhan);
			
			//boolean g=tbcrt.insert_thongbao(tb);
			//boolean f=tbtkcrt.insertTB_TK(tbtk);
			if(tbcrt.insert_thongbao(tb))
			{
				System.out.println("Vao insert tb");
				tbtk.setMaCTTB(maCTTB);
				tbtk.setMaLTB("ltt1");
				tbtk.setTinTB(TinThongBao);
				tbtk.setMaTB(maTB);
				if(tbtkcrt.insertTB_TK(tbtk))
				{
					type="themtb_1";
					url="quanlyPage.jsp?type="+type;	
					System.out.println("Vao inserttb_tk");
				}
			}
			else
			{
				type="themtb_2";
				url="quanlyPage.jsp?type="+type;	
			}
		}
		catch (Exception e ) {
			type="themtb_0";
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
