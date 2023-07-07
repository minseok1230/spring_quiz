package com.quiz.lesson07.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson07.entity.AnnouncementEntity;

@Repository
public interface AnnouncementRepository extends JpaRepository<AnnouncementEntity, Integer>{
	
		//spring  data JPA
		
		// JPQL -> Entity에 조회하는 개념
	 	//quiz02_2
		public List<AnnouncementEntity> findByEnterpriseId(int enterpriseId);
		//quiz02_3
		public List<AnnouncementEntity> findByPositionAndType(String position, String type);
		//quiz02_4
		public List<AnnouncementEntity> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
		//quiz02_5
		public List<AnnouncementEntity> findTop3ByTypeOrderBySalaryDesc(String type);
		//quiz02_6
		public List<AnnouncementEntity> findByRegionAndSalaryBetween(String region, int n1, int n2);
		//quiz02_7 - native query => DB에 직접 조회(Mysql 쿼리문)
		//마감일이 2026-04-10 이후이고 연봉이 8100 이상인 정규직 공고를 연봉 내림차순으로 조회하세요.
		@Query(value = "select * from announcement where deadline > :deadline and salary >= :salary and type = :type order by salary desc", nativeQuery = true)
		public List<AnnouncementEntity> findByDeadlineAfterAndSalaryGreaterThanEqualAndTypeAndOrderBySalaryDesc(
				@Param("deadline") String deadline, 
				@Param("salary") int salary, 
				@Param("type") String type);
		
		
		
}
