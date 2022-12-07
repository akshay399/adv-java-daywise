package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private EntityManager manager;
	@Override
	public List<Employee> fetchEmployees(long deptId) {
		System.out.println("in fetch dao" + deptId);
		String jpql = "select e from Employee e where e.myDept.id =:dId";
		List<Employee> list = manager.createQuery(jpql, Employee.class).setParameter("dId", deptId).getResultList();
		return list;
	}

}
