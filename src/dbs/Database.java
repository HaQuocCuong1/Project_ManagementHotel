package dbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
		
		public static Connection con = null;
		private static Database instance = new Database();
		public static Database getIntance() {
			return instance;
		}
		public void connect() {
			String url="jdbc:sqlserver://localhost:1433;databasename=KhachSanBTL";
			String user="sa";
			String password="123";
			try {
				con = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static Connection getConnection() {
			return con;
		}
}
