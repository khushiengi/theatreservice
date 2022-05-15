package com.example.theatreservice.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.theatreservice.service.impl.ListToStringConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="MOVIE_SHOW")
public class MovieShow {
	
	@Id
	@Column(name="ID")
	public int id;
	
	@Column(name="SHOW_NAME")
	public String showName;
	
	@Column(name="SHOW_DATE")
	public Date showDate;
	
	
	@Column(name="SHOW_TIMINGS")
	@Convert(converter = ListToStringConverter.class)
	public List<String> timings;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "THEATRE_ID")
	public Theatre theatre;

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	
}
