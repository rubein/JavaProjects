package com.incidentReporting.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.incidentReporting.dao.BaseDao;

/**
 * 
 * @author Rubein
 *
 */

@WebServlet("/addNewIncident")
public class NewIncident extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BaseDao dao=null;
	
	/**
	 * Initialize dao object to use.
	 */
	public void init() throws ServletException {
			dao = new BaseDao();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailId = request.getParameter("email");
	    String incidentName = request.getParameter("incidentName");
	    String incidentDesc = request.getParameter("incidentDesc");
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	    LocalDateTime now = LocalDateTime.now();  
	    String timeNow = dtf.format(now);  
	    dao.addIncidentToDatabase(incidentName,incidentDesc,timeNow,emailId);
	//  dao.viewAllIncidents();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void destroy() {
		super.destroy();
	}

}
