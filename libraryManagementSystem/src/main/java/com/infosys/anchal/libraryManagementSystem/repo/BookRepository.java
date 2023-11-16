package com.infosys.anchal.libraryManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.anchal.libraryManagementSystem.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
