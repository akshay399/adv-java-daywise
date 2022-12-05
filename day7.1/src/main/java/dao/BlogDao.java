package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Blog;

public interface BlogDao {
	int addBlog(String title, String content) throws SQLException;
	List<Blog> displayBlogs()  throws SQLException;
}
