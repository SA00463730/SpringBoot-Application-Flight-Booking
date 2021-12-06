package com.airline.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.airline.entity.BookingData;
import com.airline.exceptions.BookingNotAvailableException;
import com.airline.service.UserService;

@RestController
@RequestMapping("v1/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@PostMapping("/book")
	public String bookFlight(@RequestBody BookingData ticket) {
		
		return userService.bookTicket(ticket);
		
	}

	//@CacheEvict(key= "*bookingId", value="bookingStore")
	@DeleteMapping("/cancel/{bookingId}")
	public String CancelTicket(@PathVariable String bookingId) {
		userService.cancelTicket(Integer.parseInt(bookingId));
		return "Ticket Cancelled";
		
	}
	
	//@Cacheable(key="*bookingId", value="bookingStore")
	@GetMapping("/history/{bookingId}")
	public BookingData getHistory(@PathVariable String bookingId) {
		Optional<BookingData> optional= userService.getBookingHistory(Integer.parseInt(bookingId));
		if(optional.isPresent()) {
			return optional.get();
		}else {
			System.out.println("Booking is not available.");
			throw new BookingNotAvailableException("Booking is not available with Id."+bookingId);
			}
	}
	
	@GetMapping("/bookings")
	public List<BookingData> getAllBookings() {
		return userService.getAllBookings();
		
	}

}
