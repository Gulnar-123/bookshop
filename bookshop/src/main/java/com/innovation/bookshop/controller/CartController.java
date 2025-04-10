package com.innovation.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovation.bookshop.model.Cart;
import com.innovation.bookshop.model.Signup;
import com.innovation.bookshop.service.CartService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/bookshop/")
public class CartController {
@Autowired
private CartService cs;

@GetMapping("/cart/{email}")
public List<Cart> getall(@PathVariable("email")String email)
{
	return cs.findAll(email);
}
@PostMapping("/cart")
public ResponseEntity<Cart> save(@RequestBody Cart c)
{
	Cart c1=cs.add(c);
	return new ResponseEntity<Cart>(c1,HttpStatus.CREATED);
}

@DeleteMapping("/cart/{cartid}")
public ResponseEntity<Void> del(@PathVariable("cartid") int id)
{
	cs.deleteById(id);
	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
}

@PutMapping("/cart/{cartid}")
public ResponseEntity<Cart> update(@PathVariable("cartid")int id,@RequestBody Cart c)
{

	Cart c1=cs.update(id, c);
	return new ResponseEntity<Cart>(c1,HttpStatus.OK);
}

}
