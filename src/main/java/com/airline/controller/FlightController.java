package com.airline.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airline.entity.BookingData;
import com.airline.entity.Flight;
import com.airline.exceptions.FlightNotAvailableException;
import com.airline.service.FlightService;

@RestController
@RequestMapping("/v1/api/flight")
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	/*
	 * @GetMapping("/greet/{user}") public String greet(@PathVariable String user) {
	 * System.out.println(new Date().toString()); return "welcome" + user; }
	 */
	
	@GetMapping("")
	public List<Flight> getAllFlights() {
		
		return flightService.getAllFlights();
	}
	
	@Cacheable(key="*id", value="flightStore")
	@GetMapping("/{id}")
	public Flight findFlightById(@PathVariable int id) {
		
		Optional<Flight> optional= flightService.findFlightById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			System.out.println("Flight is not available.");
			throw new FlightNotAvailableException("Flight is not available.");
			}
	}
	
	@GetMapping("/getFlightBySrcAndDesti")
	public List<Flight> getFlightBySrcAndDestiAndDate(@RequestParam String source,
			@RequestParam(required=false) String destination ) {
		return flightService.getFlightOnCriteria(source,destination);
	}
	

	@PostMapping("")
	public Flight createFlight(@RequestBody Flight flight) {
		System.out.println("save flight in db: "+flight);
		return flightService.createFlight(flight);
		
	}
	
	/*
	 * @PutMapping("/UpdateFlight/{id}") public Flight
	 * UpdateFlightById(@PathVariable int id) {
	 * System.out.println("inside controller"); Flight flight = new Flight(); return
	 * null; }
	 */
	
	@CacheEvict(key= "*id", value="flightStore")
	@DeleteMapping("/deleteFlight/{id}")
	public void deleteFlightById(@PathVariable int id) {
		flightService.deleteFlight(id);
	}
	
	
	
}
