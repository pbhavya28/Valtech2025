package assignment2.spring.dao;

import java.util.List;
import java.util.Set;

import assignment2.spring.entities.Customer;


public interface CustomerDAO {

	void save (Customer c);
	void update (Customer c);
	void delete (int id);
	Customer get(int id);
	List<Customer> getAll();
	
}
