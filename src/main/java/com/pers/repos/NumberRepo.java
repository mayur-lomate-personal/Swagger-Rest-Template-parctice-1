package com.pers.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pers.entities.NumberPk;
import com.pers.entities.PhoneNumber;

@Repository
public interface NumberRepo extends JpaRepository<PhoneNumber, NumberPk> {

}
