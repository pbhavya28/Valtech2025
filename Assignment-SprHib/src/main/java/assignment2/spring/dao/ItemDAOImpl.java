package assignment2.spring.dao;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import assignment2.spring.entities.Item;


//@Transactional(propagation = Propagation.SUPPORTS)
public class ItemDAOImpl implements ItemDAO {

//	private javax.sql.DataSource dataSource;
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
//	@Transactional(propagation = Propagation.REQUIRED)
	public void save(Item i) {
		new HibernateTemplate(sessionFactory).save(i);
		
	}

	@Override
//	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Item i) {
		
		new HibernateTemplate(sessionFactory).update(i);
		
	}
	@Override
	public void delete(int id) {
		new HibernateTemplate(sessionFactory).delete(get(id));
	}

	@Override
	public Item get(int id) {
		System.out.println("Get called----------");
		System.out.println("id============"+id);
		System.out.println(Item.class.getName());
		return new HibernateTemplate(sessionFactory).get(Item.class, id);
	}

	@Override
	public Set<Item> getAll() {
		return (Set<Item>) new HibernateTemplate(sessionFactory).find("from Item i");
	}

	@Override
	public void merge(Item i) {
		
		new HibernateTemplate(sessionFactory).merge(i);
		
	} 
	

}
