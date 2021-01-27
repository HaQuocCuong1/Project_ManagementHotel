package danhsachs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entitis.Phong;
import entitis.Loaiphong;;


public class Danhsachphong {
	ArrayList<Phong> dsphong;
	Phong p;
	public Danhsachphong() {
		dsphong = new ArrayList<Phong>();
	}
	public ArrayList<Phong> docphong()
	{
		try
		{
			Connection con = Database.getinstance().getconnection();
			String sql = "Select * from LoaiPhong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				String maphong = rs.getString(1);
				String maloai = rs.getString(2);
				String tenphong = rs.getString(3);
				float dienTich = rs.getFloat(4);
				float giaThue = rs.getFloat(5);
				p = new Phong(maphong, new Loaiphong(maloai), tenphong, dienTich, giaThue);
				dsphong.add(p);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsphong;
	}
	public boolean Themphong(Phong p) {
		Connection con=Database.getinstance().getconnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt=con.prepareStatement("Insert [dbo].[Phong]([maPhong],[maLoai] , [tenPhong], [dienTich], [giaThue]) values(?,?,?,?,?)");
			stmt.setString(1, p.getMaPhong());
			stmt.setString(2, p.getMaLoaiphong().getMaLoaiphong());
			stmt.setString(3, p.getTenPhong());
			stmt.setString(4, String.valueOf(p.getDienTich()));
			stmt.setString(5, String.valueOf(p.getDongia()));
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean updatephong(String mphong,String tphong, float dientich,String loaiphong,float giathue) {
		Connection con=Database.getinstance().getconnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt=con.prepareStatement("UPDATE Phong "
							+"SET tenPhong=?, "
							+"dienTich = ?,"
							+"maLoai = ?,"
							+"giaThue = ?"
							+" WHERE maPhong=?" + ";");
			stmt.setString(1, tphong);
			stmt.setFloat(2, dientich);
			stmt.setString(3, loaiphong);
			stmt.setFloat(4, giathue);
			stmt.setString(5, mphong);
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
	public boolean delete(String mhong) {
		Connection con = Database.getinstance().getconnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("delete from Phong where maPhong=?");
			stmt.setString(1, mhong);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
}
