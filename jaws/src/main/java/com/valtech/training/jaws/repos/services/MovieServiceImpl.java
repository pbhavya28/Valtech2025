package com.valtech.training.jaws.repos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.training.jaws.Movie;
import com.valtech.training.jaws.repos.MovieRepo;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepo movieRepo;
	
	@Override
	public Movie createMovie(Movie movie) {
		return movieRepo.save(movie);
	}
	
	@Override
	public Movie getMovie(long id) {
		return movieRepo.getReferenceById(id);
	}
	
	@Override
	public List<Movie> getAllMovies(){
		return movieRepo.findAll();
	}
}
