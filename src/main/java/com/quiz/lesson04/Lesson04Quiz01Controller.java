package com.quiz.lesson04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/lesson03/quiz01")
public class Lesson04Quiz01Controller {
	
	// _view
	@RequestMapping(path = "/add_seller_view", method = RequestMethod.GET)
	public String addSellerView() {
		return "lesson03/addSeller";
	}

}
