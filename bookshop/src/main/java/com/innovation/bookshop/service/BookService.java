package com.innovation.bookshop.service;

import java.util.List;

import com.innovation.bookshop.model.Book;


public interface BookService {
	Book add(Book s);
	List<Book> findAll();
	void deleteById(int id);
	Book update(int id,Book ns);
	Book search(int id);
	List<Book> getByType(String t);
}
