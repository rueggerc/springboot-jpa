package com.rueggerllc.book.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rueggerllc.book.beans.Book;
import com.rueggerllc.book.repository.BookRepository;

@RestController
@RequestMapping("/")
public class BookController {
	
	private BookRepository repo;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public BookController(BookRepository repo) {
		this.repo = repo;
	}
	
	// GET all books
	@GetMapping("/books")
	public Iterable<Book> allBook() {
		logger.info("GetBooks BEGIN");
		return repo.findAll();
	}
	
	// GET book by ISBN
	@GetMapping("/books/isbn/{isbn}")
	public Book getBookByISBN(@PathVariable String isbn) {
		logger.info("Get Book By ISBN: " + isbn);
		return repo.findByIsbn(isbn);
	}
	
	// Save a book
	@PostMapping("/book")
	public String saveBook(@RequestBody Book book) {
		logger.debug("======= Save Book:" + book);
		repo.save(book);
		logger.debug("Book saved successfully in Database");
		return "Book saved successfully in Database";
	}
	
	// Update A Book
	@PutMapping("/book")
	public String updateBook(@RequestBody Book book) {
		logger.debug("======= Update Book:" + book);
		Book bookToUpdate = repo.findByIsbn(book.getIsbn());
		bookToUpdate.setTitle(book.getTitle());
		bookToUpdate.setAuthor(book.getAuthor());
		repo.save(bookToUpdate);
		return "Book Updated in Database";
	}
	
	
	// Delete A Book
	@DeleteMapping("/book")
	public String deleteBook(@PathVariable String isbn) {
		logger.debug("======= Delete Book:" + isbn);
		Book bookToDelete = repo.findByIsbn(isbn);
		logger.info("BookToDelete ID=" + bookToDelete.getId());
		repo.delete(bookToDelete.getId());
		return "Book Deleted from Database";
	}


    
    
}