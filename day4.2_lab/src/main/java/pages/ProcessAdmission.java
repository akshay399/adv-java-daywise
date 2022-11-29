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
 * Servlet implementation class ProcessAdmission
 */
//@WebServlet("/process_admission")
public class ProcessAdmission extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter()){
			String firstName=request.getParameter("fn");
			String lastName=request.getParameter("ln");
			Course course=Course.valueOf(request.getParameter("course").toUpperCase());
			int score=Integer.parseInt(request.getParameter("score"));
			//create student object
			Student student=new Student(firstName, lastName, course, score);
			if(score>=course.getMinScore()) {
				student.setAdmissionStatus(true);
			}
			pw.write("<h2>this will be displayed as we are using include method and not forward,"
					+ " in case of include the pw buffer is not cleared when the navigation is being done.</h2>");
			System.out.println(pw);
			pw.flush();
			System.out.println(pw);
			request.setAttribute("student_info", student);
			RequestDispatcher rd = request.getRequestDispatcher("results");
			rd.include(request, response);
			pw.write("<h2>will this be visible? as you have closed the pw in servlet 2 NO. this will be seen on client browser only if the printwriter is not closed in servlet2</h2>");
		}
	}

}
