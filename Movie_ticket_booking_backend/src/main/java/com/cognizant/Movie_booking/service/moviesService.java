package com.cognizant.Movie_booking.service;

import java.util.List;

import com.cognizant.Movie_booking.models.movies;


public interface moviesService {

	public boolean savemovies(movies movies);
	public movies updatemovies(movies movies);
	public movies getById(int movie_id);
	public boolean deleteById(int movie_id);
	public List<movies> allmovies();
	public movies getByname(String mname);

}
