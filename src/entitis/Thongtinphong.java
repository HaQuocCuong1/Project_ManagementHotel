package entitis;

public class Thongtinphong {
	private String maPhong;
	private String maLoaiphong;
	private String tenPhong;
	private String loaiPhong;
	private float dienTich;
	private float donGia;
	private String ghichu;
	public Thongtinphong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Thongtinphong(String maPhong, String maLoaiphong, String tenPhong, String loaiPhong, float dienTich,
			float donGia, String ghichu) {
		super();
		this.maPhong = maPhong;
		this.maLoaiphong = maLoaiphong;
		this.tenPhong = tenPhong;
		this.loaiPhong = loaiPhong;
		this.dienTich = dienTich;
		this.donGia = donGia;
		this.ghichu = ghichu;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getMaLoaiphong() {
		return maLoaiphong;
	}
	public void setMaLoaiphong(String maLoaiphong) {
		this.maLoaiphong = maLoaiphong;
	}
	public String getTenPhong() {
		return tenPhong;
	}
	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}
	public String getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	public float getDienTich() {
		return dienTich;
	}
	public void setDienTich(float dienTich) {
		this.dienTich = dienTich;
	}
	public float getDonGia() {
		return donGia;
	}
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	@Override
	public String toString() {
		return "Thongtinphong [maPhong=" + maPhong + ", maLoaiphong=" + maLoaiphong + ", tenPhong=" + tenPhong
				+ ", loaiPhong=" + loaiPhong + ", dienTich=" + dienTich + ", donGia=" + donGia + ", ghichu=" + ghichu
				+ "]";
	}
}
