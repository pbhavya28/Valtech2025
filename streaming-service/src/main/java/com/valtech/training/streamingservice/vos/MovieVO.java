package com.valtech.training.streamingservice.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.streamingservice.entities.Movie;

public record MovieVO(int id,String name, String genre, String language, int duration, int costPerView) {

	public static MovieVO from(Movie movie) {
		return new MovieVO(movie.getId(), movie.getName(), movie.getGenre(), movie.getLanguage(), movie.getDuration(), movie.getCostPerView());
	}
	public static List<MovieVO> from (List<Movie> movies){
		return movies.stream().map(movie -> MovieVO.from(movie)).collect(Collectors.toList());
	}
	public Movie to () {
		return new Movie(name,genre,language,duration,costPerView);
	}
}
