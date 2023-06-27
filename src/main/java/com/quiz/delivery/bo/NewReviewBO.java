package com.quiz.delivery.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.delivery.dao.NewReviewMapper;
import com.quiz.delivery.domain.newReview;

@Service
public class NewReviewBO {
	
	@Autowired
	private NewReviewMapper newReviewMapper;
	
	public List<newReview> getNewReviewList(int id){
		return newReviewMapper.selectNewReviewList(id);
	}

}
