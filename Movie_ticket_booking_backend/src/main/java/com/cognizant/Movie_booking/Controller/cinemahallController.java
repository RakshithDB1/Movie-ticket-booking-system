package com.cognizant.Movie_booking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Movie_booking.models.cinemahall;
import com.cognizant.Movie_booking.service.cinemahallServiceImpl;

@RestController
@RequestMapping("/api/")
public class cinemahallController {
	
	@Autowired
    cinemahallServiceImpl cinemahallService;
	
	@PostMapping("/cinemahall/ addCinemahall")
	public boolean savecinemahall (@RequestBody cinemahall cinemahall){

        return cinemahallService.savecinemahall(cinemahall);

    }

    @PutMapping("/cinemahall/updateCinemahall")
    public cinemahall updateCinemahall(@RequestBody cinemahall cinemahall) {

        return cinemahallService.updatecinemahall(cinemahall);

    }

    @GetMapping("/cinemahall/{id}")
    public cinemahall getCinemahall(@PathVariable("id") int cinemahall_id) {
        return cinemahallService.getById(cinemahall_id);
    }

    @GetMapping("/cinemahalls")
    public List<cinemahall> getCinemahall() {
        return cinemahallService.allcinemahall();
    }

    @DeleteMapping("/cinemahall/{id}")
    public boolean deleteCinemahall(@PathVariable("id") int cinemahall_id){
        return cinemahallService.deleteById(cinemahall_id);
    }
    
}
