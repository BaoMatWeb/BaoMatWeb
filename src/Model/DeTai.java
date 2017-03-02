package Model;

import java.util.ArrayList;

public class DeTai {
	private String MaDT;
    private String MaHienThi;
    private String MaTT;
    private String MaCN;
    private String SinhVien1;
    private String SinhVien2;
    private String GVHD;
    private String TenDT;
    private String MoTa;
    private String LinhVuc;
    private String LoaiHinh;
    private String NgayThucHien;
    private String NgayKetThuc;
    private String CoQuanChuTri;
    private String TinhHinhTrong;
    private String TinhHinhNgoai;
    private String TinhCapThiet;
    private String MucTieu;
    private String PPNC;
    private String NoiDungNC;
    private String SPDuKien;
    private String DiaChiUD;
    private double KinhPhi;
    private String TenTT;
    private String NgayNT;
    private String TenCN;
    private String TrangThaiNT;
    
  //BAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TIN
    private String MSSV;
    private String HoTen;
    private String MaHD;
	public String getMaHD() {
		return MaHD;
	}

	public void setMaHD(String maHD) {
		MaHD = maHD;
	}
    public String getMSSV() {
		return MSSV;
	}

	public void setMSSV(String mSSV) {
		MSSV = mSSV;
	}
	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	//Káº¾T THÃšC TÃ�NBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TIN
    public ArrayList<BaoCaoDT> getDsBaoCaoDT() {
		return dsBaoCaoDT;
	}

	public void setDsBaoCaoDT(ArrayList<BaoCaoDT> dsBaoCaoDT) {
		this.dsBaoCaoDT = dsBaoCaoDT;
	}

	private String MSSVCN;
    private String TenGVHD;
    private String TenSV1;
    private String TenSV2;
    private String EmailCN;
    private String EmailGV;
    private String MSSV1;
    private String MSSV2;
    
    private ArrayList<DonHuy> dsDonHuy= new ArrayList<DonHuy>();
    private ArrayList<DonGiaHan> dsDonGiaHan= new ArrayList<DonGiaHan>();
    private ArrayList<BaoCaoDT> dsBaoCaoDT= new ArrayList<BaoCaoDT>();
    
	public DeTai() {
		super();
	}

	public DeTai(String maDT, String maHienThi, String maTT, String maCN, String sinhVien1, String sinhVien2,
			String gVHD, String tenDT, String moTa, String linhVuc, String loaiHinh, String ngayThucHien,
			String ngayKetThuc, String coQuanChuTri, String tinhHinhTrong, String tinhHinhNgoai, String tinhCapThiet,
			String mucTieu, String pPNC, String noiDungNC, String sPDuKien, String diaChiUD, double kinhPhi,
			String tenTT, String ngayNT, String tenCN, String mSSVCN, String tenGVHD, String tenSV1, String tenSV2,
			String emailCN, String emailGV, String mSSV1, String mSSV2, ArrayList<DonHuy> dsDonHuy,
			ArrayList<DonGiaHan> dsDonGiaHan, ArrayList<BaoCaoDT> dsBaoCaoDT, String TrangThaiNT) {
		super();
		MaDT = maDT;
		MaHienThi = maHienThi;
		MaTT = maTT;
		MaCN = maCN;
		SinhVien1 = sinhVien1;
		SinhVien2 = sinhVien2;
		GVHD = gVHD;
		TenDT = tenDT;
		MoTa = moTa;
		LinhVuc = linhVuc;
		LoaiHinh = loaiHinh;
		NgayThucHien = ngayThucHien;
		NgayKetThuc = ngayKetThuc;
		CoQuanChuTri = coQuanChuTri;
		TinhHinhTrong = tinhHinhTrong;
		TinhHinhNgoai = tinhHinhNgoai;
		TinhCapThiet = tinhCapThiet;
		MucTieu = mucTieu;
		PPNC = pPNC;
		NoiDungNC = noiDungNC;
		SPDuKien = sPDuKien;
		DiaChiUD = diaChiUD;
		KinhPhi = kinhPhi;
		TenTT = tenTT;
		NgayNT = ngayNT;
		TenCN = tenCN;
		MSSVCN = mSSVCN;
		TenGVHD = tenGVHD;
		TenSV1 = tenSV1;
		TenSV2 = tenSV2;
		EmailCN = emailCN;
		EmailGV = emailGV;
		MSSV1 = mSSV1;
		MSSV2 = mSSV2;
		this.TrangThaiNT = TrangThaiNT;
		this.dsDonHuy = dsDonHuy;
		this.dsDonGiaHan = dsDonGiaHan;
		this.dsBaoCaoDT = dsBaoCaoDT;
	}

	public String getTrangThaiNT() {
		return TrangThaiNT;
	}

	public void setTrangThaiNT(String trangThaiNT) {
		TrangThaiNT = trangThaiNT;
	}

	public String getMaDT() {
		return MaDT;
	}

	public void setMaDT(String maDT) {
		MaDT = maDT;
	}

	public String getMaHienThi() {
		return MaHienThi;
	}

	public void setMaHienThi(String maHienThi) {
		MaHienThi = maHienThi;
	}

	public String getMaTT() {
		return MaTT;
	}

	public void setMaTT(String maTT) {
		MaTT = maTT;
	}

	public String getMaCN() {
		return MaCN;
	}

	public void setMaCN(String maCN) {
		MaCN = maCN;
	}

