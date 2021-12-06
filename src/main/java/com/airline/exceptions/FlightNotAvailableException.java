package com.airline.exceptions;

public class FlightNotAvailableException extends RuntimeException {
	
	
	public FlightNotAvailableException() {
		super();  
	}
	public FlightNotAvailableException(String errorMessage) {
		super(errorMessage);  
	}
	public FlightNotAvailableException(Exception e) {
		super(e);  
	}

	public FlightNotAvailableException(String errorMessage, Exception e) {
		super(errorMessage, e);  
	}
}
