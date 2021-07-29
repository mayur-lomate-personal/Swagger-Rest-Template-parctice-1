package com.pers.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pers.entities.Aadhar;

@Repository
public interface AadharRepo extends JpaRepository<Aadhar, Long>{

}
