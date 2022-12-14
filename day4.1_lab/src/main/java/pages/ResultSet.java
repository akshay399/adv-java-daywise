package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Student;

/**
 * Servlet implementation class ResultSet
 */
@WebServlet("/results")
public class ResultSet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter()){
			Student s =(Student) request.getAttribute("student_info");
			pw.write("<h2>Welcome "+ s.getFn() + " " + s.getLn() +"</h2>");
			if(s.getAdmissionStatus()) {
				pw.write("<h2>Congratulations you have been selected for the" + s.getCourse() +  " course!!");
			}else {
				pw.write("<h2>Sorry you are not selected for this course :(</h2>");
			}
		}
	} 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in do get of resULTsERVLET");
		doGet(request, response);
	}

}











