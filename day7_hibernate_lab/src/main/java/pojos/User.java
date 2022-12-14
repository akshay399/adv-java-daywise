package pojos;

import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.*; //will be importing all annotations from this package
@Entity //COMPULSORY ANNOTATION Specifies THE HIBERNATE that the class is an entity. This annotation is applied to theentity class. hibernate needs instructions indicating to work hre, we can do this using xml and annotation.//mandatory class level annotation meant for hibernate, to tell following is the entity to be managed by hib framework.
@Table(name="users_table") //optional annotation, meant to supply table name ELSE THE POGO name is same as table name (DO NOT USE - IN TABLE NAME)
public class User {
	@Id //mandatory field / getter level annotation which will add PRIMARY KEY contraint to userId in table which will be created
	@GeneratedValue(strategy = GenerationType.IDENTITY) //OPTIONAL ANNO, adds constraint of auto increment id generation
	
	@Column(name="user_id") //optional annotation, to change the name of column from userId to user_id.
	private Integer userId;
	
	@Column(name="first_name", length = 20) //optional anno, used to change the size of default 255 to mentioned length.
	private String firstName;
	
	@Column(name="last_name", length = 20)
	private String lastName;
	
	@Column(length = 25, unique = true) //optional ann, makes email as unique by adding unique constraint
	private String email;
	
	@Column(length = 20,  nullable = false) //optional ann, not null contraint on password added.
	private String password;
	
	@Transient //no coumn generation. It skips from persistence(i.e sending info to db) similar to serializable transient.
	private String confirmPassword;
	
	@Enumerated(EnumType.STRING) // column type will be var char (enum const name) default will be constant int values
	@Column(name="user_role", length = 30)
	private Role role;
	
	@Column(name="reg_amount", nullable=false)
	private Double regAmount;
	
	@Column(name="reg_date", nullable = false)
	private LocalDate regDate;
	
	@Lob //default for mysql is tinyblob, use this ann to convert to long blob(can store date in MB)
	private byte[] image;
	
	
	
//for hibernate supply default constructor for managing persistence
//	public User() {
//		
//	}
	
	public User(String firstName, String lastName, String email, String password, String confirmPassword, Role role,
		Double regAmount, LocalDate regDate) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.password = password;
	this.confirmPassword = confirmPassword;
	this.role = role;
	this.regAmount = regAmount;
	this.regDate = regDate;
}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(Double regAmount) {
		this.regAmount = regAmount;
	}
	public LocalDate getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", role=" + role + ", regAmount=" + regAmount + ", date=" + regDate + "]";
	}
	
}

