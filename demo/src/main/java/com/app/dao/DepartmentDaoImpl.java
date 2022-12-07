package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Department;

@Repository
@Transactional
public class DepartmentDaoImpl implements DepartmentDao {
	@Autowired
	private EntityManager manager;
	@Override
	public List<Department> fetchAllDepartment() {
		String jpql = "select d from Department d";
		List<Department> list = manager.createQuery(jpql, Department.class).getResultList();
		return list;
	}

}
