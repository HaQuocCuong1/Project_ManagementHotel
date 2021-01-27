package danhsachs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class Database {
	public static Connection con = null;
	public static Database instance = new Database();
	public static Database getinstance()
	{
		return instance;
	}
	public void connect()
	{
		String url="jdbc:sqlserver://localhost:1433;database=KhachSanBTL";
		String user="sa";
		String password="123";
		try
		{
			con = DriverManager.getConnection(url, user, password);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void disconnect()
	{
		if(con !=null)
		{
			try
			{
				con.close();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	public static Connection getconnection()
	{
		return con;
	}
	
}
