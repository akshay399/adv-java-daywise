package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojos.User;

@Repository // Mandatory class level annotation to tell spring container that following is a
			// spring bean working as DAO layer.
//singleton and eager.

public class UserDaoImpl implements UserDao {
	// dependeny: sessionFactory
	// to tell container to automatically inject the above mentioned dependdeny
	@Autowired // autowire = byType
	private SessionFactory sf; // no hibernate utils and no context listener

	public User validateUser(String email, String password) {
		String jpql = "select u from User u where u.email=:em and password=:pass"; //no changes in jpql and pojo
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", email).setParameter("pass", password).getSingleResult();
	}

}
