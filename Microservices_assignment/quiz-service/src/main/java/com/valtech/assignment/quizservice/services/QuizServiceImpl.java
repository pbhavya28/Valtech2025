package com.valtech.assignment.quizservice.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.assignment.quizservice.entities.Quiz;
import com.valtech.assignment.quizservice.repos.QuizRepo;
import com.valtech.assignment.quizservice.vos.QuestionVO;
import com.valtech.assignment.quizservice.vos.QuizVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepo quizRepo;
	
	@Autowired
	private QuestionClient questionClient;
//	@Override
//	public QuizVO createQuiz(QuizVO qvo) {
//		return QuizVO.from(quizRepo.save(qvo.to()));
//	}
//	@Override
//	public void createQuiz(QuizInputVO qivo) {
//		
//		String topic = qivo.topic();
//	    int count = qivo.count();
//	    
//		Quiz quiz = new Quiz();
//		quiz.setNoOfQuestions(count);
//		quiz.setQuestionVO(getRandomQuestions(topic,count));
//		System.out.println(quiz.getQuestionVO());
//		quizRepo.save(quiz);
//		System.out.println("success");
////		return QuizVO.from(quizRepo.save(quiz));
//	}
//	
//	
//	public QuizVO getQuiz(int id) {
//		return QuizVO.from(quizRepo.getReferenceById(id));
//	}
//	
//	
//	public List<QuestionVO> getRandomQuestions(String topic, int count){
//		
//		List<QuestionVO> quesFromTopic = questionClient.getQuestionsByTopicFromQuestion(topic);
////		Random rand = new Random();
////		List<QuestionVO> randomQues = new ArrayList<>();
////		while (randomQues.size() < count) {
////            int randomIndex = rand.nextInt(quesFromTopic.size()); 
////            randomQues.add(quesFromTopic.get(randomIndex));
////        }
////        List<QuestionVO> randomQuestions = new ArrayList<>(randomQues);
////        return randomQuestions;
//		
//		
////		return quesFromTopic.stream().filter(q -> q.topic().equals("Java")).collect(Collectors.toList());
//		return quesFromTopic;
//}
	
	
	
//	@Override
//	public void createQuiz(QuizInputVO qivo) {
//		
//		String topic = qivo.topic();
//	    int count = qivo.count();
//	    
//		Quiz quiz = new Quiz();
//		quiz.setNoOfQuestions(count);
//		quiz.setTopic(topic);
//		quiz.setQuestion(getRandomQuestions(topic,count));
//		System.out.println(quiz.getQuestion());
//		quizRepo.save(quiz);
//		System.out.println("success");
////		return QuizVO.from(quizRepo.save(quiz));
//	}
	
	
	@Override
	public QuizVO getQuiz(int id) {
		System.out.println("hiii;;;;hellooo");
		Quiz quiz = quizRepo.getReferenceById(id);
		System.out.println("-----------"+quiz.toString());
		return QuizVO.from(quizRepo.getReferenceById(id));
	}
	
	
//	public List<Question> getRandomQuestions(String topic, int count){
		
//		List<Question> quesFromTopic = questionClient.getQuestionsByTopicFromQuestion(topic);
//		Random rand = new Random();
//		List<QuestionVO> randomQues = new ArrayList<>();
//		while (randomQues.size() < count) {
//            int randomIndex = rand.nextInt(quesFromTopic.size()); 
//            randomQues.add(quesFromTopic.get(randomIndex));
//        }
//        List<QuestionVO> randomQuestions = new ArrayList<>(randomQues);
//        return randomQuestions;
		
		
//		return quesFromTopic.stream().filter(q -> q.topic().equals("Java")).collect(Collectors.toList());
//		return quesFromTopic;
//}


	@Override
	public QuizVO createQuiz(QuizVO qivo) { 
		Quiz quiz = qivo.to();
		String topic = quiz.getTopic();
		
		int noOfQuestions = quiz.getNoOfQuestions();
		List<QuestionVO> allQuestions = questionClient.getQuestionsByTopicFromQuestion(topic);
		
		List<Integer> questionIds = getRandomQuestionIds(allQuestions,noOfQuestions);
		quiz.setTopic(topic);
		quiz.setNoOfQuestions(noOfQuestions);
		quiz.setQuiestionIds(questionIds);
		quiz.setAnswers(qivo.answers());
		
		quiz = quizRepo.save(quiz);
		return QuizVO.from(quiz);
	}


	@Override
	public List<Integer> getRandomQuestionIds(List<QuestionVO> allQuestions, int noOfQuestions) {
	
		Collections.shuffle(allQuestions);
		return allQuestions.stream().limit(noOfQuestions).map(QuestionVO::id).collect(Collectors.toList());
	}
	
	@Override
	public List<QuestionVO> getQuesByTopicAndNoOfQue(String topic, int noOfQuestions){
		List<QuestionVO> allQuestions = questionClient.getQuestionsByTopicFromQuestion(topic);
		Collections.shuffle(allQuestions);
		return allQuestions.stream().limit(noOfQuestions).collect(Collectors.toList());
	} 
	
	@Override
	public QuizVO takeQuiz(int quizId,List<String> answers) {
		Quiz quiz = quizRepo.getReferenceById(quizId);
		quiz.setAnswers(answers);
		quiz = quizRepo.save(quiz);
		return QuizVO.from(quiz);		
	}
	
	@Override
	public List<String> getAnswers (int id){
		Quiz quiz = quizRepo.getReferenceById(id);
		return quiz.getAnswers();
	}
	
	@Override
	public List<QuestionVO> getQuestionsByQuiz(int id){
		Quiz quiz = quizRepo.getReferenceById(id);
		return questionClient.getQuestionsByIds(quiz.getQuiestionIds());
	}
	

}
