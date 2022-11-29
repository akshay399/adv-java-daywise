package utils;

import java.sql.*;

public class DbUtils {
	private static Connection con;
	
	public static void openConnection() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/classwork";
		con = DriverManager.getConnection(url, "D4_Akshay_69830", "sunbeam");
	}
	
	public static Connection getConnection() {
		return con;
	}
	
	public static void closeConnection() throws SQLException{
		if(con!=null) {
			con.close();
		}
		System.out.println("db cn closed");
	}
	
}
