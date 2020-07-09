package il.ac.hit.costmanager.model;

public interface IUserDAO {
	public User userRegister(String userName, String password) throws UserCostsManagerException;
	public User validateUser(String userName, String password) throws  UserCostsManagerException;
	//public boolean changeUserPassword(String userName,String password,String newPassword );
	
	public boolean checkUserName(String username)throws  UserCostsManagerException;
}
