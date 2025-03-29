package com.innovation.bookshop.service;

import java.util.List;

import com.innovation.bookshop.model.BookOrder;

public interface BookOrderService {

	BookOrder add(BookOrder b);
	List<BookOrder> findAll(String email);
	BookOrder update(int orderno,BookOrder b);
	BookOrder search(int id);
	
	 List<BookOrder> getAllOrders();
	
	
}
