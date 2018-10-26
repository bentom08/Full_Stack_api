package com.qa.api.business;

import javax.inject.Inject;

import com.qa.api.persistence.repository.MovieRepoInterface;

public class MovieService implements MovieServiceInterface {
	
	@Inject
	private MovieRepoInterface repo;
	
	public String getAllMovies() {
		return repo.getAllMovies();
	}
	
	public String getMovie(Long id) {
		return repo.getMovie(id);
	}
	
	public String addMovie(String movie) {
		return repo.addMovie(movie);
	}
	
	public String deleteMovie(Long id) {
		return repo.deleteMovie(id);
	}
	
	public String updateMovie(String movie, Long id) {
		return repo.updateMovie(movie, id);
	}
	
	public void setRepo(MovieRepoInterface repo) {
		this.repo = repo;
	}

}
