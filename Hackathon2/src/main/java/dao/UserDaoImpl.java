package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import static utils.DbUtils.getConn;

import pojos.User;

public class UserDaoImpl implements UserDao{

	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;

	
	public UserDaoImpl() throws SQLException {
		cn = getConn();
		pst1 = cn.prepareStatement("select * from users where email=? and password=?");
		System.out.println("user dao created!");
		//public user( String fullName, String email, String password, String phoneNo) {
		pst2 = cn.prepareStatement("insert into users (user_id,full_name,email,password,phone_no,created_time)values(default,?,?,?,?,?)");
	}

	
	
	@Override
	public User authenticateUser(String email, String pwd) throws SQLException {
		pst1.setString(1, email);
		pst1.setString(2, pwd);
		try (ResultSet rst = pst1.executeQuery()) {
			
			if (rst.next())
				return new User(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4));
		}
		return null;
	}



	@Override
	public int registerUser(String full_name, String email, String password, String phone_no) throws SQLException {
   
		/* String date = valueOf(LocalDate.now()); */
		
	    pst2.setString(1, full_name);
        pst2.setString(2, email);
        pst2.setString(3, password);
        pst2.setString(4 ,phone_no);
        pst2.setDate(4, Date.valueOf(LocalDate.now()));
     
        int count = pst2.executeUpdate();
	
      return count;
		
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		System.out.println("user dao cleaned up!");
	}




}
