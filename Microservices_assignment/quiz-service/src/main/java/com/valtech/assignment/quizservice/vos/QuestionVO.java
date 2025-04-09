package com.valtech.assignment.quizservice.vos;

import jakarta.persistence.Embeddable;

//@Embeddable
public record QuestionVO(int id,String questionText, String option1, String option2, String option3, String option4,
		String correctOption, String topic) {

}
