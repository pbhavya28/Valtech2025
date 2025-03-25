package dao;

import java.util.List;
import java.util.Set;

import entities.Dept;

public interface DeptDAO {

	Dept first();
	
	Dept last();
	
	Dept next(int id);
	
	Dept previous(int id);
	
	void save(Dept dept);

	void update(Dept dept);

	Dept getDept(int id);

	void delete(int id);

	List<Dept> getAll();

}