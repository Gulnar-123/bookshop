package com.innovation.bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.innovation.bookshop.exception.ResourceNotFoundException;
import com.innovation.bookshop.model.Signup;
import com.innovation.bookshop.repository.SignupRepository;

@Service
public class SignupServiceImpl implements SignupService {

	@Autowired
	@Qualifier("signRepo")
	private SignupRepository signRepo;
	
	@Override
	public Signup add(Signup s) {
		// TODO Auto-generated method stub
		return signRepo.save(s);
	}

	@Override
	public List<Signup> findAll() {
		// TODO Auto-generated method stub
		return signRepo.findAll();
	}

	@Override
	public void deleteById(int id) {
		Signup s=signRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource not found with id "+id));
		signRepo.deleteById(id);
		
	}

	@Override
	public Signup update(int id, Signup ns) {
		Signup s=signRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource not found with id "+id));
		s.setName(ns.getName());
		s.setAddress(ns.getAddress());
		s.setCity(ns.getCity());
		s.setGender(ns.getGender());
		s.setMobileno(ns.getMobileno());
		s.setEmail(ns.getEmail());
		s.setPassword(ns.getPassword());
		
		return signRepo.save(s);
	}

	@Override
	public Signup search(int id) {
	Signup s=signRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource not found with id "+id));
	
		return s;
	}

	@Override
	public Signup login(String em, String ps) {
		// TODO Auto-generated method stub
		return signRepo.findByEmailAndPassword(em, ps);
	}
	

}
