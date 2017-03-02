package Model;

public class BaoCaoDT {
	private String MaDT;
    private String MaBC;
    private String NgayBC;
    private String FileBC;
    private String TenDT;
    private String TenBC;
    
	public BaoCaoDT() {
		super();
	}

	public BaoCaoDT(String maDT, String maBC, String ngayBC, String fileBC, String tenDT, String tenBC) {
		super();
		MaDT = maDT;
		MaBC = maBC;
		NgayBC = ngayBC;
		FileBC = fileBC;
		TenDT = tenDT;
		TenBC = tenBC;
	}

	public String getMaDT() {
		return MaDT;
	}

	public void setMaDT(String maDT) {
		MaDT = maDT;
	}

	public String getMaBC() {
		return MaBC;
	}

	public void setMaBC(String maBC) {
		MaBC = maBC;
	}

	public String getNgayBC() {
		return NgayBC;
	}

	public void setNgayBC(String ngayBC) {
		NgayBC = ngayBC;
	}

	public String getFileBC() {
		return FileBC;
	}

	public void setFileBC(String fileBC) {
		FileBC = fileBC;
	}

	public String getTenDT() {
		return TenDT;
	}

	public void setTenDT(String tenDT) {
		TenDT = tenDT;
	}

	public String getTenBC() {
		return TenBC;
	}

	public void setTenBC(String tenBC) {
		TenBC = tenBC;
	}

	
}
