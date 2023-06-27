package com.quiz.weather;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather.bo.WeatherHistoryBO;
import com.quiz.weather.domain.WeatherHistory;

@Controller
@RequestMapping("/weather")
public class WeatherHistoryController {
	
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	//view화면
	@GetMapping("/weather_history_view")
	public String weatherHistoryView(Model model) {
			
		List<WeatherHistory> weatherHistory = weatherHistoryBO.getWeatherHistory();
		model.addAttribute("weatherHistory", weatherHistory);
		
		return "weather/getWeather";
	}
	
	// 날씨추가화면
	//localhost:8080/weather/weather_add
	@GetMapping("/weather_add")
	public String addWeather() {
		return "weather/addWeather";
	}
	
	// 날씨 추가
	@PostMapping("/weather_adding")
	public String weatherAdding(
			@ModelAttribute WeatherHistory addWeatherHistory
			) {
		
			//insert db
			weatherHistoryBO.addNewWeather(addWeatherHistory);
			return "redirect:/weather_hi";
	}
	
	
	
}
