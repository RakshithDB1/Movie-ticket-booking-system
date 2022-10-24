package com.cognizant.Movie_booking.service;


import java.util.List;

import com.cognizant.Movie_booking.models.user;

public interface userService {

	public user getuserByemailandpassword(String email, String password);
	
	public boolean signup(user u);
	

}
