package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Model.DeTai;
import Model.TaiKhoan;
import Packages.DBConnect;

public class Login_Controller {

		public TaiKhoan loginTaiKhoan(String email,String matkhau, String quyen) {
	        Connection cons = DBConnect.getConnecttion();
	        TaiKhoan tk=new TaiKhoan();
	        String sql =  "select * from taikhoan "
	        		+ "where taikhoan.email='"+email+"' and taikhoan.matkhau='"+matkhau+"' "
	        				+ "and taikhoan.quyen='"+quyen+"'";
	        		
	        try {
	            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	 
	            	 tk.setEmail(rs.getString("email"));
	            	 tk.setMatKhau(rs.getString("MatKhau"));
	            	 tk.setQuyen(rs.getString("quyen"));
	            }
	            cons.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return tk;
	    }
		
		public Boolean loginTaiKhoan1 (String email,String matkhau, String quyen)throws Exception {
			 Connection cons = DBConnect.getConnecttion();
			String sql =  "select * from taikhoan "
		        		+ "where taikhoan.email=? and taikhoan.matkhau=? "
		        				+ "and taikhoan.quyen=?";
			PreparedStatement pStmt=(PreparedStatement) cons.prepareStatement(sql);
			//truyền tham số
			pStmt.setString(1, email);//qui định tham số
			pStmt.setString(2, matkhau);
			pStmt.setString(3, quyen);
			ResultSet rs=pStmt.executeQuery();//thực thi
			if(rs.next())
			{
				System.out.println("true");
			return true;
			}
			System.out.println("false");
			return false;
			}
		
		public Boolean loginTaiKhoan2(String email,String matkhau, String quyen) {
	        Connection cons = DBConnect.getConnecttion();

	        String sql =  "select * from taikhoan "
	        		+ "where taikhoan.email='"+email+"' and taikhoan.matkhau='"+matkhau+"' "
	        				+ "and taikhoan.quyen='"+quyen+"'";
	        		
	        try {
	            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	return true;
	            }
	            cons.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
		public static void main(String[] args) throws SQLException, Exception {
			Login_Controller ctrl = new Login_Controller();
			ctrl.loginTaiKhoan1("admin", "e10adc3949ba59abbe56e057f20f883e", "Admin");
			
	}
}
