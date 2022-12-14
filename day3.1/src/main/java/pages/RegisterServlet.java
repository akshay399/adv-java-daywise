package pages;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import static utils.DBUtils.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDaoImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(value="/checkReg", loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;
	public void init() {
		try {
			openConnection();
			userDao = new UserDaoImpl();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter()){
			String fname = request.getParameter("fName");
			String lname = request.getParameter("lName");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String dob = request.getParameter("dob");
			System.out.println("dob " +dob);
			String role = request.getParameter("role");
			
			Date dobSQL = Date.valueOf(dob);
			System.out.println("dob in sql Date: " + dobSQL);
			LocalDate dobLocalDate = dobSQL.toLocalDate();
			System.out.println("dob in local date " + dobLocalDate);
			
			long diffInMonths = Period.between(dobLocalDate, LocalDate.now()).toTotalMonths();
			System.out.println("diff in monts " +diffInMonths);
			long diffInYears = diffInMonths/12;
			System.out.println("diff in years " + diffInYears);
			int years = (int) diffInYears;
			if((role.toLowerCase().equals("voter") && years>21) || (role.toLowerCase().equals("admin") && years>35)) {
				try {
					String msg = userDao.addNewUser(fname, lname, email, password, dobSQL, role);
					response.sendRedirect("login.html");
				}catch(SQLIntegrityConstraintViolationException e) {
					System.out.println("in catch");
					pw.write("<h2>user exists already.</h2>");
					RequestDispatcher rd = request.getRequestDispatcher("register.html");
					rd.include(request, response);
				}
			}else {
				pw.write("<h5>Invalid age for specified roles.</h5>");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
}
