package com.quiz.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.domain.RealEstate;

@RequestMapping("/lesson03/quiz01")
@RestController
public class Lesson03Quiz01RestController {
	
	@Autowired
	private RealEstateBO realEstateBO;
	
	//1-1
	@RequestMapping("/1")
	public RealEstate quiz01(
			@RequestParam("id") int id
			) {
		return realEstateBO.getRealEstateById(id);
	}
	
	//1-2
	@RequestMapping("/2")
	public List<RealEstate> quiz01_2(
			@RequestParam("rent_price") int rentPrice
			) {
		return realEstateBO.getRealEstateByRentPrice(rentPrice);
	}
	
	//1-2
		@RequestMapping("/3")
		public List<RealEstate> quiz01_3(
				@RequestParam("area") int area,
				@RequestParam("price") int price
				) {
			return realEstateBO.getRealEstateByAreaPrice(area, price);
		}

}
