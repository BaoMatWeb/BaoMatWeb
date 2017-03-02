package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;

import com.mysql.jdbc.PreparedStatement;
import com.sun.istack.internal.logging.Logger;

import Model.DeTai;
import Model.HoiDong;
import Model.TB_TK;
import Model.ThongBao;
import Packages.DBConnect;

public class ThongBao_Controller {
	//BAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TIN
	public boolean insert_thongbao(ThongBao tb) {
		Connection cons = DBConnect.getConnecttion();
		 String sql = "INSERT INTO thongbao(matb,nguoigui,nguoinhan)"
	        		+ " values (?,?,?)";
		try {
			 PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			 java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
	            ps.setString(1, tb.getMaTB());
	            ps.setString(2, tb.getNguoiGui());
	            ps.setString(3, tb.getNguoiNhan());
	        
	          return ps.executeUpdate()==1;

		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(DeTai_Controller.class.getName(), null).log(Level.SEVERE, null, e);
			return false;
		}
	}
	public Boolean kiemTraKhoaChinhTB(String maTB)
	{
		Connection connection = DBConnect.getConnecttion();
		String sql ="SELECT * FROM thongbao WHERE thongbao.matb='"+maTB+"'";
		try {
			PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public Boolean kiemTraKhoaChinhTBTK(String maCTTB)
	{
		Connection connection = DBConnect.getConnecttion();
		String sql ="SELECT * FROM tb_tk WHERE tb_tk.macttb='"+maCTTB+"'";
		try {
			PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean insert_CTthongbao(TB_TK cttb) {
		Connection cons = DBConnect.getConnecttion();
		 String sql = "INSERT INTO tb_tk(macttb,matb,maltb,tintb,ngaygui)"
	        		+ " values (?,?,?,?,?)";
		try {
			 PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			 java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
	            ps.setString(1, cttb.getMaCTTB());
	            ps.setString(2, cttb.getMaTB());
	            ps.setString(3, cttb.getMaLTB());
	            ps.setString(4, cttb.getTinTB());
	            ps.setDate(5,date);
	          return ps.executeUpdate()==1;

		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(DeTai_Controller.class.getName(), null).log(Level.SEVERE, null, e);
			return false;
		}
	}
	public ArrayList<ThongBao> getListThongBaoQLDK() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT tb_tk.tintb,tb_tk.macttb,thongbao.matb,loaitb.tenloaitb,tennguoigui.hoten as TenNG,thongbao.nguoigui, tb_tk.ngaygui "
        		+ "FROM thongbao,loaitb,tb_tk,taikhoan, taikhoan as tennguoigui "
        		+ "where loaitb.maltb=tb_tk.maltb and thongbao.matb=tb_tk.matb and thongbao.nguoinhan=taikhoan.matk"
        		+ " and tennguoigui.matk=thongbao.nguoigui "
        		+ "and taikhoan.quyen='Manager' and (loaitb.maltb='ltt2' or loaitb.maltb='ltt3' or loaitb.maltb='ltt4')";
        		
        ArrayList<ThongBao> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	ThongBao tb = new ThongBao();
            	tb.setTenLoaiTB(rs.getString("TenLoaiTB"));
            	tb.setTenNguoiGui(rs.getString("TenNG"));
            	tb.setNgayGui(rs.getString("NgayGui"));
            	tb.setMaTB(rs.getString("thongbao.matb"));
            	tb.setMaCTTB(rs.getString("tb_tk.MaCTTB"));
            	tb.setTinTB(rs.getString("tb_tk.tintb"));
            	list.add(tb);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public boolean deleteThongBao(String MaTB) throws SQLException {
		 Connection connection = DBConnect.getConnecttion();
	     String sql = "DELETE FROM thongbao WHERE matb =?";
	    try {
	       
	       PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
	       ps.setString(1,MaTB);
	       return ps.executeUpdate()==1;
	    } catch (Exception e) {
	    	return false;
	    }
	    
	}
	public boolean deleteThongBao_TaiKhoan(String MaCTTB) throws SQLException {
		 Connection connection = DBConnect.getConnecttion();
	     String sql = "DELETE FROM tb_tk WHERE macttb =?";
	    try {
	       
	       PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
	       ps.setString(1,MaCTTB);
	       return ps.executeUpdate()==1;
	    } catch (Exception e) {
	    	return false;
	    }
	    
	}
	
	public ArrayList<ThongBao> getListThongBaoQLHuyGH() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT tb_tk.macttb,thongbao.matb,loaitb.tenloaitb,tennguoigui.hoten as TenNG,thongbao.nguoigui, tb_tk.ngaygui "
        		+ "FROM thongbao,loaitb,tb_tk,taikhoan, taikhoan as tennguoigui "
        		+ "where loaitb.maltb=tb_tk.maltb and thongbao.matb=tb_tk.matb and thongbao.nguoinhan=taikhoan.matk"
        		+ " and tennguoigui.matk=thongbao.nguoigui "
        		+ "and taikhoan.quyen='Manager' and (loaitb.maltb='ltt3' or loaitb.maltb='ltt4')";
			;
        		
        ArrayList<ThongBao> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	ThongBao tb = new ThongBao();
            	tb.setTenLoaiTB(rs.getString("TenLoaiTB"));
            	tb.setTenNguoiGui(rs.getString("TenNG"));
            	tb.setNgayGui(rs.getString("NgayGui"));
            	tb.setMaTB(rs.getString("thongbao.matb"));
            	tb.setMaCTTB(rs.getString("tb_tk.MaCTTB"));
            	list.add(tb);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
//KET THUC TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TIN
	public ArrayList<ThongBao> getListThongBao() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM thongbao";
        ArrayList<ThongBao> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	ThongBao tb = new ThongBao();
            	tb.setMaTB(rs.getString("MaTB"));
            	tb.setNguoiGui(rs.getString("NguoiGui"));
            	tb.setNguoiNhan(rs.getString("NguoiNhan"));
            	list.add(tb);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public ThongBao getListThongBaoNN(String maTB) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM thongbao where matb='"+maTB+"'";
        ThongBao tb = new ThongBao();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	
            	tb.setMaTB(rs.getString("MaTB"));
            	tb.setNguoiGui(rs.getString("NguoiGui"));
            	tb.setNguoiNhan(rs.getString("NguoiNhan"));
            	
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tb;
    }
	public ThongBao getListThongBao(String nguoiGui) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM thongbao inner join taikhoan on thongbao.nguoigui=taikhoan.matk" +
        " Where thongbao.nguoigui='"+nguoiGui+"'";
        ThongBao tb = new ThongBao();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	tb.setMaTB(rs.getString("ThongBao.MaTB"));
            	tb.setNguoiGui(rs.getString("ThongBao.NguoiGui"));
            	tb.setNguoiNhan(rs.getString("ThongBao.NguoiNhan"));
            	
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tb;
    }
	public ThongBao getTBNguoiNhan(String nguoiNhan) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM thongbao inner join taikhoan on thongbao.nguoinhan=taikhoan.matk" +
        " Where thongbao.nguoinhan='"+nguoiNhan+"'";
        ThongBao tb = new ThongBao();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	tb.setMaTB(rs.getString("ThongBao.MaTB"));
            	tb.setNguoiGui(rs.getString("ThongBao.NguoiGui"));
            	tb.setNguoiNhan(rs.getString("ThongBao.NguoiNhan"));
            	
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tb;
    }
	
	public ThongBao getThongBao(String nguoiGui,String nguoiNhan) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM thongbao inner join taikhoan on thongbao.nguoigui=taikhoan.matk" +
        " Where thongbao.nguoigui='"+nguoiGui+"' and nguoinhan='"+nguoiNhan+"'";
        ThongBao tb = new ThongBao();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	tb.setMaTB(rs.getString("thongbao.MaTB"));
            	tb.setNguoiGui(rs.getString("thongbao.NguoiGui"));
            	tb.setNguoiNhan(rs.getString("thongbao.NguoiNhan"));
            	
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tb;
    }
	
	public boolean createThongBao(ThongBao tb) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "insert into thongbao values(?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setString(1,tb.getMaTB());
			ps.setString(2, tb.getNguoiGui());
			ps.setString(3, tb.getNguoiNhan());
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(ThongBao_Controller.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	
	
	public static void main(String[] args) throws SQLException, ParseException {
		TB_TK_Controller ctrl= new TB_TK_Controller();
		ThongBao_Controller thongbaoctrl = new ThongBao_Controller();
	//	ThongBao tb = thongbaoctrl.getThongBao("tk3","tk4");
		for(ThongBao c: thongbaoctrl.getListThongBaoQLHuyGH()){              
	    System.out.println(c.getMaTB());
//	    if(thongbaoctrl.getThongBao("tk3","tk4").getMaTB()==null)
//	    {
//	    	int n =thongbaoctrl.getListThongBao().size();
//		    tb.setMaTB("tb"+(n+1));
//		    tb.setNguoiGui("tk3");
//		    tb.setNguoiNhan("tk4");
//		    if(thongbaoctrl.createThongBao(tb))
//		    	System.out.println("thanh cong");
//		    
//	    }
	    
		}}
}
