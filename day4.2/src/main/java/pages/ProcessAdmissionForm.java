package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.Course;
import pojos.Student;

/**
 * Servlet implementation class ProcessAdmissionForm
 */
@WebServlet("/process_admission")
public class ProcessAdmissionForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			//1. read req params
			String firstName=request.getParameter("fn");
			String lastName=request.getParameter("ln");
			Course course=Course.valueOf(request.getParameter("course").toUpperCase());
			int score=Integer.parseInt(request.getParameter("score"));
			//create student object
			Student student=new Student(firstName, lastName, course, score);
			//since using server pull : req dispatching --min scope reqd = request scope
			request.setAttribute("student_dtls", student);
			pw.print("<h4>from 1st page ......</h4>"); //(contents are sent to the client)this will appear as include will NOT get discarded unlike in case of SP-forward
			pw.flush();
			
			//validation
			if(student.getScore() >= course.getMinScore())
				student.setAdmissionStatus(true);
			//Navigate the clnt to --> results oage in the SAME request
			//1. Get RD object
			RequestDispatcher rd=request.getRequestDispatcher("results");
			System.out.println("rd "+rd.getClass());//impl class server provided
			rd.include(request, response);
			//WC : suspends exec of this method --retains resp buffer  --invokes doPost method of the ResultPage
			System.out.println("control came back.....");
			pw.print("<h5>Contents post include </h5>");
		}
	}

}
