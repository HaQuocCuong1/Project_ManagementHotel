package dbs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entitis.NhanVien;
public class DanhSachNhanVien {
	ArrayList<NhanVien> dsnv;
	
	private static DanhSachNhanVien instance;
	NhanVien nhanvien;
	
	public static DanhSachNhanVien getInstance() {
		if(instance == null)
			synchronized (DanhSachNhanVien.class) {
				if(null==instance)
					instance = new DanhSachNhanVien();
			}
		return instance;
	}
	public DanhSachNhanVien() {
		dsnv = new ArrayList<NhanVien>();
	}
	
	public ArrayList<NhanVien> docTuBang(){
		try {
			Connection con = Database.getIntance().getConnection();
			String sql="Select * from NhanVien";
			Statement statement = con.createStatement();
		
		ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			String ma = rs.getString(1);
			String cv = rs.getString(2);
			String ten = rs.getString(3);
			String diachi = rs.getString(4);
			String ngaysinh = rs.getString(5);
			String sdt = rs.getString(6);
			NhanVien t = new NhanVien(ma, cv,ten, diachi, ngaysinh, sdt);
			dsnv.add(t);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dsnv;
	}
	public boolean ThemNhanVien(NhanVien nv) {
		Connection con=Database.getIntance().getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt=con.prepareStatement("insert into NhanVien values(?,?,?,?,?,?)");
			stmt.setString(1, nv.getMaNhanVien());
			stmt.setString(2, nv.getChucVu());
			stmt.setString(3, nv.getHoTen());
			stmt.setString(4, nv.getDiaChi());
			stmt.setString(5, nv.getNgaySinh());
			stmt.setString(6, nv.getSdt());
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Trùng");			
		}
		return n>0;
	}
	public boolean delete(String ma) {
		Connection con = Database.getIntance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("delete from NhanVien where maNhanVien=?");
			stmt.setString(1,ma);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	public ArrayList<NhanVien> Tim(String key){
		key = "N'" + key + "'";
		try {
			Connection con = Database.getIntance().getConnection();
			String sql="Select * from NhanVien where maNhanVien in ("+key+") OR hoTen in ("+key+") ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			String ma = rs.getString(1);
			String cv = rs.getString(2);
			String ten = rs.getString(3);
			String diachi = rs.getString(4);
			String nsinh = rs.getString(5);
			String sdt = rs.getString(6);
			NhanVien nv = new NhanVien(ma, cv, ten, diachi, nsinh, sdt);
			dsnv.add(nv);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dsnv;
	}
	public boolean update(String ma, String cv,String ten, String dc, String ns, String sdt) {
		Connection con=Database.getIntance().getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt=con.prepareStatement("UPDATE NhanVien "
							+"SET chucVu=?, "
							+"hoTen = ?, "
							+"diaChi = ?, "
							+"ngaySinh = ?, "
							+"soDienThoai = ?"
							+" WHERE maNhanVien=?" + ";");
			stmt.setString(1, cv);
			stmt.setString(2, ten);
			stmt.setString(3, dc);
			stmt.setString(4, ns);
			stmt.setString(5, sdt);
			stmt.setString(6, ma);
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

}
