package assignment2.spring;

import java.util.Set;

public interface LineOrderDAO {

	void save (LineOrder l);
	void update (LineOrder l);
	void delete (int id);
	LineOrder get(int id);
	Set<LineOrder> getAll();
}
