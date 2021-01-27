package danhsachs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entitis.Thongtinphong;



public class Danhsachthongtinphong {
	ArrayList<Thongtinphong> dsphong;
	Thongtinphong tt;
	public static Danhsachloaiphong lp = new Danhsachloaiphong();
	public Danhsachthongtinphong() {
		super();
		// TODO Auto-generated constructor stub
		dsphong = new ArrayList<Thongtinphong>();
	}
	public ArrayList<Thongtinphong> docbangphong()
	{
		try
		{
			Connection con = Database.getinstance().getconnection();
			String sql = "select * from [dbo].[LoaiPhong] lp join [dbo].[Phong] p on lp.[maLoai]=p.[maLoai]";
			Statement statemet = con.createStatement();
			ResultSet rs = statemet.executeQuery(sql);
			while(rs.next())
			{
				String maloaiphong = rs.getString(1);
				String loaiphong = rs.getString(2);
				String ghichu = rs.getString(3);
				String maPhong = rs.getString(4);
				String tenPhong = rs.getString(6);
				float dienTich = rs.getFloat(7);
				float dongia = rs.getFloat(8);
				tt = new Thongtinphong(maPhong, maloaiphong, tenPhong, loaiphong, dienTich, dongia, ghichu);
				dsphong.add(tt);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsphong;
	}
	public ArrayList<Thongtinphong> Timphong(String key){
		key = "'%" + key + "%'";
		try {
			Connection con = Database.getinstance().getconnection();
			String sql="Select * from [dbo].[LoaiPhong] lp join [dbo].[Phong] p on lp.[maLoai]=p.[maLoai] where p.maPhong like ("+key+")";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			String maloaiphong = rs.getString(1);
			String loaiphong = rs.getString(2);
			String ghichu = rs.getString(3);
			String maPhong = rs.getString(4);
			String tenPhong = rs.getString(6);
			float dienTich = rs.getFloat(7);
			float dongia = rs.getFloat(8);
			tt = new Thongtinphong(maPhong, maloaiphong, tenPhong, loaiphong, dienTich, dongia, ghichu);
			dsphong.add(tt);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dsphong;
	}
	public ArrayList<Thongtinphong> TimphongMLP(String key){
		key = "'%" + key + "%'";
		try {
			Connection con = Database.getinstance().getconnection();
			String sql="Select * from [dbo].[LoaiPhong] lp join [dbo].[Phong] p on lp.[maLoai]=p.[maLoai] where lp.maLoai like ("+key+")";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			String maloaiphong = rs.getString(1);
			String loaiphong = rs.getString(2);
			String ghichu = rs.getString(3);
			String maPhong = rs.getString(4);
			String tenPhong = rs.getString(6);
			float dienTich = rs.getFloat(7);
			float dongia = rs.getFloat(8);
			tt = new Thongtinphong(maPhong, maloaiphong, tenPhong, loaiphong, dienTich, dongia, ghichu);
			dsphong.add(tt);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dsphong;
	}
	public ArrayList<Thongtinphong> Timphongtenphong(String key){
		key = "'%" + key + "%'";
		try {
			Connection con = Database.getinstance().getconnection();
			String sql="Select * from [dbo].[LoaiPhong] lp join [dbo].[Phong] p on lp.[maLoai]=p.[maLoai] where p.tenPhong like ("+key+") OR p.dienTich like ("+key+")";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			String maloaiphong = rs.getString(1);
			String loaiphong = rs.getString(2);
			String ghichu = rs.getString(3);
			String maPhong = rs.getString(4);
			String tenPhong = rs.getString(6);
			float dienTich = rs.getFloat(7);
			float dongia = rs.getFloat(8);
			tt = new Thongtinphong(maPhong, maloaiphong, tenPhong, loaiphong, dienTich, dongia, ghichu);
			dsphong.add(tt);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dsphong;
	}
	public ArrayList<Thongtinphong> Timphongloaiphong(String key){
		key="'%" + key + "%'";
		try {
			Connection con = Database.getinstance().getconnection();
			String sql="Select * from [dbo].[LoaiPhong] lp join [dbo].[Phong] p on lp.[maLoai]=p.[maLoai] where lp.tenLoai like ("+key+") or p.giaThue like ("+key+")";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			String maloaiphong = rs.getString(1);
			String loaiphong = rs.getString(2);
			String ghichu = rs.getString(3);
			String maPhong = rs.getString(4);
			String tenPhong = rs.getString(6);
			float dienTich = rs.getFloat(7);
			float dongia = rs.getFloat(8);
			tt = new Thongtinphong(maPhong, maloaiphong, tenPhong, loaiphong, dienTich, dongia, ghichu);
			dsphong.add(tt);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dsphong;
	}
	public ArrayList<Thongtinphong> Locphongcokhach(){
		try {
			Connection con = Database.getinstance().getconnection();
String sql="Select * from [dbo].[LoaiPhong] lp join [dbo].[Phong] p on lp.[maLoai]=p.[maLoai] where p.[maPhong] in (select [maPhong] from [dbo].[ThuePhong])";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			String maloaiphong = rs.getString(1);
			String loaiphong = rs.getString(2);
			String ghichu = rs.getString(3);
			String maPhong = rs.getString(4);
			String tenPhong = rs.getString(6);
			float dienTich = rs.getFloat(7);
			float dongia = rs.getFloat(8);
			tt = new Thongtinphong(maPhong, maloaiphong, tenPhong, loaiphong, dienTich, dongia, ghichu);
			dsphong.add(tt);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dsphong;
	}
	public ArrayList<Thongtinphong> Locphongtrong(){
		try {
			Connection con = Database.getinstance().getconnection();
String sql="Select * from [dbo].[LoaiPhong] lp join [dbo].[Phong] p on lp.[maLoai]=p.[maLoai] where p.[maPhong] not in (select [maPhong] from [dbo].[ThuePhong])";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			String maloaiphong = rs.getString(1);
			String loaiphong = rs.getString(2);
			String ghichu = rs.getString(3);
			String maPhong = rs.getString(4);
			String tenPhong = rs.getString(6);
			float dienTich = rs.getFloat(7);
			float dongia = rs.getFloat(8);
			tt = new Thongtinphong(maPhong, maloaiphong, tenPhong, loaiphong, dienTich, dongia, ghichu);
			dsphong.add(tt);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dsphong;
	}
	public ArrayList<Thongtinphong> listphong(){
		try {
			Connection con = Database.getinstance().getconnection();
			String sql="Select * from [dbo].[LoaiPhong] lp join [dbo].[Phong] p on lp.[maLoai]=p.[maLoai]";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			String maloaiphong = rs.getString(1);
			String loaiphong = rs.getString(2);
			String ghichu = rs.getString(3);
			String maPhong = rs.getString(4);
			String tenPhong = rs.getString(6);
			float dienTich = rs.getFloat(7);
			float dongia = rs.getFloat(8);
			tt = new Thongtinphong(maPhong, maloaiphong, tenPhong, loaiphong, dienTich, dongia, ghichu);
			dsphong.add(tt);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dsphong;
	}
}
