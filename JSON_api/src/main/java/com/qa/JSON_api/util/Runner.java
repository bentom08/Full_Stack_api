package com.qa.JSON_api.util;

import com.qa.api.persistence.domain.Movie;

public class Runner {

	public static void main(String[] args) {
		JSONUtil util = new JSONUtil();
		Movie movie = new Movie("Good Will Hunting", "Drama", "15");
		
		System.out.println(util.getJSONForObject(movie));

	}

}
