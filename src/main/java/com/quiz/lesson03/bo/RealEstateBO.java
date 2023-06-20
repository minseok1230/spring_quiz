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
	// input :  int, int
	// output : List<RealEstate>
	public List<RealEstate> getRealEstateByAreaPrice(int area, int price){
		return realEstateMapper.selectRealEstateByAreaPrice(area, price);
	}
	
	//2-1
	public int addRealEstate(RealEstate realEstate) {
		return realEstateMapper.insertRealEstate(realEstate);
	}
	
	//2-2
	// realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120
	public int addRealEstateAsField(int realtorId, String address, int area, String type, int price, Integer rentPrice) {
		return realEstateMapper.insertReviewAsField(realtorId, address, area, type, price, rentPrice);
	}
	
	//3
	public int updateRealEstateById(int id, String type, int price) {
		return realEstateMapper.updateRealEstateById(id, type, price);
	}
	
	//4
	public void deleteRealEstateById(int id) {
		realEstateMapper.deleteRealEstateById(id);
	}
	
	

}




