package com.innovation.bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.innovation.bookshop.exception.ResourceNotFoundException;
import com.innovation.bookshop.model.Feedback;

import com.innovation.bookshop.repository.Feedbackrepo;

@Service
public class FeedbackServiceImpl implements FeedbackService {
@Autowired
@Qualifier("feedbackRepo")
private Feedbackrepo feedbackRepo;
	@Override
	public Feedback add(Feedback f) {
		// TODO Auto-generated method stub
		return feedbackRepo.save(f);
		
	}

	@Override
	public List<Feedback> findAll() {
		// TODO Auto-generated method stub
		return feedbackRepo.findAll();
	}

	@Override
	public void delete(int feedbackid) {
		// TODO Auto-generated method stub
		Feedback f=feedbackRepo.findById(feedbackid).orElseThrow(()->new ResourceNotFoundException("Resource not found with id "+feedbackid));
		feedbackRepo.deleteById(feedbackid);
	}

}
