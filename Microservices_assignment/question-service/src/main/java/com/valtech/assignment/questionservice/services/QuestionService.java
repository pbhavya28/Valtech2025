package com.valtech.assignment.questionservice.services;

import java.util.List;

import com.valtech.assignment.questionservice.vos.QuestionVO;

public interface QuestionService {

	QuestionVO saveOrUpdateQuestion(QuestionVO qvo);

	QuestionVO getQuestion(int id);

	List<QuestionVO> getQuestions();

	List<QuestionVO> getQuestionsFromTopic(String topic);

	Integer countByTopic(String string);

	List<QuestionVO> getQuestions(List<Integer> listint);

}