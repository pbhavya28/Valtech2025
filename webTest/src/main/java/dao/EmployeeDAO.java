package dao;

import java.util.List;

import entities.Dept;
import entities.Employee;

//import assignment1.Employee;

public interface EmployeeDAO {

	void save(Employee e);
	
	void update (Employee e);
	
	void delete (int id);
	
	Employee get(int id);
	
	List<Employee> getAll();
	
	List<Employee> getEmpByDept(int deptId);

//	List<Employee> sortByIdDesc();
//	
//	List<Employee> sortByIdAsc();
//
//	List<Employee> sortByNameDesc();
//
//	List<Employee> sortByNameAsc();
//
//	List<Employee> sortByAgeDesc();
//
//	List<Employee> sortByAgeAsc();
//
//	List<Employee> sortByGenderDesc();
//
//	List<Employee> sortByGenderAsc();
//
//	List<Employee> sortBySalaryDesc();
//
//	List<Employee> sortBySalaryAsc();
//
//	List<Employee> sortByExpDesc();
//
//	List<Employee> sortByExpAsc();
//
//	List<Employee> sortByLevelDesc();
//
//	List<Employee> sortByLevelAsc();
//
//	List<Employee> sortByDepDesc();
//
//	List<Employee> sortByDepAsc();
//	
//	
//	List<Employee> getSearchByName(String name);
//	List<Employee> getSearchBySal(long salary);
//	List<Employee> getSearchByLevel (int level);
//	List<Employee> getSearchByAge (int age);
//	List<Employee> getSearchByExp (int exp);

}
