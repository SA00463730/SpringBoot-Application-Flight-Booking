package com.airline.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.airline.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

	 @Query(value = "SELECT * FROM flight WHERE SOURCE = ?1 AND DESTINATION=?2", nativeQuery = true)
	  List<Flight> findByCriteria(String source,String destination);

	 
	 @Modifying
	 @Query(value = "update flight u set u.capacity = (u.capacity-1) where u.fight_id = ?1", nativeQuery = true)
	 void book( int id);
}
