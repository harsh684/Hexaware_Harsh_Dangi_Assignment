package com.techshop.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {

	// TODO Auto-generated method stub
	static Connection connection;
			
	public static Connection getMyDbConnection() {
	
	String filename="db.properties";
	Properties props=new Properties();
	FileInputStream fis;
	
	try {
		fis=new FileInputStream(filename);
		props.load(fis);
		
		String url=props.getProperty("db.url");
		String un=props.getProperty("db.username");
		String pass=props.getProperty("db.password");
		
		//System.out.println(url+un+pass);
		//connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Techshop","root","harsh");
		
		connection=DriverManager.getConnection(url,un,pass);
		
	}catch(SQLException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}
	
	return connection;
	}
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		System.out.println(getMyDbConnection());
		}
	}
