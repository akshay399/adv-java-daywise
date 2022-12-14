package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojos.User;

import static utils.DbUtils.getConnection;
public class UserDaoImpl implements UserDao {
	private Connection con;
	private PreparedStatement stmtAuthenticateUser;
	public UserDaoImpl() throws SQLException{
		con = getConnection();
		stmtAuthenticateUser = con.prepareStatement("SELECT * FROM USER WHERE EMAIL = ? AND PASSWORD = ?");
	}
	@Override
	public User authenticateUser(String email, String password) throws SQLException {
		stmtAuthenticateUser.setString(1, email);
		stmtAuthenticateUser.setString(2, password);
		try (ResultSet rst = stmtAuthenticateUser.executeQuery()) {
			System.out.println("in user dao : exec query");
			if (rst.next())
				return new User(rst.getInt(1), rst.getString(2), rst.getString(3), email, password, rst.getDate(6),
						rst.getBoolean(7), rst.getString(8));
		}
		return null;
	}

}
