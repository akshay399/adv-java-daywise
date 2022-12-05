package beans;

import java.sql.SQLException;
import java.time.LocalDate;

import dao.UserDaoImpl;
import pojos.User;

public class UserBean {
	private int userId;
	private String name;
	private String email;
	private String password;
	private String phone;
	private LocalDate date;
	//validated user details
	
	private User validatedUserDetails;
	private String message;
	//dao
	private UserDaoImpl userDao;
	// def ctor
	public UserBean() throws SQLException{
		//1. create user dao instance
		userDao=new UserDaoImpl();
		System.out.println("user bean created!");
	}
	
	//add B.L method for user authentication + authorization
	public String validateUser() throws SQLException
	{
		System.out.println("in validate user "+email+" "+password);//not null
		//invoke dao's method for auth
		validatedUserDetails=userDao.authenticateUser(email, password);
		if(validatedUserDetails == null)
		{
			//login failure 
			message="Invalid Login Pls retry!!!!!!!!!!!!!";
			return "login";
			
		}
		return "menu_board";
	}
	
	public String addNewUser() throws SQLException{
		int res = userDao.registerUser(name, email, password, phone);
		System.out.println("in add new user, " + res);
		if(res==1) {
			return "login";
		}
		else {
			return "register";
		}
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public User getValidatedUserDetails() {
		return validatedUserDetails;
	}

	public void setValidatedUserDetails(User validatedUserDetails) {
		this.validatedUserDetails = validatedUserDetails;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserDaoImpl getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}
	

}
