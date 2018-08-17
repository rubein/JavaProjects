package com.myrnaMethod.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myrnaMethod.dao.BaseDao;

/**
 * Servlet implementation class AddNewMember
 */
@WebServlet("/AddNewUser")
public class AddNewMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BaseDao dao = new BaseDao();
    
    public AddNewMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
	//	System.out.println(firstName);
		String lastName = request.getParameter("lastName");
	//	System.out.println(lastName);
		String email = request.getParameter("email");
	//	System.out.println(email);
		String password = request.getParameter("psw");
	//	System.out.println(password);
		String startDate = request.getParameter("startDate");
	//	System.out.println(firstName);
		int validFor = Integer.parseInt(request.getParameter("validFor"));
	//	String role = null;

		dao.addNewMemberToDatabase(firstName,lastName,email,password,startDate,validFor);		
		System.out.println(firstName + " added to the database. " );
		
		request.setAttribute("memberAdded", "Yes");
	}

}
