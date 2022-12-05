package pojos;

import java.time.LocalDate;

public class Blog {
	private int blogId;
	private String title;
	private String contents;
	private LocalDate createdTime;
	private String categoryName;
	public Blog(int blogId, String title, String contents, LocalDate createdTime) {
		super();
		this.blogId = blogId;
		this.title = title;
		this.contents = contents;
		this.createdTime = createdTime;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public LocalDate getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(LocalDate createdTime) {
		this.createdTime = createdTime;
	}
	
	public Blog(int blogId, String title, String categoryName) {
		super();
		this.title = title;
		this.categoryName = categoryName;
	}
	
}
