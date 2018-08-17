package com.bestGame.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bestGame.constants.Constants;

/**
 * @author Rubein
 */

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Counters for vote.
	public static int game1 = 0;
	public static int game2 = 0;
	public static int game3 = 0;
	public static int game4 = 0;

	Map<String, Integer> commandMap = null;
	ServletContext context = null;

	public void init() throws ServletException {
		commandMap = new HashMap<String, Integer>();
		commandMap.put("VALIDATEUSER", 1);
	}

	private Integer getCommand(String url) {
		int positionSlash = url.lastIndexOf("/");
		int positionDot = url.lastIndexOf(".");
		return commandMap.get(url.substring(positionSlash + 1, positionDot).toUpperCase());
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

	/**
	 * Identifies the command and redirects all the requests to appropriate
	 * servlets.
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

		case 1: {// Verify the vote.
			// GamePojo gameObject = new GamePojo();

			dispatcher = request.getRequestDispatcher("/validate");
			dispatcher.include(request, response);

			String status = (String) request.getAttribute("status");
			System.out.println(status);

			request.setAttribute(Constants.game1, game1);
			request.setAttribute(Constants.game2, game2);
			request.setAttribute(Constants.game3, game3);
			request.setAttribute(Constants.game4, game4);

			dispatcher = request.getRequestDispatcher("/HomePage.jsp");
			dispatcher.forward(request, response);

			break;
		}

		/*
		 * case 2: { // Authenticate user login dispatcher =
		 * request.getRequestDispatcher("/HomePage.jsp");
		 * dispatcher.forward(request, response); break; }
		 * 
		 * case 3: { // Logout HttpSession session = request.getSession(false);
		 * session.invalidate(); dispatcher = request.getRequestDispatcher("");
		 * dispatcher.forward(request, response); break; }
		 */
		default: {
			System.out.println("Wrong command");
			break;
		}
		}
	}

}
