package com.rueggerllc.book.repository;


import org.springframework.data.repository.CrudRepository;
import com.rueggerllc.book.beans.Book;

public interface BookRepository extends CrudRepository<Book,Long> {
	
	public Book findByIsbn(String isbn);

}
