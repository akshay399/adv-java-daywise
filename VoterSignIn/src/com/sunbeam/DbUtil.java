package com.sunbeam;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DbUtil {
	private static String DB_DRIVER;
	private static String DB_URL;
	private static String DB_USER;
	private static String DB_PASSWORD;
	
	static {
		try(InputStream in = DbUtil.class.getResourceAsStream("jdbc.properties")){
			Properties props = new Properties();
			props.load(in);
			DB_DRIVER = props.getProperty("db.driver");
			DB_URL = props.getProperty("db.url");
			DB_USER = props.getProperty("db.user");
			DB_PASSWORD = props.getProperty("db.password");
			
			Class.forName(DB_DRIVER);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		return con;
	}
	
//	public static void openConnection(Connection con) throws SQLException {
//		con
//	}
//	
	public static void closeConnection(Connection con) throws SQLException {
		con.close();
	}
}
