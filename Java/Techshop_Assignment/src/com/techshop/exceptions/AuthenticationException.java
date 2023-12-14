package com.techshop.exceptions;

public class AuthenticationException {
	public AuthenticationException() {
		System.err.println("from Authentication exception constructor");
	}
	
	public String toString() {
		return "Authentication Failed";
	}
}
