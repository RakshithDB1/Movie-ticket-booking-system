package com.cognizant.Movie_booking.service;

import java.util.List;

import com.cognizant.Movie_booking.models.payment;

public interface paymentService {

	//public List<payment> getpaymentByuserId(int userId);
	
	public boolean insertpayment(payment p);
	public payment getPaymentByPayment_id(int payment_id);
	public List<payment> getAllpayment();

}
