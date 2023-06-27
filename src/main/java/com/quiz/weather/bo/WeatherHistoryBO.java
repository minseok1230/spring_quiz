package com.quiz.weather.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.weather.dao.WeatherHistoryMapper;
import com.quiz.weather.domain.WeatherHistory;

@Service
public class WeatherHistoryBO {
	
	@Autowired
	private WeatherHistoryMapper weatherHistoryMapper;
	
	public List<WeatherHistory> getWeatherHistory() {
		return weatherHistoryMapper.selectWeatherHistory();
	}
	
	public void addNewWeather(WeatherHistory addWeatherHistory) {
		weatherHistoryMapper.insertNewWeather(addWeatherHistory);
	}
}
