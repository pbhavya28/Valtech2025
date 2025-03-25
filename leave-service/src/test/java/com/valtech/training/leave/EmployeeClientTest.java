package com.valtech.training.leave;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.leave.services.EmployeeClient;

@SpringBootTest
class EmployeeClientTest {

	@Autowired
	
	EmployeeClient client;
	
	@Test
	void test() {
		assertEquals(6, client.getManager(7));
		assertEquals(6, client.getManager(7));
		assertEquals(7, client.getManager(10));
	}

}
