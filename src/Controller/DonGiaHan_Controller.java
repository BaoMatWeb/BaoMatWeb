package Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;

import com.mysql.jdbc.PreparedStatement;
import com.sun.istack.internal.logging.Logger;

import java.sql.ResultSet;

import Model.DeTai;
import Model.DonGiaHan;
import Packages.DBConnect;

public class DonGiaHan_Controller {
		public ArrayList<DonGiaHan> getListDonGiaHan() {
	        Connection cons = DBConnect.getConnecttion();
	        String sql = "SELECT * FROM dongiahan";
	        ArrayList<DonGiaHan> list = new ArrayList<>();
	        try {
	            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	            ResultSet rs =  ps.executeQuery();
	            while (rs.next()) {
	            	DonGiaHan gh = new DonGiaHan();
	            	gh.setMaDonXin(rs.getString("MaDonXin"));
	            	gh.setMaDT(rs.getString("MaDT"));
	            	gh.setLyDo(rs.getString("LyDo"));
	            	gh.setGHDen(rs.getString("GHDen"));
	            	list.add(gh);
	            }
	            cons.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
		public ArrayList<DonGiaHan> getListDonGiaHanByMaDT(String maDT)  throws SQLException{
	        Connection cons = DBConnect.getConnecttion();
	        String sql = "SELECT * FROM dongiahan,detai where dongiahan.madt=DeTai.madt and detai.madt='"+maDT+"'";
	        ArrayList<DonGiaHan> list = new ArrayList<>();
	        try {
	            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	DonGiaHan gh = new DonGiaHan();
	            	gh.setMaDonXin(rs.getString("MaDonXin"));
	            	gh.setMaDT(rs.getString("MaDT"));
	            	gh.setLyDo(rs.getString("LyDo"));
	            	gh.setGHDen(rs.getString("GHDen"));
	            	list.add(gh);
	            
	            }
	            cons.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
		
		public DonGiaHan getDGH(String maDT)  throws SQLException{
	        Connection cons = DBConnect.getConnecttion();
	        String sql = "SELECT * FROM dongiahan,detai where dongiahan.madt=detai.madt and detai.madt='"+maDT+"'";
	        DonGiaHan gh = new DonGiaHan();
	        try {
	            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	gh.setMaDonXin(rs.getString("MaDonXin"));
	            	gh.setMaDT(rs.getString("MaDT"));
	            	gh.setLyDo(rs.getString("LyDo"));
	            	gh.setGHDen(rs.getString("GHDen"));
	            
	            }
	            cons.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return gh;
	    }
		public boolean insertDonGiaHan(DonGiaHan gh) throws ParseException {
			Connection cons = DBConnect.getConnecttion();
			String sql = "insert into dongiahan values(?,?,?,?)";
			try {
				SimpleDateFormat format = new SimpleDateFormat( "MM/dd/yyyy" );  
				java.util.Date myDate = format.parse(gh.getGHDen());
				java.sql.Date GHDen = new java.sql.Date( myDate.getTime() );
				PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
				ps.setString(1,gh.getMaDonXin());
				ps.setString(2, gh.getMaDT());
				ps.setDate(3,GHDen );
				ps.setString(4, gh.getLyDo());
				
				return ps.executeUpdate()==1;
			} catch (SQLException e) {
				e.printStackTrace();
				Logger.getLogger(DonGiaHan_Controller.class.getName(), null).log(Level.SEVERE, null, e);
			}
			return false;
		}
		
		public static void main(String[] args) throws SQLException {
			DonGiaHan_Controller ctrl= new DonGiaHan_Controller();
			DonGiaHan ct=ctrl.getDGH("dt1");
		    	   System.out.println(ct.getLyDo());
		    	   
			  
		}
}
