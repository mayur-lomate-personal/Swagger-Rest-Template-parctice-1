package com.pers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pers.entities.MyUserDetails;
import com.pers.entities.PracticeLoginUser;
import com.pers.repos.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		PracticeLoginUser user = userRepo.findByUserName(username);
		if(user == null) {
			throw new UsernameNotFoundException("No user found");
		}
		return new MyUserDetails(user);
	}

}
