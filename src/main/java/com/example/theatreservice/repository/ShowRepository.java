package com.example.theatreservice.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.theatreservice.model.MovieShow;

@Repository
public interface ShowRepository extends JpaRepository<MovieShow, Integer> {

	@Query(nativeQuery = true, value="select * from testdb.MOVIE_SHOW m WHERE m.SHOW_NAME=?1 AND m.THEATRE_ID IN (SELECT t.THEATRE_ID from testdb.theatre t where t.city = ?2)")
	List<MovieShow> findShowsByShowNameCityAndDate(String showName, String city, Date date);

}
