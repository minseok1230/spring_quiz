package com.quiz.lesson05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lesson05/quiz01")
public class Lesson05Quiz01Controller {
	
		//view화면
		@GetMapping("/weather_history_view")
		public String weatherHistoryView() {
			return "lesson05/"
		}
		

}
