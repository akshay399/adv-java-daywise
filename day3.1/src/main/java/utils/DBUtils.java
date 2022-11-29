package utils;

import java.sql.*;

public class DBUtils {
	private static Connection conn;

	// open db connection
	public static void openConnection() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/classwork";
		conn = DriverManager.getConnection(url, "D4_Akshay_69830", "sunbeam");
		System.out.println("db cn established !");
	}
	//get cn

	public static Connection getConn() {
		return conn;
	}
	//close cn
	public static void closeConnection()  throws SQLException
	{
		if(conn != null)
			conn.close();
		System.out.println("db cn closed !");
	}

}
