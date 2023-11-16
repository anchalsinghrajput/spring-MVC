package com.infosys.anchal.jpqlQueries.repo;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.infosys.anchal.jpqlQueries.entity.Customer;

import jakarta.transaction.Transactional;

@Repository	
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query("select c from Customer c")
	public List<Customer> findAll();
	
	@Query(value= "select * from customer01", nativeQuery= true)
	public List<Customer> findCustomers();
	
	@Query("SELECT c FROM Customer c WHERE c.customerId = :customerId")
	public List<Customer> findCustomersByCustomerId(@Param("customerId") int customerId);

	@Query("select c from Customer c where c.customerName = ?1")
	public List<Customer> findCustomersByCustomerName(String customerName);
	
	@Query("select c from Customer c where c.orderDate = :o")
	public List<Customer> findCustomersByOrderDate(@Param("o")String orderDate);
	
	@Query("SELECT c FROM Customer c WHERE c.quantity = :quantity")
	public List<Customer> findCustomersByQuantity(@Param("quantity") int quantity);
	
	@Query("SELECT c FROM Customer c WHERE c.quantity > :quantity")
	public List<Customer> findByQuantityGreaterThan(@Param("quantity") int quantity);
	
	@Query("SELECT c FROM Customer c WHERE c.orderDate BETWEEN :startDate AND :endDate")
	public List<Customer> findByOrderDateBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);

	@Query("SELECT c FROM Customer c WHERE c.customerName = :customerName AND c.orderDate = :orderDate")
	public List<Customer> findByCustomerNameAndOrderDate(@Param("customerName") String customerName, @Param("orderDate") String orderDate);

	@Query("SELECT c FROM Customer c WHERE c.customerName = :customerName AND c.quantity = :quantity")
	public List<Customer> findByCustomerNameAndQuantity(@Param("customerName") String customerName, @Param("quantity") int quantity);

	@Query("SELECT c FROM Customer c WHERE c.orderDate LIKE :startDate%")
	public List<Customer> findCustomersByOrderDateStartingWith(@Param("startDate") String startDate);
	
	@Query("SELECT c FROM Customer c WHERE c.customerName LIKE %:endingString")
	public List<Customer> findCustomersByCustomerNameEndingWith(@Param("endingString") String endingString);

	@Query("SELECT c FROM Customer c WHERE c.customerName LIKE %:searchString%")
	public List<Customer> findCustomersByCustomerNameContaining(@Param("searchString") String searchString);
	
	@Query("SELECT c FROM Customer c WHERE LOWER(c.customerName) LIKE LOWER(CONCAT('%', :partialName, '%'))")
	public List<Customer> findCustomersByCaseInsensitivePartialName(@Param("partialName") String partialName);
	
	@Query("SELECT c FROM Customer c ORDER BY c.customerId ASC")
	public List<Customer> findAllCustomersSortedByCustomerIdAsc();
	
	@Query("SELECT c FROM Customer c")
	public Page<Customer> findAllCustomersWithPagination(Pageable pageable);

	@Transactional
	@Modifying
	@Query("UPDATE Customer c SET c.customerName = :newName WHERE c.customerId = :customerId")
	void updateCustomerName(@Param("customerId") int customerId, @Param("newName") String newName);
}
