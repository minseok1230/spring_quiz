package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@Controller
@RequestMapping("/lesson04/quiz01")
public class Lesson04Quiz01Controller {
	
	@Autowired
	private SellerBO sellerBO;
	
	// _view
	@RequestMapping(path = "/add_seller_view", method = RequestMethod.GET)
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	@PostMapping("/add_seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam("profileImageUrl") String profileImageUrl,
			@RequestParam("temperature") double temperature) {
		
		//db insert
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		// jsp 연결
		return "lesson04/afterAddSeller";
	}
	
	
	//http://localhost:8080/lesson04/quiz01/seller_info
	@GetMapping("/seller_info")
	public String sellerInfo(Model model) {
		//db받기
		Seller seller = sellerBO.getSellerInfo();
		
		// seller의 자료를 jsp로 옮긴다.
		model.addAttribute("result", seller);
		
		return "lesson04/getSellerInfo";
	}

}






