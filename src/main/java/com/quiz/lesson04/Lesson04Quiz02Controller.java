package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.domain.Realtor;

@Controller
@RequestMapping("/lesson04/quiz02")
public class Lesson04Quiz02Controller {
	
	@Autowired
	private RealtorBO realtorBO;
	
	// 추가페이지
	//http://localhost:8080/lesson04/quiz02/add_realtor_view
	@GetMapping("/add_realtor_view")
	public String addRealtorView() {
		return "lesson04/addRealtor";
	}
	
	// 결과페이지
	//http://localhost:8080/lesson04/quiz02/add_realtor
	@PostMapping("/add_realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor, // 객체가 하나일때는 생략가능! @ModelAttribute
			Model model) {
		
		// insert db
		realtorBO.addRealtor(realtor);
		
		// select db
		Realtor latestRealtor = realtorBO.getRealtorById(realtor.getId());
		
		// model 담기
		model.addAttribute("realtor", latestRealtor);
		
		return "lesson04/afterAddRealtor";
	}
}








