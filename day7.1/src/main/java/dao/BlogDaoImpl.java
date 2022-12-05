package dao;

import static utils.DBUtils.getConn;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import pojos.Blog;

public class BlogDaoImpl implements BlogDao {
	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
	public BlogDaoImpl() throws SQLException {
		// get cn from db utils
		cn = getConn();
		pst1 = cn.prepareStatement("insert into blogs values(default,?,?,?)");
		pst2=cn.prepareStatement("SELECT blogs.blog_id, blogs.title, categories.title FROM blogs RIGHT JOIN categories ON blogs.category_id = categories.category_id");
		System.out.println("Blog dao created!");
	}
	@Override
	public int addBlog(String title, String contents) throws SQLException {
         
		pst1.setString(1, title);
		pst1.setString(2, contents);
		pst1.setDate(3, Date.valueOf(LocalDate.now()));
		int count = pst1.executeUpdate();
		return count;
	}
	@Override
	public List<Blog> displayBlogs() throws SQLException {
	
     List<Blog> blogs = new ArrayList<>();
		
		try (ResultSet rst = pst2.executeQuery()) {
			while (rst.next())
				blogs.add(new Blog( rst.getInt(1),rst.getString(2),rst.getString(3) ));
		}
		System.out.println("blogsss"  + blogs);
		return blogs;
		
	}
}
