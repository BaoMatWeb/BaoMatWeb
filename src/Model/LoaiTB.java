package Model;

import java.util.ArrayList;

public class LoaiTB {
	private String MaLTB;
    private String TenLTB;
    
	public LoaiTB() {
		super();
	}

	public LoaiTB(String maLTB, String tenLTB) {
		super();
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
	
}
