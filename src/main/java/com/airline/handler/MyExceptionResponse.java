package com.airline.handler;

import java.time.LocalDateTime;

import com.airline.exceptions.BookingNotAvailableException;
import com.airline.exceptions.FlightNotAvailableException;

public class MyExceptionResponse {

	
	private String Status;
	private String errorMessage;
	private LocalDateTime time;
	
	public MyExceptionResponse(String message, int i, LocalDateTime now, Exception e) {
		// TODO Auto-generated constructor stub
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "MyExceptionResponse [Status=" + Status + ", errorMessage=" + errorMessage + ", time=" + time + "]";
	}
	
}
