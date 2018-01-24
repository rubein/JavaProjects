package servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojos.R_BusDetails;
import dao.BaseDao;

@WebServlet("/removeBus")
public class RemoveBus extends HttpServlet {

	private static final long serialVersionUID = 1L;

	BaseDao dao=null;
	
    public RemoveBus() {
        super();
    }

	public void init() throws ServletException {
		System.out.println("In init removeBus");
		dao=new BaseDao();
	}

	public List<R_BusDetails> showAllAvailableBus(){   // returns the list of all the avail buses
		List<R_BusDetails> busDetails1=dao.getAllAvailableBus();
		System.out.println("List of all the available busses: ");
		Iterator<R_BusDetails> iter=busDetails1.iterator();
	
		while(iter.hasNext()){
		//for (R_BusDetails busDetails2:busDetails1) {
			//R_BusDetails busDetails2=iter.next();
			if(iter.next().getStatus().equalsIgnoreCase("Available")){
				
			}
			else{
				busDetails1.remove(iter);
			}
		}
		System.out.println(busDetails1);
		return busDetails1;
	}
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in do post remove bus");
	//	R_BusDetails busDetails = new R_BusDetails();
		System.out.println("All buses :");
		System.out.println(showAllAvailableBus());
		request.setAttribute("busNo", showAllAvailableBus());
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}