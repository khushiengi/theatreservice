package com.example.theatreservice.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.theatreservice.model.MovieShow;
import com.example.theatreservice.model.Theatre;

@Component
public interface TheatreService {
	
	public Theatre save(Theatre theatre);

	public Theatre createShow(Integer id, MovieShow show);

	public Theatre deleteShow(Integer id, MovieShow show);

	public List<MovieShow> getShows(String showName, String city, String selectedDate);

}
