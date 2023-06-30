package com.quiz.logPension.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.logPension.dao.BookingMapper;
import com.quiz.logPension.domain.Booking;

@Service
public class BookingBO {

	@Autowired
	private BookingMapper bookingMapper;
	
	// select booking 정보 가져오기 
	public List<Booking> getBookingList(){
		return bookingMapper.selectBookingList();
	}
}
