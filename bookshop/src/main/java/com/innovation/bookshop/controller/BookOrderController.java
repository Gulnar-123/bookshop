package com.innovation.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovation.bookshop.model.BookOrder;
import com.innovation.bookshop.service.BookOrderService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/bookshop/")
public class BookOrderController {
	

		@Autowired
		private  BookOrderService ss;
		
		@GetMapping("/bookorder")
		public List<BookOrder> getall()
		{
			return ss.getAllOrders();
		}
		
		@PostMapping("/bookorder")
		public ResponseEntity<BookOrder> save(@RequestBody BookOrder s)
		{
			BookOrder sp=ss.add(s);
			return new ResponseEntity<BookOrder>(sp,HttpStatus.CREATED);
		}
		
		
		@PutMapping("/bookorder/{id}")
		public ResponseEntity<BookOrder> update(@PathVariable("id")int id,@RequestBody BookOrder s)
		{
			BookOrder sp=	ss.update(id, s);
		return new ResponseEntity<BookOrder>(sp,HttpStatus.OK);
		}
		
		@GetMapping("/bookorder/{id}")
		public ResponseEntity<BookOrder> search(@PathVariable("id") int id)
		{
			BookOrder sp=ss.search(id);
			return new ResponseEntity<BookOrder>(sp,HttpStatus.OK);
		}
		@GetMapping("/bookorderemail/{em}")
		public List<BookOrder> searchemail(@PathVariable("em") String em)
		{
			List<BookOrder> sp=ss.findAll(em);
			return sp;
		}
		
	}



