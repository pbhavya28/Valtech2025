package com.valtech.training.jaws.repos.services;

import java.util.List;

import com.valtech.training.jaws.Movie;

public interface MovieService {

	Movie createMovie(Movie movie);

	Movie getMovie(long id);

	List<Movie> getAllMovies();

}