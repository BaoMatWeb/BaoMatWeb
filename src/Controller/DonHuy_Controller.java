package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;

import com.mysql.jdbc.PreparedStatement;
import com.sun.istack.internal.logging.Logger;

import Model.DonGiaHan;
import Model.DonHuy;
import Packages.DBConnect;

public class DonHuy_Controller {
	public ArrayList<DonHuy> getListDonHuy() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM donhuy";
        ArrayList<DonHuy> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DonHuy dh = new DonHuy();
            	dh.setMaDonXin(rs.getString("MaDonXin"));
            	dh.setMaDT(rs.getString("MaDT"));
            	dh.setLyDo(rs.getString("LyDo"));
            	list.add(dh);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public DonHuy getDonHuy(String maDT) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM donhuy,detai where donhuy.madt=detai.madt and detai.madt='"+maDT+"'";
        DonHuy dh = new DonHuy();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	
            	dh.setMaDonXin(rs.getString("MaDonXin"));
            	dh.setMaDT(rs.getString("MaDT"));
            	dh.setLyDo(rs.getString("LyDo"));
            	
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dh;
    }
	public boolean insertDonHuy(DonHuy dh) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "insert into donhuy values(?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setString(1,dh.getMaDonXin());
			ps.setString(2, dh.getMaDT());
			ps.setString(3, dh.getLyDo());
			
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(DonHuy_Controller.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
}
