package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDaoImpl;
import pojos.Candidate;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{	
			HttpSession session = request.getSession();
			CandidateDaoImpl cDao = (CandidateDaoImpl) session.getAttribute("candidate_dao");
			System.out.println("hiii");
			List<Candidate> cList = cDao.showTopTwo();
			Map<String, Integer> map = cDao.getVotesAnalysis();
			cDao.showTopTwo().forEach(x->System.out.println(x));	
			pw.print("<h5>Welcome Admin</h5>");
			
			for(Candidate c: cList) {
				pw.write(c.getCandidateId() + " " + c.getName() + " " + c.getPartyName() + " " + c.getVotes());
				pw.write("<br />");
			}
			pw.write("---------------------------------------------------------<br />");
			map.forEach((x,y)->pw.write("<h1>" + x +" " + y +"</h1>" +  "<br>"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
