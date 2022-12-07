package com.app.dao;

import pojos.User;

public interface UserDao {
	User validateUser(String email, String password);
}
