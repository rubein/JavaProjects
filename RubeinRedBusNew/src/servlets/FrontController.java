package servlets;

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

//@WebServlet("*.do")
public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Map<String, Integer> commandMap = null;
	ServletContext context = null;

	public void init() throws ServletException {
		commandMap = new HashMap<String, Integer>();
		commandMap.put("ADMIN", 1);
		commandMap.put("HOME", 2);
		commandMap.put("AUTHENTICATION", 3);
		commandMap.put("OUTPUT", 4);
		commandMap.put("NEWUSER", 5);
		commandMap.put("REGISTERNEWCUSTOMER", 6);
		commandMap.put("ADDSTOP", 7);
		commandMap.put("ADDBUS", 8);
		commandMap.put("REMOVEBUS", 9);
		commandMap.put("REMOVEBUS1", 10);
		commandMap.put("ROUTELIST", 11);
		commandMap.put("ADDROUTETODATABASE", 12);
		commandMap.put("SEARCHBUS", 13);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProceed(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProceed(req, resp);
	}

	private void doProceed(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer command = getCommand(request.getRequestURI());
		System.out.println(command);
		RequestDispatcher dispatcher = null;

		if (command == null) {
			System.out.println("wrong command");
			return;
		}

		switch (command) {
		case 1: {// login command from admin
			System.out.println("in case 1");
			dispatcher = request.getRequestDispatcher("/jsps/AfterAuthentication.jsp");
			dispatcher.forward(request, response);
			break;
		}

		case 2: {
			// System.out.println("New Use command");
			dispatcher = request.getRequestDispatcher("/jsps/HomePage.jsp");
			dispatcher.forward(request, response);
			break;
		}

		case 3: {// AUTHENTICATION FOR THE CUSTOMER
		//	dispatcher = request.getRequestDispatcher("/authentication");
		//	dispatcher.include(request, response);
			System.out.println("Authentication done");
		//	String status = (String) request.getAttribute("status");
			String status = "SUCCESSFULADMIN";
			System.out.println(status);
			if (status.equals("SUCCESSFULCUSTOMER")) {
				dispatcher = request.getRequestDispatcher("/jsps/SearchBus.jsp");
				dispatcher.forward(request, response);
			} else if (status.equals("SUCCESSFULADMIN")) {
				dispatcher = request.getRequestDispatcher("/jsps/AfterAuthentication.jsp");
				dispatcher.forward(request, response);
			} else {
				dispatcher = request.getRequestDispatcher("/jsps/HomePage.jsp");
				dispatcher.forward(request, response);
			}
			break;
		}

		case 4: { // Logout
			HttpSession session = request.getSession(false);
			session.invalidate();
			dispatcher = request.getRequestDispatcher("/javascript/HomePage.jsp");
			dispatcher.forward(request, response);
			break;
		}

		case 5: { // new user
			dispatcher = request.getRequestDispatcher("/javascript/NewUser.jsp");
			dispatcher.forward(request, response);
			break;
		}

		case 6: {// register new user
			String submission = request.getParameter("SUBMISSION");
			if (submission.equals("Go")) {
				dispatcher = request.getRequestDispatcher("/registerNewCustomer");
				dispatcher.include(request, response);
				System.out.println("Completed insertion");
				dispatcher = request.getRequestDispatcher("/jsps/LoginPage.jsp");
				dispatcher.forward(request, response);
			} else {// edit
				dispatcher = request.getRequestDispatcher("/jsps/RegisterPage.jsp");
				dispatcher.forward(request, response);
			}
			break;
		}

		case 7: {// add bus stop
			String submission = request.getParameter("add_stop");
			System.out.println(submission);
			if (submission.equals("SubmitStop")) {
				System.out.println("In submit stop");
				dispatcher = request.getRequestDispatcher("/addStop");
				dispatcher.include(request, response);
				dispatcher = request.getRequestDispatcher("/jsps/AfterAuthentication.jsp");
				dispatcher.forward(request, response);
			}
			break;
		}

		case 8: {// add Bus. here we assign bus to a particular route
			String submission = request.getParameter("add_Bus");
			System.out.println(submission);
			if (submission.equals("SubmitBus")) {
				System.out.println("In submit Bus FC");
				dispatcher = request.getRequestDispatcher("/addBus");
				dispatcher.include(request, response);
				dispatcher = request.getRequestDispatcher("/jsps/AfterAuthentication.jsp");
				dispatcher.forward(request, response);
			}
			break;
		}

		case 9: { // remove bus details from the database
			System.out.println("In case 9");
			/*
			 * String submission=request.getParameter("remove_bus");
			 * System.out.println(submission);
			 * 
			 */ /* if(submission.equals("RemoveBus")){ */
			System.out.println("In remove Bus FC");
			dispatcher = request.getRequestDispatcher("/removeBus");
			dispatcher.include(request, response);
			dispatcher = request.getRequestDispatcher("/jsps/bus/removeBus/removeBusDetails.jsp");
			dispatcher.forward(request, response);
			// }
			break;
		}

		case 10: {
			// System.out.println("In remove Bus FC");
			dispatcher = request.getRequestDispatcher("/removeBus1");
			dispatcher.include(request, response);
			dispatcher = request.getRequestDispatcher("/jsps/AfterAuthentication.jsp");
			dispatcher.forward(request, response);
			break;
		}

		case 11: { // add route in the database addRouteToDatabase
			HttpSession session = request.getSession();
			session.removeAttribute("Stop");
			session.invalidate();
			System.out.println("In addRoute FC");
			System.out.println("/routeadmin");
			dispatcher = request.getRequestDispatcher("/routeAdmin");
			dispatcher.include(request, response);
			dispatcher = request.getRequestDispatcher("/jsps/bus/addRoute/addRouteDetails.jsp");
			dispatcher.include(request, response);
			break;
		}

		case 12: {
			String submission1 = request.getParameter("submits");

			HttpSession session2 = request.getSession();
			// System.out.println(session2.getId()+"case 2");
			System.out.println(submission1);
			if (submission1.equals("submit")) {
				dispatcher = request.getRequestDispatcher("/routeAdmin");
				dispatcher.include(request, response);
				dispatcher = request.getRequestDispatcher("/addRouteToDatabase");
				dispatcher.include(request, response);
				dispatcher = request.getRequestDispatcher("/jsps/bus/addRoute/addRouteDetails.jsp");
				dispatcher.include(request, response);
			} else if (submission1.equals("confirm")) {
				if (!request.getParameter("destt").equals("")) {
					dispatcher = request.getRequestDispatcher("/addRouteToDatabase");
					dispatcher.include(request, response);
				}
				dispatcher = request.getRequestDispatcher("/persistRoute");
				dispatcher.include(request, response);
				dispatcher = request.getRequestDispatcher("/jsps/AfterAuthentication.jsp");
				dispatcher.forward(request, response);
			}
			break;
		}

		case 13: {
			System.out.println("we are in case 13 search bus ");
			break;
		}

		default: {
			System.out.println("Wrong command");
			break;
		}
		}
	}

	private Integer getCommand(String url) {
		int positionSlash = url.lastIndexOf("/");
		int positionDot = url.lastIndexOf(".");
		return commandMap.get(url.substring(positionSlash + 1, positionDot).toUpperCase());
	}

}
