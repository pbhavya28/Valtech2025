package assignment2.spring;

import java.util.Set;

public interface OrdersDAO {

	void save(Orders o);
	void update(Orders o);
	void delete(int id);
	Orders get(int id);
	Set<Orders> getAll();
}
