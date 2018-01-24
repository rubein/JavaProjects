package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BaseDao;

import pojos.R_Stops;

@WebServlet("/addStop")
public class AddStop extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	BaseDao dao=null;   
    
	public AddStop() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init() throws ServletException {
		dao=new BaseDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		R_Stops stop = new R_Stops();
		stop.setName(request.getParameter("stop_name"));
		try{
			dao.add(stop);
		}catch(Exception e){
			System.out.println(e);
			e.getStackTrace();
		}
		
	}

}
