package spring.ioc.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.ioc.SimpleInterest;
import spring.ioc.UtilsBean;

class IOCTest {
	
	@Test
	void testParentChild() {
		ClassPathXmlApplicationContext parent = new ClassPathXmlApplicationContext("parent.xml");
		ClassPathXmlApplicationContext child = new ClassPathXmlApplicationContext(new String[] {"child.xml"},parent);
		System.out.println(" Parent child: "+child.getBean("line"));
		
	}

	@Test
	void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ioc.xml");
		SimpleInterest si = (SimpleInterest)ctx.getBean("si");
		assertEquals(200, si.compute(200, 20, 5));
		System.out.println(ctx.getBean("p"));
		System.out.println(ctx.getBean("p1"));
		System.out.println(ctx.getBean("l"));
		System.out.println(ctx.getBean("l1"));
		System.out.println(ctx.getBean("l2"));
		System.out.println(ctx.getBean("l3"));

		ctx.close();
	}
	
	@Test
	void testUtils() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("utils.xml");
		UtilsBean bean = (UtilsBean) ctx.getBean("utils");
		System.out.println(bean.getNames());
		bean.getPoints().forEach(t -> System.out.println(t));
		System.out.println(bean.getNumbers());
		System.out.println(bean.getProps());
		try {
			SimpleInterest si = (SimpleInterest)ctx.getBean("siAbs");
			System.out.println(si.compute(200, 3, 4));
			fail("No Exception...");	
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
		SimpleInterest si = (SimpleInterest)ctx.getBean("si");
		System.out.println(si.compute(200, 3, 4));
	}

	
	
}
