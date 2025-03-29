package com.innovation.bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.innovation.bookshop.exception.ResourceNotFoundException;
import com.innovation.bookshop.model.Book;

import com.innovation.bookshop.repository.BookRepository;


@Service
public class BookServiceImpl implements BookService {
	@Autowired
	@Qualifier("bookRepo")
	private BookRepository bookRepo;
	@Override
	public Book add(Book b) {
		// TODO Auto-generated method stub
		return bookRepo.save(b);
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return bookRepo.findAll();
	}

	@Override
	public void deleteById(int id) {
		Book b=bookRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource not found with id "+id));
		bookRepo.deleteById(id);
		
	}

	@Override
	public Book update(int id, Book ns) {
		Book b=bookRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource not found with id "+id));
		b.setBookname(ns.getBookname());
		b.setAuthor(ns.getAuthor());
		b.setType(ns.getType());
		b.setPrice(ns.getPrice());
		return bookRepo.save(b);
	}

	@Override
	public Book search(int id) {
		Book b=bookRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource not found with id "+id));
		
		return b;
	}

	@Override
	public List<Book> getByType(String t) {
		
		return bookRepo.findAllByType(t);
	}

}
