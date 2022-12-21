package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User extends BaseEntity{
	@Column(name = "full_name")
	private String fullName;
	private String email;
	private String password;
	@Column(name = "phone_no")
	private String phoneNo;
	@Column(name = "created_time")
	private LocalDate createdTime;
	public User() {
		System.out.println("in def ctr");
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public LocalDate getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(LocalDate createdTime) {
		this.createdTime = createdTime;
	}
	public User(String fullName, String email, String password, String phoneNo, LocalDate createdTime) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
		this.createdTime = createdTime;
	}
	
	
}
