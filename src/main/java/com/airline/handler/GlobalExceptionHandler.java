package com.airline.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.airline.exceptions.BookingNotAvailableException;
import com.airline.exceptions.FlightNotAvailableException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(FlightNotAvailableException.class)
	public ResponseEntity<MyExceptionResponse> handleFlightException(FlightNotAvailableException e) {
		System.out.println("Flight is not avaialble. Exception occured.");
		return new ResponseEntity<MyExceptionResponse>(new MyExceptionResponse(e.getMessage(),500,LocalDateTime.now(),e), HttpStatus.OK);
	}
	
	@ExceptionHandler(BookingNotAvailableException.class)
	public ResponseEntity<MyExceptionResponse> handleFlightException(BookingNotAvailableException e) {
		System.out.println("Booking is not avaialble. Exception occured.");
		return new ResponseEntity<MyExceptionResponse>(new MyExceptionResponse(e.getMessage(),500,LocalDateTime.now(),e), HttpStatus.OK);
	}

}
