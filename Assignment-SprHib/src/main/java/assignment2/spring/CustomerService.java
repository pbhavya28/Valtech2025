package assignment2.spring;

import java.util.Set;

public interface CustomerService {

	void save (Customer c);
	void update (Customer c);
	void delete (int id);
	Customer get(int id);
	Set<Customer> getAll();
	
}
