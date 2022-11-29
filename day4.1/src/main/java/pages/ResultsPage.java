package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.Student;

/**
 * Servlet implementation class ResultsPage
 */
@WebServlet("/results")
public class ResultsPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in do-get of " + getClass());
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			// greeting
			// get student details from req scoped attribute
			Student details = (Student) request.getAttribute("student_dtls");
			pw.print("<h4> Hello , " + details.getFirstName() + " " + details.getLastName());
			System.out.println("first name : "+request.getParameter("fn"));//not null, bcs same request !
			if (details.isAdmissionStatus())
				pw.print(
						"<h4> Congratulations ! You are admitted in the Course " + details.getChosenCourse() + "</h4>");
			else
				pw.print(
						"<h4> Sorry  ! You can not be  admitted in the Course " + details.getChosenCourse() + "</h4>");
			
		} //pw.close --> committing the resp ---> clnt, then goes to line 49,50 of doPost of resultPage, since this is 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//from line 47 of processAdmissionForm (forward)
		System.out.println("in do-post of " + getClass());
		doGet(request, response);
		//goes back to line 48(after the line where forward was ccalled) of processAdmission
	}

}
