package com.valtech.assignment.questionservice.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.assignment.questionservice.entities.Question;

public record QuestionVO(int id,String questionText, String option1, String option2, String option3, String option4,
		String correctOption, String topic) {

	public static QuestionVO from (Question question) {
		return new QuestionVO(question.getId(),question.getQuestionText(), question.getOption1()
				, question.getOption2(), question.getOption3(), question.getOption4()
				, question.getCorrectOption(), question.getTopic());
	}
	public static List<QuestionVO> from (List<Question> questions){
		return questions.stream().map(question -> QuestionVO.from(question)).collect(Collectors.toList());
	}
	public Question to() {
		return new Question(questionText,option1,option2,option3,option4,correctOption,topic);
	}
}
