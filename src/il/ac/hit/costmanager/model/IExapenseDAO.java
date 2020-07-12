package il.ac.hit.costmanager.model;

public interface IExapenseDAO {
	
	public boolean addUserExense(Expense expense) throws ExpenseCostsManagerDAOExeption;
	
	public Expense [] getUserExpenses(int userId) throws ExpenseCostsManagerDAOExeption;
	
	public Expense [] getUserExpensesByMonth(int userId,String month) throws ExpenseCostsManagerDAOExeption;
	
	//public double getTotalCost(int userId) throws ExpenseCostsManagerDAOExeption;

}
