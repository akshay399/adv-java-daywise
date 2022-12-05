package dao;

import java.sql.SQLException;

import pojos.User;

public interface UserDao {
//add a method to validate user
	User authenticateUser(String email,String pwd) throws SQLException;
	int registerUser(String name, String email, String password, String phone)  throws SQLException;
}
