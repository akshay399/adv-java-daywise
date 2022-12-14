package com.sunbeam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoUser implements AutoCloseable {
	private Connection con;
	private PreparedStatement stmtAuthenticateUser;
	
	public DaoUser() throws SQLException {
		Connection con = DbUtil.getConnection();
		String sqlAuthenticateUser = "SELECT * FROM USERS WHERE EMAIL=?";
		stmtAuthenticateUser = con.prepareStatement(sqlAuthenticateUser);
	}
	
	public boolean authenticateUser(String[] user) throws SQLException  {
		boolean res = false;
		stmtAuthenticateUser.setString(1, user[0]);
		try(ResultSet rs = stmtAuthenticateUser.executeQuery()){
			boolean isNotEmpty = rs.next();
			if(!isNotEmpty) {
				System.out.println("Email does not exist");
				return false;
			}else {
				
				String email = rs.getString("email");
				String password2 = rs.getString("password");
				if(user[1].equals(password2)) return true;
				else return false;
			}
		}
		
	}
	
	@Override
	public void close() throws Exception {
		
	}
}
