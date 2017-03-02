package Model;

import java.awt.Image;
import java.util.ArrayList;

public class TaiKhoan {
	 	private String MaTK;
	    private String MatKhau;
	    private String Quyen;
	    private String HoTen;
	    private String NgaySinh;
	    private String Nganh;
	    private String Email;
	    private String HinhAnh;
	    private String MSNH;
	    private String CNNH;
	    
	  
		private ArrayList<ThongBao> dsThongBao= new ArrayList<ThongBao>();
	    private ArrayList<DeTai> dsDeTai= new ArrayList<DeTai>();
	    private ArrayList<HoiDong> dsHoiDong= new ArrayList<HoiDong>();
	    
	    public TaiKhoan() {
			super();
		}
		public TaiKhoan(String maTK, String matKhau, String quyen, String hoTen, String ngaySinh, String nganh,
				String email, String hinhAnh, String mSNH, String cNNH) {
			super();
			MaTK = maTK;
			MatKhau = matKhau;
			Quyen = quyen;
			HoTen = hoTen;
			NgaySinh = ngaySinh;
			Nganh = nganh;
			Email = email;
			MSNH = mSNH;
			CNNH = cNNH;
			HinhAnh = hinhAnh;
		}
		
		public String getHinhAnh() {
			return HinhAnh;
		}
		public void setHinhAnh(String hinhAnh) {
			HinhAnh = hinhAnh;
		}
		public ArrayList<ThongBao> getDsThongBao() {
			return dsThongBao;
		}
		public void setDsThongBao(ArrayList<ThongBao> dsThongBao) {
			this.dsThongBao = dsThongBao;
		}
		
		public ArrayList<DeTai> getDsDeTai() {
			return dsDeTai;
		}
		public void setDsDeTai(ArrayList<DeTai> dsDeTai) {
			this.dsDeTai = dsDeTai;
		}
		public ArrayList<HoiDong> getDsHoiDong() {
			return dsHoiDong;
		}
		public void setDsHoiDong(ArrayList<HoiDong> dsHoiDong) {
			this.dsHoiDong = dsHoiDong;
		}
		public String getMaTK() {
			return MaTK;
		}
		public void setMaTK(String maTK) {
			MaTK = maTK;
		}
		public String getMatKhau() {
			return MatKhau;
		}
		public void setMatKhau(String matKhau) {
			MatKhau = matKhau;
		}
		public String getQuyen() {
			return Quyen;
		}
		public void setQuyen(String quyen) {
			Quyen = quyen;
		}
		public String getHoTen() {
			return HoTen;
		}
		public void setHoTen(String hoTen) {
			HoTen = hoTen;
		}
		public String getNgaySinh() {
			return NgaySinh;
		}
		public void setNgaySinh(String ngaySinh) {
			NgaySinh = ngaySinh;
		}
		public String getNganh() {
			return Nganh;
		}
		public void setNganh(String nganh) {
			Nganh = nganh;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public String getMSNH() {
			return MSNH;
		}
		public void setMSNH(String mSNH) {
			MSNH = mSNH;
		}
		public String getCNNH() {
			return CNNH;
		}
		public void setCNNH(String cNNH) {
			CNNH = cNNH;
		}
	 
	   
}
