package com.innovation.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovation.bookshop.model.Signup;
import com.innovation.bookshop.service.SignupService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/bookshop/")
public class SignupController {

	@Autowired
	private SignupService ss;
	
	@GetMapping("/signups")
	public List<Signup> getall()
	{
		return ss.findAll();
	}
	
	@PostMapping("/signup")
	public ResponseEntity<Signup> save(@RequestBody Signup s)
	{
		Signup sp=ss.add(s);
		return new ResponseEntity<Signup>(sp,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/signup/{id}")
	public ResponseEntity<Void> del(@PathVariable("id") int id)
	{
		ss.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@PutMapping("/signup/{id}")
	public ResponseEntity<Signup> update(@PathVariable("id")int id,@RequestBody Signup s)
	{
	Signup sp=	ss.update(id, s);
	return new ResponseEntity<Signup>(sp,HttpStatus.OK);
	}
	
	@GetMapping("/signup/{id}")
	public ResponseEntity<Signup> search(@PathVariable("id") int id)
	{
		Signup sp=ss.search(id);
		return new ResponseEntity<Signup>(sp,HttpStatus.OK);
	}
	
	@GetMapping("/signup/{em}/{ps}")
	public ResponseEntity<Signup> login(@PathVariable("em") String em,@PathVariable("ps")String ps)
	{
		Signup sp=ss.login(em, ps);
		return new ResponseEntity<Signup>(sp,HttpStatus.OK);
	}
}
