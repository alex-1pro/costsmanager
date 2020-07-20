package il.ac.hit.costmanager.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import il.ac.hit.costmanager.model.*;

public class ExpensesController extends AbstractController{

	public boolean expenses(HttpServletRequest request, HttpServletResponse response, String data) {

		System.out.println("Expenses opend");
		
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
	
	
	
	public boolean addExpense(HttpServletRequest request, HttpServletResponse response, String data) {
		
		User user = (User)request.getSession().getAttribute("user");
		
		// Only for test:
		if (user == null){
			//user = new User(99,"Jacob_TEST","123456");
		}
		// ------------
		
		String type = request.getParameter("expenseType");
		String month = request.getParameter("expenseMonth");
		String description = request.getParameter("expenseDescription");
		double cost = Double.parseDouble(request.getParameter("expenseCost"));
		
		Expense expense = new Expense(user.getId(), cost, type, month, description);
		
		try {
			
			if(user == null) {
				
				response.sendRedirect("http://localhost:8080/CostManager/controller/login");
				return true;
				
			} else {
				
				IExapenseDAO iExpenseDAOHibernate = ExpenseDAOHibernate.getInstance();
				iExpenseDAOHibernate.addUserExpense(expense);
				request.setAttribute("addedSuccessfully",true);
				
				response.sendRedirect("http://localhost:8080/CostManager/controller/expenses");
			}
				
		} catch (ExpenseCostsManagerDAOExeption e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
}
