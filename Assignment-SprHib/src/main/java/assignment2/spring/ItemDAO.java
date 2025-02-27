package assignment2.spring;

import java.util.Set;

public interface ItemDAO{

	void save(Item i);
	void update(Item i);
	void delete(int id);
	Item get(int id);
	Set<Item> getAll();
	
}
