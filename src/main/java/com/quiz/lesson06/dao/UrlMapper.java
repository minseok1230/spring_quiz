package com.quiz.lesson06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson06.domain.FavoritesUrl;

@Repository
public interface UrlMapper {
	
	public List<FavoritesUrl> selectUrl();
	
	public void insertUrl(
			@Param("name") String name, 
			@Param("url") String url);
	
	public boolean existexistUrl(String url);
}
