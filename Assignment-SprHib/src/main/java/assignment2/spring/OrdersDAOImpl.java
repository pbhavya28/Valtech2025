package assignment2.spring;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional(propagation = Propagation.SUPPORTS)
public class OrdersDAOImpl implements OrdersDAO {
	
	private javax.sql.DataSource dataSource;

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Override
//	@Transactional(propagation = Propagation.REQUIRED)
	public void save(Orders o) {
		new HibernateTemplate(sessionFactory).save(o);
	}

	@Override
//	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Orders o) {
		new HibernateTemplate(sessionFactory).update(o);

	}

	@Override
	public void delete(int id) {
		new HibernateTemplate(sessionFactory).delete(get(id));

	}

	@Override
	public Orders get(int id) {
		
		return new HibernateTemplate(sessionFactory).load(Orders.class, id);
	}

	@Override
	public Set<Orders> getAll() {
		return (Set<Orders>) new HibernateTemplate(sessionFactory).find("from Orders o");
	}


	@Override
	public void persist(Orders o) {
		 new HibernateTemplate(sessionFactory).persist(o);
		
	}


	@Override
	public void merge(Orders o) {
		new HibernateTemplate(sessionFactory).persist(o);
		
	}

}
