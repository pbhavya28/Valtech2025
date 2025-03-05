package webservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieServiceImpl implements MovieService {

	private List<Movie> movies = new ArrayList<Movie>();
	
	@Override
	public List<Movie> getAllMovies(){
		return movies;
	}
	
	@Override
	public Movie getMovie(int id) {
		/*
		 * Optional API
		Optional<Movie> empty = Optional.empty();
		Optional<Movie> noIdea = Optional.ofNullable(obj);
		Optional<Movie> available = Optional.of(new Movie());
		*/
		Optional<Movie> movie =  movies.stream().filter(m -> m.getId()==id).findFirst();
		if(movie.isPresent()) return movie.get();
		return new Movie();
	}
	
	@Override
	public void addMovie(Movie movie) {
		movies.add(movie);
	}
	
	@Override
	public void removeMovie(Movie movie) {
		movies.remove(movie);
	}
}
