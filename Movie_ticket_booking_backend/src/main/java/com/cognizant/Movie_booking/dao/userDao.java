package com.cognizant.Movie_booking.dao;

import java.util.List;

import com.cognizant.Movie_booking.models.user;

public interface userDao {

	// public List<user> getAlluser();
	

	// List<user> getAlluser();

	public List<user> getAlluser(String email, String password);

	public boolean signupuser(user u);

}
