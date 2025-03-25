package assignment2.spring.dao;

import java.util.Set;

import assignment2.spring.entities.Item;


public interface ItemDAO{

	void save(Item i);
	void update(Item i);
	void delete(int id);
	Item get(int id);
	Set<Item> getAll();
	void merge(Item i);
	
}
