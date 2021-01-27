package entitis;

public class NhanSu {
	private NhanVien nhanvien;
	private String tenDangnhap;
	private String matKhau;
	public NhanSu(NhanVien nhanvien, String tenDangnhap, String matKhau) {
		super();
		this.nhanvien = nhanvien;
		this.tenDangnhap = tenDangnhap;
		this.matKhau = matKhau;
	}
	public NhanVien getNhanvien() {
		return nhanvien;
	}
	public void setNhanvien(NhanVien nhanvien) {
		this.nhanvien = nhanvien;
	}
	public String getTenDangnhap() {
		return tenDangnhap;
	}
	public void setTenDangnhap(String tenDangnhap) {
		this.tenDangnhap = tenDangnhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public NhanSu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "NhanSu [nhanvien=" + nhanvien + ", tenDangnhap=" + tenDangnhap + ", matKhau=" + matKhau + "]";
	}
	
	

}
