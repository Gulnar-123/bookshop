package com.innovation.bookshop.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.innovation.bookshop.model.Signup;

@Repository
@Qualifier("signRepo")
public interface SignupRepository extends JpaRepository<Signup, Integer> {

	Signup findByEmailAndPassword(String email,String password);
}
