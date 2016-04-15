package com.qa.smurf;
/**
 * Author - Tom
 */
import java.util.ArrayList;
import java.util.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class InitialData {

	//Supplier
	
	//Address
	
	public List<Payment> getPayment() throws ParseException {
		
		/* 
		 * Author : willseaford
			This method returns an ArrayList of Payment objects and has a dependency on the User object class being instantiated. 
		  	The method: - Creates an ArrayList of Payments, SimpleDateformat object and a User ArrayList object 
		  				  which is initialised from the getUser() method
		  	 			- adds each user to the payment ArrayList with an arbitrary card number, card type and date (which is parsed)
		  	 			  and uses the users ArrayList to get the name and the instance of the object to the Payment ArrayList 
		  				- returns the Payment ArrayList
		*/
		ArrayList<Payment> payment = new ArrayList<Payment>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");
		
		ArrayList<User> users = getUser();
		payment.add(new Payment("1234567891011121", "debit", sdf.parse("06/25"), users.get(0).getName().toString(), users.get(0)));
		payment.add(new Payment("1234678901246789", "credit", sdf.parse("02/24"), users.get(1).getName().toString(),users.get(1) ));
		payment.add(new Payment("0987654321234567", "debit", sdf.parse("04/17"), users.get(2).getName().toString(), users.get(2)));
		payment.add(new Payment("1357708642135790", "credit", sdf.parse("02/26"), users.get(3).getName().toString(), users.get(3)));
		payment.add(new Payment("2468097531246809", "debit", sdf.parse("02/19"), users.get(4).getName().toString(), users.get(4) ));
		return payment;
	}
	
	
	//Orders
	public ArrayList<Order> getOrder(){
		ArrayList<Order> orders = new ArrayList<Order>();
		double[] price = {10.10, 20.20, 30.30, 40.40, 50.50};
		
		for (int i = 0; i < 5; i++){
			orders.add(new Order(price[i], new Date(), new Date(), getPayment().get(i), getAddress().get(i), getUser().get(i), getOrderStatus().get(i)));
		}
		
		return orders;
	}
	
	//User
	
	public List<Credit> getCredit() {
		
		/* 
		 * Author : willseaford
			This method returns an ArrayList of Credit objects and has a dependency on the User object class being instantiated. 
		  	The method: - Creates an ArrayList of Credit and a User ArrayList object 
		  				  which is initialised from the getUser() method
		  	 			- adds each user to the Credit with their amount balance and amount remaining with the quarter
		  				- returns the Credit ArrayList
		*/
		
		ArrayList<Credit> credit = new ArrayList<Credit>();
		ArrayList<User> users = getUser();
		
		credit.add(new Credit(users.get(0), 0.0, 0.0, 1));
		credit.add(new Credit(users.get(1), 2000.00, 1000.00, 2));
		credit.add(new Credit(users.get(2), 0.0, 0.0, 3));
		credit.add(new Credit(users.get(3), 1500.00, 400.00, 4));
		credit.add(new Credit(users.get(4), 0.0, 0.0, 1));
		
		return credit;
	}
	
	//OrderStatus
	public ArrayList<OrderStatus> getOrderStatus(){
		ArrayList<OrderStatus> orderStatus = new ArrayList<OrderStatus>();
		
		String[] name = { "Cancelled", "Delivered", "Dispatched", "Awaiting Confirmation", "Dispatched" };
		for (int i = 0; i < 5; i++){
			orderStatus.add(new OrderStatus(name[i]));
		}
		
		return orderStatus;
	}
	
	
	public List<LineItems> getLineItems() {
		
		/* 
		 * Author : willseaford
			This method returns an ArrayList of LineItems objects and has a dependency on the order and product object classes being instantiated. 
		  	The method: - Creates ArrayLists of LineItems, Order and Product respectively and initialises 
		  				  order and product with values from in-class getter method
		  	 			- adds each instance order and product to the Credit object with the quantity, subtotal and returnedQty and adds the Credit object to the 
		  	 			  ArrayList.
		  				- returns the LineItems ArrayList
		*/
		
		ArrayList<LineItems> lineItems = new ArrayList<LineItems>();
		ArrayList<Order> order = getOrder();
		ArrayList<Product> product = getProduct();
		
		lineItems.add(new LineItems(order.get(0), product.get(0), 250, 400.00, 34));
		lineItems.add(new LineItems(order.get(1), product.get(1), 450, 1400.00, 67));
		lineItems.add(new LineItems(order.get(2), product.get(2), 600, 4200.00, 2));
		lineItems.add(new LineItems(order.get(3), product.get(3), 560, 5400.00, 45));
		lineItems.add(new LineItems(order.get(4), product.get(4), 1234, 1400.00, 235));
		
		return lineItems;
		
	}
	
	//WishlistEntry
	
	//EmployeeUser
	
	//AccountType
	
	//SupplyOrder
	public ArrayList<SupplierOrder> getSupplierOrder(){
		ArrayList<SupplierOrder> supplierOrder = new ArrayList<SupplierOrder>();
		int received[] = { 1, 2, 3, 4, 4 };
		
		for (int i = 0; i < 5; i++){
			supplierOrder.add(new SupplierOrder(getProduct().get(i), getOrderStatus().get(i), getSupplier().get(i), i, new Date(), received[i]));
		}
		
		return supplierOrder;
	}
	
	//Products
	
	//ProductType
	
	public ArrayList<ProdCat> getProdCat(){
		ArrayList<ProdCat> prodCat = new ArrayList<ProdCat>();
		
		for (int i = 0; i < 5; i++){
			prodCat.add(new ProdCat(getProduct().get(i), getCategory().get(i)));
		}
		
		return prodCat;
	}
	
	//Category
	
}
