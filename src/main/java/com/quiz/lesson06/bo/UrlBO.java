package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.dao.UrlMapper;
import com.quiz.lesson06.domain.FavoritesUrl;

@Service
public class UrlBO {
	
	
	@Autowired
	private UrlMapper urlMapper;
	
	public List<FavoritesUrl> getUrl(){
		return urlMapper.selectUrl();
	}
	
	//insert
	public void addUrl(String name, String url) {
		urlMapper.insertUrl(name, url);
	}
	
	public FavoritesUrl getFavoritesUrl(String url) {
		return urlMapper.selectFavoritesUrl(url);
	}
	
	//delete
	public int deleteUrlById(int id) {
		return urlMapper.deleteUrlById(id);
	}
	
	//중복 확인
//	public boolean existUrl(String url) {
//		return urlMapper.existUrl(url);
//	}

}
