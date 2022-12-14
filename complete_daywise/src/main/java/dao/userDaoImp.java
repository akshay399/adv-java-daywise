package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojos.User;
import static utils.DbUtil.getConnection;

public class userDaoImp implements userDao {

	private Connection con;
	private PreparedStatement pst1;
	private PreparedStatement stmtChangeStatus;
	
	public userDaoImp() throws SQLException {
		con = getConnection();
		pst1 = con.prepareStatement("SELECT * FROM USERS WHERE EMAIL = ? AND PASSWORD = ?");
		stmtChangeStatus = con.prepareStatement("Update users set status = true where id=?");
	}
	public String changeVotingStatus(int id) throws SQLException {
		stmtChangeStatus.setInt(1, id);
		int res = stmtChangeStatus.executeUpdate();
		if(res==1) {
			return "You have voted successfully";
		}else {
			return "Voting unsuccessfull :(";
		}
	}
	public User authenticater(String email, String password) throws SQLException{
		pst1.setString(1, email);
		pst1.setString(2, password);
		
		try(ResultSet rs = pst1.executeQuery()){
			if(rs.next()) {
//				 id | first_name | last_name | email             | password | dob        | status | role
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getBoolean(7), rs.getString(8));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
