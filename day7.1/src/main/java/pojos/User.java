package pojos;
//id | first_name | last_name | email             | password | dob        | status | role

import java.sql.Date;

public class User {
	private int userId;
	private String name;
	private String email;
	private String password;
	private String phone;
	private Date createdTime;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String name, String email, String password, String phone, Date createdTime) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.createdTime = createdTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + ", phone="
				+ phone + ", createdTime=" + createdTime + "]";
	}
	

	// user_id | full_name | email            | password | phone_no   | created_time
	
	
}
