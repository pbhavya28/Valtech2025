package com.valtech.training.streamingservice.services;

import java.util.List;

import com.valtech.training.streamingservice.vos.MovieVO;

public interface MovieService {

	MovieVO saveMovie(MovieVO mvo);

	MovieVO getMovie(int id);

	List<MovieVO> getAllMovies();

	List<MovieVO> getAllMoviesByGenre(String genre);

	List<MovieVO> findAllByDuration(int duration);

}