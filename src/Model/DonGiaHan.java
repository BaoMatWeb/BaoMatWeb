package Model;

public class DonGiaHan {
	private String MaDonXin;
    private String MaDT;
    private String LyDo;
    private String GHDen;
    private String TenDT;
    
	public DonGiaHan() {
		super();
	}

	public DonGiaHan(String maDonXin, String maDT, String lyDo, String gHDen, String tenDT) {
		super();
		MaDonXin = maDonXin;
		MaDT = maDT;
		LyDo = lyDo;
		GHDen = gHDen;
		TenDT = tenDT;
	}

	public String getMaDonXin() {
		return MaDonXin;
	}

	public void setMaDonXin(String maDonXin) {
		MaDonXin = maDonXin;
	}

	public String getMaDT() {
		return MaDT;
	}

	public void setMaDT(String maDT) {
		MaDT = maDT;
	}

	public String getLyDo() {
		return LyDo;
	}

	public void setLyDo(String lyDo) {
		LyDo = lyDo;
	}

	public String getGHDen() {
		return GHDen;
	}

	public void setGHDen(String gHDen) {
		GHDen = gHDen;
	}

	public String getTenDT() {
		return TenDT;
	}

	public void setTenDT(String tenDT) {
		TenDT = tenDT;
	}

	
}
