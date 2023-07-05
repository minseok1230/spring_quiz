package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.bo.EnterpriseBO;
import com.quiz.lesson07.entity.EnterpriseEntity;

@RestController
@RequestMapping("/lesson07/quiz01")
public class Lesson07Quiz01RestController {

	@Autowired
	private EnterpriseBO enterpriseBO;
	
	@RequestMapping("/save1")
	// http://localhost:8080/lesson07/quiz01/save1
	// DB enterprise 
	public EnterpriseEntity create_1() {
		String name = "넥손";
		String business ="컨텐츠 게임";
		String scale ="대기업";
		int headcount = 3585;
		
		EnterpriseEntity enterprise = enterpriseBO.addEnterprise(name, business, scale, headcount);
		
		return enterprise;
	}
	
	@RequestMapping("/save2")
	// DB enterprise 
	// http://localhost:8080/lesson07/quiz01/save2
	public EnterpriseEntity create_2() {
		EnterpriseEntity enterprise = enterpriseBO.addEnterprise("버블팝", "여신 금융업", "대기업", 6834);
		return enterprise;
	}
	
	// U: UPDATE
	// http://localhost:8080/lesson07/quiz01/update
	@GetMapping("/update")
	public EnterpriseEntity update() {
		// id = 8  -> scale: 중소기업 / headcout: 34 변경
		EnterpriseEntity enterprise = enterpriseBO.updateEnterpriseById(8,"중소기업",34);
		return enterprise;
	}
	
	// D: DELETE
	// http://localhost:8080/lesson07/quiz01/delete
	@GetMapping("/delete")
	public String delete() {
		//id : 8
		enterpriseBO.deleteEnterpriseById(8);
		return "수행 완료";
	}
}













