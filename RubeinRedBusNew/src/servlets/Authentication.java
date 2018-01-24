package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.R_Customer;
import dao.BaseDao;

@WebServlet("/authentication")
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection=null;
	BaseDao dao=null;
	
	public void destroy() {
		super.destroy();
	}

	public void init() throws ServletException {
			dao = new BaseDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Yaha aaya badme");
		String emailId = request.getParameter("email");
		System.out.println(emailId);
		String password = request.getParameter("password");
		System.out.println(emailId+"  "+password);
		boolean flag=false;
		String role=null;
		
		List<R_Customer> list1 = dao.getCustomerAuthenticated(emailId);
		if(list1!=null || !(list1.isEmpty())){
			System.out.println("Authentication Done");
			/*for(R_Customer list2:list1){
				if(list2.getPassword().equals(password)){
					request.setAttribute("USER", list2);
					role=list2.getRole();
					flag=true;
					break;
				}
				flag=false;
			}*/
			
			if(flag==true){
				if(role.equalsIgnoreCase("ADMIN")){
					request.setAttribute("status", "SUCCESSFULADMIN");
				}
				else{
					request.setAttribute("status", "SUCCESSFULCUSTOMER");
				}
			}
			else{
				System.out.println("Unsuccessful");
				//show error page and then login page
				request.setAttribute("status", "UNSUCCESSFUL");
			}
		}
		else{
			request.setAttribute("status", "UNSUCCESSFUL");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
