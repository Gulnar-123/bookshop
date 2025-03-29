package com.innovation.bookshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BookOrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int srno;
	private int bookid,qty,price,amt;

	public BookOrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookOrderDetail( int bookid, int qty, int price, int amt) {
		super();
		
		this.bookid = bookid;
		this.qty = qty;
		this.price = price;
		this.amt = amt;
	}

	
	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}

	@Override
	public String toString() {
		return "bookOrderDetail [ bookid=" + bookid + ", qty=" + qty + ", price=" + price
				+ ", amt=" + amt + "]";
	}
	
}
