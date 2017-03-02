package Model;

import java.util.ArrayList;

public class ThongBao {
	private String MaTB;
    private String NguoiGui;
    private String NguoiNhan;
    private String TenNguoiGui;
    private String TenNguoiNhan;
    //TINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTIN
    private String TenLoaiTB;
    private String MaCTTB;
    private String NgayGui;
    private String TinTB;
	public String getTenLoaiTB() {
		return TenLoaiTB;
	}

	public void setTenLoaiTB(String tenLoaiTB) {
		TenLoaiTB = tenLoaiTB;
	}
	public String getNgayGui() {
		return NgayGui;
	}

	public void setNgayGui(String ngayGui) {
		NgayGui = ngayGui;
	}
	
    //HET TINHET TINHET TINHET TINHET TINHET TINHET TINHET TINHET TINHET TINHET TINHET TINHET TINHET TINHET TINHET TIN
    private ArrayList<TB_TK> CTTB = new ArrayList<TB_TK>();
    
	public ThongBao() {
		super();
	}

	public ThongBao(String maTB, String nguoiGui, String nguoiNhan, String tenNguoiGui, String tenNguoiNhan, String tintb,
			ArrayList<TB_TK> cTTB) {
		super();
		MaTB = maTB;
		NguoiGui = nguoiGui;
		NguoiNhan = nguoiNhan;
		TenNguoiGui = tenNguoiGui;
		TenNguoiNhan = tenNguoiNhan;
		TinTB=tintb;
		CTTB = cTTB;
	}

	public String getMaTB() {
		return MaTB;
	}

	public void setMaTB(String maTB) {
		MaTB = maTB;
	}

	public String getNguoiGui() {
		return NguoiGui;
	}

	public void setNguoiGui(String nguoiGui) {
		NguoiGui = nguoiGui;
	}

	public String getNguoiNhan() {
		return NguoiNhan;
	}

	public void setNguoiNhan(String nguoiNhan) {
		NguoiNhan = nguoiNhan;
	}

	public String getTenNguoiGui() {
		return TenNguoiGui;
	}

	public void setTenNguoiGui(String tenNguoiGui) {
		TenNguoiGui = tenNguoiGui;
	}

	public String getTenNguoiNhan() {
		return TenNguoiNhan;
	}

	public void setTenNguoiNhan(String tenNguoiNhan) {
		TenNguoiNhan = tenNguoiNhan;
	}

	public ArrayList<TB_TK> getCTTB() {
		return CTTB;
	}

	public void setCTTB(ArrayList<TB_TK> cTTB) {
		CTTB = cTTB;
	}

	public String getMaCTTB() {
		return MaCTTB;
	}

	public void setMaCTTB(String maCTTB) {
		MaCTTB = maCTTB;
	}

	public String getTinTB() {
		return TinTB;
	}

	public void setTinTB(String tinTB) {
		TinTB = tinTB;
	}
	
}
