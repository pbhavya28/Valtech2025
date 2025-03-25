package assignment2.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;



import assignment2.spring.dao.CustomerDAO;
import assignment2.spring.dao.ItemDAO;
import assignment2.spring.dao.LineOrderDAO;
import assignment2.spring.dao.OrdersDAO;
import assignment2.spring.entities.Item;
import assignment2.spring.entities.LineOrder;
import assignment2.spring.entities.Orders;
import assignment2.spring.service.Service;



public class CustomerTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("tx-spr-hib-ann.xml");
		CustomerDAO cs = ctx.getBean(CustomerDAO.class);
		ItemDAO is = ctx.getBean(ItemDAO.class);
		OrdersDAO os = ctx.getBean(OrdersDAO.class);
		LineOrderDAO ls = ctx.getBean(LineOrderDAO.class);
		Service s = ctx.getBean(Service.class);
		
		
//		is.delete(5);
		is.get(1);
		cs.get(1);
//		System.out.println(cs.getAll());
		//Customer placing new item
		/* 
		 * Customer details - 
		 * Item available or not in Items 
		 * Items and quantity -> Stored in Lineorder
		 * 
		 * 
		 * */
//		Customer c2 = new Customer("Indrajeet",23,"Naroda","Chandkheda");
//		c2.setState(State.DISABLED);
//		cs.save(c2);
//		LineOrder lo1 = new LineOrder();
//		Item item = is.get(8);
//		System.out.println(item.getCurrentQty());
//		lo1.setItem(is.get(1));
//		
//		lo1.setQty(6);
////		
//		LineOrder lo2 = new LineOrder();
//		lo2.setItem(is.get(11));
//		lo2.setQty(1);
//		
//		LineOrder lo2 = new LineOrder();
//		lo2.setItem(is.get(5));
//		lo2.setQty(2);
//		
//		LineOrder lo3 = new LineOrder();
//		lo3.setItem(is.get(7));
//		lo3.setQty(7);
//		
//		Orders o = new Orders();	
//		o.setCustomer(cs.get(10));
//		o.addLineOrder(lo1);
//		o.addLineOrder(lo2);
//		o.addLineOrder(lo2);
//		o.addLineOrder(lo3);
//		o.setStatus(Status.IN_PROGRESS);;
//		s.saveOrder(o);
//		s.saveLineOrder(lo1);
//		ls.save(lo1);
//		ls.save(lo1);
//		s.saveOrder(o);
		
//		System.out.println(os.get(3).getLineOrder());
//		o.getLineOrder().
		
		
//		cs.save(new Customer("Kartik",24,"Jabalpur","Jabalpur"));
//		cs.save(new Customer("Suraj",20,"Patiyala","Patiyala"));
//		cs.save(new Customer("Baman",40,"Delhi","Raigadh"));
//		cs.save(new Customer("Nisha",34,"Kolkata","Kolkata"));
//		cs.save(new Customer("Sneha",28,"Ahmedabad","Vadodara"));
	
		/* getting newly created customer's id
		Customer c = new Customer("Shubh",24,"Gurgaon","Mumbai");
		cs.save(c);s
		System.out.println(cs.get(c.getId()).getId());
		*/
		
		
//		cs.save(new Customer("gunman",20,"jbp","amd"));
		
//		is.save(new Item("Parle-G","Classic",330,170,500));
//		is.save(new Item("Mom's Magic","Traditional",100,100,200));
//		is.save(new Item("Tiger","Kid friendly",5,20,25));
//		is.save(new Item("Rusk","Premium",35,5,40));
//		is.save(new Item("Burbon","Chocolaty",30,30,60));
//		is.save(new Item("Happy Happy","Chocolaty",30,0,30));
//		is.save(new Item("Oreo","Coconut flavour",50,70,120));
//		is.save(new Item("20-20","Buttery",150,50,200));
//		is.save(new Item("Monaco","Salty",300,100,400));
//		is.save(new Item("Krack Jack","Sweet",350,50,400));
	
		
//		LineOrder l = new LineOrder();
//		l.setItem(is.get(7));
//		l.setQty(45);
//		l.setOrder(os.get(1));
//		ls.save(l);
//		System.out.println(ls.get(l.getId()).getOrder().getId());
////		cs.update(newCustomer("Gumnaam",21,"Mumbai","Mumbai"));
//		Customer c = cs.get(1);
//		Orders o = new Orders();
//		o.setCustomer(c);
//		o.setStatus("pending");
//		s.saveOrder(o);
		
		
		
		
		
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
