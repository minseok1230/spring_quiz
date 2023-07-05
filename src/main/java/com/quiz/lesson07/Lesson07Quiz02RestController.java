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
		public List<AnnouncementEntity> quiz02(){
			return announcementReporitory.findByEnterpriseId(2);
		}
		
		@GetMapping("/3")
		// http://localhost:8080/lesson07/quiz02/3
		public List<AnnouncementEntity> quiz03(){
			return announcementReporitory.findByPositionAndType("웹 back-end 개발자", "정규직");
		}
		
		@GetMapping("/4")
		// http://localhost:8080/lesson07/quiz02/4
		public List<AnnouncementEntity> quiz04(){
			return announcementReporitory.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
		}
		
		@GetMapping("/5")
		// http://localhost:8080/lesson07/quiz02/5
		public List<AnnouncementEntity> quiz05(){
			return announcementReporitory.findTop3ByTypeOrderBySalaryDesc("계약직");
		}
		
		@GetMapping("/6")
		// http://localhost:8080/lesson07/quiz02/6
		public List<AnnouncementEntity> quiz06(){
			return announcementReporitory.findByRegionAndSalaryBetween("성남시 분당구", 7000,8500);
		}
		
		@GetMapping("/7")
		// http://localhost:8080/lesson07/quiz02/7
		public List<AnnouncementEntity> quiz07(){
			return announcementReporitory.findBySalaryGreaterThanEqualAndTypeAndDeadlineAfterOrderBySalaryDesc(8100,"정규직","2026-04-10");
		}
		
}




















