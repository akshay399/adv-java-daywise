package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="employees2")
public class Employee extends BaseEntity{
//	| id | first_name | join_date  | last_name | location | my_dept | salary |
	@Column(name="first_name")
	private String firstName;
	@Column(name="join_date")
	private LocalDate joinDate;
	@Column(name="last_name")
	private String lastName;
	
	private String location;
	@Column(name="my_dept")
	private String deptName;
	private double salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee(String firstName, LocalDate joinDate, String lastName, String location, String deptName,
			double salary) {
		super();
		this.firstName = firstName;
		this.joinDate = joinDate;
		this.lastName = lastName;
		this.location = location;
		this.deptName = deptName;
		this.salary = salary;
	}
	
}
