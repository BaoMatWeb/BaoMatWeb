package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;

import com.mysql.jdbc.PreparedStatement;
import com.sun.istack.internal.logging.Logger;

import java.sql.ResultSet;

import Model.CTNghiemThu;
import Model.TaiKhoan;
import Packages.DBConnect;

public class CTNghiemThu_Controller {
		public ArrayList<CTNghiemThu> getListCTNghiemThu() {
	        Connection cons = DBConnect.getConnecttion();
	        String sql = "SELECT * FROM ctnghiemthu";
	        ArrayList<CTNghiemThu> list = new ArrayList<>();
	        try {
	            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	CTNghiemThu ct = new CTNghiemThu();
	            	ct.setMaDT(rs.getString("MaDT"));
	            	ct.setMaHD(rs.getString("MaHD"));
	            	ct.setTongQuan(rs.getInt("TongQuan"));
	            	ct.setMucTieu(rs.getInt("MucTieu"));
	            	ct.setPhuongPhap(rs.getInt("PhuongPhap"));
	            	ct.setNoiDung(rs.getInt("NoiDung"));
	            	ct.setDongGop(rs.getInt("DongGop"));
	            	ct.setHinhThuc(rs.getInt("HinhThuc"));
	            	ct.setDiemThuong(rs.getInt("DiemThuong"));
	            	ct.setTongDiem(rs.getInt("TongDiem"));
	            	ct.setYKien(rs.getString("YKien"));
	            	ct.setNgayNT(rs.getString("NgayNT"));
	                list.add(ct);
	            }
	            cons.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
		public ArrayList<CTNghiemThu> getListCTNghiemThuMaDT(String maDT) {
	        Connection cons = DBConnect.getConnecttion();
	        String sql = "SELECT distinct * FROM ctnghiemthu,hoidong,taikhoan as ct, taikhoan as pb,detai,taikhoan "
	        		+ "where ctnghiemthu.mahd=hoidong.mahd and detai.madt=ctnghiemthu.madt and "
	        		+ "hoidong.chutich=ct.matk and hoidong.phanbien=pb.matk "
	        		+ "and ctnghiemthu.matk=taikhoan.matk and ctnghiemthu.madt='"+maDT+"'";
	        ArrayList<CTNghiemThu> list = new ArrayList<>();
	        try {
	            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	CTNghiemThu ct = new CTNghiemThu();
	            	ct.setMaDT(rs.getString("ctnghiemthu.MaDT"));
	            	ct.setTongDiem(rs.getInt("TongDiem"));
	            	ct.setTongQuan(rs.getInt("TongQuan"));
	            	ct.setTenDT(rs.getString("TenDT"));
	            	ct.setMaHD(rs.getString("hoidong.mahd"));
	            	ct.setNgayNT(rs.getString("NgayNT"));
	            	ct.setMaPhanBien(rs.getString("PhanBien"));
	            	ct.setTenPhanBien(rs.getString("pb.HoTen"));
	            	ct.setMaChuTich(rs.getString("ChuTich"));
	            	ct.setTenChuTich(rs.getString("ct.HoTen"));
	            	ct.setMaTK(rs.getString("ctnghiemthu.matk"));
	            	ct.setTenTK(rs.getString("taikhoan.HoTen"));
	                list.add(ct);
	            }
	            cons.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
		public ArrayList<CTNghiemThu> getCTNThu_QL(String madt) {
	        Connection cons = DBConnect.getConnecttion();
	        String sql ="select ctnghiemthu.matk, taikhoan.HoTen,Quyen from taikhoan,ctnghiemthu where ctnghiemthu.MaTK=taikhoan.MaTK and ctnghiemthu.madt='"+madt+"'";
	        ArrayList<CTNghiemThu> list = new ArrayList<>();
	        try {
	            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	CTNghiemThu ct = new CTNghiemThu();
	            	ct.setQuyen(rs.getString("Quyen"));
	            	ct.setTenTK(rs.getString("taikhoan.HoTen"));
	            	ct.setMaTK(rs.getString("ctnghiemthu.matk"));
	                list.add(ct);
	            }
	            cons.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
		public CTNghiemThu getCTNghiemThuMaTKQL(String maTK,String maDT) {
	        Connection cons = DBConnect.getConnecttion();
	        String sql = "SELECT distinct * FROM ctnghiemthu,hoidong,taikhoan as ct, taikhoan as pb,detai,taikhoan "
	        		+ "where ctnghiemthu.mahd=hoidong.mahd and detai.madt=ctnghiemthu.madt and "
	        		+ "hoidong.chutich=ct.matk and hoidong.phanbien=pb.matk "
	        		+ "and ctnghiemthu.matk=taikhoan.matk and ctnghiemthu.madt='"+maDT+"'and ctnghiemthu.matk='"+maTK+"'";
	        CTNghiemThu ct = new CTNghiemThu();
	        try {
	            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	
	            	ct.setMaDT(rs.getString("ctnghiemthu.MaDT"));
	            	ct.setTenDT(rs.getString("TenDT"));
	            	ct.setMaHD(rs.getString("hoidong.mahd"));
	            	ct.setNgayNT(rs.getString("NgayNT"));
	            	ct.setMaPhanBien(rs.getString("PhanBien"));
	            	ct.setTenPhanBien(rs.getString("pb.HoTen"));
	            	ct.setMaChuTich(rs.getString("ChuTich"));
	            	ct.setTenChuTich(rs.getString("ct.HoTen"));
	            	ct.setMaTK(rs.getString("ctnghiemthu.matk"));
	            	ct.setTenTK(rs.getString("taikhoan.HoTen"));
	               
	            }
	            cons.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return ct;
	    }
		public CTNghiemThu getCTNghiemThuMaTK(String maTK) {
	        Connection cons = DBConnect.getConnecttion();
	        String sql = "SELECT distinct * FROM ctnghiemthu,hoidong,taikhoan as ct, taikhoan as pb,detai,taikhoan "
	        		+ "where ctnghiemthu.mahd=hoidong.mahd and detai.madt=ctnghiemthu.madt and "
	        		+ "hoidong.chutich=ct.matk and hoidong.phanbien=pb.matk "
	        		+ "and ctnghiemthu.matk=taikhoan.matk and ctnghiemthu.matk='"+maTK+"'";
	        CTNghiemThu ct = new CTNghiemThu();
	        try {
	            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	
	            	ct.setMaDT(rs.getString("ctnghiemthu.MaDT"));
	            	ct.setTenDT(rs.getString("TenDT"));
	            	ct.setMaHD(rs.getString("hoidong.mahd"));
	            	ct.setNgayNT(rs.getString("NgayNT"));
	            	ct.setMaPhanBien(rs.getString("PhanBien"));
	            	ct.setTenPhanBien(rs.getString("pb.HoTen"));
	            	ct.setMaChuTich(rs.getString("ChuTich"));
	            	ct.setTenChuTich(rs.getString("ct.HoTen"));
	            	ct.setMaTK(rs.getString("ctnghiemthu.matk"));
	            	ct.setTenTK(rs.getString("taikhoan.HoTen"));
	               
	            }
	            cons.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return ct;
	    }
		public CTNghiemThu getListCTNghiemThuByDeTai(String maDT) throws SQLException {
	        Connection connection = DBConnect.getConnecttion();
	        String sql = "SELECT * FROM ctnghiemthu where madt='"+maDT+"'";
	        PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
	        ResultSet rs = ps.executeQuery();
	        CTNghiemThu ct = new CTNghiemThu();
	        while (rs.next()) {
	        	
	        	ct.setMaDT(rs.getString("MaDT"));
            	ct.setMaHD(rs.getString("MaHD"));
            	ct.setTongQuan(rs.getInt("TongQuan"));
            	ct.setMucTieu(rs.getInt("MucTieu"));
            	ct.setPhuongPhap(rs.getInt("PhuongPhap"));
            	ct.setNoiDung(rs.getInt("NoiDung"));
            	ct.setDongGop(rs.getInt("DongGop"));
            	ct.setHinhThuc(rs.getInt("HinhThuc"));
            	ct.setDiemThuong(rs.getInt("DiemThuong"));
            	ct.setTongDiem(rs.getInt("TongDiem"));
            	ct.setYKien(rs.getString("YKien"));
            	ct.setNgayNT(rs.getString("NgayNT"));
                
	        }
	        return ct;
	    }
		public CTNghiemThu getListCTNghiemThuByMaTK(String MaTk) throws SQLException {
	        Connection connection = DBConnect.getConnecttion();
	        String sql = "SELECT * FROM ctnghiemthu where matk='"+MaTk+"'";
	        PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
	        ResultSet rs = ps.executeQuery();
	        CTNghiemThu ct = new CTNghiemThu();
	        while (rs.next()) {
	        	
	        	ct.setMaDT(rs.getString("MaDT"));
            	ct.setMaHD(rs.getString("MaHD"));
            	ct.setTongQuan(rs.getInt("TongQuan"));
            	ct.setMucTieu(rs.getInt("MucTieu"));
            	ct.setPhuongPhap(rs.getInt("PhuongPhap"));
            	ct.setNoiDung(rs.getInt("NoiDung"));
            	ct.setDongGop(rs.getInt("DongGop"));
            	ct.setHinhThuc(rs.getInt("HinhThuc"));
            	ct.setDiemThuong(rs.getInt("DiemThuong"));
            	ct.setTongDiem(rs.getInt("TongDiem"));
            	ct.setYKien(rs.getString("YKien"));
            	ct.setNgayNT(rs.getString("NgayNT"));
                
	        }
	        return ct;
	    }
		public CTNghiemThu getListCTNghiemThu(String maDT) {
	        Connection cons = DBConnect.getConnecttion();
	        String sql = "SELECT * FROM ctnghiemthu,detai where"+
	        " ctnghiemthu.madt=detai.madt"+
	        " and detai.madt='"+maDT+"'";
	        CTNghiemThu ct = new CTNghiemThu();
	        try {
	            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	
	            	ct.setMaDT(rs.getString("MaDT"));
	            	ct.setMaHD(rs.getString("MaHD"));
	            	ct.setTongQuan(rs.getInt("TongQuan"));
	            	ct.setMucTieu(rs.getInt("MucTieu"));
	            	ct.setPhuongPhap(rs.getInt("PhuongPhap"));
	            	ct.setNoiDung(rs.getInt("NoiDung"));
	            	ct.setDongGop(rs.getInt("DongGop"));
	            	ct.setHinhThuc(rs.getInt("HinhThuc"));
	            	ct.setDiemThuong(rs.getInt("DiemThuong"));
	            	ct.setTongDiem(rs.getInt("TongDiem"));
	            	ct.setYKien(rs.getString("YKien"));
	            	ct.setNgayNT(rs.getString("NgayNT"));
	                
	            }
	            cons.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return ct;
	    }
		public CTNghiemThu getCTNghiemThuByMaTK(String maDT,String maTK) {
	        Connection cons = DBConnect.getConnecttion();
	        String sql = "SELECT distinct * FROM ctnghiemthu,hoidong,taikhoan,detai "
	        		+ "where ctnghiemthu.mahd=hoidong.mahd and detai.madt=ctnghiemthu.madt  "
	        		+ "and taikhoan.matk=ctnghiemthu.matk and ctnghiemthu.matk='"+maTK+"' and ctnghiemthu.madt='"+maDT+"'";
	        CTNghiemThu ct = new CTNghiemThu();
	        try {
	            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	
	            	ct.setMaDT(rs.getString("ctnghiemthu.MaDT"));
	            	ct.setTenDT(rs.getString("detai.TenDT"));
	            	ct.setMaHD(rs.getString("hoidong.MaHD"));
	            	ct.setMaTK(rs.getString("ctnghiemthu.MaTK"));
	            	ct.setTenTK(rs.getString("HoTen"));
	            	ct.setTongQuan(rs.getInt("TongQuan"));
	            	ct.setMucTieu(rs.getInt("MucTieu"));
	            	ct.setPhuongPhap(rs.getInt("PhuongPhap"));
	            	ct.setNoiDung(rs.getInt("NoiDung"));
	            	ct.setDongGop(rs.getInt("DongGop"));
	            	ct.setHinhThuc(rs.getInt("HinhThuc"));
	            	ct.setDiemThuong(rs.getInt("DiemThuong"));
	            	ct.setTongDiem(rs.getInt("TongDiem"));
	            	ct.setYKien(rs.getString("YKien"));
	            	ct.setNgayNT(rs.getString("NgayNT"));
	                
	            }
	            cons.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return ct;
	    }
		
		public boolean updateCTNT(CTNghiemThu ctnt) throws ParseException {
			Connection cons = DBConnect.getConnecttion();
			String sql = "update ctnghiemthu set tongquan=?, muctieu=?, phuongphap=?,noidung=?,donggop=?,"
					+ " hinhthuc=?, diemthuong=?, tongdiem=?, ykien=?, ngaynt=? where madt=? and matk=? ";
			try {
				PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
				java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
				ps.setInt(1, ctnt.getTongQuan());
				ps.setInt(2, ctnt.getMucTieu());
				ps.setInt(3, ctnt.getPhuongPhap());
				ps.setInt(4, ctnt.getNoiDung());
				ps.setInt(5, ctnt.getDongGop());
				ps.setInt(6, ctnt.getHinhThuc());
				ps.setInt(7, ctnt.getDiemThuong());
				ps.setInt(8, ctnt.getTongDiem());
				ps.setString(9, ctnt.getYKien());
				ps.setDate(10,  date);
				ps.setString(11, ctnt.getMaDT());
				ps.setString(12, ctnt.getMaTK());
				return ps.executeUpdate()==1;
			} catch (SQLException e) {
				e.printStackTrace();
				Logger.getLogger(TaiKhoan_Controller.class.getName(), null).log(Level.SEVERE, null, e);
			}
			return false;
		}
		public boolean deleteCTNT(String maHD) throws SQLException {
			 Connection connection = DBConnect.getConnecttion();
		     String sql = "DELETE FROM ctnghiemthu WHERE mahd = ?";
		    try {
		       
		       PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
		       ps.setString(1,maHD );
		       return ps.executeUpdate()==1;
		    } catch (Exception e) {
		    	return false;
		    }
		    
		}
		
		
		 public static void main(String[] args) throws SQLException, ParseException {
		       CTNghiemThu_Controller ctrl= new CTNghiemThu_Controller();
//		       CTNghiemThu ctnt=ctrl.getCTNghiemThuByMaTK("dt4","tk7");
//		    	   //System.out.println(ctnt.getMaDT()+"_____"+ctnt.getTenDT()+"____"+ctnt.getNoiDung());
//		    	   for(CTNghiemThu ct : ctrl.getListCTNghiemThuMaDT("dt9"))
//		    		   System.out.println(ct.getTongQuan()+"___"+ct.getTongDiem()+"___"+ct.getMaTK());
		    	   
		       CTNghiemThu ct= new CTNghiemThu();
		       ct = ctrl.getListCTNghiemThu("dt9");
		       ct.setDiemThuong(10);
		       ct.setYKien("nhu c");
		       if(ctrl.updateCTNT(ct))
		    	   System.out.println("TC");
		    }
}
