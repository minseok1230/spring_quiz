package com.quiz.logPension.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	// 삭제(delete)
	public int deleteBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	}
	
	// 추가(insert)
	public int addBooking(String name, String date, int day, int headcount, String phoneNumber) {
		return bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	}
	
	// 조건 정보(select by name/phoneNumber) 
	public Booking checkByNameByPN(String name, String phoneNumber){
		// 가능한 값: [], [bookingA, bookingB...]
		List<Booking> bookingList = bookingMapper.checkByNameByPN(name, phoneNumber);
		
		if (bookingList.isEmpty()) {
			return null;
		} else {
			return bookingList.get(bookingList.size() - 1); // 마지막 값을 준다. (최신예약)
		}
	}
}











