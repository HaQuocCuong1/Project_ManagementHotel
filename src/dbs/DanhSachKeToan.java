package dbs;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entitis.ThanhToan;
import entitis.ThuePhong;

public class DanhSachKeToan {
	ArrayList<ThanhToan> dstt;
	private static DanhSachKeToan instance;
	ThanhToan thanhtoan;
	
	public static DanhSachKeToan getInstance() {
		if(instance == null)
			synchronized (DanhSachKeToan.class) {
				if(null==instance)
					instance = new DanhSachKeToan();
			}
		return instance;
	}
	public DanhSachKeToan() {
		dstt = new ArrayList<ThanhToan>();
	}
	
	
	//Load Du Lieu Tu Bang
	public ArrayList<ThanhToan> docTuBang(){
		try {
			Connection con = Database.getIntance().getConnection();
			String sql="Select * from ThanhToan";
			Statement statement = con.createStatement();
		
		ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			String mathue = rs.getString(1);
			double thanhtien = rs.getDouble(2);
			String hinhthucthanhtoan = rs.getString(3);
			String ghichu = rs.getString(4);
			Date ngaythanhtoan = rs.getDate(5);
			ThanhToan t = new ThanhToan(new ThuePhong(mathue), thanhtien, hinhthucthanhtoan, ghichu, ngaythanhtoan);
			dstt.add(t);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dstt;
	}
	
	//********************************************** TIM **********************************************//
	public ArrayList<ThanhToan> Tim(String key){
		key = "N'" + key + "'";
		try {
			Connection con = Database.getIntance().getConnection();
			String sql="Select * from ThanhToan where hinhThucThanhToan in("+key+") OR ghiChu in ("+key+") OR maThue in("+key+") ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		
			while (rs.next()) {
				String mathue = rs.getString(1);
				double thanhtien = rs.getDouble(2);
				String hinhthucthanhtoan = rs.getString(3);
				String ghichu = rs.getString(4);
				Date ngaythanhtoan = rs.getDate(5);
				ThanhToan t = new ThanhToan(new ThuePhong(mathue), thanhtien, hinhthucthanhtoan, ghichu, ngaythanhtoan);
				dstt.add(t);
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return dstt;
		}
	
	public ArrayList<ThanhToan> ThongKeTren500(){
		
		try {
			Connection con = Database.getIntance().getConnection();
		//	String sql="Select * from ThanhToan where thanhTien >100000 ";
			String sql="Select * from ThanhToan where thanhTien >=500000 ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		
			while (rs.next()) {
				String mathue = rs.getString(1);
				double thanhtien = rs.getDouble(2);
				String hinhthucthanhtoan = rs.getString(3);
				String ghichu = rs.getString(4);
				Date ngaythanhtoan = rs.getDate(5);
				ThanhToan t = new ThanhToan(new ThuePhong(mathue), thanhtien, hinhthucthanhtoan, ghichu, ngaythanhtoan);
				dstt.add(t);
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return dstt;
		}
public ArrayList<ThanhToan> ThongKeDuoi500(){
		
		try {
			Connection con = Database.getIntance().getConnection();
		//	String sql="Select * from ThanhToan where thanhTien >100000 ";
			String sql="Select * from ThanhToan where thanhTien <500000 ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		
			while (rs.next()) {
				String mathue = rs.getString(1);
				double thanhtien = rs.getDouble(2);
				String hinhthucthanhtoan = rs.getString(3);
				String ghichu = rs.getString(4);
				Date ngaythanhtoan = rs.getDate(5);
				ThanhToan t = new ThanhToan(new ThuePhong(mathue), thanhtien, hinhthucthanhtoan, ghichu, ngaythanhtoan);
				dstt.add(t);
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return dstt;
		}
public ArrayList<ThanhToan> ThongKeTienMat(){
	
	try {
		Connection con = Database.getIntance().getConnection();
	
		String sql="\r\n" + 
				"Select * from ThanhToan where hinhThucThanhToan=N'Tiền mặt' ";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
	
		while (rs.next()) {
			String mathue = rs.getString(1);
			double thanhtien = rs.getDouble(2);
			String hinhthucthanhtoan = rs.getString(3);
			String ghichu = rs.getString(4);
			Date ngaythanhtoan = rs.getDate(5);
			ThanhToan t = new ThanhToan(new ThuePhong(mathue), thanhtien, hinhthucthanhtoan, ghichu, ngaythanhtoan);
			dstt.add(t);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dstt;
	}
public ArrayList<ThanhToan> ThongKeTheThanhToan(){
	
	try {
		Connection con = Database.getIntance().getConnection();
	
		String sql="\r\n" + 
				"Select * from ThanhToan where hinhThucThanhToan=N'Thẻ thanh toán' ";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
	
		while (rs.next()) {
			String mathue = rs.getString(1);
			double thanhtien = rs.getDouble(2);
			String hinhthucthanhtoan = rs.getString(3);
			String ghichu = rs.getString(4);
			Date ngaythanhtoan = rs.getDate(5);
			ThanhToan t = new ThanhToan(new ThuePhong(mathue), thanhtien, hinhthucthanhtoan, ghichu, ngaythanhtoan);
			dstt.add(t);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dstt;
	}
public ArrayList<ThanhToan> ThongKeChuyenKhoan(){
	
	try {
		Connection con = Database.getIntance().getConnection();
	
		String sql="\r\n" + 
				"Select * from ThanhToan where hinhThucThanhToan=N'Chuyển khoản' ";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
	
		while (rs.next()) {
			String mathue = rs.getString(1);
			double thanhtien = rs.getDouble(2);
			String hinhthucthanhtoan = rs.getString(3);
			String ghichu = rs.getString(4);
			Date ngaythanhtoan = rs.getDate(5);
			ThanhToan t = new ThanhToan(new ThuePhong(mathue), thanhtien, hinhthucthanhtoan, ghichu, ngaythanhtoan);
			dstt.add(t);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dstt;
	}
public ArrayList<ThanhToan> ThongKe2019(){
	
	try {
		Connection con = Database.getIntance().getConnection();
	
		String sql="\r\n" + 
				"Select * from ThanhToan where year(ngayThanhToan)=2019 ";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
	
		while (rs.next()) {
			String mathue = rs.getString(1);
			double thanhtien = rs.getDouble(2);
			String hinhthucthanhtoan = rs.getString(3);
			String ghichu = rs.getString(4);
			Date ngaythanhtoan = rs.getDate(5);
			ThanhToan t = new ThanhToan(new ThuePhong(mathue), thanhtien, hinhthucthanhtoan, ghichu, ngaythanhtoan);
			dstt.add(t);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dstt;
	}
public ArrayList<ThanhToan> ThongKe2018(){
	
	try {
		Connection con = Database.getIntance().getConnection();
	
		String sql="\r\n" + 
				"Select * from ThanhToan where year(ngayThanhToan)=2018 ";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
	
		while (rs.next()) {
			String mathue = rs.getString(1);
			double thanhtien = rs.getDouble(2);
			String hinhthucthanhtoan = rs.getString(3);
			String ghichu = rs.getString(4);
			Date ngaythanhtoan = rs.getDate(5);
			ThanhToan t = new ThanhToan(new ThuePhong(mathue), thanhtien, hinhthucthanhtoan, ghichu, ngaythanhtoan);
			dstt.add(t);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dstt;
	}
public ArrayList<ThanhToan> ThongKe2017(){
	
	try {
		Connection con = Database.getIntance().getConnection();
	
		String sql="\r\n" + 
				"Select * from ThanhToan where year(ngayThanhToan)=2017 ";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
	
		while (rs.next()) {
			String mathue = rs.getString(1);
			double thanhtien = rs.getDouble(2);
			String hinhthucthanhtoan = rs.getString(3);
			String ghichu = rs.getString(4);
			Date ngaythanhtoan = rs.getDate(5);
			ThanhToan t = new ThanhToan(new ThuePhong(mathue), thanhtien, hinhthucthanhtoan, ghichu, ngaythanhtoan);
			dstt.add(t);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dstt;
	}
public ArrayList<ThanhToan> ThongKe2016(){
	
	try {
		Connection con = Database.getIntance().getConnection();
	
		String sql="\r\n" + 
				"Select * from ThanhToan where year(ngayThanhToan)=2016 ";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
	
		while (rs.next()) {
			String mathue = rs.getString(1);
			double thanhtien = rs.getDouble(2);
			String hinhthucthanhtoan = rs.getString(3);
			String ghichu = rs.getString(4);
			Date ngaythanhtoan = rs.getDate(5);
			ThanhToan t = new ThanhToan(new ThuePhong(mathue), thanhtien, hinhthucthanhtoan, ghichu, ngaythanhtoan);
			dstt.add(t);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dstt;
	}
public ArrayList<ThanhToan> ThongKe2015(){
	
	try {
		Connection con = Database.getIntance().getConnection();
	
		String sql="\r\n" + 
				"Select * from ThanhToan where year(ngayThanhToan)=2015 ";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
	
		while (rs.next()) {
			String mathue = rs.getString(1);
			double thanhtien = rs.getDouble(2);
			String hinhthucthanhtoan = rs.getString(3);
			String ghichu = rs.getString(4);
			Date ngaythanhtoan = rs.getDate(5);
			ThanhToan t = new ThanhToan(new ThuePhong(mathue), thanhtien, hinhthucthanhtoan, ghichu, ngaythanhtoan);
			dstt.add(t);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dstt;
	}
	public double getSumThanhTien() {
		double tongtien = 0;
		try {
			Connection con = Database.getIntance().getConnection();
			String sql="select tongtien=sum(thanhTien) from ThanhToan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				tongtien = rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tongtien;
	}
	public double DT2019() {
		double tongtien = 0;
		try {
			Connection con = Database.getIntance().getConnection();
			String sql="select tongtien=sum(thanhTien) from [dbo].[ThanhToan]\r\n" + 
					"where year([ngayThanhToan])=2019";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				tongtien = rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tongtien;
	}
	public double DT2018() {
		double tongtien = 0;
		try {
			Connection con = Database.getIntance().getConnection();
			String sql="select tongtien=sum(thanhTien) from [dbo].[ThanhToan]\r\n" + 
					"where year([ngayThanhToan])=2018";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				tongtien = rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tongtien;
	}
	public double DT2017() {
		double tongtien = 0;
		try {
			Connection con = Database.getIntance().getConnection();
			String sql="select tongtien=sum(thanhTien) from [dbo].[ThanhToan]\r\n" + 
					"where year([ngayThanhToan])=2017";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				tongtien = rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tongtien;
	}
	public double DT2016() {
		double tongtien = 0;
		try {
			Connection con = Database.getIntance().getConnection();
			String sql="select tongtien=sum(thanhTien) from [dbo].[ThanhToan]\r\n" + 
					"where year([ngayThanhToan])=2016";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				tongtien = rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tongtien;
	}
	public double DT2015() {
		double tongtien = 0;
		try {
			Connection con = Database.getIntance().getConnection();
			String sql="select tongtien=sum(thanhTien) from [dbo].[ThanhToan]\r\n" + 
					"where year([ngayThanhToan])=2015";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				tongtien = rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tongtien;
	}
	
	
}






