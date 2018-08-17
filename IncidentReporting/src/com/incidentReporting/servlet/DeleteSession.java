package com.incidentReporting.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.incidentReporting.dao.BaseDao;

/**
 * Servlet implementation class DeleteSession
 */
@WebServlet("/deleteRequestedSession")
public class DeleteSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSession() {
        super();
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
		BaseDao dao = new BaseDao();
		System.out.println("deleting session " + request.getParameter("delete"));
		String buttonClicked = request.getParameter("delete");
		buttonClicked = buttonClicked.substring(7, buttonClicked.length());
	//	System.out.println(buttonClicked);
		dao.deleteRequestedSession(Integer.parseInt(buttonClicked));
	}

}
