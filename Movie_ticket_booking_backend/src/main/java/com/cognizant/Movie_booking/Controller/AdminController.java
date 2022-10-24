package com.cognizant.Movie_booking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Movie_booking.models.admin;
import com.cognizant.Movie_booking.models.movies;
import com.cognizant.Movie_booking.service.moviesServiceImpl;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	
	@Autowired
	moviesServiceImpl mService;
	
	@PostMapping("/addmovies")
	public ResponseEntity<Object> postmovies(@RequestBody movies m) {
		if (mService.savemovies(m))
		return new ResponseEntity<Object>("movie Inserted", HttpStatus.CREATED);
		else
		return new ResponseEntity<Object>("Error",HttpStatus.BAD_REQUEST);
		}

	@PostMapping("/deletemovies/{id}")
	public ResponseEntity<Object> deletemovies(@RequestBody int m) {
		if (mService.deleteById(m))
		return new ResponseEntity<Object>("deleted movie", HttpStatus.OK);
		else
		return new ResponseEntity<Object>("Error",HttpStatus.BAD_REQUEST);
		}
	@PostMapping("/Login")
	public ResponseEntity<Object> AdminSignUp(@RequestBody admin a) {

		
		if (validate(a.getAdminId(),a.getPassword())) {
		return new ResponseEntity<>("Admin found", HttpStatus.OK);}
		else {
		return new ResponseEntity<>("Searched Admin Not Found", HttpStatus.NOT_FOUND);
		}
		}

	private boolean validate(String adminId, String password) {
		if(adminId.equals("admin@gmail.com") && password.equals("12345"))
		return true;
		else
		return false;
	}
}
