package com.valtech.training.streamingservice.entities;

import jakarta.persistence.Entity;

@Entity
public class WebSeries extends Content {

	private int episodeCount;
	private int episodeDuration;
	
	public WebSeries(String name, String genre, String language, int episodeCount, int episodeDuration) {
		super(name, genre, language);
		this.episodeCount = episodeCount;
		this.episodeDuration = episodeDuration;
	}

	public WebSeries() {}

	public int getEpisodeCount() {
		return episodeCount;
	}

	public void setEpisodeCount(int episodeCount) {
		this.episodeCount = episodeCount;
	}

	public int getEpisodeDuration() {
		return episodeDuration;
	}

	public void setEpisodeDuration(int episodeDuration) {
		this.episodeDuration = episodeDuration;
	}
	
	
	
	
}
