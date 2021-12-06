package com.airline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.entity.BookingData;
import com.airline.repository.BookingRepository;

@Service
public class UserService {
	
	@Autowired
	FlightBookingImpl flightBookingImpl;
	
	@Autowired
	BookingRepository bookingRepo;

		public String bookTicket(BookingData ticket) {
			String status=flightBookingImpl.book(ticket);
			return status;
		}

	public void cancelTicket(int bookingId) {
		bookingRepo.deleteById(bookingId);
	}

	public Optional<BookingData> getBookingHistory(int bookingId) {
		return bookingRepo.findById(bookingId);
		
	}

	public List<BookingData> getAllBookings() {
		
		return bookingRepo.findAll();
	}

}
