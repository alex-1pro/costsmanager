package il.ac.hit.costmanager.model;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Collections;

public class ExpenseDAOHibernate implements IExapenseDAO {

	private static IExapenseDAO instance;
	private SessionFactory factory;

	private ExpenseDAOHibernate() throws ExpenseCostsManagerDAOExeption {
		factory = new AnnotationConfiguration().configure().buildSessionFactory();

	}

	public static IExapenseDAO getInstance() throws ExpenseCostsManagerDAOExeption {
		if (instance == null) {
			return instance = new ExpenseDAOHibernate();
		}
		return instance;
	}

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

//	@Override
	/*
	 * public double getTotalCost(int userId) throws ExpenseCostsManagerDAOExeption
	 * { Session session=null; double totalCost;
	 
	
	     
	//	  String hql="SELECT SUM(E.cost)  FROM Expense E WHERE E.userId= :user_id"; Query
		 
		 
		
		
	}*/

	public Expense[] toArray(List<Expense> expensesList) {
		int i = expensesList.size();
		Expense[] expenses = new Expense[i];
		for (int j = 0; j < i; j++)
			expenses[j] = expensesList.get(j);
		return expenses;

	}

}
