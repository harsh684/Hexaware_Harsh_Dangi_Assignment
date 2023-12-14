-- task 1
create database Techshop;

use Techshop;

-- task 2 (DDL)
-- creating customers table
create table Customers(customerid int Primary key, firstname varchar(20),
lastname varchar(20),email varchar(20),phno varchar(10),address varchar(30));

select * from Orders;

-- create orders table
create table Orders(orderid int primary key,
    customerid INT,
    orderdate DATE,
    ostatus varchar(8),
    totalamount DECIMAL(10, 2),
    FOREIGN KEY (customerid) REFERENCES Customers(customerid));

-- create order_details table
create table OrderDetails(
orderdetailid int primary key, orderid int, productid int, quantity int,
FOREIGN KEY (orderid) REFERENCES Orders(orderid) ON DELETE CASCADE,
FOREIGN KEY (productid) REFERENCES Products(productid));

select * from Customers;
select * from Orders;
select * from Products;
select * from OrderDetails;
delete from Customers where customerid=13;
-- creating inventory table
create table Inventory(
inventoryid int primary key, productid int, 
quantityinstock int, laststockupdate date,
FOREIGN KEY (productid) REFERENCES Products(productid));

-- creating Products table
create table Products(productid int Primary key,
pname varchar(20),
pdesc varchar(100),
price decimal(9,2));

-- Inserting records
-- task 3.a)

insert into Customers values(1, 'Harsh', 'Dangi', 'harsh@gmail.com', '9134567893', 'Haldwani');
insert into Customers values(2, 'Harshita', 'Mehra', 'harshita@gmail.com', '9134567999', 'Noida');
insert into Customers values(3, 'Akash', 'Chatterjee', 'akash@gmail.com', '9134565555', 'Assam');
insert into Customers values(4, 'Diya', 'Koranga', 'diya@gmail.com', '9134544444', 'Banglore');
insert into Customers values(5, 'Piyush', 'Sharma', 'piyush@gmail.com', '9134588888', 'Chennai');
insert into Customers values(6, 'Deepika', 'patel', 'deepika@gmail.com', '9134511111', 'Delhi');
insert into Customers values(7, 'John', 'Doe', 'john@gmail.com', '9134533333', 'Kanpur');
insert into Customers values(8, 'Bhuvan', 'Bam', 'bhuvan@gmail.com', '9134531313', 'Odissa');
insert into Customers values(9, 'Ashish', 'kumar', 'ashish@gmail.com', '9134575984', 'Goa');
insert into Customers values(10, 'Manish', 'Rawat', 'manish@gmail.com', '9134504561', 'Shimla');

INSERT INTO Products (productid, pname, pdesc, price)
VALUES
    (1, 'Laptop', 'High-performance laptop', 999.99),
    (2, 'Smartphone', 'Latest smartphone model', 599.99),
    (3, 'Tablet', '10-inch tablet', 299.99),
    (4, 'Headphones', 'Over-ear headphones', 149.99),
    (5, 'Smart Watch', 'Fitness tracker and smartwatch', 129.99),
    (6, 'Desktop Computer', 'Powerful desktop computer', 1499.99),
    (7, 'Wireless Router', 'High-speed wireless route', 79.99),
    (8, 'External Hard Drive', '1TB external hard drive', 79.99),
    (9, 'Digital Camera', 'Mirrorless digital camera', 899.99),
    (10, 'Bluetooth Speaker', 'Portable Bluetooth speaker', 49.99);

INSERT INTO Orders (orderid, customerid, orderdate, ostatus, totalamount)
VALUES
    (1, 1, '2023-01-01','Pending',1500.00),
    (2, 2, '2023-02-15','Pending',800.00),
    (3, 3, '2023-03-10','Shipped',1200.00),
    (4, 4, '2023-04-05','Pending',500.00),
    (5, 5, '2023-05-20','Pending',2000.00),
    (6, 1, '2023-06-15','Shipped',600.00),
    (7, 2, '2023-07-01','Pending',1000.00),
    (8, 3, '2023-08-18','Pending',900.00),
    (9, 4, '2023-09-02','Pending',700.00),
    (10, 5, '2023-10-15','Pending',1800.00);


INSERT INTO OrderDetails (orderdetailid, orderid, productid, quantity)
VALUES (1, 1, 1, 2),
    (2, 1, 3, 1),
    (3, 2, 2, 1),
    (4, 3, 5, 3),
    (5, 4, 7, 1),
    (6, 5, 4, 2),
    (7, 6, 6, 1),
    (8, 7, 8, 4),
    (9, 8, 10, 2),
    (10, 9, 9, 1);


