package com.quiz.delivery.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.delivery.domain.newReview;

@Repository
public interface NewReviewMapper {
	
	public List<newReview> selectNewReviewList(int id);

}
