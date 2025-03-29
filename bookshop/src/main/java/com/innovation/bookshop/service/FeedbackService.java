package com.innovation.bookshop.service;

import java.util.List;

import com.innovation.bookshop.model.Feedback;

public interface FeedbackService {
	Feedback add (Feedback f);
	List<Feedback> findAll();
	
	void delete(int feedbackid);
	
	
}
