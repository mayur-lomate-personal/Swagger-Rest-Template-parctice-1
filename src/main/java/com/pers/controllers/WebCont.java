package com.pers.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.pers.entities.Aadhar;
import com.pers.entities.Customer;
import com.pers.entities.MovieShow;
import com.pers.services.CustomerService;
import com.pers.services.MovieShowService;

@Controller
public class WebCont {

	@Autowired
	MovieShowService movieShowService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	RestTemplate restTemplate;
	
	/*@RequestMapping(path = "/")
	@ResponseBody
	public Principal getHi(Principal principal) {
		System.out.println("Hi");
		return principal;
	}*/
	
	@RequestMapping(path="/login")
	public String getLogin(Model model) {
		model.addAttribute("mayur", "may");
		return "login";
	}
	
	@RequestMapping(path = "/hello")
	@ResponseBody
	public List<String> getHello() {
		System.out.println("Hi");
		ArrayList<String> ar = new ArrayList<>();
		ar.add("hello");
		ar.add("welcome");
		return ar;
	}
	
	@RequestMapping(path = "/demo")
	@ResponseBody
	public Aadhar cust() {
		return customerService.demo();
		
	}
	
	@RequestMapping(path = "/logout-success")
	@ResponseBody
	public String logoutSuccess() {
		return "logout sucessfull";
	}
	
	@RequestMapping(path = "/object")
	@ResponseBody
	public Object dis() {
		return new Object() {
			private int mayur = 1;
			private String al = "yt";
			public int getMayur() {
				return mayur;
			}
			public void setMayur(int mayur) {
				this.mayur = mayur;
			}
			public String getAl() {
				return al;
			}
			public void setAl(String al) {
				this.al = al;
			}
		};
	}
	
	@PostMapping(path="/put")
	@ResponseBody
	public MovieShow put(@RequestBody MovieShow movieShow) {
		movieShowService.addMovieShow(movieShow);
		return movieShow;
	}
	
	@GetMapping(path="/find/{id}", produces = "application/json")
	@ResponseBody
	public MovieShow put(@PathVariable Optional<String> id) {
		//System.out.println(movieShowId.get());
		if(id.isPresent()) {
			return movieShowService.getById(Integer.parseInt(id.get()));	
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "MovieShow Not Found");
		
	}
	
	@GetMapping(path = "/mm")
	@ResponseBody
	public MovieShow mm() {
		MovieShow m = restTemplate.getForObject("http://localhost:8090/find/1", MovieShow.class);
		return m;
	}
	
	@GetMapping(path = "welc")
	public String getWelc(Model model) {
		model.addAttribute("mayur", new String("welcome"));
		return "welcome";
	}
	
	@GetMapping(path = "forwarded")
	public String getForwarded(Model model) {
		model.addAttribute("mayur", new String("welcome"));
		return "forward:/welc";
	}
	
	@GetMapping(path = "redirected/internal")
	public String getRedirected(Model model) {
		model.addAttribute("mayur", new String("welcome"));
		return "redirect:/welc";
	}
	
	@GetMapping(path = "redirected/external")
	public String getExternalRedirected(Model model) {
		model.addAttribute("mayur", new String("welcome"));
		return "redirect:https://www.google.com";
	}
	
	@GetMapping(path="/getall")
	@ResponseBody
	public List<MovieShow> getAll() {
		return movieShowService.getMovieShows();
	}
}
