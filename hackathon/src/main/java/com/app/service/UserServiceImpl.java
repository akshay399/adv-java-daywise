package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserDao;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Override
	public User authenticateUser(String email, String password) {
		return userDao.findByEmailAndPassword(email, password).orElseThrow();
	}

}
