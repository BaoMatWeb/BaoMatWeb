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

import Model.BaoCaoDT;
import Model.DeTai;
import Packages.DBConnect;

public class BaoCaoDT_Controller {
	public BaoCaoDT getBaoCaoDT(String maDT) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM baocaodt,detai where detai.madt=baocaodt.madt and madt='"+maDT+"'";
        BaoCaoDT bc = new BaoCaoDT();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();
            while (rs.next()) {
            	
            	bc.setMaBC(rs.getString("MaBC"));
            	bc.setMaDT(rs.getString("MaDT"));
            	bc.setNgayBC(rs.getString("NgayBC"));
            	bc.setTenDT(rs.getString("TenDT"));
            	bc.setTenBC(rs.getString("TenBC"));
            	bc.setFileBC(rs.getString("FileBC"));
            	
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bc;
    }
	public ArrayList<BaoCaoDT> getListBaoCaoDT(String maDT) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM baocaodt,detai where "+
        " detai.madt=baocaodt.madt and detai.madt='"+maDT+"'";
        
        ArrayList<BaoCaoDT> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	BaoCaoDT bc = new BaoCaoDT();
            	bc.setMaBC(rs.getString("MaBC"));
            	bc.setMaDT(rs.getString("detai.MaDT"));
            	bc.setNgayBC(rs.getString("NgayBC"));
            	bc.setTenDT(rs.getString("TenDT"));
            	bc.setTenBC(rs.getString("TenBC"));
            	bc.setFileBC(rs.getString("FileBC"));
            	list.add(bc);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public ArrayList<BaoCaoDT> getListBaoCao() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM baocaodt ";
        
        ArrayList<BaoCaoDT> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	BaoCaoDT bc = new BaoCaoDT();
            	bc.setMaBC(rs.getString("MaBC"));
            	bc.setMaDT(rs.getString("MaDT"));
            	bc.setNgayBC(rs.getString("NgayBC"));
            	bc.setFileBC(rs.getString("FileBC"));
            	bc.setTenBC(rs.getString("TenBC"));
            	list.add(bc);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public BaoCaoDT getBaoCaoDTByMaBC(String maBC) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM baocaodt where mabc='"+maBC+"'";
        BaoCaoDT bc = new BaoCaoDT();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();
            while (rs.next()) {
            	
            	bc.setMaBC(rs.getString("MaBC"));
            	bc.setMaDT(rs.getString("MaDT"));
            	bc.setNgayBC(rs.getString("NgayBC"));
            	bc.setFileBC(rs.getString("FileBC"));
            	bc.setTenBC(rs.getString("TenBC"));
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bc;
    }
	public boolean insertBaoCao(BaoCaoDT bc) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "insert into baocaodt values(?,?,?,?,?)";
		try {
			
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setString(1, bc.getMaDT());
			ps.setString(2,bc.getMaBC());
			ps.setString(3, bc.getTenBC());
			ps.setString(4, bc.getFileBC());
			ps.setString(5, bc.getNgayBC());
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(BaoCaoDT_Controller.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	public static void main(String[] args) throws SQLException {
		BaoCaoDT_Controller ctrl= new BaoCaoDT_Controller();
	       for (BaoCaoDT bc:ctrl.getListBaoCao())
	    	   System.out.println(bc.getMaBC());
	}

}
