package pojo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trial_users_table")
public class User {
	// user_id | email                | first_name | image        | last_name | password | reg_amount | reg_date   | user_role
	@Id
	@Column(name="user_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	@Column(name="user_email", length=20)
	private String email;
	private String firstName;
	private byte[] image;
	private String lastName;
	private String password;
	private double regAmount;
	private LocalDate regDate;
	private Role userRole;
	private String confirmPassword;
	public User(String email, String firstName, String lastName, 
			String password,String confirmPassword,Role userRole, double regAmount, LocalDate regDate
			 ) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.regAmount = regAmount;
		this.regDate = regDate;
		this.userRole = userRole;
		this.confirmPassword = confirmPassword;
	}
	
//	String, String, String,
//	String, String, Role, double, LocalDate
	public int getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getFirstName() {
		return firstName;
	}
	public byte[] getImage() {
		return image;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPassword() {
		return password;
	}
	public double getRegAmount() {
		return regAmount;
	}
	public LocalDate getRegDate() {
		return regDate;
	}
	public Role getUserRole() {
		return userRole;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", regAmount=" + regAmount + ", regDate=" + regDate + ", userRole=" + userRole + "]";
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}
	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
	
}
