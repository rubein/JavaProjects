package com.incidentReporting.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.incidentReporting.dao.BaseDao;

/**
 * Servlet implementation class DeleteIncident
 */
@WebServlet("/deleteRequestedIncident")
public class DeleteIncident extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteIncident() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String buttonClicked = request.getParameter("delete");
		buttonClicked = buttonClicked.substring(7, buttonClicked.length());
		
		BaseDao dao = new BaseDao();
		dao.deleteRequestedIncident(buttonClicked);
		
	}

}
