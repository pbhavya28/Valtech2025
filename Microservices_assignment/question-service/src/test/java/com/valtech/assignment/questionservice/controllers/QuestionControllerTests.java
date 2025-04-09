package com.valtech.assignment.questionservice.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.assignment.questionservice.entities.Question;
import com.valtech.assignment.questionservice.services.QuestionService;
import com.valtech.assignment.questionservice.vos.QuestionVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class QuestionControllerTests {

	@Autowired
	private QuestionService questionService;
	
	@LocalServerPort
	private Integer port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testQuestion() {
		assertEquals(6, questionService.countByTopic("Java"));
	}
	
	@BeforeEach
	public void addQuestions() {
		String url = "http://localhost:"+port+"/api/v1/questions/";
		List questions = restTemplate.getForObject("http://localhost:"+port+"/api/v1/questions/", List.class);
		if(questions.size()> 0) {
//			System.out.println("Adding questions to DB");
//			QuestionVO q1 = restTemplate.postForObject(url,
//					new QuestionVO("How many methods are there in marker interface?","None","One","Two","Many","None","Java"), QuestionVO.class);
//			QuestionVO q2 = restTemplate.postForObject(url,
//					new QuestionVO("What is the superclass of Exception?","Object","Exception","Throwable","Error","Throwable","Java"), QuestionVO.class);
//			QuestionVO q3 = restTemplate.postForObject(url,
//					new Question("How many methods are there in functional interface?","None","One","Two","Many","None","Java"), QuestionVO.class);
//			QuestionVO q4 = restTemplate.postForObject(url,
//					new Question("Can Interface have private methods?","Yes","No","Maybe","No method can be there in an interface","Yes","Java"), QuestionVO.class);
//			QuestionVO q5 = restTemplate.postForObject(url,		
//					new Question("Which subclass of Exception is not checked by comliper?","Exception","RuntimeException","CompiletimeException","Error","RuntimeException","Java"), QuestionVO.class);
		
		}
	} 
}
