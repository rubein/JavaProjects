package com.myrnaMethod.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.myrnaMethod.constants.Constants;
import com.myrnaMethod.dao.BaseDao;

/**
 * Servlet implementation class AddFoodItem
 */
@WebServlet("/addFoodItem.do")
public class AddFoodItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFoodItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BaseDao dao = new BaseDao();
		String foodName = request.getParameter("food");
			float amount = Float.parseFloat(request.getParameter("amount"));
			float unit = Float.parseFloat(request.getParameter("unit"));
			float calories = Float.parseFloat(request.getParameter("calories"));
			float protein = Float.parseFloat(request.getParameter("protein"));
			float fats = Float.parseFloat(request.getParameter("fats"));
			float carbs = Float.parseFloat(request.getParameter("carbs"));
			float fiber = Float.parseFloat(request.getParameter("fiber"));
			
			dao.lastRow = dao.getLastRowNumberForFoodDB(Constants.table2Name);
			dao.addDataToDatabase(foodName,amount,calories,protein,fats,carbs,fiber,"valid","");
			System.out.println("Food "+foodName +" added");
	}
}