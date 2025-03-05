package com.valtech.training.first.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.first.entities.Book;
import com.valtech.training.first.entities.Publisher;
import com.valtech.training.first.rdtos.BookInfoDTO;
import com.valtech.training.first.repos.BookRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRepo;
	
	@Override
	public Book saveBook(Book book) {
		return bookRepo.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}

	@Override
	public List<Book> getBooksByYearBetween(int i, int j) {
		return bookRepo.findAllByYearBetween(i, j);
	}
	
	@Override
	public List<Integer> findAllPriceByAuthorsId(int id){
		return bookRepo.findAllPriceByAuthorsId(id);
		
	}
	@Override
	public List<BookInfoDTO> getBookInfoByAuthor(int id){
		return bookRepo.getBookInfoByAuthor(id);
	}

	
}
