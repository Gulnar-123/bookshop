package com.innovation.bookshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.innovation.bookshop.model.Admin;
import com.innovation.bookshop.repository.Adminrepository;
@Service
public class AdminServiceImpl implements AdminService{
@Autowired
@Qualifier("adminRepo")
private Adminrepository adminRepo;
	@Override
	public Admin login(String email, String password) {
		// TODO Auto-generated method stub
	return adminRepo.findByEmailAndPassword(email, password);
	}

}
