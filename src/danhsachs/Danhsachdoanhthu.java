package danhsachs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entitis.Doanhthu;



public class Danhsachdoanhthu {
	ArrayList<Doanhthu> dsdt;
	Doanhthu dt;
	public Danhsachdoanhthu() {
		super();
		// TODO Auto-generated constructor stub
		dsdt = new ArrayList<Doanhthu>();
	}
	public ArrayList<Doanhthu> docDanhthu(){
		
		try {
			Connection con = Database.getinstance().getconnection();
			String sql="Select [tenPhong], [tenKhachHang], [hoTen], [ngayThanhToan],[thanhTien] from [dbo].[KhachHang] kh join [dbo].[ThuePhong] tp on kh.[maKhachHang] = tp.[maKhachHang] join [dbo].[NhanVien] nv on tp.maNhanVien=nv.maNhanVien join [dbo].[Phong] p on p.[maPhong]=tp.maPhong join [dbo].[ThanhToan] tt on tt.maThue=tp.maThue";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			String tenPhong = rs.getString(1);
			String tenKhachHang = rs.getString(2);
			String hoTen = rs.getString(3);
			String ngayThanhToan = rs.getString(4);
			float thanhTien = rs.getFloat(5);
			
			dt = new Doanhthu(tenPhong, tenKhachHang, hoTen, ngayThanhToan, thanhTien);
			dsdt.add(dt);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dsdt;
	}
	public ArrayList<Doanhthu> tinhdoanhthu(String tu, String den){
		tu = "'" + tu + "'";
		den = "'" + den + "'";
		
		try {
			Connection con = Database.getinstance().getconnection();
			String sql="Select [tenPhong], [tenKhachHang], [hoTen], [ngayThanhToan],[thanhTien] from [dbo].[KhachHang] kh join [dbo].[ThuePhong] tp on kh.[maKhachHang] = tp.[maKhachHang] join [dbo].[NhanVien] nv on tp.maNhanVien=nv.maNhanVien join [dbo].[Phong] p on p.[maPhong]=tp.maPhong join [dbo].[ThanhToan] tt on tt.maThue=tp.maThue where tt.[ngayThanhToan] >= "+tu+" and tt.[ngayThanhToan]<="+den+"";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			String tenPhong = rs.getString(1);
			String tenKhachHang = rs.getString(2);
			String hoTen = rs.getString(3);
			String ngayThanhToan = rs.getString(4);
			float thanhTien = rs.getFloat(5);
			
			dt = new Doanhthu(tenPhong, tenKhachHang, hoTen, ngayThanhToan, thanhTien);
			dsdt.add(dt);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dsdt;
	}
}
