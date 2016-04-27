package com.qa.smurf;
/**
 * Author - Tom
 */
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Singleton;

import com.qa.smurf.entities.Address;
import com.qa.smurf.entities.Category;
import com.qa.smurf.entities.Credit;
import com.qa.smurf.entities.EmployeeUser;
import com.qa.smurf.entities.LineItems;
import com.qa.smurf.entities.Order;
import com.qa.smurf.entities.Payment;
import com.qa.smurf.entities.ProdCat;
import com.qa.smurf.entities.ProdSup;
import com.qa.smurf.entities.Product;
import com.qa.smurf.entities.ProductType;
import com.qa.smurf.entities.Supplier;
import com.qa.smurf.entities.SupplierOrder;
import com.qa.smurf.entities.User;
import com.qa.smurf.util.AccountType;
import com.qa.smurf.util.OrderStatus;

@Singleton
public class InitialData {
	private ArrayList<Credit> credit = new ArrayList<Credit>();
	private ArrayList<LineItems> lineItems = new ArrayList<LineItems>();
	private ArrayList<Order> orders = new ArrayList<Order>();
	private ArrayList<OrderStatus> orderStatuses = new ArrayList<OrderStatus>();
	private ArrayList<SupplierOrder> supplierOrders = new ArrayList<SupplierOrder>();
	private ArrayList<Product> products = new ArrayList<Product>();
	private ArrayList<Payment> payment = new ArrayList<Payment>();
	private ArrayList<ProdCat> prodCats = new ArrayList<ProdCat>();
	private ArrayList<Category> categories = new ArrayList<Category>();
	private ArrayList<ProductType> productTypes = new ArrayList<ProductType>();
	private ArrayList<Address> addresses = new ArrayList<Address>();
	private ArrayList<ProdSup> prodSups = new ArrayList<ProdSup>();	
	private ArrayList<AccountType> accountTypes = new ArrayList<AccountType>();
	private ArrayList<Supplier> suppliers = new ArrayList<Supplier>();	
	private ArrayList<User> users = new ArrayList<User>();
	
	public InitialData() throws ParseException{	//TODO these need to be run in a specific order
		setOrderInitialData();
		setOrderStatusInitialData();
		setCategoriesInitialData();
		setProdCatInitialData();
		setSupplierOrderInitialdata();
		setCategoriesInitialData();
		setProductTypeInitialdata();
		setProductInitialData();
		setAddressInitialData();
		setProdSupInitialData();
		setAccountTypeInitialData();
		setUserInitialData();
	}

	/**
	 * 
	 * Created by Omar
	 * 
	 */	
	/* The below is a getMethod that will retrieve the dummy data from the necessary variables 
	 * Then it will return those values in the form of an array*/							
	
	private void setSupplierInitialData() {
				
		// Create a list of names to fill the supplier data
		String[] name = {"GaleTech", "UmbrellerCorp", "Skynet", "V.I.K.I", "Team Rocket"};
		
		// Create a loop to retrieve data a specific number of times
		for (int i = 0; i < 5; i++) {
			// adds data retrieved from other classes to array
			suppliers.add(new Supplier(getAddresses().get(i), name[i]));		
		}
	}
	
	public ArrayList<Supplier> getSuppliers() {
		return this.suppliers;
	}
	
	public void addSupplier(Supplier supplier) {
		this.suppliers.add(supplier);
	}
	
