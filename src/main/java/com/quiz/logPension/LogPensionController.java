package com.quiz.logPension;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.logPension.bo.BookingBO;
import com.quiz.logPension.domain.Booking;

@Controller
@RequestMapping("/logPension")
public class LogPensionController {

	@Autowired
	private BookingBO bookingBO;
	
	//예약 목록 보기 (처음화면 + selct 정보)
	@GetMapping("/reservation_list_view")
	public String reservationListView(Model model) {
		
		List<Booking> bookList = bookingBO.getBookingList();
		model.addAttribute("bookList", bookList);
		
		return "logPension/reservationList";
	}
	
	// 예약하기 페이지 
	@GetMapping("/reservation_view")
	public String reservationView() {
		
		return "logPension/reservation";
	}
	
	// 변동사항
	
	
}








