package il.ac.hit.costmanager.model;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;

public class UserDAOHibernet implements IUserDAO{
	
	 private static IUserDAO instance;
	 private SessionFactory factory;
    
	 private UserDAOHibernet() throws UserCostsManagerException {
	        factory = new AnnotationConfiguration().configure().buildSessionFactory();
	 }
	  public static IUserDAO getInstance() throws UserCostsManagerException {
	        if (instance == null) {
	            return instance = new UserDAOHibernet();
	        }

	        return instance;
	  }
	 
	 
	 

	@Override
	public boolean userRegister(String userName, String password) throws UserCostsManagerException{
		// TODO Auto-generated method stub
		
	      Session session = null;
	        User user = null;
	        try {
	            session = factory.openSession();
	            session.beginTransaction();
	            if(!checkUserName(userName)) {
	                throw new UserCostsManagerException("An attempt to register userName: '" + userName +"' was done, user already exists.");
	                
	            }
	            User u = new User(userName,password);
	            session.save(u);
	            session.getTransaction().commit();
	            Query query = session.createQuery("from User U where U.username= :username")
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
	      //  return user;
		
		return false;
	}
	
	
	
	@Override
	public boolean checkUserName(String username) throws UserCostsManagerException {
		
		
		Session session = null;
        try
        {
            session = factory.openSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM User U WHERE U.userName = :username")
                    .setString("username",username);
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
		
	
	@Override
	public boolean validateUser(String userName, String password) throws UserCostsManagerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUser(String userName, String password) throws UserCostsManagerException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
