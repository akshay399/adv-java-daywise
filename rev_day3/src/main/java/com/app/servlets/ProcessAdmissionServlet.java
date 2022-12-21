package com.app.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.pojos.Course;
import com.app.pojos.Student;

/**
 * Servlet implementation class ProcessAdmissionServlet
 */
@WebServlet("/processAdmission")
public class ProcessAdmissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessAdmissionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
			String fName = request.getParameter("first_name");
			String lName = request.getParameter("last_name");
			double marks = Double.parseDouble(request.getParameter("score"));
			Course course  =Course.valueOf(request.getParameter("course"));
			Student s = new Student(fName, lName,marks,course);
			if(s.getScore()>=course.getMinScore()) {
				s.setAdmitted(true);
			}
			request.setAttribute("student_info", s);
			RequestDispatcher rd = request.getRequestDispatcher("/resultServlet");
			rd.forward(request, response);
		
	}

}
