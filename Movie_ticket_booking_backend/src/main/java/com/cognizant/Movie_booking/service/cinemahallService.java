package com.cognizant.Movie_booking.service;

import java.util.List;

import com.cognizant.Movie_booking.models.cinemahall;

public interface cinemahallService {
	public boolean savecinemahall(cinemahall cinemahall);
	public cinemahall updatecinemahall(cinemahall cinemahall);
	public cinemahall getById(int cinemahall_id);
	public boolean deleteById(int cinemahall_id);
	public List<cinemahall> allcinemahall();

}