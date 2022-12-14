package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import pojos.User;

import static utils.DBUtils.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value = "/authenticate", loadOnStartup = 1)
//WC will start the life cycle of this servlet --@ app dep time
//Map : key : /authenticate , value : pages.LoginServlet
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;
//Overriding form of the method CAN NOT add any NEW or BROADER CHECKED excs

	public void init() throws ServletException/* ,SQLException */ {
		try {
			System.out.println("in code");
			// open cn
			openConnection();
			// creat dao instance
			userDao = new UserDaoImpl();
			System.out.println("init complete for " + getClass());
		} catch (Exception e) {
			// centralized exc handling in servlets : re throw the exception to the caller
			// --> WC --to inform init has failed --> so that it can abort the servlet's
			// life cycle : ServletException(String mesg, Throwable e)
			throw new ServletException("err in init of " + getClass(), e);
		}

	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			userDao.cleanUp();
			closeConnection();
		} catch (Exception e) {
			// System.out.println("err in destroy of "+getClass()+" err "+e);
			throw new RuntimeException("err in destroy " + getClass(), e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. set cont type
		response.setContentType("text/html");
		// 2. get pw to send text reps to the clnt
		try (PrintWriter pw = response.getWriter()) {
			// 3. read req params
			// API of ServletRequest : String getParamter(String paramName)
			String em = request.getParameter("email");
			String pwd = request.getParameter("pass");
			// 4.invoke dao's method for validation
			User user = userDao.authenticateUser(em, pwd);
			// 5. null chking
			if (user == null) // => invalid login
				pw.print("<h4> Invalid Login , Please <a href='login.html'>Retry</a></h4>");
			else // => valid login --> proceed to role based authorization
			{
				//how to remember the clnt across multiple reqs : cookie based
				//1. Create a Cookie
				//API of Cookie(String name,String value)
				Cookie c1=new Cookie("user_details", user.toString());
				
				//2 . Add cookie to resp header
				response.addCookie(c1);
//				pw.print("<h4> Successful Login <h4>");
//				pw.print("<h5>Your Details "+user+"</h5>");
				pw.print("from login page!!!!!!!!!!!!!!!!!"); //wont be "printed"
	//			pw.flush(); pls un comment to understand illegalstaexc.
				if (user.getRole().equals("admin")) // admin login
					// redirect : API of HttpServletResponse : public void sendRedirect(String
					// location) throws IOExc
					response.sendRedirect("admin");// /admin : url-pattern of the Admin Page
				else // voter login
				{
					if (user.isVotingStatus())// alrdy voted !
						response.sendRedirect("logout"); // logout page : url-pattern
					else // voter : not yet voted
						response.sendRedirect("candidate_list");
				}
				//What will WC do when : resp.sendRedirect(location)
				//WC discard resp buffer(pw's buffer) --> sends temp redirect resp --> clnt
				//Resp pkt : SC 302 | Location : admin + Set-Cookie : user_details: user details  | Body : EMPTY
				//Clnt browser sends NEXT request , URL : http://host:port/day2.1/admin , method : GET +
				//req header : cookie  : user_details: user details
				//WC --> doGet ---> continue....
				//What will happen if u commit the resp n then call sendRedirect?
				//You will see the resp on the clnt side BUT NO redirection 
				//server side : IllegalStateExc : can not call call sendRedirect after committing the resp

			}
		} catch (Exception e) {
			throw new ServletException("err in do-post of " + getClass(), e);
		}
	}

}
