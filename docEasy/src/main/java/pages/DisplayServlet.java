package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/display")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {
		System.out.println("Init called in display");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		String cName = request.getParameter("name");
		try(PrintWriter pw = response.getWriter()){
			pw.write("<h3>Hello and welcome. This is the class that you entered. "+ cName +"</h3>");
		}
	}
	
	public void destroy() {
		System.out.println("Destroy called in display");
	}

}