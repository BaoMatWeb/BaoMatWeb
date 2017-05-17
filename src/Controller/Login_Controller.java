package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

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
		
		public Boolean loginTaiKhoan1(String email,String matkhau, String quyen) {
	        Connection cons = DBConnect.getConnecttion();
	        TaiKhoan tk=new TaiKhoan();
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
}
	