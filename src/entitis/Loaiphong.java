package entitis;

public class Loaiphong {
	private String maLoaiphong;
	private String tenLoai;
	private String ghiChu;
	public Loaiphong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Loaiphong(String maLoaiphong) {
		super();
		this.maLoaiphong = maLoaiphong;
	}
	public Loaiphong(String maLoaiphong, String tenLoai, String ghiChu) {
		super();
		this.maLoaiphong = maLoaiphong;
		this.tenLoai = tenLoai;
		this.ghiChu = ghiChu;
	}
	public String getMaLoaiphong() {
		return maLoaiphong;
	}
	public void setMaLoaiphong(String maLoaiphong) {
		this.maLoaiphong = maLoaiphong;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	@Override
	public String toString() {
		return "Loaiphong [maLoaiphong=" + maLoaiphong + ", tenLoai=" + tenLoai + ", ghiChu=" + ghiChu + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLoaiphong == null) ? 0 : maLoaiphong.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loaiphong other = (Loaiphong) obj;
		if (maLoaiphong == null) {
			if (other.maLoaiphong != null)
				return false;
		} else if (!maLoaiphong.equals(other.maLoaiphong))
			return false;
		return true;
	}
	
}
