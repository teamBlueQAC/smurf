package com.qa.smurf;
/**
 * Author - Tom
 */
import java.util.ArrayList;
import java.util.Date;

public class InitialData {

	//Supplier
	
	//Address
	
	//Payment
	
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
	
	//Credit
	
	//OrderStatus
	public ArrayList<OrderStatus> getOrderStatus(){
		ArrayList<OrderStatus> orderStatus = new ArrayList<OrderStatus>();
		
		String[] name = { "Cancelled", "Delivered", "Dispatched", "Awaiting Confirmation", "Dispatched" };
		for (int i = 0; i < 5; i++){
			orderStatus.add(new OrderStatus(name[i]));
		}
		
		return orderStatus;
	}
	
	
	//LineItems
	
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
