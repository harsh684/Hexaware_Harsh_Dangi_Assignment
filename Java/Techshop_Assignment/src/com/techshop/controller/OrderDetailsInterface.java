package com.techshop.controller;

import java.io.IOException;
import java.util.List;

import com.techshop.entities.OrderDetails;
import com.techshop.entities.Orders;
import com.techshop.entities.Products;

public interface OrderDetailsInterface {

	//Order Details
	public void addOrderDetails();
		
		public void calculateSubTotal(int odid);
			
		public void getOrderDetailInfo(int odid);
			
		public void updateQuantity(int odid,int quant);
		
		public void AddDiscound(int odid,double discount);
		
		public List<OrderDetails> getOrderDetailsList();
}
