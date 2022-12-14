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
		response.setContentType("text/html"); //included page cannot set the headers(in this case 'content-type', WC will ignore it)
		PrintWriter pw = response.getWriter();  //not inside autclosable try catch open with resources hence the pw wont be closed and it stays open even when the flow is back in processAdmissionform
			// greeting
			// get student details from req scoped attribute
			Student details = (Student) request.getAttribute("student_dtls");
			pw.print("<h4> Hello , " + details.getFirstName() + " " + details.getLastName());
			System.out.println("first name : "+request.getParameter("fn"));//not null !
			if (details.isAdmissionStatus())
				pw.print(
						"<h4> Congratulations ! You are admitted in the Course " + details.getChosenCourse() + "</h4>");
			else
				pw.print(
						"<h4> Sorry  ! You can not be  admitted in the Course " + details.getChosenCourse() + "</h4>");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in do-post of " + getClass());
		doGet(request, response);
	}

}
