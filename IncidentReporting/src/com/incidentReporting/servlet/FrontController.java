package com.incidentReporting.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.incidentReporting.dao.BaseDao;

/**
 * @author Rubein
 */

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Map<String, Integer> commandMap = null;
	ServletContext context = null;

	public void init() throws ServletException {
		commandMap = new HashMap<String, Integer>();
		commandMap.put("ADDINCIDENT", 1);
		commandMap.put("VIEWALLINCIDENTS", 2);
		commandMap.put("ADDSESSION", 3);
		commandMap.put("VIEWALLSESSIONS", 4);
		commandMap.put("DELETEREQUESTEDINCIDENT", 5);
		commandMap.put("DELETEREQUESTEDSESSION", 6);
	//	commandMap.put("UPDATEREQUESTEDSESSION", 7);
	}

	/**
	 * Identifies the command and redirects all the requests to appropriate
	 * servlets.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doProceed(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer command = getCommand(request.getRequestURI());
		RequestDispatcher dispatcher = null;

		if (command == null) {
			System.err.println("wrong command");
			return;
		}

		switch (command) {
		/**
		 * case 1 adds incident to the database.
		 */
		case 1: {

			HttpSession session = request.getSession();

			dispatcher = request.getRequestDispatcher("/addNewIncident");
			dispatcher.include(request, response);

			session.setAttribute("incidentId", BaseDao.incidentId);

			dispatcher = request.getRequestDispatcher("/jsps/addSession.jsp");
			dispatcher.forward(request, response);

			break;
		}

		/**
		 * case 2 is used to view all incidents.
		 */
		case 2: { 
			dispatcher = request.getRequestDispatcher("/jsps/viewAllIncidents.jsp");
			dispatcher.forward(request, response);
			break;
		}

		/**
		 * case 3 adds session to the database.
		 */
		case 3: { 

			dispatcher = request.getRequestDispatcher("/AddNewSession");
			dispatcher.include(request, response);

			dispatcher = request.getRequestDispatcher("/jsps/viewAllSessions.jsp");
			dispatcher.forward(request, response);

			break;
		}
		
		/**
		 * case 4 views all sessions.
		 */
		case 4: { 
			dispatcher = request.getRequestDispatcher("/jsps/viewAllSessions.jsp");
			dispatcher.forward(request, response);
			break;
		}

		/**
		 * case 5 deletes requested incident from the database.
		 */
		case 5: { 
			dispatcher = request.getRequestDispatcher("/deleteRequestedIncident");
			dispatcher.include(request, response);

			dispatcher = request.getRequestDispatcher("/jsps/viewAllIncidents.jsp");
			dispatcher.forward(request, response);

			break;
		}

		/**
		 * case 6 updates/deletes requested session status.
		 */
		case 6: { // delete session

			if (null == request.getParameter("delete")) {
				dispatcher = request.getRequestDispatcher("/updateRequestedSession");
				dispatcher.include(request, response);
			} else {
				dispatcher = request.getRequestDispatcher("/deleteRequestedSession");
				dispatcher.include(request, response);
			}
			
			dispatcher = request.getRequestDispatcher("/jsps/viewAllSessions.jsp");
			dispatcher.forward(request, response);

			break;
		}

/*		case 7: { // update session status

			dispatcher = request.getRequestDispatcher("/updateRequestedSession");
			dispatcher.include(request, response);

			dispatcher = request.getRequestDispatcher("/jsps/viewAllSessions.jsp");
			dispatcher.forward(request, response);

			break;
		}
*/
		default: {
			System.out.println("Wrong command");
			break;
		}
		}
	}

	public FrontController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProceed(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProceed(request, response);
	}

	private Integer getCommand(String url) {
		int positionSlash = url.lastIndexOf("/");
		int positionDot = url.lastIndexOf(".");
		return commandMap.get(url.substring(positionSlash + 1, positionDot).toUpperCase());
	}

}
