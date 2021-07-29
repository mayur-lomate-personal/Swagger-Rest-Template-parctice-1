package com.pers.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pers.entities.MovieShow;

@Repository
public interface MovieShowRepo  extends JpaRepository<MovieShow, Integer>{

	public List<MovieShow> findAll();
	
}
