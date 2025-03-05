package com.valtech.training.first.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.valtech.training.first.entities.Book;
import com.valtech.training.first.rdtos.BookInfoDTO;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

	List<Book>  findAllByYearBetween(int min, int max);
	
	List<Book> findAllByAuthorsId(int authorId);
	
	@Query("select b.price from Book b join b.authors a where a.id = ?1")
	List<Integer> findAllPriceByAuthorsId(int id);
	
	@Query("select new com.valtech.training.first.rdtos.BookInfoDTO(b.publisher.name, b.price) from Book b join b.authors a where a.id=?1")
	List<BookInfoDTO> getBookInfoByAuthor(int id);
	
	//creating class here for simplicity. otherwise should be created in another package.
	
	
}
