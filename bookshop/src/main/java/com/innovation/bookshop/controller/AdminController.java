package com.innovation.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovation.bookshop.model.Admin;
import com.innovation.bookshop.service.AdminService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/bookshop/")
public class AdminController {
	@Autowired
	private AdminService  ss;
	@GetMapping("/adminlogin/{email}/{password}")
	public ResponseEntity<Admin> login(@PathVariable("email") String email,@PathVariable("password")String password)
	{
		Admin sp=ss.login(email, password);
		return new ResponseEntity<Admin>(sp,HttpStatus.OK);
	}

}
