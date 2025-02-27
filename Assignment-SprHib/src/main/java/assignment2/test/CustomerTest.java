package assignment2.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import assignment2.spring.Customer;
import assignment2.spring.CustomerDAO;

import assignment2.spring.Item;
import assignment2.spring.ItemDAO;
import assignment2.spring.LineOrder;
import assignment2.spring.LineOrderDAO;
import assignment2.spring.Orders;
import assignment2.spring.OrdersDAO;



public class CustomerTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("tx-spr-hib-ann.xml");
		CustomerDAO cs = ctx.getBean(CustomerDAO.class);
		ItemDAO is = ctx.getBean(ItemDAO.class);
		OrdersDAO os = ctx.getBean(OrdersDAO.class);
		LineOrderDAO ls = ctx.getBean(LineOrderDAO.class);
		
		
		cs.save(new Customer("gunman",20,"jbp","amd"));
	
		
//		LineOrder l = new LineOrder();
//		l.setItem(is.get(1));
//		l.setQty(3);
//		l.setOrder(os.get(1));
//		ls.save(l);
//		cs.update(newCustomer("Gumnaam",21,"Mumbai","Mumbai"));
//		Customer c = cs.get(1);
//		Orders o = new Orders();
//		o.setCustomer(c);
//		o.setStatus("pending");
//		os.save(o);
//		System.out.println(o);
		
//		System.out.println(es.getClass().getName());
//		cs.save(new Customer(1,"Hello",20,"Abd","Abd"));
//		cs.save(new Customer(4,"HelloBro",21,"Abd","Abd"));
//		cs.update(new Customer(3,"Hekkkllo",20,"Jbp","Abd"));
//		cs.delete(3);
//		is.update(new Item("Biscuit","Protein Low",5,10,15).get());
//		Item i = is.get(1);
//		i.setCurrent_qty(6);
//		is.update(i);
//		System.out.println(cs.get(2).getName());
//		System.out.println();
//		es.getAll().forEach(e -> System.out.println(e));
//		ctx.close();
//		CustomerService cs = new CustomerServiceImpl();
		ctx.close();
//		cs.save(new Customer(1,"Hello",20,"Abd","Abd"));
	}

}
