package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static utils.DBUtils.getConn;

import pojos.User;

public class UserDaoImpl implements UserDao {
	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;

	// ctor
	public UserDaoImpl() throws SQLException {
		// get cn from db utils
		cn = getConn();
		// pst1
		pst1 = cn.prepareStatement("select * from user where email=? and password=?");
		System.out.println("user dao created!");
		pst2 = cn.prepareStatement("insert into user values(default, ?, ?, ?, ?, ?)");
	

	}

	@Override
	public User authenticateUser(String email, String pwd) throws SQLException {
		// set IN params
		pst1.setString(1, email);
		pst1.setString(2, pwd);
		try (ResultSet rst = pst1.executeQuery()) {
			System.out.println("in user dao : exec query");
			// user_id | full_name | email            | password | phone_no   | created_time
			if (rst.next())
				return new User(rst.getInt(1), rst.getString(2),email, pwd, rst.getString(5), rst.getDate(6));
		}
		return null;
	}

	

	// clean up dao
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		System.out.println("user dao cleaned up!");
	}

	@Override
	public int registerUser(String name, String email, String password, String phone) throws SQLException {
		pst2.setString(1, name);
        pst2.setString(2, email);
        pst2.setString(3, password);
        pst2.setString(4 ,phone);
        pst2.setDate(5, Date.valueOf(LocalDate.now()));
     
        int count = pst2.executeUpdate();
        System.out.println("inside dao bl register " + count );
		return count;
	}

}
