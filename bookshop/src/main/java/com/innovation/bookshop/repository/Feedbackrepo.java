package com.innovation.bookshop.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.innovation.bookshop.model.Feedback;

@Repository
@Qualifier("feedbackRepo")


public interface Feedbackrepo extends JpaRepository<Feedback, Integer>{
	
	
	

}
