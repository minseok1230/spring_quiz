package com.quiz.lesson07.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.dao.EnterpriseRepository;
import com.quiz.lesson07.entity.EnterpriseEntity;

@Service
public class EnterpriseBO {
	
	@Autowired
	private EnterpriseRepository enterpriseRepository;
	
	public EnterpriseEntity addEnterprise(String name, String business, String scale, int headcount) {
		// 입력후 그 정보를 받아올수 있다 JPA
		EnterpriseEntity enterprise = enterpriseRepository.save(
				EnterpriseEntity.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.build()
				);
		return enterprise;
				
	}

}
