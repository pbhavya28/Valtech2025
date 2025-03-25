package com.valtech.training.streamingservice.entities;

import jakarta.persistence.Entity;

@Entity
public class Movie extends Content {

	private int duration;
	private int costPerView;

	public Movie() {}

	

	public Movie(String name, String genre, String language, int duration, int costPerView) {
		super(name, genre, language);
		this.duration = duration;
		this.costPerView = costPerView;
	}



	public Movie(int duration) {
		this.duration = duration;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getCostPerView() {
		return costPerView;
	}

	public void setCostPerView(int costPerView) {
		this.costPerView = costPerView;
	}
	
	
	
	
}
