package com.quiz.lesson03.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.RealEstate;

@Repository
public interface RealEstateMapper {
	
	public RealEstate selectRealEstateById(@Param("id") int id);
	public List<RealEstate> selectRealEstateByRentPrice(@Param("rentPrice") int rentPrice);
	public List<RealEstate> selectRealEstateByAreaPrice(@Param("area") int area, @Param("price") int price);
	// mybatis는 파라미터를 하나만 인식할 수 있기 떄문에
	// 하나의 맵으로 만들어 보내야 한다.
	// 맵으로 만들어주는 어노테이션 @Param
	// @Param("키") "키" => xml #{키}
	
	public int insertRealEstate(RealEstate realEstate); 
	
	public int insertReviewAsField(
			// realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120
			@Param("realtorId") int realtorId,
			@Param("address") String address,
			@Param("area") int area,
			@Param("type") String type,
			@Param("price") int price,
			@Param("rentPrice") Integer rentPrice
			);
	
	public int updateRealEstateById(
			@Param("id") int id, 
			@Param("type") String type, 
			@Param("price") int price);

}
