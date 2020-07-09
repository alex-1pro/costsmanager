package il.ac.hit.costmanager.model;

public interface IUserDAO {
	public boolean userRegister(String userName, String password) throws UserCostsManagerException;
	public boolean validateUser(String userName, String password) throws  UserCostsManagerException;
	//public boolean changeUserPassword(String userName,String password,String newPassword );
	public User getUser(String userName, String password) throws  UserCostsManagerException;
	public boolean checkUserName(String username)throws  UserCostsManagerException;
}