INSERT INTO Inventory (inventoryid, productid, quantityinstock, laststockupdate)
VALUES
    (1, 1, 15, '2023-01-01'),
    (2, 2, 25, '2023-02-15'),
    (3, 3, 10, '2023-03-10'),
    (4, 4, 30, '2023-04-05'),
    (5, 5, 20, '2023-05-20'),
    (6, 6, 5, '2023-06-15'),
    (7, 7, 18, '2023-07-01'),
    (8, 8, 12, '2023-08-18'),
    (9, 9, 8, '2023-09-02'),
    (10, 10, 15, '2023-10-15');


-- task 3.b)
-- 1  Write an SQL query to retrieve the names and emails of all customers. 
select concat(firstname,' ',lastname) Name, email Email from Customers;

-- 2  Write an SQL query to list all orders with their order dates and corresponding customer names
select concat(c.firstname,' ',c.lastname) CustomerName, o.* from Orders o 
join Customers c on o.customerid=c.customerid ;

-- 3  Write an SQL query to insert a new customer record into the "Customers" table. Include customer information such as name, email, and address.
insert into Customers(customerid,firstname,lastname,email,address) 
values(11,'Tanmay','Bhatt','tanmay@gmail.com','Himachal');

-- 4  Write an SQL query to update the prices of all electronic gadgets in the "Products" table by increasing them by 10%.
update Products
set price = price * 1.1;

-- 5 Write an SQL query to delete a specific order and its associated order details from the "Orders" and "OrderDetails" tables. Allow users to input the order ID as a parameter.
-- substitution variable
set @enu = 4;
delete from Orders where Orders.orderid=@enu;

-- 6  Write an SQL query to insert a new order into the "Orders" table. Include the customer ID, order date, and any other necessary information.
insert into Orders(customerid,orderdate,orderid,totalamount)
values(11,'2023-10-28',11,1000.00);

-- 7  Write an SQL query to update the contact information (e.g., email and address) of a specific customer in the "Customers" table. Allow users to input the customer ID and new contact information
set @uid=3;
set @contact = '9137453648';
update Customers set email='changed@gmail.com', 
address='changed address', phno=@contact
where customerid=@uid;

-- 8 Write an SQL query to recalculate and update the total cost of each order in the "Orders" table based on the prices and quantities in the "OrderDetails" table.
update Orders set totalamount=(
	select sum(od.quantity*p.price) from OrderDetails od
    join Products p on od.productid=p.productid
    where od.orderid=Orders.orderid);
    
-- 9  Write an SQL query to delete all orders and their associated order details for a specific customer from the "Orders" and "OrderDetails" tables. Allow users to input the customer ID as a parameter
set @custid=4;
DELETE from Orders where customerid=@custid;
    
-- 10 Write an SQL query to insert a new electronic gadget product into the "Products" table, including product name, category, price, and any other relevant details.
insert into Products(productid,pname,pdesc,price)
values(11,'New Product','New product description',744.99); 


-- 11 Write an SQL query to update the status of a specific order in the "Orders" table (e.g., from "Pending" to "Shipped"). Allow users to input the order ID and the new status.
set @ordid=7;
set @newstatus='Shipped';
update Orders set ostatus=@newstatus
where orderid=@ordid;

-- 12 Write an SQL query to calculate and update the number of orders placed by each customer in the "Customers" table based on the data in the "Orders" table
select  c.customerid, concat(c.firstname,' ',c.lastname) ,count(o.customerid) number_of_orders 
from Customers c left outer join Orders o 
on c.customerid=o.customerid group by c.customerid,c.firstname,c.lastname;


-- task 4 (Joins)
-- 1 . Write an SQL query to retrieve a list of all orders along with customer information (e.g., customer name) for each order
select concat(c.firstname,' ',c.lastname) CustomerName, o.* from Customers c 
join Orders o on c.customerid=o.customerid;

-- 2 . Write an SQL query to find the total revenue generated by each electronic gadget product.Include the product name and the total revenue.
select p.productid, p.price, od.quantity,(p.price*od.quantity) Total_Revenue from Products p 
join OrderDetails od where p.productid=od.productid;

-- 3 Write an SQL query to list all customers who have made at least one purchase. Include their names and contact information
select c.* from Customers c join Orders o on c.customerid=o.customerid; 

