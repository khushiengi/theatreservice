package com.example.theatreservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.theatreservice.model.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer>{

}
