package com.infosys.anchal.jpqlQueries.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Customer01")
public class Customer {
   
	@Id
    private int customerId;
    private String customerName;
    private String orderDate;
    private int quantity;
    
    public Customer() {
    	super();
    }
    
    public Customer(int customerId, String customerName, String orderDate, int quantity) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
        this.orderDate = orderDate;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", orderDate=" + orderDate
				+ ", quantity=" + quantity + "]";
	}
}

