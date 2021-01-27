package danhsachs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entitis.Loaiphong;



public class Danhsachloaiphong {
	ArrayList<Loaiphong> dsloaiphong;
	Loaiphong lp;
	public Danhsachloaiphong() {
		super();
		// TODO Auto-generated constructor stub
		dsloaiphong = new ArrayList<Loaiphong>();
	}
	public ArrayList<Loaiphong> docloaiphong()
	{
		try
		{
			Connection con = Database.getinstance().getconnection();
			String sql = "Select * from LoaiPhong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				String maLoaiphong = rs.getString(1);
				String tenLoai = rs.getString(2);
				String ghiChu = rs.getString(3);
				Loaiphong loaiphong = new Loaiphong(maLoaiphong, tenLoai, ghiChu);
				dsloaiphong.add(loaiphong);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsloaiphong;
	}
	public boolean ThemLop(Loaiphong lp) {
		Connection con=Database.getinstance().getconnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt=con.prepareStatement("insert into LoaiPhong values(?,?,?)");
			stmt.setString(1, lp.getMaLoaiphong());
			stmt.setString(2, lp.getTenLoai());
			stmt.setString(3, lp.getGhiChu());
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean updateloaiphong(String mloai, String tloai, String ghichu) {
		Connection con=Database.getinstance().getconnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt=con.prepareStatement("UPDATE LoaiPhong "
							+"SET tenLoai=?, "
							+"ghiChu = ?"
							+" WHERE maLoai=?" + ";");
			stmt.setString(1, tloai);
			stmt.setString(2, ghichu);
			stmt.setString(3, mloai);
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
	public Loaiphong Timmaloai(String key){
		key="'" + key + "'";
		try {
			Connection con = Database.getinstance().getconnection();
			String sql="select [maLoai] from [dbo].[LoaiPhong] where [tenLoai]="+key+"";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		
			while(rs.next())
			{
				String maLoaiphong = rs.getString(1);
				lp = new Loaiphong(maLoaiphong);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lp;
	}
//	public boolean delete(String mphong) {
//		Connection con = Database.getinstance().getconnection();
//		PreparedStatement stmt=null;
//		int n=0;
//		try {
//			stmt=con.prepareStatement("delete from LoaiPhong where maLoai=?");
//			stmt.setString(1, mphong);
//			n = stmt.executeUpdate();
//		} catch (SQLException e) {
//			//e.printStackTrace();
//			JOptionPane.showMessageDialog(null, this, "Loi", "hgk");
//		}
//		return n>0;
//	}
}
