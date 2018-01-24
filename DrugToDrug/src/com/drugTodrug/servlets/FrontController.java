package com.drugTodrug.servlets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.drugTodrug.Mail.MailShooter;
import com.drugTodrug.classes.ExtractExcelInformation;
import com.drugTodrug.classes.FindRelation;
import com.drugTodrug.constants.Constants;
import com.drugTodrug.dao.BaseDao;
import com.drugTodrug.pojo.Output;
import com.google.gson.Gson;

/**
 * Servlet implementation class FrontController
 */
// @WebServlet(urlPatterns = "/controller")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MailShooter mail = new MailShooter();
	public static String status = "false";
	Map<String, Integer> commandMap = null;
	ServletContext context = null;
	public static List<String> list = new ArrayList<String>();

	public void init() throws ServletException {
		commandMap = new HashMap<String, Integer>();
		commandMap.put("ADMIN", 1);
		commandMap.put("HOME", 2);
		commandMap.put("AUTHENTICATION", 3);
		commandMap.put("LOGOUT", 4);
		commandMap.put("UPLOADEXCELFILE", 5);
		commandMap.put("GETRESULT", 6);
		commandMap.put("USEROPTIONS", 7);
		commandMap.put("MAIL", 8);
	}

	/*
	 * 
	 */
	public void doProceed(HttpServletRequest request, HttpServletResponse response)
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
			dispatcher = request.getRequestDispatcher("/AfterAuthentication.jsp");
			dispatcher.forward(request, response);
			break;
		}

		case 2: {
			// System.out.println("New Use command");
			dispatcher = request.getRequestDispatcher("/HomePage.jsp");
			dispatcher.forward(request, response);
			break;
		}

		case 3: {// AUTHENTICATION FOR THE CUSTOMER
			dispatcher = request.getRequestDispatcher("/authentication");
			dispatcher.include(request, response);
			System.out.println("Authentication done");
			String status = (String) request.getAttribute("status");
			System.out.println(status);
			if (status.equals("SUCCESSFULADMIN")) {
				dispatcher = request.getRequestDispatcher("/jsps/AfterAuthentication.jsp");
				dispatcher.forward(request, response);
			} else {
				dispatcher = request.getRequestDispatcher("/jsps/adminLogin.jsp");
				dispatcher.forward(request, response);
			}
			break;
		}

		case 4: { // Logout
			HttpSession session = request.getSession(false);
			session.invalidate();
			dispatcher = request.getRequestDispatcher("/jsps/home.jsp");
			dispatcher.forward(request, response);
			break;
		}

		case 5: { // Upload
			System.out.println("in case 5");
			dispatcher = request.getRequestDispatcher("/uploadExcelFile");
			dispatcher.include(request, response);
			System.out.println("Upload done");
			// add file to database.
			String absolutePath = Constants.filePath + File.separator + UploadExcelFile.filename;
			System.out.println("Creating excel object");
			ExtractExcelInformation excel = new ExtractExcelInformation();
			excel.loadSheetInDatabase(absolutePath);

			if (request.getAttribute("message").equals("success")) {
				dispatcher = request.getRequestDispatcher("/jsps/AfterUploading.jsp");
				dispatcher.forward(request, response);
			} else {
				dispatcher = request.getRequestDispatcher("/jsps/AfterAuthentication.jsp");
				dispatcher.forward(request, response);
			}

			break;
		}

		case 6: {
			System.out.println("in case 6");
			Output.clearList();
			String drug1 = request.getParameter("drug1");
			String drug2 = request.getParameter("drug2");
			System.out.println("EValuate kar raha hu");
			new FindRelation().evaluateRelationBetweenDrugs(drug1, drug2);
			String result = new Gson().toJson(BaseDao.result);
			request.setAttribute("jsonResult", result);
			System.out.println("sending results to web page ......" + Output.getContent());
			dispatcher = request.getRequestDispatcher("/jsps/EvaluationResult.jsp");
			dispatcher.include(request, response);
			break;
		}

		case 7: {
			// response.setContentType("application/json");
			response.setHeader("Content-Type", "text/html");
			try {
				// list.clear();
				System.out.println("in case 7");
				String text = request.getParameter("text");
				System.out.println("Data from ajax call " + text);
				BaseDao dao = new BaseDao();
				list = dao.getAutoCompleteText(text);
				
				System.out.println(" Received response of ajax " + list);
				String searchList = new Gson().toJson(list);
				System.err.println(searchList);
				request.getSession().setAttribute("autoSuggest", list);

				response.getWriter().write(searchList);
			} catch (Exception e) {
				System.err.println(e.getMessage());
				mail.sendMail(e.getMessage(), e);
			}
			break;
		}
		
		case 8: {
			// response.setContentType("application/json");
			response.setHeader("Content-Type", "text/html");
			try {
				// list.clear();
				System.out.println("in case 8");
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				String phone = request.getParameter("phone");
				String msg = request.getParameter("msg");
				String subject = request.getParameter("subject");
				String content = email + "\n" + msg;
				new MailShooter().sendMail(content, null);
				System.out.println("MailSent");
				request.setAttribute("mailSent", "Mail Sent");
				dispatcher = request.getRequestDispatcher("/jsps/contact.jsp");
				dispatcher.include(request, response);
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
				mail.sendMail(e.getMessage(), e);
			}
			break;
		}
		
		

		default: {
			System.out.println("Wrong command");
			break;
		}
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
		doProceed(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProceed(request, response);
	}

	private Integer getCommand(String url) {
		int positionSlash = url.lastIndexOf("/");
		int positionDot = url.lastIndexOf(".");
		return commandMap.get(url.substring(positionSlash + 1, positionDot).toUpperCase());
	}

}
