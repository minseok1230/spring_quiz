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
	
	// 판매자 추가 페이지  _view
	@RequestMapping(path = "/add_seller_view", method = RequestMethod.GET)
//	@GetMapping("/add_seller_view")
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	// 추가 action
	@PostMapping("/add_seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl,
			@RequestParam("temperature") double temperature) {
		
		//db insert
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		// jsp 연결 (입력 성공 페이지)
		return "lesson04/afterAddSeller";
	}
	
	// 최근 가입자 정보 페이지 
	//http://localhost:8080/lesson04/quiz01/seller_info
	//http://localhost:8080/lesson04/quiz01/seller_info?id=1
	//@RequestParam(value="id", defaultValue="1") int id // 비필수 파라미터, 디폴트값 1
	@GetMapping("/seller_info")
	public String sellerInfo(
			@RequestParam(value= "id", required= false) Integer id,
			Model model
			) {
		
		//db받기 (select)
		Seller seller= null;
		if (id == null) {
			seller = sellerBO.getSellerInfo();			
		} else {
			// id가 있는 경우 
			seller = sellerBO.getSellerInfo(id);
		}
		
		// seller의 자료를 jsp로 옮긴다.
		model.addAttribute("result", seller);
		
		return "lesson04/getSellerInfo";
	}
	

	
	
	

}






