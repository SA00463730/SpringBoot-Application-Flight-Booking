package com.airline.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
//@Table(name="Flight")
public class Flight {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int fight_id;
private String model;
private String source;
private String destination;
private int capacity;
private LocalDateTime arrival;
private LocalDateTime departure;

public Flight() {
	super();
}
public Flight(int fight_id) {
	super();
	this.fight_id = fight_id;
}



public int getFight_id() {
	return fight_id;
}
public void setFight_id(int fight_id) {
	this.fight_id = fight_id;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public String getSource() {
	return source;
}
public void setSource(String source) {
	this.source = source;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}
public int getCapacity() {
	return capacity;
}
public void setCapacity(int capacity) {
	this.capacity = capacity;
}
public LocalDateTime getArrival() {
	return arrival;
}
public void setArrival(LocalDateTime arrival) {
	this.arrival = arrival;
}

@Override
public String toString() {
	return "Flight [fight_id=" + fight_id + ", model=" + model + ", source=" + source + ", destination=" + destination
			+ ", capacity=" + capacity + ", arrival=" + arrival + ", departure=" + departure + ", getFight_id()="
			+ getFight_id() + ", getModel()=" + getModel() + ", getSource()=" + getSource() + ", getDestination()="
			+ getDestination() + ", getCapacity()=" + getCapacity() + ", getArrival()=" + getArrival() + "]";
}



}
