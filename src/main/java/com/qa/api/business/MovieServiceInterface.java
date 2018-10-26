package com.qa.api.business;

public interface MovieServiceInterface {

	String getAllMovies();
	
	String getMovie(Long id);
	
	String addMovie(String movie);
	
	String deleteMovie(Long id);
	
	String updateMovie(String movie, Long id);
}
