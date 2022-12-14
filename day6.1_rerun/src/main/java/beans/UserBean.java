package beans;

import java.sql.SQLException;

import dao.UserDaoImpl;
import pojos.User;

public class UserBean {
//user conversational state.
	private String email;
	private String password;
	
	//validate userDetails
	private User validatedUserDetails;
	private String message;
	private UserDaoImpl userDao;
	
	public UserBean() throws SQLException{
		userDao = new UserDaoImpl();
		System.out.println("constructor called, useDao instance created!");
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
	
	public String validateUser() throws SQLException{
		validatedUserDetails = userDao.authenticateUser(email, password);
		if(validatedUserDetails == null) {
			message="retyr";
		}
	}
}
