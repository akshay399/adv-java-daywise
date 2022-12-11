package com.app.pojos;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends BaseEnity {
//	user_id | full_name       | email            | password | phone_no   | created_time
	@Column(name="full_name")
	private String fullName;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="phone_no")
	private String phone;
	@Column(name="created_time")
	private Date createdTime;

	public User() {
	}

	public User(Long id, String fullName, String email, String password, String phone, Date createdTime) {
		super(id);
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.createdTime = createdTime;
	}

	@Override
	public String toString() {
		return "User [fullName=" + fullName + ", email=" + email + ", password=" + password + ", phone=" + phone
				+ ", createdTime=" + createdTime + "]";
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

}
