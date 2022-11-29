package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojos.User;
import utils.DbUtils;

public class DaoUserImp implements DaoUser{
	private Connection con;
	private PreparedStatement pst;
	
	public DaoUserImp() throws SQLException{
		con = DbUtils.getConnection();
		pst = con.prepareStatement("select * from user where email = ? and password = ?");
		System.out.println("const of daouser imp called");
	}
	
	@Override
	public User authenticater(String email, String pass) throws SQLException {
		pst.setString(1, email);
		pst.setString(2, pass);
		try(ResultSet rs = pst.executeQuery()){
			if(rs.next()) {
//				return 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
