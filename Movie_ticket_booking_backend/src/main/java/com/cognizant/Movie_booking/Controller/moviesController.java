
package com.cognizant.Movie_booking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Movie_booking.models.movies;
import com.cognizant.Movie_booking.service.moviesServiceImpl;


@RestController
@RequestMapping("/api/movie")
public class moviesController {
	
	@Autowired
	moviesServiceImpl moviesService;
	
	@PostMapping("/movies")
    public ResponseEntity<Object> addMovies(@RequestBody movies movies) {

        if( moviesService.savemovies(movies)) 
        	return new ResponseEntity<Object>("movie Inserted", HttpStatus.CREATED);
    	else
    	return new ResponseEntity<Object>("Error",HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/moviesupdate")
    public movies updateMovies(@RequestBody movies movies) {

        return moviesService.updatemovies(movies);

    }

    @GetMapping("/movies/{id}")
    public movies getMovies(@PathVariable("id") int movie_id) {
        return moviesService.getById(movie_id);
    }
    
    @GetMapping("/movies/{mname}")
    public movies getMoviesname(@PathVariable("mname") String movie_name) {
        return moviesService.getByname(movie_name);
    }

    @GetMapping("/movieslist")
    public List<movies> getMovies() {
        return moviesService.allmovies();
    }

    @DeleteMapping("/movies/{id}")
    public boolean deleteMovies(@PathVariable("id") int movie_id){
        return moviesService.deleteById(movie_id);
    }

}
