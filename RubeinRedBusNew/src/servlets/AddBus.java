package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.R_BusDetails;
import dao.BaseDao;

@WebServlet("/addBus")
public class AddBus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BaseDao dao=null;
   
	public AddBus() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init() throws ServletException {
	     System.out.println("in init");
		 dao=new BaseDao();   
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in do post");
		R_BusDetails busDetails = new R_BusDetails();
		busDetails.setBusNo(request.getParameter("bus_number"));
		busDetails.setAcNAc(request.getParameter("typeOfBus"));
		busDetails.setStatus(request.getParameter("Status"));
	//	busDetails.setRoute(request.getParameter("Route"));
		System.out.println(busDetails.toString());
		try{
		//	dao.add(busDetails);
		}catch(Exception e){
			System.out.println(e);
			e.getStackTrace();
		}
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
