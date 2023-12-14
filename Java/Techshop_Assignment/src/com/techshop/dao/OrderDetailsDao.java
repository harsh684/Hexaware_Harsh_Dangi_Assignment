package com.techshop.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.techshop.controller.OrderController;
import com.techshop.controller.OrderDetailsController;
import com.techshop.controller.ProductController;
import com.techshop.entities.OrderDetails;
import com.techshop.entities.Orders;
import com.techshop.entities.Products;
import com.techshop.util.DbConnection;

public class OrderDetailsDao {

	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	OrderDetails orderDetail;
	ResultSet resultSet;
	
	public void putOrderDetailsToArray() {
		try {
			connection= DbConnection.getMyDbConnection();
			statement= connection.createStatement();
			String query="select * from OrderDetails";
			resultSet=statement.executeQuery(query);
			while(resultSet.next()) {
				orderDetail=new OrderDetails();
				orderDetail.setOrderDetailsid(resultSet.getInt(1));
				for(Orders o:OrderController.orderList) {
					if(o.getOrderId()==resultSet.getInt(2)) {
						orderDetail.setOrder(o);
						break;
					}
				}
				for(Products p:ProductController.productsList) {
					if(p.getProductId()==resultSet.getInt(3)) {
						orderDetail.setProduct(p);
						break;
					}
				}
				orderDetail.setQuantity(resultSet.getInt(4));
				OrderDetailsController.orderDetailsList.add(orderDetail);
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	public void insertOrderDetails(OrderDetails o) {
		// TODO Auto-generated method stub
		if(o!=null){
			try {
				connection= DbConnection.getMyDbConnection();
				preparedStatement=connection.prepareStatement("insert into OrderDetails values(?,?,?,?)");
				preparedStatement.setInt(1, o.getOrderDetailsid());
				preparedStatement.setInt(2, o.getOrder().getOrderId());
				preparedStatement.setInt(3, o.getProduct().getProductId());
				preparedStatement.setInt(4, o.getQuantity());
				
				int noofrows = preparedStatement.executeUpdate();
				System.out.println(noofrows + "Order Details inserted successfully !!!");
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void calculateSubTotal(int odid) {
		// TODO Auto-generated method stub
		try {
			connection= DbConnection.getMyDbConnection();
			String query="select (od.quantity * p.price) AS subtotal FROM OrderDetails od JOIN Products p ON od.productid = p.productid WHERE od.orderdetailid ="+odid;
			resultSet= preparedStatement.executeQuery(query);
			while(resultSet.next()) {
				System.out.println("Order Detail Subtotal  : " + resultSet.getDouble(1));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void getOrderDetailInfo(int odid) {
		// TODO Auto-generated method stub
		try {
			connection= DbConnection.getMyDbConnection();
			statement= connection.createStatement();
			String query="select * from OrderDetails where orderdetailid="+odid;
			resultSet=statement.executeQuery(query);
			while(resultSet.next()) {
				System.out.println("Order Detail Id  : " + resultSet.getInt(1));
				System.out.println("Order Id  : " + resultSet.getInt(2));
				System.out.println("Product Id  : " + resultSet.getInt(3));
				System.out.println("Order Quantity  : " + resultSet.getInt(4));
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}

	public void getAllOrderDetailInfo() {
		// TODO Auto-generated method stub
		try {
			connection= DbConnection.getMyDbConnection();
			statement= connection.createStatement();
			String query="select * from OrderDetails";
			resultSet=statement.executeQuery(query);
			while(resultSet.next()) {
				System.out.println("Order Detail Id  : " + resultSet.getInt(1));
				System.out.println("Order Id  : " + resultSet.getInt(2));
				System.out.println("Product Id  : " + resultSet.getInt(3));
				System.out.println("Order Quantity  : " + resultSet.getInt(4));
				System.out.println();
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	public void updateQuantity(int odid,int quant) {
		// TODO Auto-generated method stub
		try {
			connection= DbConnection.getMyDbConnection();
			preparedStatement=connection.prepareStatement("update OrderDetails set quantity="+quant+" where orderdetailid="+odid);
			
			int noofrows = preparedStatement.executeUpdate();
			System.out.println(noofrows + "Order Detail Quantity Updated successfully !!!");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addDiscount(int odid,double discount) {
		try {
			connection= DbConnection.getMyDbConnection();
			String query="select (o.totalamount-(o.totalamount*"+discount+")) discounted_price from OrderDetails od join Orders o on od.orderid=o.orderid where od.orderdetailid="+odid;
			preparedStatement=connection.prepareStatement(query);
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("Discount applied!!!\n"
						+ "New Discounted price: "+resultSet.getDouble(1));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
