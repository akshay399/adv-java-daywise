package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.candidateDaoImp;
import pojos.*;

@WebServlet("/candidate_list")
public class CandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doget of candidate servlet");
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter()){
			HttpSession session = request.getSession();
			
			User user = (User) session.getAttribute("user_info");
			candidateDaoImp cDao = (candidateDaoImp)session.getAttribute("candidate_dao");
			List<Candidate> candidates = cDao.getAllCandidates();
			pw.write("<form action='logout'>");
			for(Candidate c: candidates) {
				pw.write("<h5><input type='radio' name='candidateId' value ='" + c.getId()  +"'/>"
						+ c.getName() + "</h5>"
						);
			}
			pw.write("<h4><input type = 'submit'  value='Vote'/></h4>");
			pw.write("</form>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
