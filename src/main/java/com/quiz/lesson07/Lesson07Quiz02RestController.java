package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.dao.AnnouncementRepository;
import com.quiz.lesson07.entity.AnnouncementEntity;

@RestController
@RequestMapping("/lesson07/quiz02")
public class Lesson07Quiz02RestController {

		@Autowired
		private AnnouncementRepository announcementReporitory;
	
		@GetMapping("/1")
		// http://localhost:8080/lesson07/quiz02/1
		public AnnouncementEntity quiz01(){
			AnnouncementEntity announcement = announcementReporitory.findById(8).orElse(null);
			return announcement;
		}
		
		@GetMapping("/2")
		// http://localhost:8080/lesson07/quiz02/2
		public List<AnnouncementEntity> quiz02_2(){
			return announcementReporitory.findByEnterpriseId(1);
		}
		
		@GetMapping("/3")
		// http://localhost:8080/lesson07/quiz02/3
		public List<AnnouncementEntity> quiz02_3(){
			return announcementReporitory.findByPositionAndType("웹 back-end 개발자", "정규직");
		}
		
		@GetMapping("/4")
		// http://localhost:8080/lesson07/quiz02/4
		public List<AnnouncementEntity> quiz02_4(){
			// 정규직이거나 연봉이 9000 이상인 공고를 조회 
			return announcementReporitory.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
		}
		
		@GetMapping("/5")
		// http://localhost:8080/lesson07/quiz02/5
		public List<AnnouncementEntity> quiz02_5(){
			return announcementReporitory.findTop3ByTypeOrderBySalaryDesc("계약직");
		}
		
		@GetMapping("/6")
		// http://localhost:8080/lesson07/quiz02/6
		public List<AnnouncementEntity> quiz02_6(){
			//성남시 분당구가 지역인 연봉 7000 이상 8500 이하인 공고를 조회하고 아래와 같이 출력하세요.
			return announcementReporitory.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
		}
		
		@GetMapping("/7")
		// http://localhost:8080/lesson07/quiz02/7
		public List<AnnouncementEntity> quiz02_7(){
			return announcementReporitory.findByDeadlineAfterAndSalaryGreaterThanEqualAndTypeAndOrderBySalaryDesc("2026-04-10", 8100,"정규직");
		}
		
}




















