package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private static Connection conn;
	public static void openConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/classwork";
		conn = DriverManager.getConnection(url, "D4_Akshay_69830", "sunbeam");
		System.out.println("db cn established !");
	}
	
	public static Connection getConnection() {
		return conn;
	}
	
}
