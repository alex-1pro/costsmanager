package il.ac.hit.costmanager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import il.ac.hit.costmanager.model.IUserDAO;
import il.ac.hit.costmanager.model.User;
import il.ac.hit.costmanager.model.UserCostsManagerDAOException;
import il.ac.hit.costmanager.model.UserDAOHibernate;

import java.io.IOException;

/**
 * 
 * @author Alexey Belogurov & Jacob Graham
 *
 *this class extends from AbstractController which connects  and passes data between the jsp pages and the model objects.
 */


public class RegisterController extends AbstractController {
	
   public boolean register(HttpServletRequest request, HttpServletResponse response, String data) {
      System.out.println("In RegisterController"); 
	   return false;
   }
   /**
    * try to register the user information sent in the form
    * @param request The request which was sent to the controller
    * @param response The response which was sent to the controller
    * @param data Extra data if needed
    * @return boolean returns if redirect was sent
   */
   public boolean tryToRegister(HttpServletRequest request, HttpServletResponse response, String data) {

	   
	      String userName = request.getParameter("userName");
	       String password = request.getParameter("password");
	       System.out.println("here in controller.... "+userName +"------"+password);
	       try {
	           IUserDAO userDAO =UserDAOHibernate.getInstance();
	    	   User user = userDAO.userRegister(userName, password);
	    	   System.out.println(user);
	    	   request.setAttribute("pass", password);
	    	   response.setHeader("uName",userName );
	    	   request.setAttribute("succsess",true);
	    	   
	       } catch (UserCostsManagerDAOException e) {
	           System.out.println(e.getMessage());
	           request.setAttribute("succsess",false);
	           return false;
	       } 
	       return true;
   }

   /**
    * Check if the user object is null or not
    * @param user the user returned from addUser function
    * @return boolean if user is null or not
    */
   private boolean userAlreadyExistsInDb(User user) {
       return user == null;
   }
	
}
