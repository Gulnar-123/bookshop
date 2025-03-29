package com.innovation.bookshop.model;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Book {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long id;
private String bookname,author,type;
private int price;

@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
@JoinTable(name="book_images",joinColumns= {
		@JoinColumn(name="book_id")
},
inverseJoinColumns= {
		@JoinColumn(name="image_id")
}
)
private Set<ImageModel> bookImages;

public Book() {
	super();
	// TODO Auto-generated constructor stub
}

public Book(String bookname, String author, String type, int price) {
	super();
	this.bookname = bookname;
	this.author = author;
	this.type = type;
	this.price = price;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getBookname() {
	return bookname;
}

public void setBookname(String bookname) {
	this.bookname = bookname;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public Set<ImageModel> getBookImages() {
	return bookImages;
}

public void setBookImages(Set<ImageModel> bookImages) {
	this.bookImages = bookImages;
}




}