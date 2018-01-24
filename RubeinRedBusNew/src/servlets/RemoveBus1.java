package servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BaseDao;

import pojos.R_BusDetails;

/**
 * Servlet implementation class RemoveBus1
 */
@WebServlet("/removeBus1")
public class RemoveBus1 extends HttpServlet {
	BaseDao dao=null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveBus1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		dao=new BaseDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busToBeRemoved=request.getParameter("busNumber");
		int id=dao.getTableData(busToBeRemoved);
		System.out.println(id);
		R_BusDetails busDetails = new R_BusDetails();
		busDetails=dao.get(R_BusDetails.class, id);
		busDetails.setStatus("Inactive");
		dao.edit(busDetails);
		System.out.println("Bus Removed servlet done");
		System.out.println(busDetails.toString());
	}

}
