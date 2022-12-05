package pojos;

import java.time.LocalDate;

public class User {

	private int UserId;
	private String FullName;
	private String Email;
	private String Password;
	private String PhoneNo;
	private LocalDate CreatedTime;
		
	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getPhoneNo() {
		return PhoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}

	public LocalDate getCreatedTime() {
		return CreatedTime;
	}

	public void setCreatedTime(LocalDate createdTime) {
		CreatedTime = createdTime;
	}

	public User(String fullName, String email, String password, String phoneNo) {
		super();
		FullName = fullName;
		Email = email;
		Password = password;
		PhoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "user [UserId=" + UserId + ", FullName=" + FullName + ", Email=" + Email + ", PhoneNo=" + PhoneNo
				+ ", CreatedTime=" + CreatedTime + "]";
	}
	
	
}
