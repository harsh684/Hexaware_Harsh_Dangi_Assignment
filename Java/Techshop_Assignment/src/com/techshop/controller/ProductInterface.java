package com.techshop.controller;

import java.util.List;

import com.techshop.entities.Products;

public interface ProductInterface {

	//Products
	
	public void add_Product();
	
	public void getProductDetails(int pid);
	
	public void updateProductInfo(int pid);
	
	public void isProductInStock(int pid);
	
	//show all products
	public void showAllProducts();
	
	public List<Products> getProductList();
}

