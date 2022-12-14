package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.candidateDaoImp;
import dao.userDaoImp;
import pojos.User;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try(PrintWriter pw = response.getWriter()){
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user_info");
			userDaoImp uDao =(userDaoImp) session.getAttribute("user_dao");
			candidateDaoImp cDao = (candidateDaoImp) session.getAttribute("candidate_dao");
			
			if(user.isVotingStatus()) {
				pw.write("<h2>Thanks for vaoting "+user.getFirstName() + " " + user.getLastName()  +"</h2>");
				pw.write("<h3>You are being logged out now</h3>");
			}else {
				int cId = Integer.parseInt(request.getParameter("candidateId"));
			pw.write( "<h5>" +  uDao.changeVotingStatus(user.getUserId()) +"</h5>");
			pw.write( "<h5>" +  cDao.incrVotes(cId) +"</h5>");
			
			}
//			session.invalidate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
