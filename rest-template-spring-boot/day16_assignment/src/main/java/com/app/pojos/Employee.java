package com.app.pojos;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee extends BaseEntity {
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	private String location;
	private double salary;
	@Column(name="join_date")
	private Date joinDate; 
//	@JoinColumn(name="dept_id", nullable = false)
	@Column(name="my_dept")
	private String myDept;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String firstName, String lastName) {
//		super();
		System.out.println(firstName + " in param const "+  lastName);
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Employee(String firstName, String lastName, String location, double salary, Date joinDate,
			String myDept) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
		this.salary = salary;
		this.joinDate = joinDate;
		this.myDept = myDept;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getMyDept() {
		return myDept;
	}
	public void setMyDept(String myDept) {
		this.myDept = myDept;
	}
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", location=" + location + ", salary="
				+ salary + ", joinDate=" + joinDate + "]";
	}
	

}
//many employee in one dept
//many to one uni directional

//dept 1<---* Emp