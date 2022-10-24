package com.cognizant.Movie_booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Movie_booking.dao.paymentDaoImpl;
import com.cognizant.Movie_booking.models.payment;

@Service
public class paymentServiceImpl implements paymentService {
	
	@Autowired
	paymentDaoImpl pDao;
	
	@Override
	public boolean insertpayment(payment p) {
		
		return pDao.Insertpaymentrecord(p);
	}

	@Override
	public payment getPaymentByPayment_id(int payment_id) {
		// TODO Auto-generated method stub
		return pDao.getPaymentByPayment_id(payment_id);
	}

	@Override
	public List<payment> getAllpayment() {
		// TODO Auto-generated method stub
		return pDao.getAllpayment();
	}

}
