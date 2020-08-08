package il.ac.hit.costmanager.model;
/**
 * @authors Alexey Belogurov & Jacob Graham
 * 
  Thrown to indicate a problem whith database managemet 
  */
public class UserCostsManagerDAOException extends Exception {
	/**
	 * Constructs an UserCostsManagerDAOException with no
     * detail message.
	 */

	public  UserCostsManagerDAOException() {
		super();
	}
	
	/**
	 * Constructs an UserCostsManagerDAOException with 
     * detail message and cause.
     * @param message the detail message.
     *  
	 */
	public  UserCostsManagerDAOException(String message, Throwable cause) {
	        super(message, cause);
	}
	/**
	 * Constructs an UserCostsManagerDAOException with 
    * detail message .
    * @param message the detail message.
	*/
	public  UserCostsManagerDAOException(String message) {
	        super(message);
	}

}
