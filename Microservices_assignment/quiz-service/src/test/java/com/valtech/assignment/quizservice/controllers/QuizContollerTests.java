package com.valtech.assignment.quizservice.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.assignment.quizservice.services.QuestionClient;
import com.valtech.assignment.quizservice.services.QuizService;
import com.valtech.assignment.quizservice.vos.QuestionVO;
import com.valtech.assignment.quizservice.vos.QuizVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class QuizContollerTests {

	@Autowired
	private QuizService quizService;
	
	@LocalServerPort
	private Integer port;
	
	@Autowired
	private QuestionClient questionClient;
	
	@Autowired
	private TestRestTemplate restTemplate;

//	@Test   
//	public void addQuestions() {
//		int count = 2;
//		String topic = "Java";
//		String url = "http://localhost:"+port+"/api/v1/quizes/";
////		List questions = restTemplate.getForObject(url, List.class);
//		
//		QuizVO q1 = restTemplate.postForObject(url, new QuizInputVO("Java",2),QuizVO.class);
//		System.out.println("helloooooooooooooooooooooooooooo");		
//	
//	} 
	@Test
	public void testGeneratedQuiz() { 
		String url = "http://localhost:"+port+"/api/v1/quizes/";
		QuizVO quiz = restTemplate.postForObject(url, new QuizVO(0,2,"Java",null,null), QuizVO.class);
	}
	
	@Test
	public void testTakeQuiz() {
		String url = "http://localhost:"+port+"/api/v1/quizes/takequiz/28";
//		QuizVO qvo = quizService.takeQuiz(28, List.of("Throwable","None"));
		QuizVO quiz = restTemplate.postForObject(url, List.of("Object","None"), QuizVO.class);
	}
	
	@Test
	public void testGetQuestionsForQuiz() {
		String url = "http://localhost:"+port+"/api/v1/quizes/28/questions";
//		QuestionVO[] qs = Arrays.asList(restTemplate.getForObject(url, QuestionVO[].class));
//		List<QuestionVO> questions = List.of(qs);
		
//		List<QuestionVO> que = Arrays.asList(restTemplate.getForObject(url, QuestionVO[].class));
//    	System.out.println("........................"+que);
//		QuestionVO que = restTemplate.getForObject(url, QuestionVO.class);
		
//		List<Object> que = Arrays.asList(restTemplate.getForObject(url,QuestionVO[].class));
		System.out.println("-------------0000-----------------");

		QuizVO qvo = quizService.getQuiz(28);
		System.out.println("-------------0000-----------------"+qvo.toString());
		
		
		System.out.println("bakaaaaaaaaaaaaaaaaaaaaaa"+ qvo.quiestionIds());
		System.out.println(questionClient.getQuestionsByIds(qvo.quiestionIds()) + "ooooooooooooooooo");
		System.out.println("********************");
		
	} 
	
		@Test
		public void getQuiz() {
		String url = "http://localhost:"+port+"/api/v1/quizes/28";
		QuizVO questions = restTemplate.getForObject(url, QuizVO.class);
		System.out.println("dddd" +questions.noOfQuestions() + questions.id() + questions.topic() +questions.quiestionIds());
	}
	
}
