package com.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.entity.BookingData;

public interface BookingRepository extends JpaRepository<BookingData, Integer> {

}
