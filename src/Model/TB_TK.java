package Model;

public class TB_TK {
	private String MaCTTB;
    private String MaTB;
    private String TinTB;
    private String MaLTB;
    private String TenLTB;
    private String NgayGui;
    private String TenNguoiGui;
    
	public TB_TK() {
		super();
	}
	public TB_TK(String maCTTB, String maTB, String tinTB, String ngayGui,String nguoiGui, String maLTB, String tenLTB) {
		super();
		MaCTTB = maCTTB;
		MaTB = maTB;
		TinTB = tinTB;
		NgayGui = ngayGui;
		TenNguoiGui=nguoiGui;
		MaLTB = maLTB;
		TenLTB = tenLTB;
	}
	public String getMaLTB() {
		return MaLTB;
	}
	public void setMaLTB(String maLTB) {
		MaLTB = maLTB;
	}
	public String getTenLTB() {
		return TenLTB;
	}
	public void setTenLTB(String tenLTB) {
		TenLTB = tenLTB;
	}
	public String getMaCTTB() {
		return MaCTTB;
	}
	
	public String getTenNguoiGui() {
		return TenNguoiGui;
	}
	public void setTenNguoiGui(String tenNguoiGui) {
		TenNguoiGui = tenNguoiGui;
	}
	public void setMaCTTB(String maCTTB) {
		MaCTTB = maCTTB;
	}
	public String getMaTB() {
		return MaTB;
	}
	public void setMaTB(String maTB) {
		MaTB = maTB;
	}
	public String getTinTB() {
		return TinTB;
	}
	public void setTinTB(String tinTB) {
		TinTB = tinTB;
	}
	public String getNgayGui() {
		return NgayGui;
	}
	public void setNgayGui(String ngayGui) {
		NgayGui = ngayGui;
	}
 
}
