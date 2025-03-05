package com.valtech.training.first;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.booleanThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.first.entities.Publisher;
import com.valtech.training.first.services.AuthorService;
import com.valtech.training.first.services.BookService;
import com.valtech.training.first.services.PublisherService;

@SpringBootTest
class PublisherTest {

//	@Autowired
//	private Publisher publisher;
	@Autowired
	private PublisherService publisherService;
	@Autowired
	private BookService bookService;
	@Autowired
	private AuthorService authorService;
	
	@Test
	void test() {
//		publisherService.savePublisher(new Publisher("Hello"));
		assertEquals(8, publisherService.getAllPublisher().size());
////		System.out.println(publisherService.getAllPublisher().size());
		assertEquals(6, bookService.getAllBooks().size());
		assertEquals(6, authorService.getAllAuthors().size());
		assertEquals(5, bookService.getBooksByYearBetween(2000,2006).size());
		System.out.println(bookService.getBookInfoByAuthor(2));
	}

}
