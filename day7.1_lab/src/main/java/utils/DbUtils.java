package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
	private static Connection con;
	public static void openConnection(String url, String userName, String password) throws SQLException {
		con = DriverManager.getConnection(url, userName, password);
		System.out.println("con established");
	}
	
	public static Connection getConnection() {
		return con;
	}
	
	public static void closeConnection() throws SQLException{
		if(con!=null)
			con.close();
		System.out.println("connection closed");
	}
}
