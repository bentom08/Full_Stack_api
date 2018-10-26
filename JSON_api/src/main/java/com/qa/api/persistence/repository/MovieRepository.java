package com.qa.api.persistence.repository;

import java.util.Collection;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;


import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.JSON_api.util.JSONUtil;
import com.qa.api.persistence.domain.Movie;

@Transactional(SUPPORTS)
@Default
public class MovieRepository implements MovieRepoInterface {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	public String getAllMovies() {
		Query query = manager.createQuery("SELECT a FROM Movie a");
		Collection<Movie> movies = (Collection<Movie>) query.getResultList();
		return util.getJSONForObject(movies);
	}
	
	public String getMovie(Long id) {
		Movie movie = findMovie(id);
		return util.getJSONForObject(movie);
	}
	
	@Transactional(REQUIRED)
	public String deleteMovie(Long id) {
		Movie movie = findMovie(id);
		if (movie != null) {
			manager.remove(movie);
		}
		return "{\"message\": \"movie sucessfully deleted\"}";
	}
	
	@Transactional(REQUIRED)
	public String addMovie(String movie) {
		Movie movieObj = util.getObjectForJSON(movie, Movie.class);
		manager.persist(movieObj);
		return "{\"message\": \"movie sucessfully added\"}";
	}
	
	public String updateMovie(String movie, Long id) {
		Movie newMovie = util.getObjectForJSON(movie, Movie.class);
		Movie oldMovie = findMovie(id);
		
		oldMovie.setTitle(newMovie.getTitle());
		oldMovie.setGenre(newMovie.getGenre());
		oldMovie.setAgeRating(newMovie.getAgeRating());
		
		return "{\"message\": \"movie sucessfully updated\"}";
	}
	
	private Movie findMovie(Long id) {
		return manager.find(Movie.class, id);
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}
