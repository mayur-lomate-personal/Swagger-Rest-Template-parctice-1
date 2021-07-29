package com.pers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pers.entities.MovieShow;
import com.pers.repos.MovieShowRepo;

@Service
public class MovieShowService {

	@Autowired
	private MovieShowRepo movieShowRepo;
	
	public MovieShow getById(int id) {
		return movieShowRepo.findById(id).orElseThrow(() -> new RuntimeException("Customer Not Found"));
	}
	
	public void addMovieShow(MovieShow movieShow) {
		movieShowRepo.save(movieShow);
	}
	
	public void deleteById(int id) {
		movieShowRepo.deleteById(id);
	}
	
	public void updateMovieShow(MovieShow movieShow) {
		movieShowRepo.save(movieShow);
	}
	
	public List<MovieShow> getMovieShows() {
		return movieShowRepo.findAll();
	}
}
