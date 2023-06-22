package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.dao.RealtorMapper;
import com.quiz.lesson04.domain.Realtor;

@Service
public class RealtorBO {
	
	@Autowired
	private RealtorMapper realtorMapper; 
	
	// insert
	public void getRealtor(Realtor realtor) {
		realtorMapper.insertRealtor(realtor);
	}
	
	public Realtor getRealtorById(int id) {
		return realtorMapper.selectRealtorById(id);
	}
	

}
