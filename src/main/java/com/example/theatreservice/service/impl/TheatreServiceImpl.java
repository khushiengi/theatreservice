package com.example.theatreservice.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.theatreservice.model.MovieShow;
import com.example.theatreservice.model.Theatre;
import com.example.theatreservice.repository.ShowRepository;
import com.example.theatreservice.repository.TheatreRepository;
import com.example.theatreservice.service.TheatreService;

@Component
public class TheatreServiceImpl implements TheatreService{
	
	@Autowired
	TheatreRepository theatreRepository;
	
	@Autowired
	ShowRepository showRepo;

	@Override
	public Theatre save(Theatre theatre) {
		Theatre t = theatreRepository.save(theatre);
		
		//Logic added to update theatre_id in Show 
		List<MovieShow> shows = t.getShows();
		for(MovieShow m : shows) {
			if(m.getTheatre() == null ) {
				m.setTheatre(t);
				showRepo.save(m);
			}
			
			
		}
		
		return t;
	}

	@Override
	public Theatre createShow(Integer id, MovieShow show) {

		Theatre theatre = theatreRepository.getById(id);
		theatre.getShows().add(show);
		
		return save(theatre);
	}

	@Override
	public Theatre deleteShow(Integer id, MovieShow show) {
		Theatre theatre = theatreRepository.getById(id);
		theatre.getShows().remove(show);
		
		return save(theatre);
	}

	@Override
	public List<MovieShow> getShows(String showName, String city, String selectedDate) {

		  
		
		try {
			return showRepo.findShowsByShowNameCityAndDate(showName,city,new SimpleDateFormat("yyyy-mm-dd").parse(selectedDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		//return null;
	}
	
	

}
