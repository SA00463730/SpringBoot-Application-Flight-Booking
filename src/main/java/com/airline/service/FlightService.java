package com.airline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.entity.Flight;
import com.airline.repository.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	FlightRepository repository;
	
	@Autowired
	FlightBookingImpl flightBookingImpl;

	public List<Flight> getAllFlights() {
		return repository.findAll();
		
	}
	 public Optional<Flight> findFlightById(int id) {
		
		 return repository.findById(id);
	 }
	 
	 public Flight createFlight(Flight flight) {
		 return repository.save(flight);
	 }
	 
	 public void deleteFlight(int id) {
		 repository.deleteById(id);
		 
	 }
	
	public List<Flight> getFlightOnCriteria(String source, String destination) {
		return repository.findByCriteria(source,destination);
	}
	
}
