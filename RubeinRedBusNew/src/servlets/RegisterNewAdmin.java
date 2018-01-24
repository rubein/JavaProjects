package servlets;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojos.R_Customer;
import dao.BaseDao;

@WebServlet("/registerNewAdmin")
public class RegisterNewAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection=null;
	BaseDao dao=null;
	   
	@Override
	public void init() throws ServletException {
		dao = new BaseDao();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Submission = request.getParameter("SUBMISSION");
		R_Customer custDetails = new R_Customer();
	
		String name=request.getParameter("Name");
		custDetails.setName(name);
		custDetails.setAge(Integer.parseInt(request.getParameter("age")));
		custDetails.setMobileNo(Long.parseLong(request.getParameter("mobile")));
		custDetails.setEmail(request.getParameter("email"));
		custDetails.setPassword(request.getParameter("password"));
		custDetails.setRole("Admin");
		
		System.out.println(Submission+" in reg new admin");
		if(Submission.equals("Go")){
			
			dao.add(custDetails);
			request.setAttribute("USER", name);
		}
	}
}
