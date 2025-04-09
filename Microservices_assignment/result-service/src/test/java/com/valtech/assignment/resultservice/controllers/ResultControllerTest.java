package com.valtech.assignment.resultservice.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.assignment.resultservice.vos.ResultVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ResultControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void test() {
		String url = "http://localhost:"+port+"/api/v1/results/28";	
		ResultVO resultVO = restTemplate.getForObject(url, ResultVO.class);
//		assertEquals(1, resultVO.score());
		}
}
