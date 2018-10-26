package com.qa.api.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.api.business.MovieServiceInterface;

@Path("/movie")
public class MovieEndPoint {
	
	@Inject
	private MovieServiceInterface service;

	@Path("/getAllMovies")
	@GET
	@Produces({ "application/json" })
	public String getAllMovies() {
		return service.getAllMovies();
	}
	
	@Path("/getMovie/{id}")
	@GET
	@Produces({ "application/json" })
	public String getMovie(@PathParam("id") Long id) {
		return service.getMovie(id);
	}
	
	@Path("/addMovie")
	@POST
	@Produces({ "application/json" })
	public String addMovie(String movie) {
		return service.addMovie(movie);
	}
	
	@Path("/deleteMovie/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteMovie(@PathParam("id") Long id) {
		return service.deleteMovie(id);
	}
	
	@Path("/updateMovie/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateMovie(String movie, @PathParam("id") Long id) {
		return service.updateMovie(movie, id);
	}
	
	public void setService(MovieServiceInterface service) {
		this.service = service;
	}
}
