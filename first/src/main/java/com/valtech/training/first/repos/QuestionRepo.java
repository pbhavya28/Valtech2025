package com.valtech.training.first.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.first.entities.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long>{

	List<Question> findAllByTopic(String topic);

	long countByTopic(String topic);

	long countByTopicAndQuestionTextContains(String topic, String keyword);

	long countByTopicAndQuestionTextContainsIgnoreCase(String topic, String keyword);
}
