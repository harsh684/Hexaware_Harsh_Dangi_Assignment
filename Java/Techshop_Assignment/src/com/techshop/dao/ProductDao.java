package com.techshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.techshop.controller.ProductController;
import com.techshop.entities.Products;
import com.techshop.util.DbConnection;

public class ProductDao {

	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	Products productObject;
	ResultSet resultSet;
	
	public void putProductsToArray() {
		// TODO Auto-generated method stub
		try {
			connection= DbConnection.getMyDbConnection();
			statement= connection.createStatement();
			resultSet=statement.executeQuery("select * from Products");
				while(resultSet.next()) {
					productObject=new Products();
					productObject.setProductId(resultSet.getInt(1));
					productObject.setProductName(resultSet.getString(2));
					productObject.setDescription(resultSet.getString(3));
					productObject.setPrice(resultSet.getDouble(4));
					ProductController.productsList.add(productObject);
				}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
	}
	
	public void insertProduct(Products p) {
		// TODO Auto-generated method stub
		try {
			connection= DbConnection.getMyDbConnection();
			preparedStatement=connection.prepareStatement("insert into Products values(?,?,?,?)");
			preparedStatement.setInt(1, p.getProductId());
			preparedStatement.setString(2, p.getProductName());
			preparedStatement.setString(3, p.getDescription());
			preparedStatement.setDouble(4, p.getPrice());
			int noofrows = preparedStatement.executeUpdate();
			System.out.println(noofrows + " inserted successfully !!!");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void showAllProducts() {
		// TODO Auto-generated method stub
		try {
			connection= DbConnection.getMyDbConnection();
			statement= connection.createStatement();
			resultSet=statement.executeQuery("select * from Products");
				while(resultSet.next()) {
					System.out.println("Product Id  : " + resultSet.getInt(1));
					System.out.println("Product Name  : " + resultSet.getString(2));
					System.out.println("Product Description  : " + resultSet.getString(3));
					System.out.println("Product Price  : " + resultSet.getDouble(4));
				}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}

	public void isProductInStock(int pid) {
		try {
			connection= DbConnection.getMyDbConnection();
			statement= connection.createStatement();
			resultSet=statement.executeQuery("select 1 from inventory where productid="+pid+" and quantityinstock>0;");
				while(resultSet.next()) {
					if(resultSet.getInt(1)==1) {
						System.out.println("Product is in stock");
					}else {
						System.out.println("Product Out of stock");
					}
				}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	public void getProductDetails(int pid) {
		// TODO Auto-generated method stub
		try {
			connection= DbConnection.getMyDbConnection();
			statement= connection.createStatement();
			String query="select * from Products where productid="+pid;
			resultSet=statement.executeQuery(query);
				while(resultSet.next()) {
					System.out.println("Product Id  : " + resultSet.getInt(1));
					System.out.println("Product Name  : " + resultSet.getString(2));
					System.out.println("Product Description  : " + resultSet.getString(3));
					System.out.println("Product Price  : " + resultSet.getDouble(4));
				}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}

	public void searchProduct(String name) {
		try {
			connection= DbConnection.getMyDbConnection();
			statement= connection.createStatement();
			String query="select * from Products where pname like '"+name+"'";
			resultSet=statement.executeQuery(query);
		
				while(resultSet.next()) {
					System.out.println("Product Id  : " + resultSet.getInt(1));
					System.out.println("Product Name  : " + resultSet.getString(2));
					System.out.println("Product Description  : " + resultSet.getString(3));
					System.out.println("Product Price  : " + resultSet.getDouble(4));
				}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	public void updateProductDetails(Products product) {
		// TODO Auto-generated method stub
		try {
			connection= DbConnection.getMyDbConnection();
			preparedStatement=connection.prepareStatement("update Products set pname='"+product.getProductName()+"',pdesc='"+product.getDescription()+
					"',price="+product.getPrice()+" where productid="+product.getProductId());
			
			int noofrows = preparedStatement.executeUpdate();
			System.out.println(noofrows + "Product Updated successfully !!!");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}


}
