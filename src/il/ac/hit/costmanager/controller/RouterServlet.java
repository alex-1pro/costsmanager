

package il.ac.hit.costmanager.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import il.ac.hit.costmanager.CostsManagerException;


/**
 * @author Alexey Belogurov & Jacob Graham 
 * Servlet implementation class RouterServlet
 */
@WebServlet("/controller/*")
public class RouterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String controller = "";
	String action = "";
	String view = "";
	String data = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RouterServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
				
			response.setContentType("text/html");
			
			String[] texts = request.getRequestURI().split("/");
			
			if (texts.length > 3) {
				view = texts[3];
				controller = texts[3].substring(0, 1).toUpperCase() + texts[3].substring(1);
				
				System.out.println("view = " + view);
				System.out.println("controller = " + controller);
			}
			
			if (texts.length > 4)
				action = texts[4].substring(0, 1).toLowerCase() + texts[4].substring(1);
			else
				action = view;
			
			System.out.println("action = " + action);
			
			if (texts.length > 5)
				data = texts[5];
			
			String controllerClassName = il.ac.hit.costmanager.Settings.CONTROLLERS_PACKAGE + "." + controller + "Controller";
						
			System.out.println("controllerClassName= " + controllerClassName);
			
			System.out.println("Strating the Reflection:");
			
			Class clazz = Class.forName(controllerClassName);
			Method method = clazz.getMethod(action, HttpServletRequest.class, HttpServletResponse.class, String.class);
//			Method method = clazz.getMethod(view, HttpServletRequest.class, HttpServletResponse.class, String.class);
			method.invoke(clazz.newInstance(), request, response, data);
			
			System.out.println("After the Reflection");
			
//			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/"+ action +".jsp");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/"+ view +".jsp");
			dispatcher.include(request,response);
			System.out.println("After the Reflection----"+"/views/"+ view +".jsp");
		} catch(ClassNotFoundException | NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| InstantiationException | CostsManagerException e) {
			
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}