-- 4 . Write an SQL query to find the most popular electronic gadget, which is the one with the highest total quantity ordered. Include the product name and the total quantity ordered
SELECT p.pname, SUM(od.quantity) AS TotalQuantityOrdered
FROM OrderDetails od JOIN Products p ON od.productid = p.productid
GROUP BY p.pname ORDER BY TotalQuantityOrdered DESC LIMIT 1;

-- 5  Write an SQL query to retrieve a list of electronic gadgets along with their corresponding categories.

select * from products;

-- 6 . Write an SQL query to calculate the average order value for each customer. Include the customer's name and their average order value.
select avg(od.totalamount) AverageOrderValue,c.firstname from Orders od join Customers c
on od.customerid=c.customerid group by od.totalamount,c.firstname order by AverageOrderValue desc;

SELECT
    (SELECT AVG(totalamount) FROM Orders WHERE customerid = c.customerid) AS AverageOrderValue,
    c.firstname
FROM
    Customers c
    order by AverageOrderValue desc;

-- 7  Write an SQL query to find the order with the highest total revenue. Include the order ID, customer information, and the total revenue
select o.orderid, c.*,o.totalamount TotalRevenue from Orders o join Customers c 
on c.customerid=o.orderid order by TotalRevenue desc limit 1;



-- 8  Write an SQL query to list gadgets and the number of times each product has been ordered.

select p.productid, p.pname, COUNT(od.orderid) AS OrderCount
from Products p
left join OrderDetails od ON p.productid = od.productid
group by p.productid, p.pname
order by OrderCount;

-- 9  Write an SQL query to find customers who have purchased a specific electronic gadget product. Allow users to input the product name as a parameter

set @pn='Bluetooth Speaker';
select c.* from Customers c where c.customerid = (select o.customerid from Orders o where o.orderid=
(select od.orderid from OrderDetails od join
Products p on od.productid=p.productid where p.pname=@pn ));

-- 10 Write an SQL query to calculate the total revenue generated by all orders placed within a specific time period. Allow users to input the start and end dates as parameters.

set @startd='2023-01-01';
set @endd='2023-12-31';
select sum(totalamount) TotalRevenue from Orders where orderdate between @startd and @endd;

-- task 5 (Aggregate functions and subqueries)

-- 1. Write an SQL query to find out which customers have not placed any orders

select * from Customers where customerid not in (select distinct customerid from Orders);

-- 2. Write an SQL query to find the total number of products available for sale. 

select count(*) TotalProductsForSale from Products where productid IN (select productid from OrderDetails where quantity>0);

-- 3. Write an SQL query to calculate the total revenue generated by TechShop. 

select sum(totalamount) TotalRevenue from Orders;

-- 4. Write an SQL query to calculate the average quantity ordered for products in a specific category. Allow users to input the category name as a parameter.

set @proname='Bluetooth Speaker';
select avg(quantity) from OrderDetails where productid 
in (select productid from Products where pname=@proname);

-- 5. Write an SQL query to calculate the total revenue generated by a specific customer. Allow users to input the customer ID as a parameter.

set @cid=1;
select sum(totalamount) TotalRevenue from Orders 
where customerid in 
(select customerid from Customers where customerid=@cid);

-- 6. Write an SQL query to find the customers who have placed the most orders. List their names and the number of orders they've placed

select firstname,lastname,noOfOrders from 
(select count(customerid) noOfOrders,customerid from Orders group by customerid order by noOfOrders desc) sub,Customers c
where c.customerid=sub.customerid;  


-- 7. Write an SQL query to find the most popular product category, which is the one with the highest total quantity ordered across all orders.

select pname from Products where productid = 
(select productid from OrderDetails 
where quantity=(select MAX(quantity) from OrderDetails));

-- 8. Write an SQL query to find the customer who has spent the most money (highest total revenue) on electronic gadgets. List their name and total spending

select c.firstname,max(UserAmount) MostMoney,sub.customerid from 
(select sum(totalamount) UserAmount,customerid from Orders group by customerid order by UserAmount desc) sub 
join Customers c on sub.customerid=c.customerid
group by sub.customerid,c.firstname order by UserAmount desc limit 1;

-- 9.Write an SQL query to calculate the average order value (total revenue divided by the number of orders) for all customers

select sum(totalamount)/count(*) from Orders;

-- 10. Write an SQL query to find the total number of orders placed by each customer and list their names along with the order count.

select concat(firstname,lastname) uname,
(select count(customerid) from Orders where Orders.customerid=Customers.customerid) OrderCount
from Customers order by OrderCount; 