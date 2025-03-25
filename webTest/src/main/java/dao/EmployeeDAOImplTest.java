package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import entities.Employee;
import entities.Employee.Gender;



class EmployeeDAOImplTest {

	@Test
	void test() {
		EmployeeDAO dao= new EmployeeDAOImpl(); 
//		Employee e = new Employee(179, "DEF",28,16000,2,8,Gender.MALE,5);
//		System.out.println(dao.get(178));
//		System.out.println(e);
//		dao.delete(178);
//		dao.save(e);
		List<Employee> l_emp = dao.getAll();
//		System.out.println(dao.sortByIdDesc());
//		System.out.println(dao.sortByIdAsc());
//		Employee e = new Employee(190, "JJF",21,16000,2,8,Gender.MALE,1);
//		Employee e1 = new Employee(279, "AEF",38,18000,3,5,Gender.FEMALE,1);
//		Employee e2 = new Employee(79, "BEF",28,26000,4,2,Gender.MALE,2);
//		Employee e3 = new Employee(1900, "CEF",20,36000,6,10,Gender.FEMALE,2);
//		dao.save(e3);
//		dao.save(e2);
//		dao.save(e1);
//		dao.save(e);

//		System.out.println(dao.getEmpByDept(2));

//		System.out.println(dao.getSearchByName("anti"));
//		dao.getSearchByName("kanti").forEach(System.out::println);
//		System.out.println(dao.getAll());
		System.out.println(dao.getEmpByDept(2));
	}

}
