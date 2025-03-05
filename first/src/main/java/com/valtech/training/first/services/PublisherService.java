package com.valtech.training.first.services;

import java.util.List;

import com.valtech.training.first.entities.Publisher;

public interface PublisherService {


	List<Publisher> getAllPublisher();
	Publisher savePublisher(Publisher publisher);
//
//	long count();
}
