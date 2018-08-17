package com.bestGame.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bestGame.constants.Constants;
import com.bestGame.dao.BaseDao;
import com.bestGame.service.Service;

@WebServlet("/validate")
public class Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BaseDao dao=null;
	Service service = null;
	
	/**
	 * Static block to create tables database and tables if not exist
	 */
	static {
		BaseDao dao = new BaseDao();
		dao.createVoterDatabase(Constants.databaseName);
		dao.createVoterTable(Constants.table1Name);
		dao.createVoterTable(Constants.table2Name);
	}
	
	/**
	 * Initialize dao object to use.
	 */
	public void init() throws ServletException {
			dao = new BaseDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hostId = request.getRemoteHost();
		String hostIp = request.getRemoteAddr();
		String emailId = request.getParameter("emailId");
	    String votedFor = request.getParameter("bestGame");
		
		//Checks if the user has voted in the last 24 hrs or user host is used to send message.
		if(!isPresent(emailId) || !isPresent(hostId, hostIp)){
			System.out.println("Already voted");
			request.setAttribute("status", "invalid");
		}else{
			System.out.println("Successfully voted");
			request.setAttribute("status", "valid");
			
			//increment the vote counter.
			service = new Service();
			service.incrementCounter(votedFor);
		}	
	}
	
	/**
	 * Checks entry for host system in the database.
	 * Overloaded method that catches the SQL exception. 
	 * @param hostId host name of the requester.
	 * @param hostIp requesters ip address.
	 * @return
	 */
	private boolean isPresent(String hostId, String hostIp) {
		boolean presentAndValid = false;
		try {
			presentAndValid = dao.checkDatabaseForSameHost(hostId , hostIp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return presentAndValid;
	}

	private boolean isPresent(String email){
		boolean present = false;
		present = dao.getVoterValidated(email);
		return present;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void destroy() {
		super.destroy();
	}

}
