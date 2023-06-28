package com.quiz.delivery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.delivery.bo.NewReviewBO;
import com.quiz.delivery.domain.newReview;
import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Store;




@Controller
@RequestMapping("/delivery")
public class DeliveryController {
	
	@Autowired
	private StoreBO storeBO;
	
	@Autowired
	private NewReviewBO newReviewBO;
	
	// 배탈의민족 가게 뷰 
	@GetMapping("/store_view")
	public String  storeView(Model model) {
		
		List<Store> storeList = storeBO.getStoreList();
		model.addAttribute("storeList", storeList);
		return "delivery/getStore";
	}
	
	// 선택된 가게 리뷰 뷰
	@GetMapping("/store_review_view")
	public String StoreReviewView(
			@RequestParam("id") int id,
			@RequestParam("name") String name,
			Model model) {
		
		List<newReview> newReviewList = newReviewBO.getNewReviewList(id);
		model.addAttribute("newReviewList", newReviewList);
		model.addAttribute("name", name);
		
		return "delivery/getReview";
	}

}
