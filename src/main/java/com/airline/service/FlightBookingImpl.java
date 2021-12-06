package com.airline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.airline.entity.BookingData;
import com.airline.entity.Flight;
import com.airline.repository.BookingRepository;
import com.airline.repository.FlightRepository;

@Component
public class FlightBookingImpl {
	
	@Autowired
	FlightRepository flightRepo;
	
	@Autowired
	BookingRepository bookingRepo;

	@Transactional
	String book(BookingData ticket) {
		Flight flight=flightRepo.getById(ticket.getFlightId());
		if (flight.getCapacity()>0) {
		
		flight.setCapacity(flight.getCapacity()-1);
			flightRepo.save(flight);
			bookingRepo.save(ticket);
			return "confirmed";
		}
		return "Not Confirmed";
	}

}
