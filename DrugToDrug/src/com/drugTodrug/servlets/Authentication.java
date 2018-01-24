package com.drugTodrug.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drugTodrug.dao.BaseDao;

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
		String emailId = request.getParameter("email");
		System.out.println(emailId);
		String password = request.getParameter("password");
		System.out.println(emailId+"  "+password);
		boolean flag=false;
		String role=null;

		//Checks for password of admin
		if(dao.getCustomerAuthenticated(emailId).equals(password)){
			System.out.println("Authentication Done");
			request.setAttribute("status", "SUCCESSFULADMIN");
		}else{
			System.out.println("Unsuccessful");
			//show error page and then login page
			request.setAttribute("status", "UNSUCCESSFUL");
		}	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
