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
	private String booktitle;
	private int qty,price,amt;

	public BookOrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	

	public BookOrderDetail(String booktitle, int qty, int price, int amt) {
		super();
		this.booktitle = booktitle;
		this.qty = qty;
		this.price = price;
		this.amt = amt;
	}





	public int getSrno() {
		return srno;
	}





	public void setSrno(int srno) {
		this.srno = srno;
	}





	public String getBooktitle() {
		return booktitle;
	}





	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
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

	
	
}
