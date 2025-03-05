package com.valtech.training.first.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.first.entities.Publisher;
import com.valtech.training.first.repos.PublisherRepo;
import com.valtech.training.first.services.PublisherService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PublisherServiceImpl implements PublisherService {

	@Autowired
	private PublisherRepo publisherRepo;
	
	public List<Publisher> getAllPublisher(){
		return publisherRepo.findAll();
	}

	@Override
	public Publisher savePublisher(Publisher publisher) {
		
		return publisherRepo.save(publisher);
	} 
	
//	@Override
//	public Publisher savePublisher(Publisher publisher) {
//		return publisherRepo.save(publisher);
//		
//	}
//
//	@Override
//	public long count() {
//		return publisherRepo.count();
//	}



}
