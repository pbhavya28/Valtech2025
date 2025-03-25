package com.valtech.training.employee.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.employee.vos.EmployeeVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class EmployeeControllerTests {

	@LocalServerPort
	private Integer port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void addEmplyoees() {
		List emps = restTemplate.getForObject("http://localhost:"+port+"/api/v1/employees/", List.class);
		if(emps.size() == 0) {
			System.out.println("Adding employees to DB");
			EmployeeVO manager = restTemplate.postForObject("http://localhost:"+port+"/api/v1/employees/",
					new EmployeeVO(0, "Abc", 1234567, "abc@jj.ll", 0), EmployeeVO.class);
			EmployeeVO manager1 = restTemplate.postForObject("http://localhost:"+port+"/api/v1/employees/",
					new EmployeeVO(0, "Def", 1234567, "def@jj.ll", manager.id()), EmployeeVO.class);
			EmployeeVO emp1 = restTemplate.postForObject("http://localhost:"+port+"/api/v1/employees/",
					new EmployeeVO(0, "Pqr", 1234567, "pqr@jj.ll", manager1.id()), EmployeeVO.class);
			EmployeeVO emp2 = restTemplate.postForObject("http://localhost:"+port+"/api/v1/employees/",
					new EmployeeVO(0, "Xyz", 1234567, "xyz@jj.ll", manager.id()), EmployeeVO.class);
			EmployeeVO emp3 = restTemplate.postForObject("http://localhost:"+port+"/api/v1/employees/",
					new EmployeeVO(0, "Lmn", 1234567, "lmn@jj.ll", manager1.id()), EmployeeVO.class);
			
		}
	}

}
