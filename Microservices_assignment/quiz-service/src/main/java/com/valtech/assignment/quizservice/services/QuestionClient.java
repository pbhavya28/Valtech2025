package com.valtech.assignment.quizservice.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.valtech.assignment.quizservice.vos.QuestionVO;


@Component
public class QuestionClient 

{

	String url = "http://localhost:9030/api/v1/questions/";
	public List<QuestionVO> getQuestionsByTopicFromQuestion(String topic) {
		RestTemplate temp = new RestTemplate();
		String url1 = url+"topic/"+topic;
		List<QuestionVO> questions = Arrays.asList(temp.getForObject(url1,QuestionVO[].class));
		return questions;
	}

	public List<QuestionVO> getQuestionsByIds(List<Integer> quiestionIds) {
		System.out.println("********************"+quiestionIds);
		RestTemplate temp = new RestTemplate();
		System.out.println("bakwassssssssssss"+quiestionIds.stream().map(String::valueOf).collect(Collectors.joining(",")));
		String url2 = url + "questions/"+quiestionIds.stream().map(String::valueOf).collect(Collectors.joining(","));
		System.out.println("here..........here................");
//		String url2 = url + "ids/"+quiestionIds;

		List<QuestionVO> questions = Arrays.asList(temp.getForObject(url2,QuestionVO[].class));

		return questions;
	}

//	public List<QuestionVO> getQuestionsByTopicFromQuestion(String topic) {
//		// TODO Auto-generated method stub
//		return null;
	
}
