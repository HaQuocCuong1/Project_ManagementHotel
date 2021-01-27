package entitis;

import java.util.Date;

public class NhanVien {
	private String maNhanVien;
	private String chucVu;
	private String hoTen;
	private String diaChi;
	private String ngaySinh;
	private String sdt;
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public NhanVien(String maNhanVien, String chucVu, String hoTen, String diaChi, String ngaySinh, String sdt) {
		super();
		this.maNhanVien = maNhanVien;
		this.chucVu = chucVu;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
		this.sdt = sdt;
	}
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NhanVien(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}
	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", chucVu=" + chucVu + ", hoTen=" + hoTen + ", diaChi=" + diaChi
				+ ", ngaySinh=" + ngaySinh + ", sdt=" + sdt + "]";
	}
	
	
}
