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
 * Servlet implementation class AddSession
 */
@WebServlet("/AddNewSession")
public class AddSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BaseDao dao = new BaseDao();
		String sessionStatus = request.getParameter("sessionStatus");
	    String sessionName = request.getParameter("sessionName");
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	    LocalDateTime now = LocalDateTime.now();  
	    String timeNow = dtf.format(now);  
	    String malwareScanStatus = request.getParameter("malwareStatus");
	    dao.addSessionToDatabase(Integer.parseInt(request.getSession().getAttribute("incidentId").toString()), sessionName,timeNow, sessionStatus, malwareScanStatus);
	 //   dao.viewAllSessions();
	    System.out.println("control going back to controller.");
	}

}
