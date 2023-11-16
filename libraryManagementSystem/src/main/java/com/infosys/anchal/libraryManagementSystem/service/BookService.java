package com.infosys.anchal.libraryManagementSystem.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.anchal.libraryManagementSystem.model.Book;
import com.infosys.anchal.libraryManagementSystem.repo.BookRepository;

@Service
public class BookService {
	@Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void removeBook(int id) {
        bookRepository.deleteById(id);
    }
    
    public boolean bookExists(Integer id) {
        return bookRepository.existsById(id);
    }

    public Book updateBookPrice(int id, double price) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.setPrice(price);
            return bookRepository.save(book);
        }
        return null;
    }

    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
