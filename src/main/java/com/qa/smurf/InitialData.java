package com.qa.smurf;

/**
 * Author - Tom
 */
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
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
import com.qa.smurf.util.ProductType;
import com.qa.smurf.entities.Supplier;
import com.qa.smurf.entities.SupplierOrder;
import com.qa.smurf.entities.User;
import com.qa.smurf.entities.WishListEntry;
import com.qa.smurf.util.OrderStatus;

@Singleton
public class InitialData {
	private ArrayList<Credit> credits = new ArrayList<Credit>();
	private ArrayList<LineItems> lineItems = new ArrayList<LineItems>();
	private ArrayList<Order> orders = new ArrayList<Order>();
	private ArrayList<SupplierOrder> supplierOrders = new ArrayList<SupplierOrder>();
	private ArrayList<Product> products = new ArrayList<Product>();
	private ArrayList<Payment> payments = new ArrayList<Payment>();
	private ArrayList<ProdCat> prodCats = new ArrayList<ProdCat>();
	private ArrayList<Category> categories = new ArrayList<Category>();
	private ArrayList<Address> addresses = new ArrayList<Address>();
	private ArrayList<ProdSup> prodSups = new ArrayList<ProdSup>();
	private ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<WishListEntry> wishListEntries = new ArrayList<WishListEntry>();
	private ArrayList<EmployeeUser> employeeUsers = new ArrayList<EmployeeUser>();

	@PostConstruct
	public void initial(){
		setAddressInitialData();
		setUserInitialData();
		setSupplierInitialData();
		setPaymentInitialData();
		setOrderInitialData();
		setProductInitialData();
		setLineItemsInitialData();
		setSupplierOrderInitialData();
		setEmployeeUserInitialData();
		setCategoriesInitialData();
		setProdCatInitialData();
		setProdSupInitialData();
		setWishlistEntryInitialData();
	}

	/**
	 * 
	 * Created by Omar
	 * 
	 */
	/*
	 * The below is a getMethod that will retrieve the dummy data from the
	 * necessary variables Then it will return those values in the form of an
	 * array
	 */

