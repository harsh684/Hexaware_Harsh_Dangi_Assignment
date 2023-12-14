package com.techshop.entities;

import java.time.LocalDate;

public class Orders implements Comparable<Orders> {
	private Customers customer;
	private int orderId;
	private LocalDate orderDate;
	private String status;
	private double totalAmount;
	//private OrderDetails orderDetails;

public Orders() {
	super();
}
	
public Orders(Customers customer, int orderId, LocalDate orderDate, double totalAmount, String status){// OrderDetails orderDetails 
	super();
	this.customer = customer;
	this.orderId = orderId;
	this.orderDate = orderDate;
	this.totalAmount = totalAmount;
	this.status=status;
	//this.orderDetails = orderDetails;
	}


public Customers getCustomer() {
	return customer;
}

public void setCustomer(Customers customer) {
	this.customer = customer;
}

public int getOrderId() {
	return orderId;
}

public void setOrderId(int orderId) {
	this.orderId = orderId;
}

public LocalDate getOrderDate() {
	return orderDate;
}

public void setOrderDate(LocalDate orderDate) {
	this.orderDate = orderDate;
}

public double getTotalAmount() {
	return totalAmount;
}

public void setTotalAmount(double totalAmount) {
	this.totalAmount = totalAmount;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status=status;
}



@Override
public String toString() {
	return "Orders [customer=" + customer.getFirstName()+
	" "
	+customer.getLastName() + ", orderId=" 
	+ orderId + ", orderDate=" 
	+ orderDate + ", status="
	+ status + ", totalAmount=" + totalAmount + "]\n";
}

@Override
public int compareTo(Orders otherOrder) {
	// TODO Auto-generated method stub
	return this.orderDate.compareTo(otherOrder.getOrderDate());
}
	
	// ///////////////////////////////////////////////////

}
