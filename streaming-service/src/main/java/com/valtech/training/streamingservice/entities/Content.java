package com.valtech.training.streamingservice.entities;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;

@MappedSuperclass
public class Content {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "content_seq")
	@SequenceGenerator(name = "content_seq",sequenceName = "contentSeq",allocationSize = 1)
	private int id;
	private String name;
	private String genre;
	private String language;
	public Content() {}
	public Content(String name, String genre, String language) {
		super();
		this.name = name;
		this.genre = genre;
		this.language = language;
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
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
	
	
}
