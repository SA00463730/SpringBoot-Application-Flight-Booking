package com.airline.exceptions;

public class BookingNotAvailableException extends RuntimeException {

	public BookingNotAvailableException() {
		super();
	}

	public BookingNotAvailableException(String message) {
		super(message);
	}

	public BookingNotAvailableException(Exception exception) {
		super(exception);
	}

	public BookingNotAvailableException(String message, Exception exception) {
		super(message,exception);
	}

	
}
