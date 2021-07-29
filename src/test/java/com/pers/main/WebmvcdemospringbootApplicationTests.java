package com.pers.main;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.pers.entities.MovieShow;
import com.pers.repos.MovieShowRepo;
import com.pers.services.MovieShowService;

@SpringBootTest
class WebmvcdemospringbootApplicationTests {

	@Autowired
	private MovieShowService movieShowService;
	
	@MockBean
	private MovieShowRepo movieShowRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void movieShowServiceTest() {
		when(movieShowRepo.findAll()).thenReturn(Stream.of(new MovieShow(), new MovieShow()).collect(Collectors.toList()));
		assertEquals(2, movieShowService.getMovieShows().size());
		verify(movieShowRepo).findAll();
	}

	@Test
	public void movieShowServiceTest2() {
		MovieShow m1 = new MovieShow();
		//doNothing().when(movieShowRepo).save(Matchers.<MovieShow>any());
		when(movieShowRepo.save(Matchers.<MovieShow>any())).thenReturn(m1);
		movieShowService.addMovieShow(m1);
		System.out.println(verify(movieShowRepo).save(Matchers.<MovieShow>any()));
	}

}
