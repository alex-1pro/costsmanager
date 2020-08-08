package il.ac.hit.costmanager.model;
/**
 * @authors Alexey Belogurov & Jacob Graham
 * 
 * Provides an interface to our DOA that allows to add users to database , checks if user already exits and validate user.
 */

public interface IUserDAO {
	  /**
     * This method adds new user  to database.
     * @param userName adds to user name in database.
     * @param password user password.
     * @return the user object for the http session object if the registration succeeded, if not return null
     * @throws UserCostsManagerDAOException if user exites.
     */
	public User userRegister(String userName, String password) throws UserCostsManagerDAOException;

	/**
     * This method validates username and password.
     * @param userName its user name  validate.
     * @param password user password  validate.
     * @return the user object if username and password correct, else return null
     * @throws UserCostsManagerDAOException if username or password arent correct.
	*/
	public User validateUser(String userName, String password) throws  UserCostsManagerDAOException;
	
	
	/**
	 * This function get username and check if it's exits in database.
	 * @param username its username to check
	 * @return true if username exits else false
	 * @throws UserCostsManagerDAOException in case the user already exists*/
	public boolean checkUserName(String username)throws  UserCostsManagerDAOException;
}
