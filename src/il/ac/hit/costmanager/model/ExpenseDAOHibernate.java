package il.ac.hit.costmanager.model;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Collections;
/**
 *  @author Alexey Belogurov & Jacob Graham
 * 
 *  This class implements IExapenseDAO and communicate with a database 
 */

public class ExpenseDAOHibernate implements IExpenseDAO {

	
	private static IExpenseDAO instance;
	private SessionFactory factory;

	private ExpenseDAOHibernate() throws ExpenseCostsManagerDAOExeption {
		factory = new AnnotationConfiguration().configure().buildSessionFactory();

	}
	/**
	 * @return the instance of this object, if no instance exists, create a new one.
	 * */
	public static IExpenseDAO getInstance() throws ExpenseCostsManagerDAOExeption {
		if (instance == null) {
			return instance = new ExpenseDAOHibernate();
		}
		return instance;
	}
	/** Add the expense to database
	    * @param expense The expense object to add
	    * @return true if add successed else return false 
	    * @throws ExpenseCostsManagerDAOExeption in case of error
	    */
	@Override
	public boolean addUserExpense(Expense expense) throws ExpenseCostsManagerDAOExeption {
		boolean success = false;
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			session.save(expense);
			success = true;
			session.getTransaction().commit();
		} catch (HibernateException e) {
			Transaction tx = Objects.requireNonNull(session).getTransaction();
			if (tx.isActive())
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return success;
	}

	/**
     * Get array of all the user expenses by user id
     * @param userId user id
     * @return all the expenses of the user
     * @throws ExpenseCostsManagerDAOExeption in case the user has no expenses yet
     */

	@Override
	public Expense[] getUserExpenses(int userId) throws ExpenseCostsManagerDAOExeption {
		Session session = null;
		Expense[] expenses = null;
		List<Expense> expensesList = new ArrayList<>();
		try {
			session = factory.openSession();
			session.beginTransaction();
			String hql = "FROM Expense E WHERE E.userId= :user_id";
			Query query = session.createQuery(hql);
			query.setParameter("user_id", userId);
			expensesList = query.list();
			expenses = toArray(expensesList);

		} catch (HibernateException ex) {
			Transaction tx = session.getTransaction();
			if (tx.isActive())
				tx.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return expenses;
	}
	/**
     * Get array of all the user expenses by user id and by month
     * @param userId user id
     * @param month expenses month 
     * @return all the expenses  of the required month
     * @throws ExpenseCostsManagerDAOExeption in case the user has no expenses 
     */

	@Override
	public Expense[] getUserExpensesByMonth(int userId, String month) throws ExpenseCostsManagerDAOExeption {
		Session session = null;
		Expense[] expenses = null;
		List<Expense> expensesList = new ArrayList<>();
		try {
			session = factory.openSession();
			session.beginTransaction();
			String hql = "FROM Expense E WHERE E.userId= :user_id and E.month= :month";
			Query query = session.createQuery(hql);
			query.setParameter("user_id", userId);
			query.setParameter("month", month);
			expensesList = query.list();
			expenses = toArray(expensesList);
            session.getTransaction().commit();

		} catch (HibernateException ex) {
			Transaction tx = session.getTransaction();
			if (tx.isActive())
				tx.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return expenses;
	}
	/**
	 *toArray function get list of expenses and casts and returns array of expenses 
	 *used in  getUserExpenses and getUserExpensesByMonth.
	 *@param expensesList casting from expenses list raw type to expenses array
     *@return the expenses as array
	  */

	public Expense[] toArray(List<Expense> expensesList) {
		int i = expensesList.size();
		Expense[] expenses = new Expense[i];
		for (int j = 0; j < i; j++)
			expenses[j] = expensesList.get(j);
		return expenses;

	}

}
