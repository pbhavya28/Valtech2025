package assignment2.spring.dao;

import java.util.Set;

import assignment2.spring.entities.LineOrder;


public interface LineOrderDAO {

	void save (LineOrder l);
	void update (LineOrder l);
	void delete (int id);
	LineOrder get(int id);
	Set<LineOrder> getAll();
}
