package dbs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entitis.NhanSu;
import entitis.NhanVien;
import entitis.ThanhToan;
import entitis.ThuePhong;
public class DanhSachNhanSu {
	ArrayList<NhanSu> dsns;
	private static DanhSachNhanSu instance;
	ThanhToan thanhtoan;
	
	public static DanhSachNhanSu getInstance() {
		if(instance == null)
			synchronized (DanhSachNhanSu.class) {
				if(null==instance)
					instance = new DanhSachNhanSu();
			}
		return instance;
	}
	public DanhSachNhanSu() {
		dsns = new ArrayList<NhanSu>();
	}
	
	
	//Load Du Lieu Tu Bang
	public ArrayList<NhanSu> docTuBang(){
		try {
			Connection con = Database.getIntance().getConnection();
			String sql="Select * from NhanSu";
			Statement statement = con.createStatement();
		
		ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			String manv = rs.getString(1);
			String tendangnhap = rs.getString(2);
			String matkhau = rs.getString(3);
			NhanSu ns = new NhanSu(new NhanVien(manv), tendangnhap, matkhau);
			dsns.add(ns);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dsns;
	}
	
	public boolean ThemNhanSu(NhanSu ns) {
		Connection con=Database.getIntance().getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt=con.prepareStatement("insert into nhansu values(?,?,?)");
			stmt.setString(1, ns.getNhanvien().getMaNhanVien());
			stmt.setString(2, ns.getTenDangnhap());
			stmt.setString(3, ns.getMatKhau());
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean delete(String ten) {
		Connection con = Database.getIntance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("delete from NhanSu where tenDangnhap=?");
			stmt.setString(1,ten);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	public ArrayList<NhanSu> Tim(String key){
		key = "'" + key + "'";
		try {
			Connection con = Database.getIntance().getConnection();
			String sql="Select * from NhanSu where tenDangNhap in ("+key+")";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			String ma = rs.getString(1);
			String ten = rs.getString(2);
			String mk = rs.getString(3);
			NhanSu s = new NhanSu(new NhanVien(ma), ten, mk);
			dsns.add(s);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dsns;
	}
	
	
}
