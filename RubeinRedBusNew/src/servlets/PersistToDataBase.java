package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pojos.R_Route;
import dao.BaseDao;


@WebServlet("/persistRoute")
public class PersistToDataBase extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List list5;
	List list7;

    @Override
	public void init() throws ServletException {
    	
    	list5=new ArrayList();
    	System.out.println("in init ka persistRoute");
    	super.init();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		HttpSession session1=request.getSession(true);
		System.out.println(session.getId());
		list5 = (List) session.getAttribute("Listing");
		System.out.println("String csv : "+list5);
		list7 =(List) session1.getAttribute("EndId");
		System.out.println("persist "+list7);
		 System.out.println(list5);
		 list5.add(list7.get(0));
		String csv="";
		for(int index=0;index<list5.size()-1;index++) {
			int i=(Integer) list5.get(index);
		csv+=i+",";
		}
		csv+=list5.get(list5.size()-1);
		System.out.println("csv "+csv);
		BaseDao dao=new BaseDao();
		R_Route route=new R_Route();
		route.setStops(csv);
		dao.add(route);
		System.out.println("route added to route dB!!!");
	}

}
