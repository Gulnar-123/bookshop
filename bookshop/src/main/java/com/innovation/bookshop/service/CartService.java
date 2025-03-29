package com.innovation.bookshop.service;

import java.util.List;

import com.innovation.bookshop.model.Cart;

public interface CartService {
	Cart add(Cart c);
	List<Cart> findAll(String email);
	void deleteById(int id);
	Cart update(int id,Cart nc);
	Cart search(int id);

}
