package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.mysql.jdbc.PreparedStatement;

import Model.CTNghiemThu;
import Model.HoiDong;
import Model.TB_TK;
import Model.ThongBao;
import Packages.DBConnect;

public class TB_TK_Controller {
	public ArrayList<TB_TK> getListTB_TK() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM tb_tk";
        ArrayList<TB_TK> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	TB_TK cttb = new TB_TK();
            	cttb.setMaCTTB(rs.getString("MaCTTB"));
            	cttb.setMaTB(rs.getString("MaTB"));
            	cttb.setTinTB(rs.getString("TinTB"));
            	cttb.setNgayGui(rs.getString("NgayGui"));
                list.add(cttb);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public TB_TK getListTB_TKMaTB(String maCTTB) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM tb_tk where macttb='"+maCTTB+"'";
        TB_TK cttb = new TB_TK();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	
            	cttb.setMaCTTB(rs.getString("MaCTTB"));
            	cttb.setMaTB(rs.getString("MaTB"));
            	cttb.setTinTB(rs.getString("TinTB"));
            	cttb.setNgayGui(rs.getString("NgayGui"));
                
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cttb;
    }
	public TB_TK getTinTB(String maCTTB) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM tb_tk where maCTTB='"+maCTTB+"'";
        TB_TK tbtk = new TB_TK();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	
            	tbtk.setTinTB(rs.getString("tinTB"));
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tbtk;
    }
	public ArrayList<TB_TK> getListTB_TKByMaTK(String email) throws SQLException {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT macttb, thongbao.matb, tintb,ngaygui,tk2.hoten as TenNguoiGui FROM tb_tk,thongbao,taikhoan,"+
        " taikhoan as tk2 where thongbao.matb=tb_tk.matb and "+ 
        "thongbao.nguoinhan=taikhoan.matk and thongbao.nguoigui=tk2.matk and taikhoan.email='"+email+"' and MaLTB='ltt1'"
        		+ " order by ngaygui desc";
        ArrayList<TB_TK> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	TB_TK cttb= new TB_TK();
            	cttb.setMaCTTB(rs.getString("MaCTTB"));
            	cttb.setMaTB(rs.getString("MaTB"));
            	cttb.setTinTB(rs.getString("TinTB"));
            	cttb.setNgayGui(rs.getString("NgayGui"));
            	cttb.setTenNguoiGui(rs.getString("TenNguoiGui"));
                list.add(cttb);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public boolean deleteTB_TK(String maCTTB) throws SQLException {
		 Connection connection = DBConnect.getConnecttion();
	     String sql = "DELETE FROM tb_tk WHERE macttb = ?";
	    try {
	       
	       PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
	       ps.setString(1,maCTTB );
	       return ps.executeUpdate()==1;
	    } catch (Exception e) {
	    	return false;
	    }
	    
	}
	
	public boolean insertTB_TK(TB_TK tbtk) throws SQLException {
		 Connection connection = DBConnect.getConnecttion();
	     String sql = "insert into tb_tk values(?,?,?,?,?)";
	    try { 
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
	       PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
	       ps.setString(1,tbtk.getMaCTTB());
	       ps.setString(2,tbtk.getMaTB());
	       ps.setString(3,tbtk.getMaLTB());
	       ps.setString(4,tbtk.getTinTB());
	       ps.setDate(5,date);
	       return ps.executeUpdate()==1;
	    } catch (Exception e) {
	    	return false;
	    }
	    
	}
	
	public static void main(String[] args) throws SQLException {
		TB_TK_Controller ctrl= new TB_TK_Controller();
		TB_TK tbtk = new TB_TK();
		tbtk.setMaCTTB("cttb20");
		tbtk.setMaTB("tb1");
		tbtk.setMaLTB("ltt1");
		tbtk.setTinTB("zxczxcz");
		tbtk.setNgayGui("1/1/2011");
	     if(ctrl.insertTB_TK(tbtk))
	    	 System.out.println("Thanh cong");
	}
}
