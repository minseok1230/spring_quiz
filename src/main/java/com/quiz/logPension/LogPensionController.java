package com.quiz.logPension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.logPension.bo.BookingBO;
import com.quiz.logPension.domain.Booking;

@Controller
@RequestMapping("/logPension")
public class LogPensionController {

	@Autowired
	private BookingBO bookingBO;
	
	// 1)예약 목록 보기 (처음화면 + selct 정보)
	// /logPension/reservation_list_view
	@GetMapping("/reservation_list_view")
	public String reservationListView(Model model) {
		
		List<Booking> bookList = bookingBO.getBookingList();
		model.addAttribute("bookList", bookList);
		
		return "logPension/reservationList";
	}
	
	// 2) 예약하기 페이지 
	// http://localhost:8080/logPension/reservation_view
	@GetMapping("/reservation_view")
	public String reservationView() {
		
		return "logPension/reservation";
	}
	
	// 3) 예약 조회 기능 페이지 
	// http://localhost:8080/logPension/reservation_check_view
	@GetMapping("/reservation_check_view")
	public String reservationCheckView() {
		
		return "logPension/reservationCheck";
	}
	
	// AJAX 예약 조회 페이지
	@PostMapping("/check_reservation")
	@ResponseBody
	public Map<String, Object> checkReservationByNameByPN(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber
			){
		
		// 조회 하기 
			Booking searchBooking = bookingBO.checkByNameByPN(name, phoneNumber);
			Map<String, Object> result = new HashMap<>();
			
			if (searchBooking == null) {
				result.put("code", 500);
				result.put("errorMessage", "예약 정보가 없습니다.");
			} else {
				result.put("code", 1);
				result.put("result", searchBooking);
			}
			
			return result;
	}
	
	
	// AJAX 예약 조회 삭제 페이지
	@DeleteMapping("/delete_reservation")
	@ResponseBody
	public Map<String, Object> deleteReservation(
			@RequestParam("bookingId") int id){
		int deleteRow = bookingBO.deleteBookingById(id);
		
		Map<String, Object> result = new HashMap<>();
		if (deleteRow == 1) {
			result.put("code", 1);
			result.put("result", "success");
		} else {
			result.put("code", 500);
			result.put("errorMessage", "예약 내역이 없습니다.");
		}
		
		return result;
	}
	
	// AJAX 예약 추가 페이지
	@PostMapping("/add_reservation")
	@ResponseBody
	public Map<String, Object> addReservation(
			@RequestParam("name") String name,
			@RequestParam("date") String date,
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber){
		
		//db insert
		int addRow = bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		Map<String, Object> result = new HashMap<>();
		if (addRow > 0) {
			result.put("code", 1);
			result.put("result", "success");
		} else {
			result.put("code", 500);
			result.put("errorMessage", "데이터 추가에 실패하였습니다.");
		}
		
		return result;
	}
}








