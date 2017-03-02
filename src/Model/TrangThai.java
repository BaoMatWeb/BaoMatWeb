package Model;

import java.util.ArrayList;

public class TrangThai {
	private String MaTT;
    private String tenTT;
    
    private ArrayList<DeTai> dsDeTai= new ArrayList<DeTai>();
    
	public TrangThai() {
		super();
	}

	public TrangThai(String maTT, String tenTT) {
		super();
		MaTT = maTT;
		this.tenTT = tenTT;
	}

	public String getMaTT() {
		return MaTT;
	}

	public void setMaTT(String maTT) {
		MaTT = maTT;
	}

	public String getTenTT() {
		return tenTT;
	}

	public void setTenTT(String tenTT) {
		this.tenTT = tenTT;
	}
    
}
