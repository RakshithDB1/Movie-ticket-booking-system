package com.cognizant.Movie_booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cognizant.Movie_booking.dao.userDao;
import com.cognizant.Movie_booking.dao.userDaoImpl;
import com.cognizant.Movie_booking.models.user;

@Service
public class userServiceImpl implements userService {
	@Autowired
	userDaoImpl uDao;
	@Override
	public user getuserByemailandpassword(String email, String password) {
		List<user> useritem = uDao.getAlluser(email, password);
		return useritem.get(0);

	}

	@Override
	public boolean signup(user u) {

		return uDao.signupuser(u);
	}

}
