package com.practice.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.practice.bookclub.models.Book;
import com.practice.bookclub.repositories.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}
	
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}

	public Book findOne(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	public Book create(Book book) {
		return bookRepo.save(book);
	}
	
	public Book update(Book book) {
		return bookRepo.save(book);
	}
	
	public void delete(Long id) {
		bookRepo.deleteById(id);
	}
	
}
