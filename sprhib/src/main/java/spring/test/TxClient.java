package spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.tx.Employee;
import spring.tx.Employee.Gender;
import spring.tx.EmployeeService;

public class TxClient {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("tx-hib-ann.xml");
		EmployeeService es = ctx.getBean(EmployeeService.class);
		System.out.println(es.getClass().getName());
		es.update(new Employee(10,"Ten",10,200000,10,10,Gender.MALE));
		es.getAll().forEach(e -> System.out.println(e));
		ctx.close();
	}

}
