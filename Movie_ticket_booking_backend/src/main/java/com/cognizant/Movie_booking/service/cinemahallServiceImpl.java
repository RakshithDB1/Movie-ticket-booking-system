package com.cognizant.Movie_booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Movie_booking.dao.cinemahallDaoImpl;
import com.cognizant.Movie_booking.models.cinemahall;

@Service
public class cinemahallServiceImpl implements cinemahallService{

	@Autowired
	cinemahallDaoImpl cDao;
	
	@Override
	public boolean savecinemahall(cinemahall cinemahall) {
		// TODO Auto-generated method stub
		return cDao.savecinemahall(cinemahall);
	}

	@Override
	public cinemahall updatecinemahall(cinemahall cinemahall) {
		// TODO Auto-generated method stub
		return cDao.updatecinemahall(cinemahall);
	}

	@Override
	public cinemahall getById(int cinemahall_id) {
		// TODO Auto-generated method stub
		cinemahall cinemahall = cDao.getById(cinemahall_id);
		return cinemahall;
	}

	@Override
	public boolean deleteById(int cinemahall_id) {
		// TODO Auto-generated method stub
		return cDao.deleteById(cinemahall_id);
	}

	@Override
	public List<cinemahall> allcinemahall() {
		// TODO Auto-generated method stub
		List<cinemahall> cinemahall = cDao.allcinemahall();
		return cinemahall;
	}

}