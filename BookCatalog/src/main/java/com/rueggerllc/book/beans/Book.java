package com.rueggerllc.book.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="book")
@Data
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long  id;
	private String isbn;
	private String title;
	private String author;
	
    
}