	public void setSupplier(ArrayList<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	/*end of section*/
	
	
	/**
	 * 
	 * Created by Omar
	 * 
	 */
	/* The below is a getMethod that will retrieve the dummy data from the necessary variables 
	 * Then it will return those values in the form of an array*/

	private void setAddressInitialData(){
		String[] addressLine1 = {"54 abbey lane", "54 abbey lane", "54 abbey lane", "54 abbey lane", "54 abbey lane"};
		String[] addressLine2 = {"ayfter road", "ayfter road", "ayfter road", "ayfter road", "ayfter road"};
		String[] addressLine3 = {"Birgmingham", "Birgmingham", "Birgmingham", "Birgmingham", "Birgmingham"};
		String[] addressLine4 = {"UK", "UK", "UK", "UK", "UK"};
		String[] postCode = {"NX7 4GH", "NX7 4GH", "NX7 4GH", "NX7 4GH", "NX7 4GH"};
		
		for (int i = 0; i < 5; i++) {
			addresses.add(new Address(addressLine1[i], addressLine2[i], addressLine3[i], addressLine4[i], postCode[i]));		
		}		
	}
	public ArrayList<Address> getAddresses(){
		return this.addresses;
	}
	public void addAddress(Address address){
		this.addresses.add(address);
	}
	public void setAddress(ArrayList<Address> addresses){
		this.addresses = addresses;
	}
	
	public void setPayment() throws ParseException {
		
		//  Author : willseaford - This method returns an ArrayList of Payment objects and has a dependency on the User object class being instantiated. 
	
		SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");
		
		ArrayList<User> users = getUsers();
		payment.add(new Payment("1234567891011121", "debit", sdf.parse("06/25"), "Mr W Seaford", new Address("23 Holway Road", "TA1 2EZ") ,users.get(0)));
		payment.add(new Payment("1234678901246789", "credit", sdf.parse("02/24"), "Mr S Smith", new Address("71 Mountbatton", "BS37 S35") , users.get(1)));
		payment.add(new Payment("0987654321234567", "debit", sdf.parse("04/17"), "Miss E Smitten", new Address("1 Beaumont Court", "E1 4NX") , users.get(2)));
		payment.add(new Payment("1357708642135790", "credit", sdf.parse("02/26"), "Mr W T Beaumont", new Address("14 Louise Road", "E15 4NW") ,users.get(3)));
		payment.add(new Payment("2468097531246809", "debit", sdf.parse("02/19"), "Mrs D Matthison", new Address("908 The Heart", "M50 2JY") , users.get(4)));

	}
	
	public void addPayment(Payment payment){
		this.payment.add(payment);
	}
	
	public ArrayList<Payment> getPayment(){
		return this.payment;
	}
	
	private void setOrderInitialData() throws ParseException{
		double[] price = {10.10, 20.20, 30.30, 40.40, 50.50};
		
		for (int i = 0; i < 5; i++){
			orders.add(new Order(price[i], new Date(), new Date(), getPayment().get(i), getAddresses().get(i), getUsers().get(i), getOrderStatuses().get(i)));
		}
	}
	public ArrayList<Order> getOrders(){
		return orders;
	}
	public void addOrder(Order order) {
		orders.add(order);
	}
	public void setOrders(ArrayList<Order> orders){
		this.orders = orders;
	}
		
	public void setCredit() {
		
		// Author : willseaford - 
		ArrayList<User> users = getUsers();
		
		credit.add(new Credit(users.get(0), 0.0, 0.0, 1));
		credit.add(new Credit(users.get(1), 2000.00, 1000.00, 2));
		credit.add(new Credit(users.get(2), 0.0, 0.0, 3));
		credit.add(new Credit(users.get(3), 1500.00, 400.00, 4));
		credit.add(new Credit(users.get(4), 0.0, 0.0, 1));
		
	}
	
	public void addCredit(Credit credit){
		this.credit.add(credit);
	}
	
	public ArrayList<Credit> getCredit(){
		return credit;
	}
	
	//Creates an ArrayList that is populated by dummy data.
	public ArrayList<User> getUsers(){		
		return this.users;
	}
	
	private void setUserInitialData(){
		users.add(new User(1, "Sam Elleray", "Chickens1", "sam@chickens.com", "07881508168", new Date(), true, new Address("12 High Street", "Whocares", "Somerset", "England", "WH1 1t1" ), new Date()));
		users.add(new User(2, "Boris Seaford", "willpower3", "boris@will.com", "08005428106", new Date(), true, new Address("15 Orchard Road", "Funplace", "Somerset", "England", "WH7 1GA"), new Date()));
		users.add(new User(3, "Will Weiner", "Password123", "random@email.com", "07826719832", new Date(), true, new Address("4 The Limes", "Lowton", "Warrington", "England", "WA3 1HZ"), new Date()));
		users.add(new User(4, "Tom Bob", "Thisisapassword", "thisis@anemail", "01942836745", new Date(), true, new Address("28 Kings Cl", "Ashbury", "Swindon", "England", "SN5 7PA"), new Date()));
		users.add(new User(5, "James Trainer", "JamesPassword", "James@James.com", "07325428106", new Date(), true, new Address("15 Vale Cl", "Cranleigh", "Oxford", "England", "OX5 7PA"), new Date()));
	}
	public void setUsers(ArrayList<User> users){
		this.users = users;
	}
	
	public void addUser(User user){
		this.users.add(user);
	}
		
	private void setOrderStatusInitialData(){
		String[] name = { "Cancelled", "Delivered", "Dispatched", "Awaiting Confirmation", "Dispatched" };
		for (int i = 0; i < 5; i++){
			orderStatuses.add(new OrderStatus(name[i]));
		}
	}
	public ArrayList<OrderStatus> getOrderStatuses(){
		return orderStatuses;
	}
	public void addOrderStatus(OrderStatus orderStatus){
		orderStatuses.add(orderStatus);
	}
	public void setOrderStatuses(ArrayList<OrderStatus> orderStatuses){
		this.orderStatuses = orderStatuses;
	}
	
	public void setLineItems() throws ParseException {
		
		//  Author : willseaford - This method sets an ArrayList of LineItems objects and has a dependency on the order and product object classes being instantiated. 
		
		ArrayList<Order> order = getOrders();
		ArrayList<Product> product = getProducts();
		
		lineItems.add(new LineItems(order.get(0), product.get(0), 250, 400.00, 34));
		lineItems.add(new LineItems(order.get(1), product.get(1), 450, 1400.00, 67));
		lineItems.add(new LineItems(order.get(2), product.get(2), 600, 4200.00, 2));
		lineItems.add(new LineItems(order.get(3), product.get(3), 560, 5400.00, 45));
		lineItems.add(new LineItems(order.get(4), product.get(4), 1234, 1400.00, 235));
	}
		
	public void addLineItems(LineItems lineitem){
		this.lineItems.add(lineitem);
	}
	
	public ArrayList<LineItems> getLineItems(){
		return lineItems;
	}
	public ArrayList<EmployeeUser> getEmployeeUser(){
		
		/* 
		 * Author : willseaford
			This method returns an ArrayList of EmployeeUser objects and has a dependency on the AccountType class being instantiated. 
		  	The method: - Creates ArrayLists of EmployeeUser and AccountType and initialises AccountType
		  	 			- adds each instance.
		  				- returns the ArrayList
		*/
		
		
		ArrayList<EmployeeUser> employeeUser = new ArrayList<EmployeeUser>();
		ArrayList<AccountType> accountType = getAccountTypes();
		
		employeeUser.add(new EmployeeUser(accountType.get(0), "Mr Big Mann"));
		employeeUser.add(new EmployeeUser(accountType.get(1), "Mr Patrick Starfish"));
		employeeUser.add(new EmployeeUser(accountType.get(2), "Miss Wo Mann"));
		employeeUser.add(new EmployeeUser(accountType.get(0), "Mr James Trainer"));
		employeeUser.add(new EmployeeUser(accountType.get(0), "Mr Stewart Noob"));
		
		return employeeUser;
	}
		
		//Populates the ArrayList for Account Type with 3 different account types.
	
	private void setAccountTypeInitialData(){
		accountTypes.add(new AccountType(1, "Inventory Manager"));
		accountTypes.add(new AccountType(1, "Accounts Worker"));
		accountTypes.add(new AccountType(1, "Warehouse Worker"));
	}
	public ArrayList<AccountType> getAccountTypes(){
		return this.accountTypes;
	}
	public void addAccountType(AccountType accountType){
		this.accountTypes.add(accountType);
	}
	public void setAccountType(ArrayList<AccountType> accountTypes){
		this.accountTypes = accountTypes;
	}

	private void setSupplierOrderInitialdata(){
		int received[] = { 1, 2, 3, 4, 4 };
		
		for (int i = 0; i < 5; i++){
			supplierOrders.add(new SupplierOrder(getProducts().get(i), getOrderStatuses().get(i), getSuppliers().get(i), i, new Date(), received[i]));
		}
	}
	public ArrayList<SupplierOrder> getSupplierOrders(){
		return supplierOrders;
	}
	public void addSupplierOrder(SupplierOrder supplierOrder){
		supplierOrders.add(supplierOrder);
	}
	public void setSupplierOrders(ArrayList<SupplierOrder> supplierOrders){
		this.supplierOrders = supplierOrders;
	}
	
		
	//Products nabz & Dean
	private void setProductInitialData(){
		products.add(new Product(0, "gnome", "GHTY-YTER-GFDG", "blue", 40.00,
				false, "mydocs", 500, getProductTypes().get(1),
				"Huge scary gnome with 3 eyes and a huge shovel.", 40, 500));
		
		products.add(new Product(1, "seeds", "SDFF-DFGF-JGGJ", "green", 10.00,
				false, "mydocs", 600, getProductTypes().get(2), "zombie green seeds.",
				60, 700));
		
		products.add(new Product(2, "garden utensils", "EWRE-WRFS-SAZC",
				"blue", 5.00, false, "mydocs", 700, getProductTypes().get(3),
				"big and scary garden utensils.", 70, 400));
	}
	public ArrayList<Product> getProducts() {
		return products;
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	private void setProdCatInitialData(){
		for (int i = 0; i < 5; i++){
			prodCats.add(new ProdCat(getProducts().get(i), getCategories().get(i)));
		}
	}
	public ArrayList<ProdCat> getProdCats(){
		return prodCats;
	}
	public void addProdCat(ProdCat prodCat){
		prodCats.add(prodCat);
	}
	public void setProdCats(ArrayList<ProdCat> prodCats){
		this.prodCats = prodCats;
	}

	//Populates the ArrayList for Product Type with 3 different product types.
	
	private void setProductTypeInitialdata(){
		productTypes.add(new ProductType(1,"Seeds"));
		productTypes.add(new ProductType(1,"Gardening Tools"));
		productTypes.add(new ProductType(1,"Selena Gnomes"));
	}
		
	public ArrayList<ProductType> getProductTypes(){
		return productTypes;
	}

		
	public void addProductType(ProductType productType)
	{
		this.productTypes.add(productType);
	}
		
	public void setProductTypes(ArrayList<ProductType> productTypes)
	{
		this.productTypes = productTypes;
	}
	
	//Category Nabz & Dean
	
	private void setCategoriesInitialData() {
		categories.add(new Category(1, "axe wielding"));
		categories.add(new Category(2, "zombie"));
		categories.add(new Category(3, "big and scary"));
	}
		
	public ArrayList<Category> getCategories() {
		return categories;
	}

	public void addCategory(Category category) {
		categories.add(category);
	}

	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}
	
	
	/**
	 * 
	 * Created by Omar
	 * 
	 */

	private void setProdSupInitialData(){
		double[] cost = {100.05, 200.40, 400.09, 300.02, 800.32};
		
		for (int i = 0; i < 5; i++) {
			prodSups.add(new ProdSup(getSuppliers().get(i), getProducts().get(i), cost[i]));		
		}
	}
	public ArrayList<ProdSup> getProdSups(){
		return this.prodSups;
	}
	public void addProdSup(ProdSup prodSup){
		this.prodSups.add(prodSup);
	}
	public void setProdSups(ArrayList<ProdSup> prodSups){
		this.prodSups = prodSups;
	}

}
