package pages;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.candidateDao;
import dao.candidateDaoImp;
import dao.userDaoImp;
import pojos.User;

import static utils.DbUtil.openConnection;;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/authenticate")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private userDaoImp userDaoRef;
	private candidateDaoImp candidateDaoRef;

	public void init() throws ServletException{
		System.out.println("in init of login servlet");
		try {
			openConnection();
			userDaoRef = new userDaoImp();
			candidateDaoRef = new candidateDaoImp();
		}catch (SQLException e) {
			throw new ServletException();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter()){
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			User user = userDaoRef.authenticater(email, password);
			if(user == null) {
				pw.write("<h3>Login Unsuccessfull please <a href='login.html'>Retry</a></h3>");
			}
			else {
				HttpSession session = request.getSession();
				System.out.println("from login servlet, is the login new? " + session.isNew());
				System.out.println("id is(JSESSIOID)" + session.getId());
				session.setAttribute("user_info", user);
				session.setAttribute("user_dao", userDaoRef);
				session.setAttribute("candidate_dao", candidateDaoRef);
				if(user.getRole().equals("admin")) {
					pw.write("<h2>welcome admin</h2>");
				}else {
					if(user.isVotingStatus()) {
						response.sendRedirect("logout");
					}else {
						System.out.println("hellooo in else");
						response.sendRedirect("candidate_list");
					}
				}
			} 	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
