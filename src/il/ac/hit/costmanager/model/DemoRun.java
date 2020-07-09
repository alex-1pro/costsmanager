
package il.ac.hit.costmanager.model;


public class DemoRun {
	 public static void main(String[] args) {
		
		 try {
			 IUserDAO dao=UserDAOHibernet.getInstance();
			
			 dao.userRegister("Alex", "123456");
			 User u2=dao.validateUser("Alex", "123456");
			 System.out.println(u2+"\n\n");
				
		 }catch (UserCostsManagerException e) {
			e.printStackTrace();
		}
	 }
	
	
}
