package com.pers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pers.entities.Aadhar;
import com.pers.entities.Customer;
import com.pers.entities.PhoneNumber;
import com.pers.repos.CustomerRepo;
import com.pers.repos.MovieShowRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private MovieShowRepo movieShowRepo;
	
	public Aadhar demo() {
		Customer customer = customerRepo.findById(6L).get();
		Aadhar a = customer.getAadhar();
		customerRepo.deleteById(6L);
		return a;
	}
}
