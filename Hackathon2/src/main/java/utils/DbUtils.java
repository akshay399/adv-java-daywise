package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
	private static Connection conn;

	// open db connection
	public static void openConnection(String url,String userName,String password) throws SQLException{

		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackathon", "root","manager");
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
