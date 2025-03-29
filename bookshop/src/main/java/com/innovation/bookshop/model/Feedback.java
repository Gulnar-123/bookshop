package com.innovation.bookshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feedbackid;
	private String email,message;
	private int rating;
	
	
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feedback(int rating, String email, String message) {
		super();
			this.rating = rating;
		this.email = email;
		this.message = message;
	}

	public int getFeedbackid() {
		return feedbackid;
	}

	public void setFeedbackid(int feedbackid) {
		this.feedbackid = feedbackid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackid=" + feedbackid + ", email=" + email + ", message=" + message + ", rating=" + rating
				+ "]";
	}
	
	
	
	
}
