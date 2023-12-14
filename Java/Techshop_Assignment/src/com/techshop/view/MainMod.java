package com.techshop.view;

import java.util.Scanner;
import java.util.function.BiPredicate;

import com.techshop.controller.CustomerController;
import com.techshop.controller.InventoryController;
import com.techshop.controller.OrderController;
import com.techshop.controller.OrderDetailsController;
import com.techshop.controller.ProductController;
import com.techshop.exceptions.AuthorizationException;

/**
 * This is the main method
 */
public class MainMod {

	public static void main(String[] args) throws AuthorizationException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		BiPredicate<String, String> authentication = (username, password) -> username.equals("Harsh") && password.equals("harsh");
		String username="";
		String password="";
		System.out.print("Enter Username:");
		username=sc.next();
		System.out.println("\nEnter password:");
		password=sc.next();
		
		if(authentication.test(username,password)) {
			
			int choice;
			CustomerController customerController=new CustomerController();
			ProductController productController=new ProductController();
			OrderController orderController=new OrderController();
			OrderDetailsController orderDetailsController=new OrderDetailsController();
			InventoryController inventoryController=new InventoryController();
			
			customerController.putCustomersToArray();
			productController.putProductsToArray();
			orderController.putOrdersToArray();
			orderDetailsController.putOrderDetailsToArray();
			inventoryController.putInventoryToArray();
			
			do {
				System.out.println("Enter Select an option:");
				System.out.println("0. Exit");
				System.out.println("1. Customer Section");
				System.out.println("2. Product Section");
				System.out.println("3. Order Section");
				System.out.println("4. Order Details Section");
				System.out.println("5. Inventory");
				choice=sc.nextInt();
				switch(choice){
				
				case 0: break;
				
				case 1:	int k;
						System.out.println("0. Exit");
						System.out.println("1. Add Customer");
						System.out.println("2. Calculate total Orders");
						System.out.println("3. Get Customer Details");
						System.out.println("4. Display all customers");
						System.out.println("5. Update Customer Information");
						k=sc.nextInt();
						switch(k) {
						
							case 0: break;
							
							case 1:customerController.add_Customer();
							break;
							
							case 2:System.out.print("Enter customer id:");
							customerController.CalculateTotalOrders(sc.nextInt());
							break;
							
							case 3:System.out.print("Enter customer id: ");
								customerController.getCustomerDetails(sc.nextInt());
							break;
							
							case 4:customerController.displayAllCustomers();
							break;
							
							case 5:System.out.print("Enter customer id:");
							customerController.updateCustomerInfo(sc.nextInt());
							break;
						}
						break;
				
				case 2:	int l;
						System.out.println("0. Exit");
						System.out.println("1. Add Product Info");
						System.out.println("2. Get Product Details");
						System.out.println("3. Update Product Info");
						System.out.println("4. Check if Product is in Stock");
						System.out.println("5. Show Products list");
						System.out.println("6. Search Product Details by name");
						l=sc.nextInt();
						switch(l) {
						
							case 0: break;
							
							case 1:productController.add_Product();
							break;
							
							case 2:System.out.print("Enter product id:");
							productController.getProductDetails(sc.nextInt());
							break;
							
							case 3:System.out.print("Enter product id: ");
								productController.updateProductInfo(sc.nextInt());
							break;
							
							case 4:System.out.print("Enter product id: ");
								productController.isProductInStock(sc.nextInt());
							break;
							
							case 5:productController.showAllProducts();
							break;
							
							case 6:System.out.print("Enter Product name: ");
							productController.searchProduct(sc.next());
							break;
						}
						break;
					
				case 3:	int m;
						System.out.println("0. Exit");
						System.out.println("1. Add Order");
						System.out.println("2. Get Order Details");
						System.out.println("3. Calculate Total Amount");
						System.out.println("4. Update Order Status");
						System.out.println("5. Cancel Order");
						System.out.println("6. Sort Orders by date");
						System.out.println("7. Check Order Status");
						m=sc.nextInt();
						switch(m) {
						
							case 0: break;
							
							case 1:orderController.addOrder();;
							break;
							
							case 2:System.out.print("Enter order id:");
							orderController.getOrderDetails(sc.nextInt());
							break;
							
							case 3:System.out.print("Enter order id: ");
								orderController.calculateTotalAmount(sc.nextInt());
							break;
							
							case 4:System.out.print("Entern order id and updated status: ");
							orderController.updateOrderStatus(sc.nextInt(),sc.next());
							break;
							
							case 5:System.out.println("Enter order id: ");
								orderController.cancelOrder(sc.nextInt());
								break;
							
							case 6:orderController.showAllOrders();
							break;
							
							case 7:System.out.println("Enter order id: ");
								orderController.getOrderStatus(sc.nextInt());;
								break;
						}
				break;
					
				case 4:	int z;
						System.out.println("0. Exit");
						System.out.println("1. Add Order Details");
						System.out.println("2. Calculate Subtotal");
						System.out.println("3. Get Order Details Information");
						System.out.println("4. Display All Order Details");
						System.out.println("5. Update Order Quanntity");
						System.out.println("6. Add Discount");
						z=sc.nextInt();
						switch(z) {
						
							case 0: break;
							
							case 1:orderDetailsController.addOrderDetails();
							break;
							
							case 2:System.out.print("Enter order details id:");
							orderDetailsController.calculateSubTotal(sc.nextInt());
							break;
							
							case 3:System.out.print("Enter order details id: ");
								orderDetailsController.getOrderDetailInfo(sc.nextInt());
							break;
							
							case 4:orderDetailsController.getAllOrderDetailInfo();
							break;
							
							case 5:System.out.print("Entern order details id and Quantity: ");
							orderDetailsController.updateQuantity(sc.nextInt(), sc.nextInt());
							break;
							
							case 6:System.out.println("Enter order details id and discount(in decimal): ");
								orderDetailsController.AddDiscound(sc.nextInt(), sc.nextDouble());
							break;
						}
						break;
				
				case 5:	int q;
						System.out.println("0. Exit");
						System.out.println("1. Add product to inventory");
						System.out.println("2. Get details for product in inventory");
						System.out.println("3. Get Quantity in Stock");
						System.out.println("4. Remove product from Inventory");
						System.out.println("5. Update Stock Quantity of product");
						System.out.println("6. Check product availability");
						System.out.println("7. Get Inventory value");
						System.out.println("8. List all low stock products");
						System.out.println("9. List all out of stock products");
						System.out.println("10. List all products");
						System.out.println("11. Get Sorted List by Product Id");
						q=sc.nextInt();
						switch(q) {
						
							case 0: break;
							
							case 1:inventoryController.addToInventory();
							break;
							
							case 2:System.out.print("Enter product id:");
							inventoryController.getProduct(sc.nextInt());
							break;
							
							case 3:System.out.print("Enter product id: ");
							inventoryController.getQuantityInStock(sc.nextInt());
							break;
							
							case 4:System.out.print("Entern product id and quantity: ");
							inventoryController.removeFromInvenory(sc.nextInt(), sc.nextInt());
							break;
							
							case 5:System.out.println("Enter product id and quantity: ");
								inventoryController.updateStockQuantity(sc.nextInt(), sc.nextInt());
							break;
							
							case 6:System.out.println("Enter product id and desired quantity for availability: ");
							inventoryController.isProductAvailable(sc.nextInt(),sc.nextInt());
							break;
							
							case 7:inventoryController.getInventoryValue();
							break;
							
							case 8:System.out.println("Enter product threshold quantity: ");
							inventoryController.listLowStockProducts(sc.nextInt());
							break;
							
							case 9:inventoryController.listOutOfStockProducts();
							break;
							
							case 10:inventoryController.listAllProducts();
							break;
							
							case 11:inventoryController.SortedInventoryList();
							break;
							
						}
						break;

				
				default: System.out.println("Enter valid option:");
				break;
				}
			}while(choice!=0);
		}else {
			throw new AuthorizationException();
		}
	}

}
