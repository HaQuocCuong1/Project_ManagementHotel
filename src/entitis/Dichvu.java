package entitis;

import java.text.SimpleDateFormat;

public class Dichvu {
	private String maDV;
	private String tenDV;
	private int soLuong;
	private float dongia;
	private float thanhTien;
	private String ngayXuat;
	public Dichvu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dichvu(String maDV, String tenDV, int soLuong, float dongia, float thanhTien, String ngayXuat) {
		super();
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.soLuong = soLuong;
		this.dongia = dongia;
		this.thanhTien = thanhTien;
		this.ngayXuat = ngayXuat;
	}
	public String getMaDV() {
		return maDV;
	}
	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}
	public String getTenDV() {
		return tenDV;
	}
	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public float getDongia() {
		return dongia;
	}
	public void setDongia(float dongia) {
		this.dongia = dongia;
	}
	public float getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(float thanhTien) {
		this.thanhTien = thanhTien;
	}
	public String getNgayXuat() {
		return ngayXuat;
	}
	public void setNgayXuat(String ngayXuat) {
		this.ngayXuat = ngayXuat;
	}
	@Override
	public String toString() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		return "Dichvu [maDV=" + maDV + ", tenDV=" + tenDV + ", soLuong=" + soLuong + ", dongia=" + dongia
				+ ", thanhTien=" + thanhTien + ", ngayXuat=" + df.format(ngayXuat) + "]";
	}
	
	
}
