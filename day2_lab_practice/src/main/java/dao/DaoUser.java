package dao;

import java.sql.SQLException;

import pojos.User;

public interface DaoUser {
	User authenticater(String email, String pass)  throws SQLException ;
}
