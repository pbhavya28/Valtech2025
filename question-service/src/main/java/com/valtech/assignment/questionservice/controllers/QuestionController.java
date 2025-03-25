package com.valtech.assignment.questionservice.controllers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.assignment.questionservice.services.QuestionService;
import com.valtech.assignment.questionservice.vos.QuestionVO;


@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@PostMapping("/")
	public QuestionVO createQuestion(@RequestBody QuestionVO questionVO) {
		return questionService.saveOrUpdateQuestion(questionVO);
	}
	
	@GetMapping("/{id}")
	public QuestionVO getQuestion(@PathVariable("id") int id) {
		return questionService.getQuestion(id);
	}
	
	@GetMapping("/")
	public List<QuestionVO> getAllQuestions(){
		return questionService.getQuestions();
	}
	
	@GetMapping("/topic/{topic}")
	public List<QuestionVO> getAllQuestionsByTopic(@PathVariable("topic") String topic){
		return questionService.getQuestionsFromTopic(topic);
	}
	@GetMapping("/questions/{ids}")
	public List<QuestionVO> getQuestionsOfQuiz(@PathVariable("ids") String ids){
		System.out.println("Inside Question controller............");
		List<Integer> listint = Arrays.stream(ids.split(",")).map(Integer::parseInt)
				.collect(Collectors.toList());
		
		return questionService.getQuestions(listint);
	}
}
