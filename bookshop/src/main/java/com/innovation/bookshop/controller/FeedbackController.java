package com.innovation.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovation.bookshop.model.Feedback;
import com.innovation.bookshop.model.Signup;
import com.innovation.bookshop.service.FeedbackService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/bookshop/")
public class FeedbackController {
	@Autowired
	FeedbackService fs;
	@GetMapping("/feedback")
	public List<Feedback> getall()
	{
		return fs.findAll();
	}
	
	@PostMapping("/feedback")
	public ResponseEntity<Feedback> save(@RequestBody Feedback s)
	{
		Feedback sp=fs.add(s);
		return new ResponseEntity<Feedback>(sp,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/feedback/{id}")
	public ResponseEntity<Void> del(@PathVariable("id") int id)
	{
		fs.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
}
