
package il.ac.hit.costmanager.model;


public class DemoRun {
	 public static void main(String[] args) {
		 User user =new User ("Alex","123456");
		 try {
			 IUserDAO dao=UserDAOHibernet.getInstance();
			// boolean success =false;
				// success=dao.userRegister("Alex", "123456");
			 	//dao.userRegister("aaa", "bbbb");
			 	//dao.userRegister("cccc", "gggg");
			 	dao.userRegister("jjjk", "kkkk");
			 	dao.userRegister("fffff", "kkkk");

				/*
				 * if(success) System.out.println(user+" added successfully\n\n"); else
				 * System.out.println(user+" did'nt add\n\n");
				 */
		 }catch (UserCostsManagerException e) {
			e.printStackTrace();
		}
	 }
	
	
}
