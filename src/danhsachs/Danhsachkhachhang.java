package danhsachs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entitis.Khachhang;



public class Danhsachkhachhang {
	ArrayList<Khachhang> dskh;
	Khachhang kh;
	public Danhsachkhachhang() {
		dskh = new ArrayList<Khachhang>();
	}
	public ArrayList<Khachhang> docloaikhachang()
	{
		try
		{
			Connection con = Database.getinstance().getconnection();
			String sql = "Select * from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				String maKH = rs.getString(1);
				String tenkhachhang = rs.getString(2);
				String diachi = rs.getString(3);
				String sodienthoai = rs.getString(4);
				Khachhang kh = new Khachhang(maKH, tenkhachhang, diachi, sodienthoai);
				dskh.add(kh);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dskh;
	}
	public boolean delete(String makh) {
		Connection con = Database.getinstance().getconnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("delete from KhachHang where maKhachHang=?");
			stmt.setString(1, makh);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean updatekhachhang(String mkh, String tkh, String diachhi,String sdt) {
		Connection con=Database.getinstance().getconnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt=con.prepareStatement("UPDATE KhachHang "
							+"SET tenKhachHang=?, "
							+"diaChi = ?,"
							+"soDienThoai = ?"
							+" WHERE maKhachHang=?" + ";");
			stmt.setString(1, tkh);
			stmt.setString(2, diachhi);
			stmt.setString(3, sdt);
			stmt.setString(4, mkh);
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return n > 0; 
	}
	public ArrayList<Khachhang> Timkhma(String key){
		key = "'%" + key + "%'";
		try {
			Connection con = Database.getinstance().getconnection();
			String sql="Select * from KhachHang where maKhachHang like ("+key+")";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			String maKH = rs.getString(1);
			String tenkhachhang = rs.getString(2);
			String diachi = rs.getString(3);
			String sodienthoai = rs.getString(4);
			kh = new Khachhang(maKH, tenkhachhang, diachi, sodienthoai);
			dskh.add(kh);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dskh;
	}
	public ArrayList<Khachhang> Timkhten(String key){
		key = "'%" + key + "%'";
		try {
			Connection con = Database.getinstance().getconnection();
			String sql="Select * from KhachHang where tenKhachHang like ("+key+")";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			String maKH = rs.getString(1);
			String tenkhachhang = rs.getString(2);
			String diachi = rs.getString(3);
			String sodienthoai = rs.getString(4);
			kh = new Khachhang(maKH, tenkhachhang, diachi, sodienthoai);
			dskh.add(kh);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dskh;
	}
	public ArrayList<Khachhang> Timkhiachi(String key){
		key = "'%" + key + "%'";
		try {
			Connection con = Database.getinstance().getconnection();
			String sql="Select * from KhachHang where diaChi like ("+key+")";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			String maKH = rs.getString(1);
			String tenkhachhang = rs.getString(2);
			String diachi = rs.getString(3);
			String sodienthoai = rs.getString(4);
			kh = new Khachhang(maKH, tenkhachhang, diachi, sodienthoai);
			dskh.add(kh);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dskh;
	}
}
