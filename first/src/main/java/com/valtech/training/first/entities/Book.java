package com.valtech.training.first.entities;

import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Book {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bookseq")
	@SequenceGenerator(name = "bookseq",sequenceName = "book_seq",allocationSize = 1)
	private int id;
	private String name;
	private int price;
	private int year;
	@ManyToOne(targetEntity = Publisher.class,cascade = CascadeType.ALL)
	@JoinColumn(name="publisher_id",referencedColumnName = "id")
	private Publisher publisher;
	
	@ManyToMany(targetEntity = Author.class,fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "book_author",joinColumns = @JoinColumn(name = "book_id"),inverseJoinColumns = @JoinColumn(name = "author_id"))
	private List<Author> authors;

	
	
	public Book() {}

	public Book( String name, int price, int year, Publisher publisher) {
		this.name = name;
		this.price = price;
		this.year = year;
		this.publisher = publisher;
	}
	
	public void addAuthor(Author author) {
		if(authors == null) authors = new ArrayList<Author>();
		authors.add(author);
		if(author.getBooks()==null) author.setBooks(new ArrayList<Book>());
		author.getBooks().add(this);
	}
	
	public void removeAuthor(Author author) {
		authors.remove(author);
		author.getBooks().remove(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String book) {
		this.name = book;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
	
	
	

}
