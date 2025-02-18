package day4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import assignment1.Employee;
import assignment1.Employee.Gender;

class EmployeeDAOTest {

	@Test
	void testInsert() {
		EmployeeDAO dao = new EmployeeDAOImpl();
//		dao.save(new Employee(173,"Testing",23,15000,2,9,Gender.FEMALE));
		Employee e = new Employee(171, "DEF",23,16000,2,8,Gender.MALE);
		dao.update(e);
//		e = dao.get(1);
//		assertEquals(1,e.getId());
//		assertEquals("DEF",e.getName());
//		assertEquals(23,e.getAge());
//		assertEquals(16000,e.getSalary());
//		assertEquals(2,e.getExperience());
//		assertEquals(8,e.getLevel());
//		assertEquals(Gender.MALE,e.getGender());
		assertTrue(dao.getAll().size()>1);
//		dao.delete(107);
	}

}
