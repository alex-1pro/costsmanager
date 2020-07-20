package il.ac.hit.costmanager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import il.ac.hit.costmanager.model.*;

public class ReportsController {

	public boolean reports(HttpServletRequest request, HttpServletResponse response, String data) {
		
		System.out.println("started reports in ReportsController");
		
		User user = (User)request.getSession().getAttribute("user");
		
		Expense[] expenses = null;
		
		try {
	
			if(user == null){
//				response.sendRedirect("http://localhost:8080/CostsManager/controller/login");
//				return true;
				expenses = ExpenseDAOHibernate.getInstance().getUserExpenses(99);
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
	
	
	public boolean filterByMonth(HttpServletRequest request, HttpServletResponse response, String data) {
		
		User user=(User)request.getSession().getAttribute("user");
		
		try {
			
			if(user == null){
//				response.sendRedirect("http://localhost:8080/CostsManager/controller/login");
//				return true;
				
				// TEST USER! ID 99
				String filteredMonth = request.getParameter("filteredMonth");
				Expense[] expenses = ExpenseDAOHibernate.getInstance().getUserExpensesByMonth(99,filteredMonth);
				
				double sum=0.0;
				for (Expense expense : expenses)
					sum += expense.getCost();
				
				request.setAttribute("expenses", expenses);
				request.setAttribute("month", filteredMonth);
				request.setAttribute("sum", sum);
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
		}
		return false;
	}
	

}
