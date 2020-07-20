package il.ac.hit.costmanager.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import il.ac.hit.costmanager.model.IUserDAO;
import il.ac.hit.costmanager.model.User;
import il.ac.hit.costmanager.model.UserCostsManagerDAOException;
import il.ac.hit.costmanager.model.UserDAOHibernate;

import java.util.Objects;

public class LoginController extends AbstractController {
	
	 
	    public boolean tryToLogin(HttpServletRequest request, HttpServletResponse response, String data) {
	        String userName = request.getParameter("userName");
	        String password = request.getParameter("password");
	        
	        try {
	          
	            IUserDAO userDAO =UserDAOHibernate.getInstance();
		    	   User user = userDAO.validateUser(userName, password);
	            if (user != null)
	            {
	                request.getSession().setAttribute("user", user);
	             
	           
	               response.sendRedirect("http://localhost:8080/CostManager/controller/home");
	                return true;
	            }
	            else
	                request.setAttribute("succsess",false);
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (UserCostsManagerDAOException e) {
	            System.out.println(e.getMessage());
	            request.setAttribute("succsess",false);
	            return false;
	        }
	        return false;
	    }


	 public boolean userLogged(HttpServletRequest request, HttpServletResponse response, String data) {
	        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/home_screen.jsp");
	        try {
	            dispatcher.include(request,response);
	        } catch (ServletException | IOException e) {
	            e.printStackTrace();
	        }
	        return true;
	    }
	 
	 
	  public boolean logOut(HttpServletRequest request, HttpServletResponse response, String data) {
	        request.getSession().removeAttribute("user");
	     // removeAppCookie(response);
	        try {
	            response.sendRedirect("http://localhost:8080/CostManager/controller/login");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return true;
	    }
	  public boolean login(HttpServletRequest request, HttpServletResponse response, String data) {
			
			System.out.println("In LoginController");
		
			return true;
		}

}
