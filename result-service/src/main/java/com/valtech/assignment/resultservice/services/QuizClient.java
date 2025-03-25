package com.valtech.assignment.resultservice.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.valtech.assignment.resultservice.vos.QuizVO;


@Component
public class QuizClient {

	public List<String> getSubmittedAnswers (int id){
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:9050/api/v1/quizes/answers/"+id;
//		QuizVO qvo = restTemplate.getForObject(url, QuizVO.class);
//		List<String> answers = qvo.answers();
//		return answers;
		List<String> answers = restTemplate.getForObject(url, List.class);
		return answers;
	}
	public List<Integer> getQuestionIdsFromQuiz(int quizId){
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:9050/api/v1/quizes/"+quizId+"/questions";
		List<QuizVO> qvo = Arrays.asList(restTemplate.getForObject(url, QuizVO[].class));
		System.out.println("checking--checking--checking----"+qvo.size() + "jj" +qvo.toString());
		return qvo.stream().map(que -> que.id()).collect(Collectors.toList());
//		List<Integer> ids = qvo.quiestionIds();
//		return List.of(22,23);
//		return ids;
	}
	
}
