package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pojos.User;

public interface userDao {
	User authenticater(String email, String password) throws SQLException;
	String changeVotingStatus(int id) throws SQLException;
}
