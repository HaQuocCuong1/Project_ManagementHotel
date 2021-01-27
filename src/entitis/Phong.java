package entitis;

import java.util.List;

public class Phong {
	private String maPhong;
	private Loaiphong maLoaiphong;
	private String tenPhong;
	private float dienTich;
	private float dongia;
	private static List<Thongtinphong> list;
	public Phong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Phong(String maPhong, Loaiphong maLoaiphong, String tenPhong, float dienTich, float dongia) {
		super();
		this.maPhong = maPhong;
		this.maLoaiphong = maLoaiphong;
		this.tenPhong = tenPhong;
		this.dienTich = dienTich;
		this.dongia = dongia;
	}


	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public Loaiphong getMaLoaiphong() {
		return maLoaiphong;
	}

	public void setMaLoaiphong(Loaiphong maLoaiphong) {
		this.maLoaiphong = maLoaiphong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public float getDienTich() {
		return dienTich;
	}

	public void setDienTich(float dienTich) {
		this.dienTich = dienTich;
	}

	public float getDongia() {
		return dongia;
	}

	public void setDongia(float dongia) {
		this.dongia = dongia;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Phong [maPhong=");
		builder.append(maPhong);
		builder.append(", maLoaiphong=");
		builder.append(maLoaiphong);
		builder.append(", tenPhong=");
		builder.append(tenPhong);
		builder.append(", dienTich=");
		builder.append(dienTich);
		builder.append(", dongia=");
		builder.append(dongia);
		builder.append("]");
		return builder.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLoaiphong == null) ? 0 : maLoaiphong.hashCode());
		result = prime * result + ((maPhong == null) ? 0 : maPhong.hashCode());
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
		Phong other = (Phong) obj;
		if (maLoaiphong == null) {
			if (other.maLoaiphong != null)
				return false;
		} else if (!maLoaiphong.equals(other.maLoaiphong))
			return false;
		if (maPhong == null) {
			if (other.maPhong != null)
				return false;
		} else if (!maPhong.equals(other.maPhong))
			return false;
		return true;
	}
	
}
