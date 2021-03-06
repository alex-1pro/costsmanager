


package il.ac.hit.costmanager.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import il.ac.hit.costmanager.model.*;
/**
 * 
 *  @author Alexey Belogurov & Jacob Graham
 *  this class connects  and passes data between the jsp pages and the model objects
 */
public class ReportsController {
/**
 * returned all expenses to view
 * @param request
 * @param response
 * @param data
 * @return
 * @throws IOException
 */
	public boolean reports(HttpServletRequest request, HttpServletResponse response, String data) throws IOException {
		
		System.out.println("started reports in ReportsController");
		
		User user = (User)request.getSession().getAttribute("user");
		
		Expense[] expenses = null;
		
		try {
	
			if(user == null){
			response.sendRedirect("http://localhost:8080/CostManager/controller/login");
			return true;
			} else {
				
				expenses = ExpenseDAOHibernate.getInstance().getUserExpenses(user.getId());
			}
			
		} catch (ExpenseCostsManagerDAOExeption e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		}
		
		request.setAttribute("expenses", expenses);
		
		return false;
	}
	/**	
	 Filter the expenses page by month
	 * @param request The request which was sent to the controller
	 * @param response The response which was sent to the controller
	 * @param data Extra data if needed
	 * @return boolean returns if redirect was sent
	 */
	public boolean filterByMonth(HttpServletRequest request, HttpServletResponse response, String data) {
		
		User user=(User)request.getSession().getAttribute("user");
		
		try {
			
			if(user == null){
				response.sendRedirect("http://localhost:8080/CostsManager/controller/login");
				return true;
			}
			else {
				
				String filteredMonth = request.getParameter("filteredMonth");
				Expense[] expenses = ExpenseDAOHibernate.getInstance().getUserExpensesByMonth(user.getId(),filteredMonth);
				
				double sum=0.0;
				for (Expense expense : expenses)
					sum += expense.getCost();
				
				request.setAttribute("expenses", expenses);
				request.setAttribute("month", filteredMonth);
				request.setAttribute("sum", sum);
			}
		} catch (ExpenseCostsManagerDAOExeption e) {
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		return false;
	}
	

}
