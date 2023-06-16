package com.quiz.lesson03.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.RealEstate;

@Repository
public interface RealEstateMapper {
	
	public RealEstate selectRealEstateById(@Param("id") int id);
	public List<RealEstate> selectRealEstateByRentPrice(@Param("rentPrice") int rentPrice);
	public List<RealEstate> getRealEstateByAreaPrice(@Param("area") int area, @Param("price") int price);

}
