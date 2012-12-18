package fr.todooz.service;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import fr.todooz.domain.Task;

public class TaskServiceImpl implements TaskService {
	
	@Inject
	private SessionFactory sessionFactory;
	
	/* (non-Javadoc)
	 * @see fr.todooz.service.TaskService#save(fr.todooz.domain.Task)
	 */
	@Override
	@Transactional
	public void save(Task task) {
		// TODO
		Session session = sessionFactory.getCurrentSession();
		session.save(task);
	   }
	
	/* (non-Javadoc)
	 * @see fr.todooz.service.TaskService#delete(java.lang.Long)
	 */
	@Override
	@Transactional
	public void delete(Long id) {
		// TODO
		Session session = sessionFactory.getCurrentSession();		
		session.delete(session.get(Task.class, id));		
	   }
	
	/* (non-Javadoc)
	 * @see fr.todooz.service.TaskService#findAll()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Task> findAll() {
	    // TODO
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Task.class);
		List<Task> tasks = criteria.list();
		
		return tasks;
	   }
	
	/* (non-Javadoc)
	 * @see fr.todooz.service.TaskService#findByQuery(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Task> findByQuery(String query) {
	    // TODO
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Task.class);
	    criteria.add(Restrictions.like("title", "%" + query + "%").ignoreCase());
	    List<Task> tasks = criteria.list();

	 	return tasks;	
	   }
	
	/* (non-Javadoc)
	 * @see fr.todooz.service.TaskService#count()
	 */
	@Override
	@Transactional(readOnly = true)
	public int count() {
	      // TODO
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Task.class);
		List<Task> tasks = criteria.list();
		int c;
		c = tasks.size();
		return c;
	   }

	public void setSessionFactory(SessionFactory sessionFactory) {
		   // TODO Auto-generated method stub
		   this.sessionFactory = sessionFactory;
	   }
	   
}
