package com.app.pojos;

public class Student {
//	Accept student details : first name , last name , entrance test score,course,admission status
	private String firstName;
	private String lastName;
	private double score;
	private Course course;
	private boolean isAdmitted = false;
	public Student(String firstName, String lastName, double score, Course course) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.score = score;
		this.course = course;
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
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public boolean isAdmitted() {
		return isAdmitted;
	}
	public void setAdmitted(boolean isAdmitted) {
		this.isAdmitted = isAdmitted;
	}
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", score=" + score + ", course=" + course
				+ ", isAdmitted=" + isAdmitted + "]";
	}
	
	
	
}
