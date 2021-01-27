package Data;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	public Connection getConnect() 
	{
		Connection conn= null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn= DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=KhachSanBTL;user=sa;password=123");
			if(conn != 	null)
				System.out.println("Kết nối thành công !");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		return conn;
	}
}

