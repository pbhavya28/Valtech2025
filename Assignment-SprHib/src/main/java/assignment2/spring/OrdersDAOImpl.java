package assignment2.spring;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class OrdersDAOImpl implements OrdersDAO {
	
	private javax.sql.DataSource dataSource;

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Override
	public void save(Orders o) {
		new HibernateTemplate(sessionFactory).save(o);
	}

	@Override
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

}
