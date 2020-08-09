package il.ac.hit.costmanager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Alexey Belogurov & Jacob Graham 
 *this class  connects  and passes data between the jsp pages and the model objects.
 */
public class HomeController {

public boolean home(HttpServletRequest request, HttpServletResponse response, String data) {
		
		System.out.println("In HomeController");
	
		return true;
	}
	
}
