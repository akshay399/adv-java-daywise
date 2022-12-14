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
	private PreparedStatement pst1, pst2;
	private PreparedStatement stmtAddNew;

	// ctor
	public UserDaoImpl() throws SQLException {
		// get cn from db utils
		cn = getConn();
		// pst1
		pst1 = cn.prepareStatement("select * from users where email=? and password=?");
		pst2 = cn.prepareStatement("update users set status=true where id=?");
		stmtAddNew = cn.prepareStatement("Insert into users values(default, ?, ?, ?, ?, ?, 0, ?)");

	}
	@Override
	public String addNewUser(String fName, String lName, String email, String password, Date dob,
			String role) throws SQLException {
		stmtAddNew.setString(1, fName);
		stmtAddNew.setString(2, lName);
		stmtAddNew.setString(3, email);
		stmtAddNew.setString(4, email);
		stmtAddNew.setDate(5, dob);
		stmtAddNew.setString(6, role);
		int res = stmtAddNew.executeUpdate();
		if(res == 1) {
			return "user added successfully";
		}
		return "registration unsuccessfull";
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

	@Override
	public String updateVotingStatus(int voterId) throws SQLException {
		// set IN param : voter id
		pst2.setInt(1, voterId);
		// exec update ---> update count : chk it
		int rowCount = pst2.executeUpdate();
		if (rowCount == 1)
			return "You have casted a vote successfully!";
		return "Voting failed!!!!!!!!!!!!!!!!!";

	}

	// clean up dao
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		System.out.println("user dao cleaned up!");
	}

}
