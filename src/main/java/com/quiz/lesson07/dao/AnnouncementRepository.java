package com.quiz.lesson07.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.lesson07.entity.AnnouncementEntity;

@Repository
public interface AnnouncementRepository extends JpaRepository<AnnouncementEntity, Integer>{
	
		//spring  data JPA
	 	//2
		public List<AnnouncementEntity> findByEnterpriseId(int enterpriseId);
		//3
		public List<AnnouncementEntity> findByPositionAndType(String position, String type);
		//4
		public List<AnnouncementEntity> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
		//5
		public List<AnnouncementEntity> findTop3ByTypeOrderBySalaryDesc(String type);
		//6
		public List<AnnouncementEntity> findByRegionAndSalaryBetween(String region, int n1, int n2);
		//7
		public List<AnnouncementEntity> findBySalaryGreaterThanEqualAndTypeAndDeadlineAfterOrderBySalaryDesc(int salary, String type, String deadline);
		
		
		
}
