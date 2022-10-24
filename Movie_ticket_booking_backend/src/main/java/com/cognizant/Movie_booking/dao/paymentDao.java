package com.cognizant.Movie_booking.dao;

import java.util.List;
import com.cognizant.Movie_booking.models.payment;

public interface paymentDao {
	
	public List<payment> getAllpayment();
	public payment getPaymentByPayment_id(int payment_id);
	public boolean Insertpaymentrecord(payment p);

}
