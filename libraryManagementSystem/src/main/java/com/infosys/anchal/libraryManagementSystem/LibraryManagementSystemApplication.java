package com.infosys.anchal.libraryManagementSystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

import com.infosys.anchal.libraryManagementSystem.model.Book;
import com.infosys.anchal.libraryManagementSystem.service.BookService;

@SpringBootApplication
public class LibraryManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementSystemApplication.class, args);
    }
}

@Component
class LibraryManagementRunner implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a new book");
            System.out.println("2. Remove a book");
            System.out.println("3. Update book price");
            System.out.println("4. Display available books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    removeBook(scanner);
                    break;
                case 3:
                    updateBookPrice(scanner);
                    break;
                case 4:
                    displayBooks();
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private void addBook(Scanner scanner) {
        System.out.print("Enter book name: ");
        String name = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setPrice(price);

        bookService.addBook(book);
        System.out.println("Book added successfully.");
    }

    private void removeBook(Scanner scanner) {
        System.out.print("Enter the book ID to remove: ");
        int id = scanner.nextInt();

        if (bookService.bookExists(id)) {
            bookService.removeBook(id);
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book with ID " + id + " not found.");
        }
    }

    private void updateBookPrice(Scanner scanner) {
        System.out.print("Enter the book ID to update: ");
        int id = scanner.nextInt();
        
        if (bookService.bookExists(id)) {
            System.out.print("Enter the new price: ");
            double price = scanner.nextDouble();
            bookService.updateBookPrice(id, price);
            System.out.println("Book price updated successfully.");
        } else {
            System.out.println("Book with ID " + id + " not found.");
        }
    }

    private void displayBooks() {
        Iterable<Book> books = bookService.getAllBooks();
        System.out.println("Available Books:");
        for (Book book : books) {
            System.out.println("ID: " + book.getId() + ", " + book.getName() + " by " + book.getAuthor() + " - Price: " + book.getPrice());
        }
    }
}
