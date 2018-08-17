package com.incidentReporting.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.incidentReporting.dao.BaseDao;

/**
 * Servlet implementation class UpdateSession
 */
@WebServlet("/updateRequestedSession")
public class UpdateSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sessionId = request.getParameter("update");
		sessionId = sessionId.substring(7, sessionId.length());
		System.out.println(sessionId);
		String sessionStatus = request.getParameter("sessionStatus");
		
		String malwareScanStatus = request.getParameter("malwareScanStatus");
		BaseDao dao = new BaseDao();
		if(sessionStatus == null){
			dao.updateRequestedSessionMalwareStatus(Integer.parseInt(sessionId), malwareScanStatus);
		}
		if(malwareScanStatus == null){
			dao.updateRequestedSessionSessionStatus(Integer.parseInt(sessionId), sessionStatus);
		}
		
		if(sessionStatus != null && malwareScanStatus != null)
			dao.updateRequestedIncident(Integer.parseInt(sessionId), sessionStatus,malwareScanStatus);

		
	}

}
