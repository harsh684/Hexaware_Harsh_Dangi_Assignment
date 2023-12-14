package com.techshop.exceptions;

public class AuthorizationException extends Exception {
	
	public AuthorizationException() {
		System.err.println("from authorization exception constructor");
	}
	 public String toString() {
		 return "Authorization Denied";
	 }
}