	private void setSupplierInitialData() {

		// Create a list of names to fill the supplier data
		String[] name = { "GaleTech", "UmbrellerCorp", "Skynet", "V.I.K.I", "Team Rocket" };

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

	/* end of section */

	/**
	 * 
	 * Created by Omar
	 * 
	 */
	/*
	 * The below is a getMethod that will retrieve the dummy data from the
	 * necessary variables Then it will return those values in the form of an
	 * array
	 */

	private void setAddressInitialData() {
		String[] addressLine1 = { "1 abbey lane", "2 north road", "3 south road", "4 east road", "5 west road" };
		String[] addressLine2 = { "ayfter road", "north", "South", "North", "West" };
		String[] addressLine3 = { "Birgmingham", "Leeds", "Southampton", "Norwich", "Aberystwyth" };
		String[] addressLine4 = { "UK", "UK", "UK", "UK", "UK" };
		String[] postCode = { "NX7 4GH", "LE7 4GH", "SO7 4GH", "NX7 4GH", "NX7 4GH" };

		for (int i = 0; i < 5; i++) {
			addresses.add(new Address(addressLine1[i], addressLine2[i], addressLine3[i], addressLine4[i], postCode[i]));
		}
	}

	public ArrayList<Address> getAddresses() {
		return this.addresses;
	}

	public void addAddress(Address address) {
		this.addresses.add(address);
	}

	public void setAddress(ArrayList<Address> addresses) {
		this.addresses = addresses;
	}

	private void setPaymentInitialData(){

		// Author : willseaford - This method returns an ArrayList of Payment
		// objects and has a dependency on the User object class being
		// instantiated.

		payments.add(new Payment("1234567891011121", "debit", "06/25", "Mr W Seaford",
				this.addresses.get(0), this.users.get(0)));
		payments.add(new Payment("1234678901246789", "credit", "02/24", "Mr S Smith",
				this.addresses.get(1), this.users.get(1)));
		payments.add(new Payment("0987654321234567", "debit", "04/17", "Miss E Smitten",
				this.addresses.get(2), this.users.get(2)));
		payments.add(new Payment("1357708642135790", "credit", "02/26", "Mr W T Beaumont",
				this.addresses.get(3), this.users.get(3)));
		payments.add(new Payment("2468097531246809", "debit", "02/19", "Mrs D Matthison",
				this.addresses.get(4), this.users.get(4)));
		
	}

	public void addPayment(Payment payment) {
		this.payments.add(payment);
	}

	public ArrayList<Payment> getPayments() {
		return this.payments;
	}

	public void setPayment(ArrayList<Payment> payments) {
		this.payments = payments;
	}

	private void setOrderInitialData() {
		double[] price = { 10.10, 20.20, 30.30, 40.40, 50.50 };

		for (int i = 0; i < 5; i++) {
			if(i != 0){
				orders.add(new Order(price[i], new Date(), new Date(), getPayments().get(i), getAddresses().get(i),
						getUsers().get(i), OrderStatus.DELIVERED));
			} else {
				orders.add(new Order(price[i], new Date(), null, getPayments().get(i), getAddresses().get(i),
						getUsers().get(i), OrderStatus.PENDING));
			}
		}
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void addOrder(Order order) {
		orders.add(order);
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public void setCreditInitialData() {

		// Author : willseaford -
		ArrayList<User> users = getUsers();

		credits.add(new Credit(users.get(0), 0.0, 0.0));
		credits.add(new Credit(users.get(1), 2000.00, 1000.00));
		credits.add(new Credit(users.get(2), 0.0, 0.0));
		credits.add(new Credit(users.get(3), 1500.00, 400.00));
		credits.add(new Credit(users.get(4), 0.0, 0.0));

	}

	public void addCredit(Credit credit) {
		this.credits.add(credit);
	}

	public ArrayList<Credit> getCredit() {
		return credits;
	}

	public void setCredit(ArrayList<Credit> credit) {
		this.credits = credit;
	}

	// Creates an ArrayList that is populated by dummy data.
	public ArrayList<User> getUsers() {
		return this.users;
	}

	private void setUserInitialData() {
		users.add(new User(0,"Sam Elleray", "Sam", "Chickens1", "sam@chickens.com", "07881508168", new Date(), true, new Address("12 High Street", "Whocares", "Somerset", "England", "WH1 1t1"), new Date()));
		users.add(new User(1,"Boris Seaford", "Boris", "willpower3", "boris@will.com", "08005428106", new Date(), true, new Address("15 Orchard Road", "Funplace", "Somerset", "England", "WH7 1GA"), new Date()));
		users.add(new User(2,"Will Weiner", "Will", "Password123", "random@email.com", "07826719832", new Date(), true, new Address("4 The Limes", "Lowton", "Warrington", "England", "WA3 1HZ"), new Date()));
		users.add(new User(3,"Tom Bob", "Tom", "Thisisapassword", "thisis@anemail", "01942836745", new Date(), true, new Address("28 Kings Cl", "Ashbury", "Swindon", "England", "SN5 7PA"), new Date()));
		users.add(new User(4,"James Trainer", "James", "JamesPassword", "James@James.com", "07325428106", new Date(), true, new Address("15 Vale Cl", "Cranleigh", "Oxford", "England", "OX5 7PA"), new Date()));
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public void addUser(User user) {
		this.users.add(user);
	}

	private void setLineItemsInitialData() {

		// Author : willseaford - This method sets an ArrayList of LineItems
		// objects and has a dependency on the order and product object classes
		// being instantiated.

		ArrayList<Order> order = getOrders();
		ArrayList<Product> product = getProducts();

		LineItems lineItem1 = new LineItems(order.get(0), product.get(3), 1, 400.00, 34);
		order.get(0).setLineItem(setLineItemForOrder(lineItem1));
		LineItems lineItem2 = new LineItems(order.get(1), product.get(1), 2, 1400.00, 67);
		order.get(1).setLineItem(setLineItemForOrder(lineItem2));
		LineItems lineItem3 = new LineItems(order.get(2), product.get(2), 3, 4200.00, 2);
		order.get(2).setLineItem(setLineItemForOrder(lineItem3));
		LineItems lineItem4 = new LineItems(order.get(3), product.get(3), 4, 5400.00, 45);
		order.get(3).setLineItem(setLineItemForOrder(lineItem4));
		LineItems lineItem5 = new LineItems(order.get(4), product.get(4), 5, 1400.00, 235);
		order.get(4).setLineItem(setLineItemForOrder(lineItem5));
	}

	public ArrayList<LineItems> setLineItemForOrder(LineItems lineItem){
		lineItems.add(lineItem);
		ArrayList<LineItems> li = new ArrayList<LineItems>();
		li.add(lineItem);
		return li;
	}

	public void addLineItems(LineItems lineitem) {
		this.lineItems.add(lineitem);
	}

	public ArrayList<LineItems> getLineItems() {
		return lineItems;
	}

	public void setLineItems(ArrayList<LineItems> lineItems) {
		this.lineItems = lineItems;
	}


	private void setEmployeeUserInitialData() {
		employeeUsers.add(new EmployeeUser("Mr Big Mann"));
		employeeUsers.add(new EmployeeUser("Mr Patrick Starfish"));
		employeeUsers.add(new EmployeeUser("Miss Wo Mann"));
		employeeUsers.add(new EmployeeUser("Mr James Trainer"));
		employeeUsers.add(new EmployeeUser("Mr Stewart Noob"));

	}

	public void addEmployeeUser(EmployeeUser eu) {
		employeeUsers.add(eu);
	}

	public ArrayList<EmployeeUser> getEmployeeUser() {
		return employeeUsers;
	}

	public void setEmployeeUsers(ArrayList<EmployeeUser> employeeUsers) {
		this.employeeUsers = employeeUsers;
	}

	private void setSupplierOrderInitialData() {
		int received[] = { 1, 2, 3, 4, 4 };

		for (int i = 0; i < 5; i++) {
			supplierOrders.add(new SupplierOrder(getProducts().get(i), OrderStatus.AWAITINGDISPATCH,
					getSuppliers().get(i), i, new Date(), received[i]));
		}
	}

	public ArrayList<SupplierOrder> getSupplierOrders() {
		return supplierOrders;
	}

	public void addSupplierOrder(SupplierOrder supplierOrder) {
		supplierOrders.add(supplierOrder);
	}

	public void setSupplierOrders(ArrayList<SupplierOrder> supplierOrders) {
		this.supplierOrders = supplierOrders;
	}

	// Products nabz & Dean
	private void setProductInitialData() {
		products.add(new Product(0, "Day Dream Gnome", "GHTY-YTER-GFDG", "blue", 44.99, false, "DayDreamGnome", 500,
				ProductType.GNOME, "A traditional garden gnome, a great new addition to your lawn. To be cleaned of with a dam cloth.", 40, 500));

		products.add(new Product(1, "Sunflower Seeds", "SDFF-DFGF-JGGJ", "yellow", 3.99, false, "SunflowerSeeds", 600,
				ProductType.SEED, "Helianthus annuus, Sunflower seeds forms beautiful tall sunflowers which are bright yellow.", 60, 700));

		products.add(new Product(2, "Wheelbarrow", "EWRE-WRFS-SAZC", "red", 20.99, false, "WheelBarrow", 700,
				ProductType.TOOL, "This sturdy and reliable wheelbarrow is ideal for gardening work, with a great capacity.", 70, 400));

		products.add(new Product(3, "Peace Gnome", "GHTY-YTER-GFD2", "blue", 39.99, false, "PeaceGnome", 500,
				ProductType.GNOME, "This garden gnome ideal for garden beds, adds a vibrant feel to your garden.", 40, 500));

		products.add(new Product(4, "Pumpkin Seeds", "SDFF-DFGF-JGG2", "orange", 3.99, false, "PumpkinSeeds", 600,
				ProductType.SEED, "Cucurbita maxima, Pumpkin Seeds form large orange pumpkins, great for decoration at festive times like halloween.", 60, 700));

		products.add(new Product(5, "Lawn Mower", "EWRE-WRFS-SAZ2", "blue", 1072.00, false, "LawnMower", 700,
				ProductType.TOOL, "Top of the range WORX robotic lawn mower, cuts the lawn so you don't have to. Provides multiple height settings for different lawn heights. Intergated with a 36V lithium-ion battery technology.", 70, 400));
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

	private void setProdCatInitialData() {
		for (int i = 0; i < 5; i++) {
			prodCats.add(new ProdCat(getProducts().get(i), getCategories().get(i)));
		}
	}

	public ArrayList<ProdCat> getProdCats() {
		return prodCats;
	}

	public void addProdCat(ProdCat prodCat) {
		prodCats.add(prodCat);
	}

	public void setProdCats(ArrayList<ProdCat> prodCats) {
		this.prodCats = prodCats;
	}
	// Category Nabz & Dean

	private void setCategoriesInitialData() {
		categories.add(new Category(1, "axe wielding"));
		categories.add(new Category(2, "zombie"));
		categories.add(new Category(3, "big and scary"));
		categories.add(new Category(4, "small and scary"));
		categories.add(new Category(5, "big and not scary"));
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

	private void setProdSupInitialData() {
		double[] cost = { 100.05, 200.40, 400.09, 300.02, 800.32 };

		for (int i = 0; i < 5; i++) {
			prodSups.add(new ProdSup(getSuppliers().get(i), getProducts().get(i), cost[i]));
		}
	}

	public ArrayList<ProdSup> getProdSups() {
		return this.prodSups;
	}

	public void addProdSup(ProdSup prodSup) {
		this.prodSups.add(prodSup);
	}

	public void setProdSups(ArrayList<ProdSup> prodSups) {
		this.prodSups = prodSups;
	}

	/**
	 * 
	 * Created by Omar
	 * 
	 */
	private void setWishlistEntryInitialData() {
		for (int i = 0; i < 5; i++) {
			wishListEntries.add(new WishListEntry(getProducts().get(i), new Date(), getUsers().get(i)));
		}
	}

	public ArrayList<WishListEntry> getWishListEntries() {
		return this.wishListEntries;
	}

	public void addWishListEntry(WishListEntry wishListEntry) {
		this.wishListEntries.add(wishListEntry);
	}

	public void setWishListEntries(ArrayList<WishListEntry> wishListEntries) {
		this.wishListEntries = wishListEntries;
	}
}
