package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static utils.DBUtils.getConn;

import pojos.User;

public class UserDaoImpl implements UserDao {
	private Connection cn;
	private PreparedStatement pst1;

	// ctor
	public UserDaoImpl() throws SQLException {
		// get cn from db utils
		cn = getConn();
		// pst1
		pst1 = cn.prepareStatement("select * from users where email=? and password=?");
		System.out.println("user dao created!");

	}

	@Override
	public User authenticateUser(String email, String pwd) throws SQLException {
		// set IN params
		pst1.setString(1, email);
		pst1.setString(2, pwd);
		try (ResultSet rst = pst1.executeQuery()) {
			/*
			 * userId, String firstName, String lastName, String email, String password,
			 * Date dob, boolean votingStatus, String role
			 */
			if (rst.next())
				return new User(rst.getInt(1), rst.getString(2), rst.getString(3), email, pwd, rst.getDate(6),
						rst.getBoolean(7), rst.getString(8));
		}
		return null;
	}

	// clean up dao
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		System.out.println("user dao cleaned up!");
	}

}
