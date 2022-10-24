package com.cognizant.Movie_booking.service;

import java.util.List;

import com.cognizant.Movie_booking.models.ticket_booking_details;

public interface ticket_booking_detailsService {

	public List<ticket_booking_details> getticket_booking_detailsByuserId(int user_Id);
	
	public boolean addticket(ticket_booking_details t);
	
	public boolean removeticket(int tid,int uid);

}
