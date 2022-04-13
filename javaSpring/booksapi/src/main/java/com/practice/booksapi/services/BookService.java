package com.practice.booksapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.practice.booksapi.models.Book;
import com.practice.booksapi.repositories.BookRepositories;

@Service
public class BookService {

	// adding the book repository as a dependency
    private final BookRepositories bookRepository;
    
    public BookService(BookRepositories bookRepository) {
    	
        this.bookRepository = bookRepository;
    }
    
    
    // returns all the books
    public List<Book> allBooks() {
    	//return the call to the BookRepo method called bookRepositories.findAll();    	
        return bookRepository.findAll();
    }
    
    public String write(String s) {
    	return "String";
    }
    
    
    // creates a book
    public Book createBook(Book b) {
    	
        return bookRepository.save(b);
    }
    
    
    // retrieves a book
    public Book findBook(Long id) {
    	
        Optional<Book> optionalBook = bookRepository.findById(id);
        
        if(optionalBook.isPresent()) {
        	
            return optionalBook.get();
            
        }else {
        	
            return null;
        }
        
    }
        
    
        //Need a method called updateBook
        //Needs to return a book
        public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
        	
        	
        	Optional<Book> optionalBook = bookRepository.findById(id);
            
            if(optionalBook.isPresent()) {
            	
                Book thisBook =  optionalBook.get();
                
                thisBook.setTitle(title);
                thisBook.setDescription(desc);
                thisBook.setLanguage(lang);
                thisBook.setNumberOfPages(numOfPages);
                
                return thisBook;
                
            }else {
            	
                return null;
            }
            
//        public void deleteBook(Long )
    }
}























