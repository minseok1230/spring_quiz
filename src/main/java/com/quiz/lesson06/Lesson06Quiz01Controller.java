package com.quiz.lesson06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.UrlBO;
import com.quiz.lesson06.domain.FavoritesUrl;

@Controller
@RequestMapping("/lesson06/quiz01")
public class Lesson06Quiz01Controller {

		@Autowired
		private UrlBO urlBO;
		
		// 입력페이지
		@GetMapping("/add_url_view")
		public String addUrlView() {
			return "lesson06/addUrl";
		}
		
		// AJAX가 요청한 곳 => response String(data)이어야 함
		@PostMapping("/add_url")
		@ResponseBody
			public String addUser(
				@RequestParam("name") String name,
				@RequestParam("url") String url) {
			
				// db insert
				urlBO.addUrl(name, url);
				// return String
				return "성공";
			}
		
		// 리스트 화면
		//입력 성공 페이지
		@GetMapping("/after_add_url_view")
		public String afterAddUserView(Model model) {
			
			// select
			List<FavoritesUrl> FavoritesUrlList = urlBO.getUrl();
			model.addAttribute("FavoritesUrlList", FavoritesUrlList);
			// 출력 화면
			return "lesson06/afterAddUrl";
		}
}
