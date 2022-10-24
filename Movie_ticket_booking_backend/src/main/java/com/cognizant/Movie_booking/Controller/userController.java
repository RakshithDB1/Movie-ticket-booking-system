package com.cognizant.Movie_booking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Movie_booking.models.payment;
import com.cognizant.Movie_booking.models.ticket_booking_details;
import com.cognizant.Movie_booking.models.user;
import com.cognizant.Movie_booking.service.paymentServiceImpl;
import com.cognizant.Movie_booking.service.ticket_booking_detailsServiceImpl;
//import com.cognizant.Movie_booking.service.userService;
import com.cognizant.Movie_booking.service.userServiceImpl;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class userController {
	@Autowired
	private userServiceImpl userService;
	
	@Autowired
	private ticket_booking_detailsServiceImpl t;
	
	@Autowired
	private paymentServiceImpl paymentService;
	
	@GetMapping("/signin/{email}/{password}")
	
	public ResponseEntity<Object> validateandgetuser(@PathVariable String password,@PathVariable String email) {
		
		 
		 user u =userService.getuserByemailandpassword(email, password);
		 if(u==null)
			 return new ResponseEntity<>("Searched user Not Found", HttpStatus.NOT_FOUND);
		 return new ResponseEntity<>(u, HttpStatus.OK);
		 
		 
		
	}
	
	@PostMapping("/signup")
	public ResponseEntity<Object> postCustomer(@RequestBody user u2) {
	if (userService.signup(u2))
	return new ResponseEntity<Object>("user Inserted", HttpStatus.CREATED);
	else
	return new ResponseEntity<Object>("Error",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/profile")
	public ResponseEntity<Object> profilepage(@RequestBody user u) {
		
		 user up =userService.getuserByemailandpassword(u.getUser_email(), u.getUser_password());
		 if(up==null)
			 return new ResponseEntity<>("Searched user Not Found", HttpStatus.NOT_FOUND);
		 return new ResponseEntity<>(up, HttpStatus.OK);
	}
	
	@PostMapping("/payment")
	public ResponseEntity<Object> postpayment(@RequestBody payment p) {
	if (paymentService.insertpayment(p))
	return new ResponseEntity<Object>("payment Inserted", HttpStatus.CREATED);
	else
	return new ResponseEntity<Object>("Error",HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/addticket")
	public ResponseEntity<Object> postticket(@RequestBody ticket_booking_details tb) {
		if (t.addticket(tb))
		return new ResponseEntity<Object>("ticket Inserted", HttpStatus.CREATED);
		else
		return new ResponseEntity<Object>("Error",HttpStatus.BAD_REQUEST);
		}
	@DeleteMapping("/addticket/{bid}/{uid}")
	public ResponseEntity<Object> deleteticket(@RequestBody int uid,int bid ) {
		if (t.removeticket(bid, uid))
		return new ResponseEntity<Object>("ticket Inserted", HttpStatus.CREATED);
		else
		return new ResponseEntity<Object>("Error",HttpStatus.BAD_REQUEST);
		}
}
