package beans;

import java.sql.SQLException;
import java.time.LocalDate;

import dao.UserDaoImpl;
import pojos.User;

public class UserBean {
	private String name;
	private String email;
	private String password;
	private String phoneNo;

	private User validatedUserDetails;
	private String message;
	private UserDaoImpl userDao;
	public UserBean() throws SQLException{
		userDao=new UserDaoImpl();
		System.out.println("user bean created!");
	}
	public UserBean(String name, String email, String password, String phoneNo) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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

	//authenticateUser
	public String validateUser() throws SQLException
	{
		System.out.println("in validate user "+email+" "+password);//not null
		validatedUserDetails=userDao.authenticateUser(email, password);
		if(validatedUserDetails == null)
		{
			message="Invalid Login Pls retry!!!!!!!!!!!!!";
			return "login";
			
		}
	  return "register"	;
	}
	
	public int addNewUser() throws SQLException {
		int success;
		System.out.println("in register user "+name+" "+email+" "+password+" "+phoneNo );
		 
		success = userDao.registerUser(name, email, password, phoneNo);
		return success;
	}
	
}
