package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="departments")
public class Department extends BaseEntity{
	@Column(name="dept_name")
	private String deptName;
	public Department() {
		// TODO Auto-generated constructor stub
	}
	public Department(String deptName) {
		super();
		this.deptName = deptName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return "Department [deptName=" + deptName + "]";
	}
	
}
