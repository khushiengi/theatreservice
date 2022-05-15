package com.example.theatreservice.api;

import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.theatreservice.model.MovieShow;
import com.example.theatreservice.model.Theatre;

@RestController
public interface TheatreServiceApi {

	@GetMapping("/pingtheatre")
	public default String ping() {

		return "ping Theatre";
	}

	@PostMapping(path = "/addTheatre", consumes = "application/json")
	public ResponseEntity<Theatre> setTheatre(@RequestBody Theatre theatre);

	// create Show
	@PostMapping(path = "theatre/{id}/createShow", consumes = "application/json")
	public ResponseEntity<Theatre> createShow(@PathVariable("id") Integer id, @RequestBody MovieShow show);

	// update show

	// delete show
	@DeleteMapping(path = "theatre/{id}/deleteShow", consumes = "application/json")
	public ResponseEntity<Theatre> deleteShow(@PathParam("id") Integer id, @RequestBody MovieShow show);
	
	@GetMapping(path = "getShows/showName/{showName}/city/{city}/selectedDate/{selectedDate}")
	public ResponseEntity<List<MovieShow>> getShows(@PathVariable("showName") String showName, @PathVariable("city") String city, @PathVariable("selectedDate") String selectedDate);

}
