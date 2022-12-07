package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserDao;

import pojos.User;

@Service //Madatory class level annotations to tell spring container, following is a spring bean containing business logic
@Transactional //Mandatory class annotation to tell SC to auto supply transaction management
public class UserServiceImpl implements UserService{
	//depencency: DAO layer i/f
	@Autowired
	private UserDao userDao;
	@Override
	public User authenticateUser(String em, String pass) {
		//currently no business logic
		return userDao.validateUser(em, pass);
	}
}
