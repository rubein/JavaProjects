package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.R_Stops;
import dao.BaseDao;


@WebServlet("/routeAdmin")
public class RouteAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BaseDao dao=null;
@Override
	public void init() throws ServletException {
		System.out.println("in routeAdmin init()");
		dao=new BaseDao();
		super.init();
	}
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			doPost(req, resp);
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
			ArrayList<R_Stops> list=dao.displayAllStops();
			System.out.println(list);
			request.setAttribute("List", list);
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
//		
//		LinkedHashSet<R_Stops> lhs=dao.displayAllStops();
//		request.setAttribute("LHS", lhs);
//		System.out.println(" in do post "+lhs);
//
//	}
}