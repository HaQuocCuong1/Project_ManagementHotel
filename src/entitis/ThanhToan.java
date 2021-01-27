package entitis;

import java.sql.Date;

public class ThanhToan {
	private ThuePhong maThue;
	private double thanhTien;
	private String hinhThucThanhToan;
	private String ghiChu;
	private Date ngayThanhToan;
	
	public ThuePhong getMaThue() {
		return maThue;
	}
	public void setMaThue(ThuePhong maThue) {
		this.maThue = maThue;
	}
	public double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	public String getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}
	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public Date getNgayThanhToan() {
		return ngayThanhToan;
	}
	public void setNgayThanhToan(Date ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}
	public ThanhToan(ThuePhong maThue, String hinhThucThanhToan) {
		super();
		this.maThue = maThue;
		this.hinhThucThanhToan = hinhThucThanhToan;
	}
	public ThanhToan(ThuePhong maThue, double thanhTien, String hinhThucThanhToan, String ghiChu, Date ngayThanhToan) {
		super();
		this.maThue = maThue;
		this.thanhTien = thanhTien;
		this.hinhThucThanhToan = hinhThucThanhToan;
		this.ghiChu = ghiChu;
		this.ngayThanhToan = ngayThanhToan;
	}
	public ThanhToan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ThanhToan(ThuePhong maThue) {
		super();
		this.maThue = maThue;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ThanhToan [maThue=");
		builder.append(maThue);
		builder.append(", thanhTien=");
		builder.append(thanhTien);
		builder.append(", hinhThucThanhToan=");
		builder.append(hinhThucThanhToan);
		builder.append(", ghiChu=");
		builder.append(ghiChu);
		builder.append(", ngayThanhToan=");
		builder.append(ngayThanhToan);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
