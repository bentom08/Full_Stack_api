package com.qa.api.persistence.repository;

public interface MovieRepoInterface {

	String addMovie(String movie);
	
	String getMovie(Long id);
	
	String getAllMovies();
	
	String deleteMovie(Long id);
	
	String updateMovie(String movie, Long id);
}
