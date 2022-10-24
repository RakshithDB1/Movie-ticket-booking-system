package com.cognizant.Movie_booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Movie_booking.dao.moviesDaoImpl;
import com.cognizant.Movie_booking.models.movies;



@Service
public class moviesServiceImpl implements moviesService{

	@Autowired
	moviesDaoImpl mDao;

	@Override
	public boolean savemovies(movies movies) {
		// TODO Auto-generated method stub
		return mDao.savemovies(movies);
	}

	@Override
	public movies updatemovies(movies movies) {
		// TODO Auto-generated method stub
		return mDao.updatemovies(movies);
	}

	@Override
	public movies getById(int movie_id) {
		// TODO Auto-generated method stub
		movies movies = mDao.getById(movie_id);
		return movies;
	}

	@Override
	public boolean deleteById(int movie_id) {
		// TODO Auto-generated method stub
		return mDao.deleteById(movie_id);
	}

	@Override
	public List<movies> allmovies() {
		// TODO Auto-generated method stub
		List<movies> movies = mDao.allmovies();
		return movies;
	}

	@Override
	public movies getByname(String mname) {
		// TODO Auto-generated method stub
		return mDao.getByname(mname);
	}

	
	}


