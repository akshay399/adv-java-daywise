package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Student;

/**
 * Servlet implementation class ResultPageServlet
 */
@WebServlet("/results")
public class ResultPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
//			try(PrintWriter pw = response.getWriter()){
			Student s =(Student) request.getAttribute("student_info");
			pw.write("<h2> Welcome " + s.getFirstName() + "</h2>");
			if (s.isAdmissionStatus())
				pw.print(
						"<h4> Congratulations ! You are admitted in the Course " + s.getChosenCourse() + "</h4>");
			else
				pw.print(
						"<h4> Sorry  ! You can not be  admitted in the Course " + s.getChosenCourse() + "</h4>");
			
		
	}
}
