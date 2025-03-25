package assignment2.spring.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import assignment2.spring.entities.Customer;


public class CustomerDAOImpl implements CustomerDAO {

//	private javax.sql.DataSource dataSource;

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void save(Customer c) {

		new HibernateTemplate(sessionFactory).save(c);
	}

	@Override
	public void update(Customer c) {
		new HibernateTemplate(sessionFactory).update(c);
	}

	@Override
	public void delete(int id) {
		new HibernateTemplate(sessionFactory).delete(get(id));
	}

	@Override
	public Customer get(int id) {
		return new HibernateTemplate(sessionFactory).load(Customer.class, id);
	}

	@Override
	public List<Customer> getAll() {
		return  new HibernateTemplate(sessionFactory).find("from Customer c");
	}

}
