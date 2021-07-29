package com.pers.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pers.entities.PracticeLoginUser;

@Repository
public interface UserRepo extends JpaRepository<PracticeLoginUser, String>{
	
	public PracticeLoginUser findByUserName(String userName);
}
