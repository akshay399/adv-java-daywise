package com.app.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.pojos.Student;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/resultServlet")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter()){
			pw.write("res page");
			Student student =(Student) request.getAttribute("student_info");
			String fName= student.getFirstName();
			pw.print("hello " + fName + " welcome!");
			String result = student.isAdmitted() ? "Congratulations you have been selected for " + student.getCourse() + " course." : "Sorry, Please try next time :(";
			pw.print(result);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in do get of resULTsERVLET");
		doGet(request, response);
	}

}





