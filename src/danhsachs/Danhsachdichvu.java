package danhsachs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import entitis.Dichvu;


public class Danhsachdichvu {
	ArrayList<Dichvu> dsdv;
	Dichvu dv;
	public Danhsachdichvu() {
		super();
		// TODO Auto-generated constructor stub
		dsdv = new ArrayList<Dichvu>();
	}
	public ArrayList<Dichvu> doclendichvu(){
		
		try {
			Connection con = Database.getinstance().getconnection();
			String sql="Select dv.[maDichVu],[tenDichVu],[soLuong],[giaTien], [soLuong]*[giaTien] as thanhtien,[ngaySuDung] from [dbo].[DichVu] dv join [dbo].[SuDungDichVu] sd on dv.maDichVu=sd.maDichVu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			String maDichVu = rs.getString(1);
			String tenDichVu = rs.getString(2);
			int soLuong = rs.getInt(3);
			float giaTien = rs.getFloat(4);
			float thanhtien = rs.getFloat(5);
			String ngaysudung = rs.getString(6);
			
			dv = new Dichvu(maDichVu, tenDichVu, soLuong, giaTien, thanhtien, ngaysudung);
			dsdv.add(dv);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dsdv;
	}
	public ArrayList<Dichvu> tinhdichvu(String tu, String den){
		tu = "'" + tu + "'";
		den = "'" + den + "'";
		
		try {
			Connection con = Database.getinstance().getconnection();
			String sql="Select dv.[maDichVu],[tenDichVu],[soLuong],[giaTien], [soLuong]*[giaTien] as thanhtien,[ngaySuDung] from [dbo].[DichVu] dv join [dbo].[SuDungDichVu] sd on dv.maDichVu=sd.maDichVu where sd.[ngaySuDung] >= "+tu+" and sd.[ngaySuDung]<="+den+"";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			String maDichVu = rs.getString(1);
			String tenDichVu = rs.getString(2);
			int soLuong = rs.getInt(3);
			float giaTien = rs.getFloat(4);
			float thanhtien = rs.getFloat(5);
			String ngaysudung = rs.getString(6);
			
			dv = new Dichvu(maDichVu, tenDichVu, soLuong, giaTien, thanhtien, ngaysudung);
			dsdv.add(dv);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dsdv;
	}
}
