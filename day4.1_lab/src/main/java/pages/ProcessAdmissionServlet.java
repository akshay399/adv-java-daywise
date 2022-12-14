package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Course;
import pojo.Student;

/**
 * Servlet implementation class ProcessAdmissionServlet
 */
@WebServlet("/process_admission")
public class ProcessAdmissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String fname = request.getParameter("fn");
			String lname = request.getParameter("ln");
			Course course =Course.valueOf(request.getParameter("course").toUpperCase());
			int score = Integer.parseInt(request.getParameter("score"));
			Student student = new Student(fname, lname, course, score);
			request.setAttribute("student_info", student);
			if(student.getScore()>=course.getMinScore()) {
				student.changeAdmittedStatus(true);
			}
			RequestDispatcher rd = request.getRequestDispatcher("results");
			System.out.println("request dispatcher in s1 " + rd);
			rd.forward(request, response);
			
	}	
}




