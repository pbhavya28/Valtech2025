package com.valtech.training.first.services;

import java.util.List;

import com.valtech.training.first.entities.Book;
import com.valtech.training.first.entities.Publisher;
import com.valtech.training.first.rdtos.BookInfoDTO;

public interface BookService {

	Book saveBook(Book book); 
	List<Book> getAllBooks();
	List<Book> getBooksByYearBetween(int i, int j);
	List<Integer> findAllPriceByAuthorsId(int id);
	List<BookInfoDTO> getBookInfoByAuthor(int id);
	
}
