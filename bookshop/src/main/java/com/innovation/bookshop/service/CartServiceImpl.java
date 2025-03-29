package com.innovation.bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.innovation.bookshop.exception.ResourceNotFoundException;
import com.innovation.bookshop.model.Cart;
import com.innovation.bookshop.repository.CartRepository;
@Service
public class CartServiceImpl implements CartService{

	@Autowired
	@Qualifier("cartRepo")
	private CartRepository cartRepo;
	
	@Override
	public Cart add(Cart c) {
		// TODO Auto-generated method stub
		return cartRepo.save(c);
	}

	@Override
	public List<Cart> findAll(String email) {
		// TODO Auto-generated method stub
		return cartRepo.findAllByEmail(email);
	}

	@Override
	public void deleteById(int id) {
	Cart c=cartRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource not found with id"+id));
	cartRepo.deleteById(id);
		
	}

	@Override
	public Cart update(int id, Cart nc) {
		Cart c=cartRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource not found with id"+id));
		c.setAmount(nc.getAmount());
		c.setBooktitle(nc.getBooktitle());
		c.setEmail(nc.getEmail());
		c.setQty(c.getQty());
		return cartRepo.save(c);
	}

	@Override
	public Cart search(int id) {
		Cart c=cartRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource not found with id"+id));
		
		return c;
	}

}
