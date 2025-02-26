package assignment2.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import assignment2.spring.Customer;
import assignment2.spring.CustomerService;
import assignment2.spring.CustomerServiceImpl;
import assignment2.spring.Item;
import assignment2.spring.ItemService;


public class CustomerTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("tx-spr-hib-ann.xml");
		CustomerService cs = ctx.getBean(CustomerService.class);
		ItemService is = ctx.getBean(ItemService.class);
//		System.out.println(es.getClass().getName());
//		cs.save(new Customer(1,"Hello",20,"Abd","Abd"));
//		cs.save(new Customer(4,"HelloBro",21,"Abd","Abd"));
//		cs.update(new Customer(3,"Hekkkllo",20,"Jbp","Abd"));
//		cs.delete(3);
//		is.update(new Item("Biscuit","Protein Low",5,10,15).get());
		Item i = is.get(1);
		i.setCurrent_qty(6);
		is.update(i);
//		System.out.println(cs.get(2).getName());
//		System.out.println();
//		es.getAll().forEach(e -> System.out.println(e));
//		ctx.close();
//		CustomerService cs = new CustomerServiceImpl();
		ctx.close();
//		cs.save(new Customer(1,"Hello",20,"Abd","Abd"));
	}

}
