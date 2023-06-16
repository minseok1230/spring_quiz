package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.dao.RealEstateMapper;
import com.quiz.lesson03.domain.RealEstate;

@Service
public class RealEstateBO {
	
	@Autowired
	private RealEstateMapper realEstateMapper;
	
	//1-1
	public RealEstate getRealEstateById(int id) {
		return realEstateMapper.selectRealEstateById(id);
	}
	
	//1-2
	public List<RealEstate> getRealEstateByRentPrice(int rentPrice) {
		return realEstateMapper.selectRealEstateByRentPrice(rentPrice);
	}
	
	//1-3
	public List<RealEstate> getRealEstateByAreaPrice(int area, int price){
		return realEstateMapper.getRealEstateByAreaPrice(area, price);
	}

}




