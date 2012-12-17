package fr.todooz.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import fr.todooz.domain.Task;

public class TaskService {
	
	private SessionFactory sessionFactory;
	
	public void save(Task task) {
		// TODO
		Session session = sessionFactory.openSession();
		session.save(task);
		session.close();
	   }
	
	public void delete(Long id) {
		// TODO
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(session.get(Task.class, id));
		tx.commit();
		session.close();
	   }
	
	public List<Task> findAll() {
	    // TODO
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Task.class);
		List<Task> tasks = criteria.list();
		
		session.close();
		return tasks;
	   }
	
	public List<Task> findByQuery(String query) {
	    // TODO
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Task.class);
	    criteria.add(Restrictions.like("title", "%" + query + "%").ignoreCase());
	    List<Task> tasks = criteria.list();

	 	session.close();
	 	return tasks;	
	   }
	
	public int count() {
	      // TODO
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Task.class);
		List<Task> tasks = criteria.list();
		int c;
		c = tasks.size();
		session.close();
		return c;
	   }

	public void setSessionFactory(SessionFactory sessionFactory) {
		   // TODO Auto-generated method stub
		   this.sessionFactory = sessionFactory;
	   }
	   
}
