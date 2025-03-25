package com.valtech.assignment.quizservice.services;

import java.util.List;

import com.valtech.assignment.quizservice.vos.QuestionVO;
import com.valtech.assignment.quizservice.vos.QuizVO;

public interface QuizService {

//	QuizVO createQuiz(QuizVO qvo);

	QuizVO getQuiz(int id);

//	QuizVO createQuiz(String topic, int count);

//	QuizVO createQuiz(QuizInputVO qivo);
//	void createQuiz(QuizInputVO qivo);

//	QuizVO createQuiz(QuizVO qivo);

	List<QuestionVO> getQuestionsByQuiz(int id);

	List<String> getAnswers(int id);

	QuizVO takeQuiz(int quizId, List<String> answers);

	List<QuestionVO> getQuesByTopicAndNoOfQue(String topic, int noOfQuestions);

	List<Integer> getRandomQuestionIds(List<QuestionVO> allQuestions, int noOfQuestions);

	QuizVO createQuiz(QuizVO qivo);

//	QuizVO getQuiz(int id);

}