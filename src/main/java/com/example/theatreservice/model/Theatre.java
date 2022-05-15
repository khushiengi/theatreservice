package com.example.theatreservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="THEATRE")
public class Theatre {
	
	
	@Id
	@Column(name="THEATRE_ID")
	public int theatreId;
	
	@Column(name="THEATRE_NAME")
	public String theatreName;
	
	@OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
	public List<MovieShow> shows;
	
	public String city;
	
	public List<MovieShow> getShows() {
		return shows;
	}

	public void setShows(List<MovieShow> shows) {
		this.shows = shows;
	}

	public String country;

}
