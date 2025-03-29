package com.innovation.bookshop.service;

import java.util.List;

import com.innovation.bookshop.model.Signup;

public interface SignupService {
Signup add(Signup s);
List<Signup> findAll();
void deleteById(int id);
Signup update(int id,Signup ns);
Signup search(int id);
Signup login(String em,String ps);
}
