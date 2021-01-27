package entitis;

public class ThuePhong {
	private String maThue;
	private String maKhachHang;
	private String maPhong;
	private String maNhanVien;
	private String ngayVao;
	private String ngayRa;
	private String thanhTien;
	public String getMaThue() {
		return maThue;
	}
	public void setMaThue(String maThue) {
		this.maThue = maThue;
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getNgayVao() {
		return ngayVao;
	}
	public void setNgayVao(String ngayVao) {
		this.ngayVao = ngayVao;
	}
	public String getNgayRa() {
		return ngayRa;
	}
	public void setNgayRa(String ngayRa) {
		this.ngayRa = ngayRa;
	}
	public String getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(String thanhTien) {
		this.thanhTien = thanhTien;
	}
	public ThuePhong(String maThue, String maKhachHang, String maPhong, String maNhanVien, String ngayVao,
			String ngayRa, String thanhTien) {
		super();
		this.maThue = maThue;
		this.maKhachHang = maKhachHang;
		this.maPhong = maPhong;
		this.maNhanVien = maNhanVien;
		this.ngayVao = ngayVao;
		this.ngayRa = ngayRa;
		this.thanhTien = thanhTien;
	}
	
	@Override
	public String toString() {
		return "ThuePhong [maThue=" + maThue + "]";
	}
	public ThuePhong(String maThue) {
		super();
		this.maThue = maThue;
	}
	
	

}
