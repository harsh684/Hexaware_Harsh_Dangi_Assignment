package com.techshop.exceptions;

public class InsufficientStockException extends Exception {
	public InsufficientStockException() {
		// TODO Auto-generated constructor stub
		System.err.println("from insufficient stock constructor");
	}
	
	public String toString() {
		return "Not enough products in stock";
	}
}
