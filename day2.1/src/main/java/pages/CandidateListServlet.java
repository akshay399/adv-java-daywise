package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/candidate_list")
public class CandidateListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doget of candidate servlet");
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			System.out.println("inside init candidate list");
			pw.print("<h5>Welcome Voter !!!</h5>");
			//get user details from cookie
			//1. HttpServletRequest : Cookie[] getCookies()
			Cookie[] cookies=request.getCookies();
			if(cookies != null ) {
				for(Cookie c : cookies)
					if(c.getName().equals("user_details"))
						pw.print("<h4> User details from a Cookie "+c.getValue()+"</h4>");
			} else
				pw.print("<h4> No Cookies , No Session Tracking!!!!!!!!!!!!!!</h4>");
		//	pw.print("Hello "+request.getParameter("email"));
		}
	}

}