	public String getSinhVien1() {
		return SinhVien1;
	}

	public void setSinhVien1(String sinhVien1) {
		SinhVien1 = sinhVien1;
	}

	public String getSinhVien2() {
		return SinhVien2;
	}

	public void setSinhVien2(String sinhVien2) {
		SinhVien2 = sinhVien2;
	}

	public String getGVHD() {
		return GVHD;
	}

	public void setGVHD(String gVHD) {
		GVHD = gVHD;
	}

	public String getTenDT() {
		return TenDT;
	}

	public void setTenDT(String tenDT) {
		TenDT = tenDT;
	}

	public String getMoTa() {
		return MoTa;
	}

	public void setMoTa(String moTa) {
		MoTa = moTa;
	}

	public String getLinhVuc() {
		return LinhVuc;
	}

	public void setLinhVuc(String linhVuc) {
		LinhVuc = linhVuc;
	}

	public String getLoaiHinh() {
		return LoaiHinh;
	}

	public void setLoaiHinh(String loaiHinh) {
		LoaiHinh = loaiHinh;
	}

	public String getNgayThucHien() {
		return NgayThucHien;
	}

	public void setNgayThucHien(String ngayThucHien) {
		NgayThucHien = ngayThucHien;
	}

	public String getNgayKetThuc() {
		return NgayKetThuc;
	}

	public void setNgayKetThuc(String ngayKetThuc) {
		NgayKetThuc = ngayKetThuc;
	}

	public String getCoQuanChuTri() {
		return CoQuanChuTri;
	}

	public void setCoQuanChuTri(String coQuanChuTri) {
		CoQuanChuTri = coQuanChuTri;
	}

	public String getTinhHinhTrong() {
		return TinhHinhTrong;
	}

	public void setTinhHinhTrong(String tinhHinhTrong) {
		TinhHinhTrong = tinhHinhTrong;
	}

	public String getTinhHinhNgoai() {
		return TinhHinhNgoai;
	}

	public void setTinhHinhNgoai(String tinhHinhNgoai) {
		TinhHinhNgoai = tinhHinhNgoai;
	}

	public String getTinhCapThiet() {
		return TinhCapThiet;
	}

	public void setTinhCapThiet(String tinhCapThiet) {
		TinhCapThiet = tinhCapThiet;
	}

	public String getMucTieu() {
		return MucTieu;
	}

	public void setMucTieu(String mucTieu) {
		MucTieu = mucTieu;
	}

	public String getPPNC() {
		return PPNC;
	}

	public void setPPNC(String pPNC) {
		PPNC = pPNC;
	}

	public String getNoiDungNC() {
		return NoiDungNC;
	}

	public void setNoiDungNC(String noiDungNC) {
		NoiDungNC = noiDungNC;
	}

	public String getSPDuKien() {
		return SPDuKien;
	}

	public void setSPDuKien(String sPDuKien) {
		SPDuKien = sPDuKien;
	}

	public String getDiaChiUD() {
		return DiaChiUD;
	}

	public void setDiaChiUD(String diaChiUD) {
		DiaChiUD = diaChiUD;
	}

	public double getKinhPhi() {
		return KinhPhi;
	}

	public void setKinhPhi(double kinhPhi) {
		KinhPhi = kinhPhi;
	}

	public String getTenTT() {
		return TenTT;
	}

	public void setTenTT(String tenTT) {
		TenTT = tenTT;
	}

	public String getNgayNT() {
		return NgayNT;
	}

	public void setNgayNT(String ngayNT) {
		NgayNT = ngayNT;
	}

	public String getTenCN() {
		return TenCN;
	}

	public void setTenCN(String tenCN) {
		TenCN = tenCN;
	}

	public String getMSSVCN() {
		return MSSVCN;
	}

	public void setMSSVCN(String mSSVCN) {
		MSSVCN = mSSVCN;
	}

	public String getTenGVHD() {
		return TenGVHD;
	}

	public void setTenGVHD(String tenGVHD) {
		TenGVHD = tenGVHD;
	}

	public String getTenSV1() {
		return TenSV1;
	}

	public void setTenSV1(String tenSV1) {
		TenSV1 = tenSV1;
	}

	public String getTenSV2() {
		return TenSV2;
	}

	public void setTenSV2(String tenSV2) {
		TenSV2 = tenSV2;
	}

	public String getEmailCN() {
		return EmailCN;
	}

	public void setEmailCN(String emailCN) {
		EmailCN = emailCN;
	}

	public String getEmailGV() {
		return EmailGV;
	}

	public void setEmailGV(String emailGV) {
		EmailGV = emailGV;
	}

	public String getMSSV1() {
		return MSSV1;
	}

	public void setMSSV1(String mSSV1) {
		MSSV1 = mSSV1;
	}

	public String getMSSV2() {
		return MSSV2;
	}

	public void setMSSV2(String mSSV2) {
		MSSV2 = mSSV2;
	}

	public ArrayList<DonHuy> getDsDonHuy() {
		return dsDonHuy;
	}

	public void setDsDonHuy(ArrayList<DonHuy> dsDonHuy) {
		this.dsDonHuy = dsDonHuy;
	}

	public ArrayList<DonGiaHan> getDsDonGiaHan() {
		return dsDonGiaHan;
	}

	public void setDsDonGiaHan(ArrayList<DonGiaHan> dsDonGiaHan) {
		this.dsDonGiaHan = dsDonGiaHan;
	}

	
}