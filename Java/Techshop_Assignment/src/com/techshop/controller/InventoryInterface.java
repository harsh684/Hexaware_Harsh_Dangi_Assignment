package com.techshop.controller;

import java.util.List;

import com.techshop.entities.Inventory;
import com.techshop.entities.Products;

public interface InventoryInterface {

		//Inventory
		public void putInventoryToArray();
		
		public Products returnProductObject(int pid);
		
		public void addToInventory();
		
		public void getProduct(int pid);
		
		public void getQuantityInStock(int pid);
		
		public void removeFromInvenory(int id,int q);
		
		public void updateStockQuantity(int id,int q);
		
		public boolean isProductAvailable(int id,int qtc);
		
		public void getInventoryValue();
		
		public void listLowStockProducts(int threshold);
		
		public void listOutOfStockProducts();
		
		public void listAllProducts();
		
		public List<Inventory> getInventoryList();
}
