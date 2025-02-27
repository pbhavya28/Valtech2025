package com.valtech.training.first;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.valtech.training.first.entities.Question;
import com.valtech.training.first.services.QuestionService;

@SpringBootTest
class FirstApplicationTests {

	@Autowired
	private Arithmetic arithmetic;
	@Autowired
	private SimpleInterest simpleInterest;
	@Autowired
	private QuestionService questionService;
	
	@Test
	void testArithmetic() {
		assertEquals(10, arithmetic.add(4, 6));
		assertEquals(200, simpleInterest.compute(5, 200, 20));
		
	
	}
	
	@Test
	void questionService() {
		
		assertEquals(6, questionService.countByTopic("Java"));
		assertEquals(5, questionService.countByTopic("gk"));
		assertEquals(2, questionService.countByTopicAndQuestionTextContains("Java","Exception"));
		assertEquals(3, questionService.countByTopicAndQuestionTextContainsIgnoreCase("Java","Interface"));
	}
	
	
	@BeforeEach
//	@Rollback
	void initData() {
		System.out.println("Question service class name: "+questionService.getClass().getName());
		long count = questionService.count();
		if (count != 0) return;
	    questionService.saveQuestion
				(new Question("What is the color of sky?","blue","red","yellow","green","blue","gk"));
		 questionService.saveQuestion
				(new Question("What is the color of moon?","blue","red","yellow","white","white","gk"));
		 questionService.saveQuestion
				(new Question("What is the color of mars?","blue","red","yellow","green","red","gk"));
		 questionService.saveQuestion
				(new Question("What is the color of venus?","blue","red","yellow","white","white","gk"));
		 questionService.saveQuestion
				(new Question("What is the color of saturn?","blue","red","yellow","green","yellow","gk"));
		 questionService.saveQuestion
				(new Question("What is the superclass of Exception?","Object","Exception","Throwable","Error","Throwable","Java"));
		 questionService.saveQuestion
				(new Question("Which class is used to create dynamic strings?","String","DynamicString","Builder","StringBuilder","StringBuilder","Java"));
		 questionService.saveQuestion
				(new Question("How many methods are there in marker interface?","None","One","Two","Many","None","Java"));
		 questionService.saveQuestion
				(new Question("How many methods are there in functional interface?","None","One","Two","Many","None","Java"));
		 questionService.saveQuestion
			(new Question("Can Interface have private methods?","Yes","No","Maybe","No method can be there in an interface","Yes","Java"));
		 questionService.saveQuestion
			(new Question("Which subclass of Exception is not checked by comliper?","Exception","RuntimeException","CompiletimeException","Error","RuntimeException","Java"));

//		assertTrue(q.getId()>0);
//		assertEquals(count+1, questionService.count());	
	}

	
}
