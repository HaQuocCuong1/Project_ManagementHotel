package entitis;

public class Doanhthu {
	private String tenPhong;
	private String tenKH;
	private String tenNV;
	private String ngayLap;
	private float tongTien;
	public Doanhthu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doanhthu(String tenPhong, String tenKH, String tenNV, String ngayLap, float tongTien) {
		super();
		this.tenPhong = tenPhong;
		this.tenKH = tenKH;
		this.tenNV = tenNV;
		this.ngayLap = ngayLap;
		this.tongTien = tongTien;
	}

	public String getTenPhong() {
		return tenPhong;
	}
	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}
	public float getTongTien() {
		return tongTien;
	}
	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}
	@Override
	public String toString() {
		return "Doanhthu [tenPhong=" + tenPhong + ", tenKH=" + tenKH + ", tenNV=" + tenNV + ", ngayLap=" + ngayLap
				+ ", tongTien=" + tongTien + "]";
	}
	
}
