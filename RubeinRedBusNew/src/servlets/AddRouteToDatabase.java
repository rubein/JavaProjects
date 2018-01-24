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
import dao.BaseDao;

@WebServlet("/addRouteToDatabase")
public class AddRouteToDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BaseDao dao=null;
	
	
		
	@Override
	public void init() throws ServletException {
		dao=new BaseDao();
		super.init();
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		HttpSession session1=request.getSession();
		List list3 = (List) session.getAttribute("Listing");
		if(list3==null){
			list3 = new ArrayList();
		}
		System.out.println("addroute doPost");
		String start = (String) request.getParameter("srcc");
		String end=request.getParameter("destt");
		System.out.println("start point selected: "+start);
		System.out.println("end point selected: "+end);
		List list2=dao.getStartStopID(start);
		List list6=dao.getEndID(end);
		session1.setAttribute("EndId", list6);
		System.out.println("list 6"+list6);
		 session.setAttribute("Stop", end);
		 int index1=0;
		 if(list3.size()==0)
		 {
			 
			 	 System.out.println("entered if");
				 System.out.println(list2.get(index1)+" check list 2");
				 list3.add(list2.get(index1));
				
			 
			 session.setAttribute("Listing", list3);
		 }
		 else{
			 
			 list3.add(list2.get(list2.size()-1));
		 }
		 //list3.add(list2.get(list2.size()-1));
		

		for(int index=0; index<list3.size();index++ ) {
		System.out.println(list3.get(index)+" from addlinksDB");
		}	
		 session.setAttribute("Listing", list3);
		 System.out.println(session.getId());
	}

}
