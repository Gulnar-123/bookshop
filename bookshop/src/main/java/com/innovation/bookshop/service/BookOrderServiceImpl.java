package com.innovation.bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.innovation.bookshop.exception.ResourceNotFoundException;
import com.innovation.bookshop.model.BookOrder;
import com.innovation.bookshop.repository.BookOrderRepository;
@Service
public class BookOrderServiceImpl implements BookOrderService{

	@Autowired
	@Qualifier("boRepo")
	private BookOrderRepository boRepo;
	@Override
	public BookOrder add(BookOrder b) {
		// TODO Auto-generated method stub
		return boRepo.save(b);
	}

	@Override
	public List<BookOrder> findAll(String email) {
		// TODO Auto-generated method stub
		return boRepo.findAllByEmailid(email);
	}

	@Override
	public BookOrder update(int orderno, BookOrder b) {
	BookOrder bold=boRepo.findById(orderno).orElseThrow(()->new ResourceNotFoundException("Order no not found with id "+orderno));
	bold.setStatus(b.getStatus());
	
	
		return boRepo.save(bold);
	}

	@Override
	public List<BookOrder> getAllOrders() {
		// TODO Auto-generated method stub
		return boRepo.findAll();
	}
	public BookOrder search(int id)
	{
		BookOrder bold=boRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Order no not found with id "+id));
return bold;
	}
	

}
