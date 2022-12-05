package dao;

import java.sql.SQLException;
import java.time.LocalDate;

import pojos.User;

public interface UserDao {
	
    User authenticateUser(String email,String pwd) throws SQLException;
	
	int registerUser(String full_name,String email,String password,String phone_no) throws SQLException;

}
