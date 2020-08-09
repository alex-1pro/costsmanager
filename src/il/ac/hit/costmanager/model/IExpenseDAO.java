package il.ac.hit.costmanager.model;
/**
 * 
 * @authors Alexey Belogurov & Jacob Graham
 * 
 *  Provides an interface to our DOA that allows to add  expenses to database and get data from it.
 */


public interface IExpenseDAO {
	
	/** Add the expense to database
    * @param expense The expense object to add
    * @return true if add successed else return false 
    * @throws ExpenseCostsManagerDAOExeption in case of error
    */
	public boolean addUserExpense(Expense expense) throws ExpenseCostsManagerDAOExeption;
	
	/**
     * Get array of all the user expenses by user id
     * @param userId user id
     * @return all the expenses of the user
     * @throws ExpenseCostsManagerDAOExeption in case the user has no expenses yet
     */
	public Expense [] getUserExpenses(int userId) throws ExpenseCostsManagerDAOExeption;
	
	/**
     * Get array of all the user expenses by user id and by month
     * @param userId user id
     * @param month expenses month 
     * @return all the expenses  of the required month
     * @throws ExpenseCostsManagerDAOExeption in case the user has no expenses 
     */
	public Expense [] getUserExpensesByMonth(int userId,String month) throws ExpenseCostsManagerDAOExeption;
	
	

}
