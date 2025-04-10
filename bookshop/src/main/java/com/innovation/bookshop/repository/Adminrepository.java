package com.innovation.bookshop.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.innovation.bookshop.model.Admin;
import com.innovation.bookshop.model.Signup;

@Repository
@Qualifier("adminRepo")

public interface Adminrepository extends JpaRepository<Admin, Integer> {
	Admin findByEmailAndPassword(String email,String password);
}
