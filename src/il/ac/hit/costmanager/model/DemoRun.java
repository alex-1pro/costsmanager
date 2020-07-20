
package il.ac.hit.costmanager.model;


public class DemoRun {
	 public static void main(String[] args) throws ExpenseCostsManagerDAOExeption {
		
		 try {
	//		 IUserDAO dao1=UserDAOHibernate.getInstance();
	//		 IExapenseDAO dao2=ExpenseDAOHibernate.getInstance();
			// dao1.userRegister("Haim", "123456");
			// System.out.println(dao1.validateUser("Alex", "123456"));
			 // Expense expense =new Expense(1,10.5,"food","august","milk");
			// Expense expense2 =new Expense(1,20.9,"clothes","july","t-short");
			// Expense expense3 =new Expense(1,10000,"car","july","BMW");
			// User u2=dao1.validateUser("Alex", "123456");
			//dao2.addUserExense(expense2);
			// Expense expense2 =new Expense(1,20.9,"clothes","july","t-short"); 
			// dao2.addUserExpense(expense2);
			// dao2.addUserExpense(expense3);
		//	 Expense [] expenses=dao2.getUserExpensesByMonth(1,"july");
				/*
				 * for(Expense ex:expenses ) System.out.println(ex+"\n\n");
				 */

	 IUserDAO dao=UserDAOHibernate.getInstance();
	   User user1=dao.userRegister("vangoch","vodka");
	   System.out.println(user1);
	 
			// IUserDAO dao=UserDAOHibernate.getInstance();
			 IExapenseDAO dao2=ExpenseDAOHibernate.getInstance();
		//	 Expense [] expenses=dao2.getUserExpensesByMonth(1,"july");
				
		//		 for(Expense ex:expenses ) System.out.println(ex+"\n\n");
				
		 }catch (UserCostsManagerDAOException e) {
			e.printStackTrace();
		}
	 }
	
	
}
