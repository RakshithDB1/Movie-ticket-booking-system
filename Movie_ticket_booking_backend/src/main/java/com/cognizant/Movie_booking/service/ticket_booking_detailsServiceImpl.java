package com.cognizant.Movie_booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.Movie_booking.dao.ticket_booking_detailsDaoImpl;
import com.cognizant.Movie_booking.models.ticket_booking_details;
@Repository
public class ticket_booking_detailsServiceImpl implements ticket_booking_detailsService  {

	@Autowired
	ticket_booking_detailsDaoImpl tDao;
	@Override
	public List<ticket_booking_details> getticket_booking_detailsByuserId(int user_Id) {
		// TODO Auto-generated method stub
		return tDao.getAllticket_booking_details();
	}
	@Override
	public boolean addticket(ticket_booking_details t) {
		// TODO Auto-generated method stub
		return tDao.saveticket(t);
	}
	@Override
	public boolean removeticket(int tid, int uid) {
		// TODO Auto-generated method stub
		return tDao.deleteticket(tid, uid);
	}

	
}
