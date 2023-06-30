package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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
		
		// AJAX가 요청한 곳 => response String(data)이어야 함 view가 아니여야함
		@PostMapping("/add_url")
		@ResponseBody
			public Map<String, Object> addUrl(
				@RequestParam("name") String name,
				@RequestParam("url") String url) {
			
				// db insert
				urlBO.addUrl(name, url);
				
				// 응답
				// { "code": 1, "result":"성공"} JSON String
				Map<String, Object> result = new HashMap<>();
				result.put("code", 1);
				result.put("result", "성공");
				
				return result;
			}
		
		// AJAX가 하는 요청 -  URL 중복 확인
		@PostMapping("/is_duplication")
		@ResponseBody
		public Map<String, Object> isDuplication(
				@RequestParam("url") String url){
			
			Map<String, Object> result = new HashMap<>();
			result.put("code", 1);
			result.put("isDuplication", false);
			
			//db 중복조회
			//boolean existUrl = urlBO.existUrl(url);
			FavoritesUrl favoritesUrl = urlBO.getFavoritesUrl(url); // bookmark or null
			if (favoritesUrl != null) { // 중복
				result.put("isDuplication", true);
			}
			
			return result;
		}
		
		// 리스트 화면
		// 입력 성공 페이지
		@GetMapping("/after_add_url_view")
		public String afterAddUrlView(Model model) {
			
			// select
			List<FavoritesUrl> FavoritesUrlList = urlBO.getUrl();
			model.addAttribute("FavoritesUrlList", FavoritesUrlList);
			// 출력 화면
			return "lesson06/afterAddUrl";
		}
		
		// AJAX가 하는 요청 - 즐겨찾기 삭제
		@DeleteMapping("/delete_url")
		@ResponseBody
		public Map<String, Object> deleteBookmark(
				@RequestParam("urlId") int id){
			
			// db delete
			int row = urlBO.deleteUrlById(id); 
					
			Map<String, Object> result = new HashMap<>();
			if (row > 0) {
				// 성공
				result.put("code", 1);
				result.put("result", "성공");
			} else {
				// 삭제된 행 없음 - 실패
				result.put("code", 500);
				result.put("errorMessage", "삭제될 데이터가 없습니다.");
			}
			return result;
		}
		
		

}
















