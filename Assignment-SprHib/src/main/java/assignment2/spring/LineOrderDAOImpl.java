package assignment2.spring;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class LineOrderDAOImpl implements LineOrderDAO {

	private javax.sql.DataSource dataSource;

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void save(LineOrder l) {
		new HibernateTemplate(sessionFactory).save(l);

	}

	@Override
	public void update(LineOrder l) {
		new HibernateTemplate(sessionFactory).update(l);;

	}

	@Override
	public void delete(int id) {
		new HibernateTemplate(sessionFactory).delete(get(id));

	}

	@Override
	public LineOrder get(int id) {
		return new HibernateTemplate(sessionFactory).load(LineOrder.class, id);
	}

	@Override
	public Set<LineOrder> getAll() {
		return (Set<LineOrder>) new HibernateTemplate(sessionFactory).find("from LineOrder l");
	}

}
