package com.valtech.assignment.quizservice.entities;

import java.util.List;

import com.valtech.assignment.quizservice.vos.QuestionVO;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;

@Entity
public class Quiz {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "quizGen")
	@SequenceGenerator(sequenceName = "quiz_gen", name = "quizGen",allocationSize = 1)
	private int id;
	private int noOfQuestions;
	private String topic;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "quiz_question", joinColumns = @JoinColumn(name="quiz_id"))
	@Column(name = "question_id")
	private List<Integer> quiestionIds;
	
	@ElementCollection
	@CollectionTable(name = "quiz_answer", joinColumns = @JoinColumn(name="quiz_id"))
	@Column(name = "answers")
	private List<String> answers;
//	@ElementCollection(fetch = FetchType.EAGER,targetClass = Question.class)
//	private List<Question> question;

	public Quiz() {}
	
	public Quiz(int noOfQuestions, String topic, List<Integer> quiestionIds, List<String> answers) {

	this.noOfQuestions = noOfQuestions;
	this.topic = topic;
	this.quiestionIds = quiestionIds;
	this.answers = answers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNoOfQuestions() {
		return noOfQuestions;
	}

	public void setNoOfQuestions(int noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public List<Integer> getQuiestionIds() {
		return quiestionIds;
	}

	public void setQuiestionIds(List<Integer> quiestionIds) {
		this.quiestionIds = quiestionIds;
	}

	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
	@Override
	public String toString() {
		return "id "+ id + "noOfQuestions " + noOfQuestions +  "topic" +  topic + "quiestionIds "+ quiestionIds + "answers "+ answers;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public Quiz() {}
//	
//	public Quiz(int id, int noOfQuestions, String topic, List<Question> question) {
//		this.id = id;
//		this.noOfQuestions = noOfQuestions;
//		this.topic = topic;
//		this.question = question;
//	}
//	
//	public Quiz(int noOfQuestions, String topic, List<Question> question) {
//		this.noOfQuestions = noOfQuestions;
//		this.topic = topic;
//		this.question = question;
//	}
//
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public int getNoOfQuestions() {
//		return noOfQuestions;
//	}
//	public void setNoOfQuestions(int noOfQuestions) {
//		this.noOfQuestions = noOfQuestions;
//	}
//	public String getTopic() {
//		return topic;
//	}
//	public void setTopic(String topic) {
//		this.topic = topic;
//	}
//	public List<Question> getQuestion() {
//		return question;
//	}
//	public void setQuestion(List<Question> question) {
//		this.question = question;
//	}
//
//	@Override
//	public String toString() {
//		return "Quiz [id=" + id + ", noOfQuestions=" + noOfQuestions + ", topic=" + topic + ", question=" + question
//				+ "]";
//	}

	
	
	
	
	
	
}
