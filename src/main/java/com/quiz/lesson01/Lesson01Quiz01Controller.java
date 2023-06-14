package com.quiz.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lesson01/quiz01")
public class Lesson01Quiz01Controller {
	
	//	quiz01-1
	@RequestMapping("/1")
	@ResponseBody
	public String ex01_1() {
		String text ="<h1>테스트 프로젝트 완성</h1>"
				+ "<h3>해당 프로젝트를 통해서 문제 풀이를 진행 합니다.</h3>";
		return text;
	}
	
	//	quiz01-2
	@RequestMapping("/2")
	@ResponseBody
	public Map<String, Object> ex01_2(){
		Map<String, Object> map = new HashMap<>();
		map.put("국어", 80);
		map.put("수학", 90);
		map.put("영어", 85);
		return map;
	}

}
