package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Model.TaiKhoan;
import Model.TrangThai;
import Packages.DBConnect;

public class TrangThai_Controller {
	public ArrayList<TrangThai> getListTrangThai() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM trangthai";
        ArrayList<TrangThai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	TrangThai tt = new TrangThai();
            	tt.setMaTT(rs.getString("MaTT"));
            	tt.setTenTT(rs.getString("tenTT"));
                list.add(tt);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public TrangThai getTenTT(String MaTT) {
		Connection cons = DBConnect.getConnecttion();
		String sql = "SELECT * FROM TrangThai where MaTT='" + MaTT + "'";
		TrangThai tt = new TrangThai();
		try {
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
					tt.setTenTT(rs.getString("TenTT"));
					tt.setMaTT(rs.getString("MaTT"));
				

			}
			cons.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tt;
	}
	public TrangThai getListTrangThaiByDT() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM trangthai";
        TrangThai tt = new TrangThai();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	
            	tt.setMaTT(rs.getString("MaTT"));
            	tt.setTenTT(rs.getString("tenTT"));
                
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tt;
    }
}
