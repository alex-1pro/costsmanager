package il.ac.hit.costmanager.model;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
/**
 * @author Alexey Belogurov & Jacob Graham
 * 
 * This class implements IUserDAO and communicate with a database
 * 
 * */
public class UserDAOHibernate implements IUserDAO{
	
	 private static IUserDAO instance;
	 private SessionFactory factory;
    
	 private UserDAOHibernate() throws UserCostsManagerDAOException {
	        factory = new AnnotationConfiguration().configure().buildSessionFactory();
	 }
	/**
	 * @return the instance of this object, if no instance exists, create a new one.
	 * */
	 public static IUserDAO getInstance() throws UserCostsManagerDAOException {
	        if (instance == null) {
	            return instance = new UserDAOHibernate();
	        }

	        return instance;
	 }
	 
	 /**
	     * This method insert new user  to database.
	     * @param userName adds to user name in database.
	     * @param password user password.
	     * @return the user object for the http session object if the registration succeeded, if not return null
	     * @throws UserCostsManagerDAOException if user exites.
	     */
	@Override
	public User userRegister(String userName, String password) throws UserCostsManagerDAOException {
		 Session session = null;
	        User user = null;
	        try {
	            session = factory.openSession();
	            session.beginTransaction();
	            if(!checkUserName(userName))
	                throw new UserCostsManagerDAOException("An attempt to register userName: '" + userName +"' was done, user already exists.");
	            User userTemp = new User(userName, password);
	            session.save(userTemp);
	            session.getTransaction().commit();
	            Query query = session.createQuery("from User U where U.userName= :username")
	                    .setString("username",userName);
	            List<?> users = query.list();
	            Iterator<?> i = users.iterator();
	            user = (User)users.get(0);
	        }
	        catch (HibernateException e)
	        {
	            Transaction tx = Objects.requireNonNull(session).getTransaction();
	            if (tx.isActive())
	                tx.rollback();
	            e.printStackTrace();
	        }
	        finally
	        {
	            if(session!=null)
	                session.close();
	        }
	        return user;
		
	}
	
	
	
	/**
    * This method validates username and password.
    * @param userName its user name  validate.
    * @param password user password  validate.
    * @return the user object if username and password correct, else return null
    * @throws UserCostsManagerDAOException if username or password arent correct.
	*/
	@Override
	public User validateUser(String userName, String password) throws UserCostsManagerDAOException {
		Session session = null;
        User user = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            //Checks if the user exists or details are valid
            Query query=session.createQuery("FROM User U WHERE U.userName = :username and U.password= :password")
                    .setString("username",userName)
                    .setString("password",password);
            List<?> users = query.list();
            // If the information sent doesn't fit a row in the DB
            if (users.size() == 0)
                throw new UserCostsManagerDAOException("Username '" + userName +"' is not exist or wrong password");
            else
                user = (User)users.get(0);
        }
        catch (HibernateException e)
        {
            Transaction tx = Objects.requireNonNull(session).getTransaction();
            if (tx.isActive()) 
            	tx.rollback();
        }
        finally
        {
            if(session!=null) session.close();
        }
        return user;
	}
	
	/**
	 * This function get username and check if it's exits in database.
	 * @param username its username to check
	 * @return true if username exits else false
	 * @throws UserCostsManagerDAOException in case the user already exists*/
	
	@Override
	public boolean checkUserName(String userName) throws UserCostsManagerDAOException {
		 Session session = null;
	        try
	        {
	            session = factory.openSession();
	            session.beginTransaction();

	            Query query = session.createQuery("FROM User U WHERE U.userName= :username")
	                    .setString("username",userName);
	            List<?> users = query.list();
	            if(users.size() != 0)
	                return false;
	        }
	        catch (HibernateException e)
	        {
	            Transaction tx = Objects.requireNonNull(session).getTransaction();
	            if (tx.isActive())
	                tx.rollback();
	        }
	        finally
	        {
	            if(session!=null) session.close();
	        }
	        return true;
	    }
	
}
	 
	 
	 

	
	

