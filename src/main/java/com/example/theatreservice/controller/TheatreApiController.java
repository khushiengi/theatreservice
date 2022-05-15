package com.example.theatreservice.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.theatreservice.api.TheatreServiceApi;
import com.example.theatreservice.model.MovieShow;
import com.example.theatreservice.model.Theatre;
import com.example.theatreservice.service.TheatreService;

@RestController
public class TheatreApiController implements TheatreServiceApi{
	
	@Autowired
	TheatreService theatreService;
	
	public ResponseEntity<Theatre> setTheatre(@RequestBody Theatre theatre){
		
		theatreService.save(theatre);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(theatre);
	  }

	@Override
	public ResponseEntity<Theatre> createShow(Integer id, MovieShow show) {
		
		Theatre t = theatreService.createShow(id, show);

		return ResponseEntity.status(HttpStatus.CREATED).body(t);
	}

	@Override
	public ResponseEntity<Theatre> deleteShow(Integer id, MovieShow show) {
		
		Theatre t = theatreService.deleteShow(id, show);

		return ResponseEntity.status(HttpStatus.OK).body(t);
	}

	@Override
	public ResponseEntity<List<MovieShow>> getShows(String showName, String city, String selectedDate) {

		List<MovieShow> shows = theatreService.getShows(showName, city, selectedDate);
		
		return ResponseEntity.status(HttpStatus.OK).body(shows);
	}

}
