package com.app.service;

import pojos.User;

public interface UserService {
	User authenticateUser(String em, String pass);
}
