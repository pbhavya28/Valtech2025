package assignment2.spring.dao;

import java.util.Set;

import assignment2.spring.entities.Orders;


public interface OrdersDAO {

	void save(Orders o);
	void update(Orders o);
	void delete(int id);
	Orders get(int id);
	Set<Orders> getAll();
	void persist(Orders o);
	void merge(Orders o);
}
