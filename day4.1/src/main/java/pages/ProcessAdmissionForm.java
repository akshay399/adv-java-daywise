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
@WebServlet("/process_admission") //lazy loaded, no init and destrpy overloaded
public class ProcessAdmissionForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//since this is always going to call resultsPage.java we are ever going to send anything to client browser hence no use of print writer either??
//---------------------------------------------------------
//		response.setContentType("text/html"); 		       |
//		try(PrintWriter pw=response.getWriter()){          |
//---------------------------------------------------------
			//1. read req params
			String firstName=request.getParameter("fn");
			String lastName=request.getParameter("ln");
			Course course=Course.valueOf(request.getParameter("course").toUpperCase());
			int score=Integer.parseInt(request.getParameter("score"));
			//create student object
			Student student=new Student(firstName, lastName, course, score);
			//since using server pull : req dispatching --min scope reqd = request scope
			request.setAttribute("student_dtls", student);
//			pw.print("<h4>from 1st page ......</h4>");//contents are added to pw's buffer
//			pw.flush();
			
			//validation
			if(student.getScore() >= course.getMinScore())
				student.setAdmissionStatus(true);
			//Navigate the clnt to --> results oage in the SAME request
			//1. Get RD object
			RequestDispatcher rd=request.getRequestDispatcher("results"); //sinxe we want to navigate the user in the same request , we user server pull
			//we can wrap jsp, servlet and also html pages in getRequestDispacther().. i.e both dynamic as well as static resources
			System.out.println("rd "+rd.getClass());//impl class server provided
			rd.forward(request, response);//IllegalStateExc : can not call forward after commititng the resp, if pw.flsh() executed.!
			
			//WC : suspends exec of this method --clrs resp buffer  --invokes doPost method of the ResultPage as we have called this in doPost of processAdmissionForm
			System.out.println("control came back.....");
//		}
	}

}
