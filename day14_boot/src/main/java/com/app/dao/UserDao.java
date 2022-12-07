package com.app.dao;

import com.app.pojos.User;

public interface UserDao {
//add a method for user validation
	User validateUser(String email,String pass);
}
