package pojo;

public class Student {
	private String fn;
	private String ln;
	private Course course;
	private int score;
	private boolean isAdmitted;
	public void changeAdmittedStatus(boolean b) {
		isAdmitted = b;
	}
	public boolean getAdmissionStatus() {
		return isAdmitted;
	}
	public Student(String fn, String ln, Course course, int score) {
		this.fn = fn;
		this.ln = ln;
		this.course = course;
		this.score = score;
	}
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [fn=" + fn + ", ln=" + ln + ", course=" + course + ", score=" + score + "]";
	}
	
	
}
