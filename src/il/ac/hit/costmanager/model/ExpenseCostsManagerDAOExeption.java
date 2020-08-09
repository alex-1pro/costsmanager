package il.ac.hit.costmanager.model;
/**@author Alexey Belogurov & Jacob Graham
 * 
 * Thrown to indicate a problem whith database Expense managemet 
*/
public class ExpenseCostsManagerDAOExeption extends Exception {
	
	/**
	 * Constructs an ExpenseCostsManagerDAOExeption with no
     * detail message.
	 */
	public  ExpenseCostsManagerDAOExeption() {
		super();
	}
	
	/**
	 * Constructs an ExpenseCostsManagerDAOExeption with 
     * detail message and cause.
     * @param message the detail message.
     * @param cause
	 */
	public  ExpenseCostsManagerDAOExeption(String message, Throwable cause) {
	        super(message, cause);
	}
	/**
	 * Constructs an ExpenseCostsManagerDAOExeption with 
     * detail message and cause.
     * @param message the detail message.
	 */
	
	public  ExpenseCostsManagerDAOExeption(String message) {
	        super(message);
	}

}
