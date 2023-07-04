package com.quiz.lesson07.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.quiz.lesson07.entity.EnterpriseEntity;

@Repository
public interface EnterpriseRepository  extends JpaRepository<EnterpriseEntity, Integer>{
		// Spring data JPA
		// save()
	
}
