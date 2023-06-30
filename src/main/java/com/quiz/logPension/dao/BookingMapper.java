package com.quiz.logPension.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.logPension.domain.Booking;


@Repository
public interface BookingMapper {
	
	public List<Booking> selectBookingList();

}
