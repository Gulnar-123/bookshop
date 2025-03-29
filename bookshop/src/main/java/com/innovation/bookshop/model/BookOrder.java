package com.innovation.bookshop.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderColumn;

@Entity
public class BookOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderno;
	
	private String emailid,dt,status;
	private int totalamt;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderno")
	
	private List<BookOrderDetail> booklst;
	public BookOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookOrder(String emailid, String dt, String status, int totalamt, List<BookOrderDetail> booklst) {
		super();
		this.emailid = emailid;
		this.dt = dt;
		this.status = status;
		this.totalamt = totalamt;
		this.booklst = booklst;
	}
	public int getOrderno() {
		return orderno;
	}
	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTotalamt() {
		return totalamt;
	}
	public void setTotalamt(int totalamt) {
		this.totalamt = totalamt;
	}
	public List<BookOrderDetail> getBooklst() {
		return booklst;
	}
	public void setBooklst(List<BookOrderDetail> booklst) {
		this.booklst = booklst;
	}
	@Override
	public String toString() {
		return "BookOrder [orderno=" + orderno + ", emailid=" + emailid + ", dt=" + dt + ", status=" + status
				+ ", totalamt=" + totalamt + ", booklst=" + booklst + "]";
	}
	
	
}
