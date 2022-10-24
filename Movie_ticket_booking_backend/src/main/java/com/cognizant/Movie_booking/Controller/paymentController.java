package com.cognizant.Movie_booking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Movie_booking.models.payment;
import com.cognizant.Movie_booking.service.paymentServiceImpl;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins="http://localhost:3000")
public class paymentController {
	
	@Autowired
	paymentServiceImpl paymentService;
	
	 @GetMapping("/payment/{id}")
	    public payment getPayment(@PathVariable("id") int payment_id) {
	        return paymentService.getPaymentByPayment_id(payment_id);
	    }

	    @GetMapping("/payment")
	    public List<payment> getAllpayment() {
	        return paymentService.getAllpayment();
	    }
	    
}
