package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.sql.Date;

import com.mysql.jdbc.PreparedStatement;
import com.sun.istack.internal.logging.Logger;

import Model.CTNghiemThu;
import Model.DeTai;
import Model.DonGiaHan;
import Model.TaiKhoan;
import Packages.DBConnect;

public class DeTai_Controller {
	
/*BẮT ĐÀU TÍn*/
	
	public boolean updateTrangThai_DeTai_QL(DeTai dt) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "update detai set matt=?, mahienthi=? where madt=?";
		try {
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setString(1,dt.getMaTT());
			ps.setString(2, dt.getMaHienThi());
			ps.setString(3, dt.getMaDT());
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(DeTai_Controller.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	
	
	public ArrayList<DeTai> getListDeTaiPheDuyetQL()  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql ="select distinct * from detai,trangthai,taikhoan as tkgv,taikhoan as tksv  "
        		+ "where detai.matt='tt1' and detai.matt=trangthai.matt and tksv.matk=detai.macn and tkgv.matk=detai.gvhd";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setMaCN(rs.getString("MaCN"));
            	dt.setLinhVuc(rs.getString("LinhVuc"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setTenGVHD(rs.getString("tkgv.hoten"));
            	dt.setTenCN(rs.getString("tksv.hoten"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public ArrayList<DeTai> getListDeTaiPheDuyetQL_loai2()  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql ="select distinct * from detai,trangthai,taikhoan as tkgv "
        		+ "where detai.matt='tt10' and detai.matt=trangthai.matt and tkgv.matk=detai.gvhd and detai.macn is null";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("detai.madt"));
            	dt.setMaCN(rs.getString("MaCN"));
            	dt.setTenGVHD(rs.getString("tkgv.hoten"));
            	dt.setLinhVuc(rs.getString("LinhVuc"));
            	dt.setTenDT(rs.getString("TenDT"));

            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

	
	public DeTai getDeTai_ALL(String maDT) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM detai,taikhoan,taikhoan as tk1,taikhoan as tk2,taikhoan as tk3" +
      		  " where taikhoan.matk=detai.macn and tk1.matk=detai.gvhd"+
      	        " and tk2.matk=detai.sinhvien1 and tk3.matk=detai.sinhvien2 and madt='"+maDT+"'";
        DeTai dt = new DeTai();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	
            	
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setMaHienThi(rs.getString("MaHienThi"));
            	dt.setMaTT(rs.getString("MaTT"));
            	dt.setMaCN(rs.getString("MaCN"));
            	dt.setSinhVien1(rs.getString("SinhVien1"));
            	dt.setSinhVien2(rs.getString("SinhVien2"));
            	dt.setGVHD(rs.getString("GVHD"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setMoTa(rs.getString("MoTa"));
            	dt.setLinhVuc(rs.getString("LinhVuc"));
            	dt.setLoaiHinh(rs.getString("LoaiHinh"));
            	dt.setNgayThucHien(rs.getString("NgayThucHien"));
            	dt.setNgayKetThuc(rs.getString("NgayKetThuc"));
            	dt.setCoQuanChuTri(rs.getString("CoQuanChuTri"));
            	dt.setTinhHinhTrong(rs.getString("TinhHinhTrong"));
            	dt.setTinhHinhNgoai(rs.getString("TinhHinhNgoai"));
            	dt.setTinhCapThiet(rs.getString("TinhCapThiet"));
            	dt.setMucTieu(rs.getString("MucTieu"));
            	dt.setPPNC(rs.getString("PPNC"));
            	dt.setNoiDungNC(rs.getString("NoiDungNC"));
            	dt.setSPDuKien(rs.getString("SPDuKien"));
            	dt.setDiaChiUD(rs.getString("DiaChiUD"));
            	dt.setTenCN(rs.getString("taikhoan.hoten"));
            	dt.setMSSVCN(rs.getString("taikhoan.matkhau"));
            	dt.setTenSV1(rs.getString("tk2.hoten"));
            	dt.setTenSV2(rs.getString("tk3.hoten"));
            	dt.setTenGVHD(rs.getString("tk1.hoten"));
            	dt.setEmailCN(rs.getString("taikhoan.Email"));
            	dt.setEmailGV(rs.getString("tk1.Email"));
            	dt.setMSSV1(rs.getString("tk2.matkhau"));
            	dt.setMSSV2(rs.getString("tk3.matkhau"));
            	dt.setKinhPhi(rs.getDouble("KinhPhi"));
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dt;
    }
	public ArrayList<DeTai> getListDeTaiCanPhanCongPB()  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql ="select *"
        		+ " from detai,trangthai,taikhoan "
        		+ "where detai.matt='tt3' and detai.matt=trangthai.matt and taikhoan.matk=detai.macn";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setHoTen(rs.getString("HoTen"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public ArrayList<DeTai> getListDeTaiChoNghiemThu()  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql ="select *"
        		+ "from detai,trangthai "
        		+ "where detai.matt='tt11' and detai.matt=trangthai.matt";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setTenDT(rs.getString("TenDT"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public Boolean kiemTraTT(String madt)
	{
		Connection connection = DBConnect.getConnecttion();
		String sql ="SELECT * FROM detai WHERE detai.matt='tt10' and detai.madt='"+madt+"'";
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
	public Boolean kiemTraPCPB(String madt)
	{
		Connection connection = DBConnect.getConnecttion();
		String sql ="SELECT * FROM ctnghiemthu WHERE ctnghiemthu.madt='"+madt+"'";
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
	public ArrayList<DeTai> getListPCPBQL()  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql ="select distinct detai.madt,tendt,tensv.hoten as TenSV,tengv.hoten as TenGV,ctnghiemthu.mahd as MHD "
        		+ "from detai,ctnghiemthu,taikhoan as tensv,taikhoan as tengv "
        		+ "where detai.madt=ctnghiemthu.madt and detai.gvhd=tengv.matk and detai.macn=tensv.matk and detai.matt='tt9'";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setHoTen(rs.getString("TenSV"));
            	dt.setTenGVHD(rs.getString("TenGV"));
            	dt.setMaHD(rs.getString("MHD"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public ArrayList<DeTai> getListPCPBQL_CNT()  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql ="select distinct detai.madt,tendt,tensv.hoten as TenSV,tengv.hoten as TenGV,ctnghiemthu.mahd as MHD "
        		+ "from detai,ctnghiemthu,taikhoan as tensv,taikhoan as tengv "
        		+ "where detai.madt=ctnghiemthu.madt and detai.gvhd=tengv.matk and detai.macn=tensv.matk and detai.matt='tt8'";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setHoTen(rs.getString("TenSV"));
            	dt.setTenGVHD(rs.getString("TenGV"));
            	dt.setMaHD(rs.getString("MHD"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public ArrayList<DeTai> getListDeTaiQL()  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql ="select detai.madt as MaDT, tkgv.hoten as TenGV, tksv.hoten as TenSV, mahienthi, tendt, gvhd,tentt"
        		+ " from detai,taikhoan as tksv, taikhoan as tkgv,trangthai "
        		+ "where detai.macn=tksv.matk and trangthai.matt=detai.matt and detai.gvhd=tkgv.matk";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setMaHienThi(rs.getString("MaHienThi"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setHoTen(rs.getString("TenSV"));
            	dt.setTenGVHD(rs.getString("TenGV"));
            	dt.setGVHD(rs.getString("GVHD"));
            	dt.setTenTT(rs.getString("TenTT"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	
	/*KẾT THÚC TIn*/
	public DeTai getDeTai(String maDT) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM detai,taikhoan,taikhoan as tk1,taikhoan as tk2,taikhoan as tk3"+
        " where taikhoan.matk=detai.macn and tk1.matk=detai.gvhd"+
        " and tk2.matk=detai.sinhvien1 and tk3.matk=detai.sinhvien2 and madt='"+maDT+"'";
        DeTai dt = new DeTai();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	
            	
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setMaHienThi(rs.getString("MaHienThi"));
            	dt.setMaTT(rs.getString("MaTT"));
            	dt.setMaCN(rs.getString("MaCN"));
            	dt.setSinhVien1(rs.getString("SinhVien1"));
            	dt.setSinhVien2(rs.getString("SinhVien2"));
            	dt.setGVHD(rs.getString("GVHD"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setMoTa(rs.getString("MoTa"));
            	dt.setLinhVuc(rs.getString("LinhVuc"));
            	dt.setLoaiHinh(rs.getString("LoaiHinh"));
            	dt.setNgayThucHien(rs.getString("NgayThucHien"));
            	dt.setNgayKetThuc(rs.getString("NgayKetThuc"));
            	dt.setCoQuanChuTri(rs.getString("CoQuanChuTri"));
            	dt.setTinhHinhTrong(rs.getString("TinhHinhTrong"));
            	dt.setTinhHinhNgoai(rs.getString("TinhHinhNgoai"));
            	dt.setTinhCapThiet(rs.getString("TinhCapThiet"));
            	dt.setMucTieu(rs.getString("MucTieu"));
            	dt.setPPNC(rs.getString("PPNC"));
            	dt.setNoiDungNC(rs.getString("NoiDungNC"));
            	dt.setSPDuKien(rs.getString("SPDuKien"));
            	dt.setDiaChiUD(rs.getString("DiaChiUD"));
            	dt.setTenCN(rs.getString("taikhoan.hoten"));
            	dt.setMSSVCN(rs.getString("taikhoan.matkhau"));
            	dt.setTenSV1(rs.getString("tk2.hoten"));
            	dt.setTenSV2(rs.getString("TK3.hoten"));
            	dt.setTenGVHD(rs.getString("tk1.hoten"));
            	dt.setEmailCN(rs.getString("taikhoan.Email"));
            	dt.setEmailGV(rs.getString("tk1.Email"));
            	dt.setMSSV1(rs.getString("tk2.matkhau"));
            	dt.setMSSV2(rs.getString("TK3.matkhau"));
            	dt.setKinhPhi(rs.getDouble("KinhPhi"));
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dt;
    }
	
	
	
	
	public ArrayList<DeTai> getListDeTaiByMaCN(String Email)  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql = "select detai.madt as MaDT, detai.tendt as TenDT,detai.ngaythuchien as NgayDK, mahienthi, "+
				" detai.ngayketthuc as NgayNT, trangthai.tentt as TenTT"+
				" from detai,taikhoan,trangthai"+
				" where detai.macn=taikhoan.matk and detai.matt=trangthai.matt "+
				" and taikhoan.email='"+Email+"'";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setNgayThucHien(rs.getString("NgayDK"));
            	dt.setNgayKetThuc(rs.getString("NgayNT"));
            	dt.setTenTT(rs.getString("TenTT"));
            	dt.setMaHienThi(rs.getString("MaHienThi"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public ArrayList<DeTai> getListDeTaiDeXuat()  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql = "select detai.madt as MaDT, detai.tendt as TenDT,detai.ngaythuchien as NgayDK,"+
				" taikhoan.hoten as TenGVHD "+
				" from detai,taikhoan,trangthai where detai.gvhd=taikhoan.matk "+
				" and detai.matt=trangthai.matt and trangthai.matt='tt11'";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setNgayThucHien(rs.getString("NgayDK"));
            	dt.setTenGVHD(rs.getString("TenGVHD"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public DeTai getDeTaiDX(String maDT) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM detai,taikhoan as tk1 "+
        " where tk1.matk=detai.gvhd"+
        "  and madt='"+maDT+"'";
        DeTai dt = new DeTai();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	
            	
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setMaHienThi(rs.getString("MaHienThi"));
            	dt.setMaTT(rs.getString("MaTT"));
            	dt.setGVHD(rs.getString("GVHD"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setMoTa(rs.getString("MoTa"));
            	dt.setLinhVuc(rs.getString("LinhVuc"));
            	dt.setLoaiHinh(rs.getString("LoaiHinh"));
            	dt.setNgayThucHien(rs.getString("NgayThucHien"));
            	dt.setNgayKetThuc(rs.getString("NgayKetThuc"));
            	dt.setCoQuanChuTri(rs.getString("CoQuanChuTri"));
            	dt.setTinhHinhTrong(rs.getString("TinhHinhTrong"));
            	dt.setTinhHinhNgoai(rs.getString("TinhHinhNgoai"));
            	dt.setTinhCapThiet(rs.getString("TinhCapThiet"));
            	dt.setMucTieu(rs.getString("MucTieu"));
            	dt.setPPNC(rs.getString("PPNC"));
            	dt.setNoiDungNC(rs.getString("NoiDungNC"));
            	dt.setSPDuKien(rs.getString("SPDuKien"));
            	dt.setDiaChiUD(rs.getString("DiaChiUD"));
            	dt.setTenGVHD(rs.getString("HoTen"));
            	dt.setEmailGV(rs.getString("Email"));
            	dt.setKinhPhi(rs.getDouble("KinhPhi"));
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dt;
    }
	public DeTai getListDeTaiByMaDT(String maDT)  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql = "select detai.madt as MaDT, detai.tendt as TenDT,detai.ngaythuchien as NgayDK,"+
				" detai.ngayketthuc as NgayNT, trangthai.tentt as TenTT,matkhau as MSSV, hoten as TenCN"+
				" from detai,taikhoan,trangthai"+
				" where detai.macn=taikhoan.matk and detai.matt=trangthai.matt "+
				" and madt='"+maDT+"'";
        DeTai dt = new DeTai();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setNgayThucHien(rs.getString("NgayDK"));
            	dt.setNgayKetThuc(rs.getString("NgayNT"));
            	dt.setTenTT(rs.getString("TenTT"));
            	dt.setMSSVCN(rs.getString("MSSV"));
            	dt.setTenCN(rs.getString("TenCN"));
            	
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dt;
    }
	public ArrayList<DeTai> getListDeTaiByGVHD(String gvhd)  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM detai,taikhoan where detai.macn=taikhoan.matk and gvhd='"+gvhd+"'";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setMaHienThi(rs.getString("MaHienThi"));
            	dt.setMaTT(rs.getString("MaTT"));
            	dt.setMaCN(rs.getString("MaCN"));
            	dt.setSinhVien1(rs.getString("SinhVien1"));
            	dt.setSinhVien2(rs.getString("SinhVien2"));
            	dt.setGVHD(rs.getString("GVHD"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setMoTa(rs.getString("MoTa"));
            	dt.setLinhVuc(rs.getString("LinhVuc"));
            	dt.setLoaiHinh(rs.getString("LoaiHinh"));
            	dt.setNgayThucHien(rs.getString("NgayThucHien"));
            	dt.setNgayKetThuc(rs.getString("NgayKetThuc"));
            	dt.setCoQuanChuTri(rs.getString("CoQuanChuTri"));
            	dt.setTinhHinhTrong(rs.getString("TinhHinhTrong"));
            	dt.setTinhHinhNgoai(rs.getString("TinhHinhNgoai"));
            	dt.setTinhCapThiet(rs.getString("TinhCapThiet"));
            	dt.setMucTieu(rs.getString("MucTieu"));
            	dt.setPPNC(rs.getString("PPNC"));
            	dt.setNoiDungNC(rs.getString("NoiDungNC"));
            	dt.setSPDuKien(rs.getString("SPDuKien"));
            	dt.setDiaChiUD(rs.getString("DiaChiUD"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public ArrayList<DeTai> getListDeTaiNT(String email)  throws SQLException{
		 Connection cons = DBConnect.getConnecttion();
	        String sql = "select distinct detai.madt as MaDT, detai.tendt as TenDT,detai.ngaythuchien as NgayDK,"+
					" ctnghiemthu.ngaynt as NgayNT,detai.mahienthi"+
					" from detai,taikhoan,ctnghiemthu "+
					" where detai.macn=taikhoan.matk "+
					" and detai.madt=ctnghiemthu.madt and taikhoan.email='"+email+"' and matt='tt9'";
	        ArrayList<DeTai> list = new ArrayList<>();
	        CTNghiemThu_Controller crt = new CTNghiemThu_Controller();
	        try {
	            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	DeTai dt = new DeTai();
	            	dt.setMaDT(rs.getString("MaDT"));
	            	boolean f=true;
	            	int TongDiemChung = 0;
					for(CTNghiemThu ct:crt.getListCTNghiemThuMaDT(rs.getString("MaDT")))
					{
						TongDiemChung+=ct.getTongDiem();
						if((Integer.toString(ct.getTongQuan())=="0") || ct.getTongQuan() == 0 )
							f=false;		
					}
					if(f){
						TongDiemChung = (int)TongDiemChung/2;
						if(TongDiemChung<50)
							dt.setTrangThaiNT("Trung Bình");
						if(TongDiemChung>=50 && TongDiemChung<80)
							dt.setTrangThaiNT("Khá");
						if(TongDiemChung>=80)
							dt.setTrangThaiNT("Giỏi");
					}
	            	dt.setTenDT(rs.getString("TenDT"));
	            	dt.setNgayThucHien(rs.getString("NgayDK"));
	            	dt.setNgayNT(rs.getString("NgayNT"));
	            	dt.setMaHienThi(rs.getString("detai.mahienthi"));
	            	list.add(dt);
	            }
	           
	            cons.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
   }
	
	public ArrayList<DeTai> getListDeTaiPhanCongPhanBien(String Email)  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql = "select distinct detai.madt as MaDT, detai.tendt as TenDT,tk1.hoten as MaCN,tk2.hoten as GVHD,detai.mahienthi"+
			" from detai,ctnghiemthu,hoidong,taikhoan,taikhoan as tk1, taikhoan as tk2"+
			" where detai.madt=ctnghiemthu.madt and ctnghiemthu.mahd=hoidong.mahd and "
			+ " (hoidong.phanbien=taikhoan.matk or hoidong.chutich=taikhoan.matk)"+
			" and taikhoan.email='"+Email+"' and detai.macn=tk1.matk and detai.gvhd=tk2.matk and tongquan is null"+
			" and ctnghiemthu.matk=taikhoan.matk" ;
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setMaHienThi(rs.getString("detai.mahienthi"));
            	dt.setTenCN(rs.getString("MaCN"));
            	dt.setTenGVHD(rs.getString("GVHD"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public ArrayList<DeTai> getListDeTaiPhanCongPhanBienQL(String Email)  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql = "select distinct detai.madt as MaDT, detai.tendt as TenDT,tk1.hoten as MaCN,tk2.hoten as GVHD"+
			" from detai,trangthai,ctnghiemthu,hoidong,taikhoan,taikhoan as tk1, taikhoan as tk2"+
			" where detai.madt=ctnghiemthu.madt and ctnghiemthu.mahd=hoidong.mahd and "
			+ " (hoidong.phanbien=taikhoan.matk or hoidong.chutich=taikhoan.matk)"+
			" and taikhoan.email='"+Email+"' and detai.macn=tk1.matk and detai.gvhd=tk2.matk"+
			" and ctnghiemthu.matk=taikhoan.matk and detai.matrangthai='tt8'" ;
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setTenCN(rs.getString("MaCN"));
            	dt.setTenGVHD(rs.getString("GVHD"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public ArrayList<DeTai> getListDeTaiPhanCongPheDuyet(String Email)  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql = "select detai.madt as MaDT, detai.tendt as TenDT,tk1.hoten as MaCN,tk2.hoten as GVHD,detai.linhvuc as LinhVuc,detai.mahienthi "+
			" from detai,taikhoan as tk1,taikhoan as tk2"+
			" where detai.macn=tk1.matk and detai.gvhd=tk2.matk and tk2.email='"+Email+"' and detai.matt='tt2'";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setTenCN(rs.getString("MaCN"));
            	dt.setTenGVHD(rs.getString("GVHD"));
            	dt.setLinhVuc(rs.getString("LinhVuc"));
            	dt.setMaHienThi(rs.getString("detai.mahienthi"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public ArrayList<DeTai> getListDeTaiHuongDan(String Email)  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql = "select detai.madt as MaDT, detai.tendt as TenDT,tk1.hoten as MaCN,tk2.hoten as GVHD,detai.mahienthi "+
			" from detai,taikhoan as tk1,taikhoan as tk2"+
			" where detai.macn=tk1.matk and detai.gvhd=tk2.matk and tk2.email='"+Email+"' and (detai.matt='tt11' or"+
			" detai.matt='tt3' or detai.matt='tt4' or detai.matt='tt6' or detai.matt='tt7' or detai.matt='tt8')";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setTenCN(rs.getString("MaCN"));
            	dt.setTenGVHD(rs.getString("GVHD"));
            	dt.setMaHienThi(rs.getString("detai.mahienthi"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public ArrayList<DeTai> getListDeTaiGV_DK(String Email)  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql = "select detai.madt as MaDT, detai.tendt as TenDT,taikhoan.hoten as GVHD,trangthai.tentt as TenTT,detai.linhvuc"+
			" from detai,taikhoan,trangthai "+
			" where detai.gvhd=taikhoan.matk and detai.matt=trangthai.matt and taikhoan.email='"+Email+"' "+
			" and (detai.matt='tt11' or detai.matt='tt10')";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setTenGVHD(rs.getString("GVHD"));
            	dt.setLinhVuc(rs.getString("detai.LinhVuc"));
            	dt.setTenTT(rs.getString("TenTT"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public ArrayList<DeTai> getListDeTai_YC_Huy_GiaHan(String Email)  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql = "select detai.madt as MaDT, detai.tendt as TenDT,tk2.hoten as TenCN,taikhoan.hoten as GVHD,trangthai.tentt as TenTT,detai.matt,detai.mahienthi"+
			" from detai, taikhoan, trangthai, taikhoan as tk2 "+
			" where detai.macn=tk2.matk and detai.gvhd=taikhoan.matk and detai.matt=trangthai.matt and taikhoan.email='"+Email+"' " + 
			" and (detai.matt='tt4' or detai.matt='tt6')";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setTenCN(rs.getString("TenCN"));
            	dt.setTenTT(rs.getString("TenTT"));
            	dt.setMaTT(rs.getString("detai.matt"));
            	dt.setMaHienThi(rs.getString("detai.mahienthi"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public DeTai getDeTaiGV(String maDT) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM detai,taikhoan"+
        " where taikhoan.matk=detai.gvhd"+
        " and  madt='"+maDT+"'";
        DeTai dt = new DeTai();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setMaHienThi(rs.getString("MaHienThi"));
            	dt.setMaTT(rs.getString("MaTT"));
            	dt.setMaCN(rs.getString("MaCN"));
            	dt.setSinhVien1(rs.getString("SinhVien1"));
            	dt.setSinhVien2(rs.getString("SinhVien2"));
            	dt.setGVHD(rs.getString("GVHD"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setMoTa(rs.getString("MoTa"));
            	dt.setLinhVuc(rs.getString("LinhVuc"));
            	dt.setLoaiHinh(rs.getString("LoaiHinh"));
            	dt.setNgayThucHien(rs.getString("NgayThucHien"));
            	dt.setNgayKetThuc(rs.getString("NgayKetThuc"));
            	dt.setCoQuanChuTri(rs.getString("CoQuanChuTri"));
            	dt.setTinhHinhTrong(rs.getString("TinhHinhTrong"));
            	dt.setTinhHinhNgoai(rs.getString("TinhHinhNgoai"));
            	dt.setTinhCapThiet(rs.getString("TinhCapThiet"));
            	dt.setMucTieu(rs.getString("MucTieu"));
            	dt.setPPNC(rs.getString("PPNC"));
            	dt.setNoiDungNC(rs.getString("NoiDungNC"));
            	dt.setSPDuKien(rs.getString("SPDuKien"));
            	dt.setDiaChiUD(rs.getString("DiaChiUD"));
            	dt.setTenGVHD(rs.getString("taikhoan.hoten"));
            	dt.setEmailGV(rs.getString("taikhoan.Email"));
            	dt.setKinhPhi(rs.getDouble("KinhPhi"));
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dt;
    }
	
	public boolean updateTrangThai_DeTai(DeTai dt) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "update detai set matt=? where madt=?";
		try {
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setString(1,dt.getMaTT());
			ps.setString(2, dt.getMaDT());
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(DeTai_Controller.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	
	

	public boolean insert_DeTaiSVDK(DeTai dt) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "insert into detai values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			SimpleDateFormat format = new SimpleDateFormat( "MM/dd/yyyy" );  
			java.util.Date myDate = format.parse(dt.getNgayThucHien());
			java.sql.Date ngaythuchien = new java.sql.Date( myDate.getTime() );
			java.util.Date myDate2 = format.parse(dt.getNgayKetThuc());
			java.sql.Date ngayketthuc = new java.sql.Date( myDate2.getTime() );
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setString(1,dt.getMaDT());
			ps.setString(2, dt.getMaHienThi());
			ps.setString(3, dt.getMaTT());
			ps.setString(4, dt.getMaCN());
			ps.setString(5, dt.getSinhVien1());
			ps.setString(6, dt.getSinhVien2());
			ps.setString(7, dt.getGVHD());
			ps.setString(8, dt.getTenDT());
			ps.setString(9, dt.getMoTa());
			ps.setString(10, dt.getLinhVuc());
			ps.setString(11, dt.getLoaiHinh());
			ps.setDate(12, ngaythuchien);
			ps.setDate(13, ngayketthuc);
			ps.setString(14, dt.getCoQuanChuTri());
			ps.setString(15, dt.getTinhHinhTrong());
			ps.setString(16, dt.getTinhHinhNgoai());
			ps.setString(17, dt.getTinhCapThiet());
			ps.setString(18, dt.getMucTieu());
			ps.setString(19, dt.getPPNC());
			ps.setString(20, dt.getNoiDungNC());
			ps.setString(21, dt.getSPDuKien());
			ps.setString(22, dt.getDiaChiUD());
			ps.setDouble(23, dt.getKinhPhi());
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(DeTai_Controller.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	public boolean insert_DeTaiQLDK(DeTai dt) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "insert into detai (madt,matt,gvhd,tendt,mota,linhvuc,loaihinh,coquanchutri,tinhhinhtrong,"
				+ "tinhhinhngoai,tinhcapthiet,muctieu,ppnc,noidungnc,spdukien,diachiud,kinhphi)  "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setString(1,dt.getMaDT());
			ps.setString(2, dt.getMaTT());
			ps.setString(3, dt.getGVHD());
			ps.setString(4, dt.getTenDT());
			ps.setString(5, dt.getMoTa());
			ps.setString(6, dt.getLinhVuc());
			ps.setString(7, dt.getLoaiHinh());
			ps.setString(8, dt.getCoQuanChuTri());
			ps.setString(9, dt.getTinhHinhTrong());
			ps.setString(10, dt.getTinhHinhNgoai());
			ps.setString(11, dt.getTinhCapThiet());
			ps.setString(12, dt.getMucTieu());
			ps.setString(13, dt.getPPNC());
			ps.setString(14, dt.getNoiDungNC());
			ps.setString(15, dt.getSPDuKien());
			ps.setString(16, dt.getDiaChiUD());
			ps.setDouble(17, dt.getKinhPhi());
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(DeTai_Controller.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	public ArrayList<DeTai> getListDeTai()  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql = "select * from detai";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setMaHienThi(rs.getString("MaHienThi"));
            	dt.setMaTT(rs.getString("MaTT"));
            	dt.setMaCN(rs.getString("MaCN"));
            	dt.setSinhVien1(rs.getString("SinhVien1"));
            	dt.setSinhVien2(rs.getString("SinhVien2"));
            	dt.setGVHD(rs.getString("GVHD"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setMoTa(rs.getString("MoTa"));
            	dt.setLinhVuc(rs.getString("LinhVuc"));
            	dt.setLoaiHinh(rs.getString("LoaiHinh"));
            	dt.setNgayThucHien(rs.getString("NgayThucHien"));
            	dt.setNgayKetThuc(rs.getString("NgayKetThuc"));
            	dt.setCoQuanChuTri(rs.getString("CoQuanChuTri"));
            	dt.setTinhHinhTrong(rs.getString("TinhHinhTrong"));
            	dt.setTinhHinhNgoai(rs.getString("TinhHinhNgoai"));
            	dt.setTinhCapThiet(rs.getString("TinhCapThiet"));
            	dt.setMucTieu(rs.getString("MucTieu"));
            	dt.setPPNC(rs.getString("PPNC"));
            	dt.setNoiDungNC(rs.getString("NoiDungNC"));
            	dt.setSPDuKien(rs.getString("SPDuKien"));
            	dt.setDiaChiUD(rs.getString("DiaChiUD"));
            	dt.setKinhPhi(rs.getDouble("KinhPhi"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public ArrayList<DeTai> getListLinhVuc(String Email)  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql = "select detai.madt as MaDT, detai.tendt as TenDT,tk2.hoten as TenCN,taikhoan.hoten as GVHD,trangthai.tentt as TenTT,detai.matt"+
			" from detai, taikhoan, trangthai, taikhoan as tk2 "+
			" where detai.macn=tk2.matk and detai.gvhd=taikhoan.matk and detai.matt=trangthai.matt and taikhoan.email='"+Email+"' " + 
			" and (detai.matt='tt4' or detai.matt='tt6')";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setTenCN(rs.getString("TenCN"));
            	dt.setTenTT(rs.getString("TenTT"));
            	dt.setMaTT(rs.getString("detai.MaTT"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public boolean DangKyDTDX(DeTai dt) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "update detai set macn=? ,sinhvien1=? ,sinhvien2=? where madt=? ";
		
		try {
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setString(1,dt.getMaCN());
			ps.setString(2, dt.getSinhVien1());
			ps.setString(3, dt.getSinhVien2());
			ps.setString(4, dt.getMaDT());
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(DeTai_Controller.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	public boolean updateMaHienThiDT(DeTai dt) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "update detai set mahienthi=? where madt=?";
		try {
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setString(1,dt.getMaHienThi());
			ps.setString(2, dt.getMaDT());
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(DeTai_Controller.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	public static void main(String[] args) throws SQLException, Exception {
		DeTai_Controller ctrl = new DeTai_Controller();
		for(DeTai ct:ctrl.getListDeTaiPhanCongPhanBien("lxtriet@gmail.com"))
			System.out.println(ct.getMaHienThi()+"_____"+ct.getTenDT());
//		System.out.println("cuttt");
//		DeTai dt= new DeTai();
//		dt.setMaDT("dt2");
//		dt.setMaTT("tt11");	
//		dt.setGVHD("tk1");
//		dt.setTenDT("tenDT");
//		dt.setMoTa("mota");
//		dt.setLinhVuc("Tự nhiên");
//		dt.setLoaiHinh("Cơ bản");
//		dt.setCoQuanChuTri("coquanchutri");
//		dt.setTinhHinhTrong("tinhhinhTrong");
//		dt.setTinhHinhNgoai("tinhhinhNgoai");
//		dt.setTinhCapThiet("tinhcapThiet");
//		dt.setMucTieu("muctieu");
//		dt.setPPNC("PPNC");
//		dt.setNoiDungNC("NoiDungNC");
//		dt.setSPDuKien("SPDuKien");
//		dt.setDiaChiUD("DiaChiUD");
//		dt.setKinhPhi(10000);
//		ctrl.insert_DeTaiQLDK(dt);
//		DeTai dt= new DeTai();
//		dt=ctrl.getDeTai("dt12");
//		dt.setMaTT("tt1");
//		if(ctrl.updateTrangThai_DeTai(dt))
//			System.out.println(dt.getMaTT());
		
}}
