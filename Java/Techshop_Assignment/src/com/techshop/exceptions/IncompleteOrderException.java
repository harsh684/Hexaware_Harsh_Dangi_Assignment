package com.techshop.exceptions;

public class IncompleteOrderException extends Exception {

	public IncompleteOrderException() {
		// TODO Auto-generated constructor stub
		System.err.println("from incomplete order exception constructor");
	}
	
	public String toString() {
		return "Order Incomplete";
	}
}
