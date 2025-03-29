package com.innovation.bookshop.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.innovation.bookshop.model.BookOrder;

@Repository
@Qualifier("boRepo")
public interface BookOrderRepository extends JpaRepository<BookOrder, Integer> {
List<BookOrder> findAllByEmailid(String emailid);
}
