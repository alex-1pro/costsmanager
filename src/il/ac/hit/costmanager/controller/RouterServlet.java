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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
				
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String[] texts = request.getRequestURI().split("/");
			
			if (texts.length > 2) {
				view = texts[2];
				controller = texts[2].substring(0, 1).toUpperCase() + texts[2].substring(1);
			}
			
			if (texts.length > 3)
				action = texts[3].substring(0, 1).toLowerCase() + texts[3].substring(1);
			else
				action = view;
			
			if (texts.length > 4)
				data = texts[4];
			
			String controllerClassName = il.ac.hit.costmanager.Settings.CONTROLLERS_PACKAGE + "." + controller + "Controller";
						
			Class clazz = Class.forName(controllerClassName);
			Method method = clazz.getMethod(action, HttpServletRequest.class, HttpServletResponse.class, String.class);
			method.invoke(clazz.newInstance(), request, response, data);
			
//			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/"+ action +".jsp");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/"+ view +".jsp");
			dispatcher.include(request,response);
			
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
