package com.valtech.assignment.questionservice.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.assignment.questionservice.entities.Question;
import com.valtech.assignment.questionservice.repos.QuestionRepo;
import com.valtech.assignment.questionservice.vos.QuestionVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepo questionRepo;
	
	@Override
	public QuestionVO saveOrUpdateQuestion(QuestionVO qvo) {
		return QuestionVO.from(questionRepo.save(qvo.to()));
	}
	@Override
	public QuestionVO getQuestion(int id) {
		return QuestionVO.from(questionRepo.getReferenceById(id));
	}
	@Override
	public List<QuestionVO> getQuestions(){
		return QuestionVO.from(questionRepo.findAll());
	}
	@Override
	public List<QuestionVO> getQuestionsFromTopic(String topic){
		return QuestionVO.from(questionRepo.findAllByTopic(topic));
	}
	@Override
	public Integer countByTopic(String topic) {
		return questionRepo.countByTopic(topic);
	}
	@Override
	public List<QuestionVO> getQuestions(List<Integer> listint) {
		List<Question> qs = questionRepo.findAllById(listint);
	
		return qs.stream().map(q -> QuestionVO.from(q)).collect(Collectors.toList());
	}
}
