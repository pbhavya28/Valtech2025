package com.valtech.assignment.quizservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.assignment.quizservice.entities.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Integer> {

}
