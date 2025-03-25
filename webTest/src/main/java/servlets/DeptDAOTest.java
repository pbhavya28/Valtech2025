package servlets;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.DeptDAO;
import dao.DeptDAOImpl;

class DeptDAOTest {

	@Test
	void test() {
//		Dept dept = new Dept(4,"Finance","Mumbai");
		DeptDAO dao = new DeptDAOImpl();
//		dao.save(dept);
		
//		Dept deptUpdate = new Dept(4,"Sales","Mumbai");
//		dao.update(deptUpdate);
//		System.out.println(dao.next(3));
//		dao.delete(4);
//		System.out.println(dao.first());
//		System.out.println(dao.getAll());
//		dao.getAll().forEach(System.out::println);
		System.out.println(dao.getDept(2));
		
		

	}

}
