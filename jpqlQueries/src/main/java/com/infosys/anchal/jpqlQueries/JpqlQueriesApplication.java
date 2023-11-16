package com.infosys.anchal.jpqlQueries;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.infosys.anchal.jpqlQueries.entity.Customer;
import com.infosys.anchal.jpqlQueries.repo.CustomerRepository;

@SpringBootApplication
public class JpqlQueriesApplication implements CommandLineRunner {
	
	@Autowired
	private CustomerRepository customerRepo;

	public static void main(String[] args) {
		SpringApplication.run(JpqlQueriesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Customer> customers = new ArrayList<>();

        customers.add(new Customer(1, "Anchal", "15/04/2002", 2));
        customers.add(new Customer(2, "John", "10/05/2000", 3));
        customers.add(new Customer(3, "Alice", "20/03/2005", 5));
        
        // saving the list of data
        customerRepo.saveAll(customers);
       
        System.out.println("\n------------ Finding all the Customer records ------------------");
        customers = customerRepo.findAll();
        show(customers);
        
        System.out.println("\n------------ Finding all the Customer records using native query ------------------");
        customers = customerRepo.findCustomers();
        show(customers);
        
        
        System.out.println("\n------------ Finding Customer records by their Id ------------------");
        customers = customerRepo.findCustomersByCustomerId(1);
        show(customers);

        System.out.println("\n------------ Finding Customer records by their name ------------------");
        customers = customerRepo.findCustomersByCustomerName("Anchal");
        show(customers);
        
        System.out.println("\n------------ Finding Customer records by their orderDate ------------------");
        customers = customerRepo.findCustomersByOrderDate("20/03/2005");
        show(customers);
        
        System.out.println("\n------------ Finding Customer records by their name ------------------");
        customers = customerRepo.findCustomersByQuantity(5);
        show(customers);
        
        System.out.println("\n------------ Finding Customer records with Quantity Greater Than 3 ------------------");
        customers = customerRepo.findByQuantityGreaterThan(3);
        show(customers);

        System.out.println("\n------------ Finding Customer records with Order Date Between '15/04/2002' and '20/03/2005' ------------------");
        customers = customerRepo.findByOrderDateBetween("15/04/2002", "20/03/2005");
        show(customers);

        System.out.println("\n------------ Finding Customer records with Name 'Anchal' and Order Date '15/04/2002' ------------------");
        customers = customerRepo.findByCustomerNameAndOrderDate("Anchal", "15/04/2002");
        show(customers);

        System.out.println("\n------------ Finding Customer records with Name 'Anchal' and Quantity 2 ------------------");
        customers = customerRepo.findByCustomerNameAndQuantity("Anchal", 2);
        show(customers);
        
        System.out.println("\n------------ Finding Customer records with Order Date starting with '15' ------------------");
        customers = customerRepo.findCustomersByOrderDateStartingWith("15");
        show(customers);

        System.out.println("\n------------ Finding Customer records with Names ending with 'al' ------------------");
        customers = customerRepo.findCustomersByCustomerNameEndingWith("al");
        show(customers);
        
        System.out.println("\n------------ Finding Customer records with Names containing 'An' ------------------");
        customers = customerRepo.findCustomersByCustomerNameContaining("An");
        show(customers);

        System.out.println("\n------------ Finding Customer records with Names (case-insensitive) containing 'An' ------------------");
        customers = customerRepo.findCustomersByCaseInsensitivePartialName("An");
        show(customers);
        
        System.out.println("\n------------ Finding all the Customer records sorted by Customer Name (Ascending) ------------------");
        customers = customerRepo.findAllCustomersSortedByCustomerIdAsc();
        show(customers);
        
        
        System.out.println("\n------------ Finding all the Customer using Pagination ------------------");

        int page = 0;
        int pageSize = 2; 

        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Customer> customerPage = customerRepo.findAllCustomersWithPagination(pageable);

        // Extract and display the results
        customers = customerPage.getContent();
        show(customers);
        
        
        System.out.println("\n------------ Finding all the Customer using Pagination and sorted by customer name -----------------");

        Sort sort = Sort.by("customerName").ascending(); // Sort by customerId in ascending order
        pageable = PageRequest.of(page, pageSize, sort);
        customerPage = customerRepo.findAllCustomersWithPagination(pageable);
        customers = customerPage.getContent();
        show(customers);
        
        System.out.println("\n------------ Updating the customer name with id 1 -----------------");
        customerRepo.updateCustomerName(1, "Rajveer");
        customers = customerRepo.findAll();
        show(customers);
        
	}
	
	public void show(List<Customer> customers) {
		customers.forEach(System.out::println);
	}

}
