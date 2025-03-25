package com.valtech.assignment.quizservice.vos;

import java.util.List;

import com.valtech.assignment.quizservice.entities.Quiz;

//import com.valtech.assignment.quizservice.entities.Question;
//import com.valtech.assignment.quizservice.entities.Quiz;

public record QuizVO(int id,int noOfQuestions, String topic, List<Integer> quiestionIds, List<String> answers) {

//	public static QuizVO from(Quiz quiz) {
//		return new QuizVO(quiz.getId(), quiz.getNoOfQuestions(), quiz.getTopic()
//				,quiz.getQuestionVO());
//	}
//	public Quiz to() {
//		return new Quiz(id,noOfQuestions,topic,questionVO);
//	}
//	public static QuizVO from(Quiz quiz) {
//		return new QuizVO(quiz.getId(), quiz.getNoOfQuestions(), quiz.getTopic()
//				,quiz.getQuestion());
//	}
//	public Quiz to() {
//		return new Quiz(id,noOfQuestions,topic,question);
//	}
	public static QuizVO from(Quiz quiz) {
		return new QuizVO(quiz.getId(),quiz.getNoOfQuestions(),quiz.getTopic(),quiz.getQuiestionIds(),quiz.getAnswers());
	}
	public Quiz to() {
		return new Quiz(noOfQuestions, topic, quiestionIds, answers);
	}
	
	
	
}
