import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.Runner;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

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


import com.qa.smurf.InitialData;

public class InitialDataTest {

	InitialData initialDataTest = new InitialData();
    
	@Test
	public void testInitial() {
		initialDataTest.initial();
	}

	@Test
	public void testGetSuppliers() {
		assertNotNull(initialDataTest.getSuppliers());
	}

	@Test
	public void testAddSupplier() {
		Supplier newSup = new Supplier(new Address("a", "a"), "a");
		initialDataTest.addSupplier(newSup);
		assertEquals(newSup, initialDataTest.getSuppliers().get(initialDataTest.getSuppliers().size() -1));
	}

	@Test
	public void testSetSupplier() {
		ArrayList<Supplier> newSups = new ArrayList<Supplier>();
		initialDataTest.setSupplier(newSups);
		assertEquals(newSups, initialDataTest.getSuppliers());
	}

	@Test
	public void testGetAddresses() {
		assertNotNull(initialDataTest.getAddresses());
	}

	@Test
	public void testAddAddress() {
		Address newAddress = new Address("a", "a");
		initialDataTest.addAddress(newAddress);
		assertEquals(newAddress, initialDataTest.getAddresses().get(initialDataTest.getAddresses().size() -1));
	}

	@Test
	public void testSetAddress() {
		ArrayList<Address> newAddresses = new ArrayList<Address>();
		initialDataTest.setAddress(newAddresses);
		assertEquals(newAddresses, initialDataTest.getAddresses());
	}

	@Test
	public void testAddPayment() {
		Payment newPayment = new Payment("", "", "", "", new Address("a", "a"), new User());
		
		initialDataTest.addPayment(newPayment);
		assertEquals(newPayment, initialDataTest.getPayment().get(initialDataTest.getPayment().size() -1));
	}

	@Test
	public void testGetPayment() {
		assertNotNull(initialDataTest.getPayment());
	}

	@Test
	public void testSetPayment() {
		ArrayList<Payment> newPayments = new ArrayList<Payment>();
		initialDataTest.setPayment(newPayments);
		assertEquals(newPayments, initialDataTest.getPayment());
	}

	@Test
	public void testGetOrders() {
		assertNotNull(initialDataTest.getOrders());
	}

	@Test
	public void testAddOrder() {
		Order newOrder = new Order(0, new Date(), new Date(), new Payment("a", "a", "a", "a", new Address("a", "a"), new User()), new Address("a", "a"), new User(), null);
		initialDataTest.addOrder(newOrder);
		assertEquals(newOrder, initialDataTest.getOrders().get(initialDataTest.getOrders().size() -1));
	}

	@Test
	public void testSetOrders() {
		ArrayList<Order> newOrders = new ArrayList<Order>();
		initialDataTest.setOrders(newOrders);
		assertEquals(newOrders, initialDataTest.getOrders());
	}
/*
	@Test
	public void testSetCreditInitialData() {
		ArrayList<Credit> newCredit = new ArrayList<Credit>();
		initialDataTest.setCredit(newCredit);
		assertEquals(newCredit, initialDataTest.getCredit());
	}
	*/

	@Test
	public void testAddCredit() {
		Credit newCredit = new Credit(new User(), 0, 0);
		initialDataTest.addCredit(newCredit);
		assertEquals(newCredit, initialDataTest.getCredit().get(initialDataTest.getCredit().size() -1));
	}

	@Test
	public void testGetCredit() {
		assertNotNull(initialDataTest.getCredit());
	}

	@Test
	public void testSetCredit() {
		ArrayList<Credit> newCredit = new ArrayList<Credit>();
		initialDataTest.setCredit(newCredit);
		assertEquals(newCredit, initialDataTest.getCredit());
	}

	@Test
	public void testGetUsers() {
		assertNotNull(initialDataTest.getUsers());
	}

	@Test
	public void testSetUsers() {
		ArrayList<User> newUsers = new ArrayList<User>();
		initialDataTest.setUsers(newUsers);
		assertEquals(newUsers, initialDataTest.getUsers());
	}

	//@Test
	//public void testAddUser() {
		//User newUser = new User(1, "a", "a", "a", "a", new Date(), true, new Address("a", "a"), new Date());
		//initialDataTest.addUser(newUser);
		//assertEquals(newUser, initialDataTest.getUsers().get(initialDataTest.getUsers().size() -1));
	//}

	@Test
	public void testAddLineItems() {
		LineItems newLineItem = new LineItems(new Order(0, new Date(), new Date(), new Payment("a", "a", "a", "a", new Address("a", "a"), new User()), new Address("a", "a"), new User(), null), new Product(0, "a", "a", "a", 1.5, false, "", 0, null, "a", 0, 0), 0, 0, 0);
		initialDataTest.addLineItems(newLineItem);
		assertEquals(newLineItem, initialDataTest.getLineItems().get(initialDataTest.getLineItems().size() -1));
	}

	@Test
	public void testGetLineItems() {
		assertNotNull(initialDataTest.getLineItems());
	}

	@Test
	public void testSetLineItems() {
		ArrayList<LineItems> newLineItems = new ArrayList<LineItems>();
		initialDataTest.setLineItems(newLineItems);
		assertEquals(newLineItems, initialDataTest.getLineItems());
	}

	@Test
	public void testAddEmployeeUser() {
		EmployeeUser newEmployeeUser = new EmployeeUser("a");
		initialDataTest.addEmployeeUser(newEmployeeUser);
		assertEquals(newEmployeeUser, initialDataTest.getEmployeeUser().get(initialDataTest.getEmployeeUser().size() -1));
	}

	@Test
	public void testGetEmployeeUser() {
		assertNotNull(initialDataTest.getEmployeeUser());
	}

	@Test
	public void testSetEmployeeUsers() {
		ArrayList<EmployeeUser> newEmployeeUsers = new ArrayList<EmployeeUser>();
		initialDataTest.setEmployeeUsers(newEmployeeUsers);
		assertEquals(newEmployeeUsers, initialDataTest.getEmployeeUser());
	}

	@Test
	public void testGetSupplierOrders() {
		assertNotNull(initialDataTest.getSupplierOrders());
	}

	@Test
	public void testAddSupplierOrder() {
		SupplierOrder newSupOrd = new SupplierOrder(new Product(0, "a", "a", "a", 1.5, false, "", 0, null, "a", 0, 0), null, new Supplier( new Address("a", "a"), "a"), 0, new Date(), 0);
		initialDataTest.addSupplierOrder(newSupOrd);
		assertEquals(newSupOrd, initialDataTest.getSupplierOrders().get(initialDataTest.getSupplierOrders().size() -1));
	}

	@Test
	public void testSetSupplierOrders() {
		ArrayList<SupplierOrder> newSupplierOrders = new ArrayList<SupplierOrder>();
		initialDataTest.setSupplierOrders(newSupplierOrders);
		assertEquals(newSupplierOrders, initialDataTest.getSupplierOrders());
	}

	@Test
	public void testGetProducts() {
		assertNotNull(initialDataTest.getProducts());
	}

	@Test
	public void testAddProduct() {
		Product newProduct = new Product(0, "a", "a", "a", 1.5, false, "", 0, null, "a", 0, 0);
		initialDataTest.addProduct(newProduct);
		assertEquals(newProduct, initialDataTest.getProducts().get(initialDataTest.getProducts().size() -1));
	}

	@Test
	public void testSetProducts() {
		ArrayList<Product> newProducts = new ArrayList<Product>();
		initialDataTest.setProducts(newProducts);
		assertEquals(newProducts, initialDataTest.getProducts());
	}

	@Test
	public void testGetProdCats() {
		assertNotNull(initialDataTest.getProdCats());
	}

	@Test
	public void testAddProdCat() {
		ProdCat newProdCat = new ProdCat( new Product(0, "a", "a", "a", 1.5, false, "", 0, null, "a", 0, 0), new Category(1, "a"));
		initialDataTest.addProdCat(newProdCat);
		assertEquals(newProdCat, initialDataTest.getProdCats().get(initialDataTest.getProdCats().size() -1));
	}
	

	@Test
	public void testSetProdCats() {
		ArrayList<ProdCat> newProdCat = new ArrayList<ProdCat>();
		initialDataTest.setProdCats(newProdCat);
		assertEquals(newProdCat, initialDataTest.getProdCats());
	}

	/*@Test
	public void testGetProductTypes() {
		
	}
	
	

	@Test
	public void testAddProductType() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetProductTypes() {
		fail("Not yet implemented");
	}
	*/

	@Test
	public void testGetCategories() {
		assertNotNull(initialDataTest.getCategories());
	}

	@Test
	public void testAddCategory() {
		Category newCategory = new Category(1, "a");
		initialDataTest.addCategory(newCategory);
		assertEquals(newCategory, initialDataTest.getCategories().get(initialDataTest.getCategories().size() -1));
	}

	@Test
	public void testSetCategories() {
		ArrayList<Category> newCategories = new ArrayList<Category>();
		initialDataTest.setCategories(newCategories);
		assertEquals(newCategories, initialDataTest.getCategories());
	}

	@Test
	public void testGetProdSups() {
		assertNotNull(initialDataTest.getProdSups());
	}

	@Test
	public void testAddProdSup() {
		ProdSup newProdSup = new ProdSup(new Supplier(new Address("a", "a"), "a"), new Product(0, "a", "a", "a", 1.5, false, "", 0, null, "a", 0, 0), 1);
		initialDataTest.addProdSup(newProdSup);
		assertEquals(newProdSup, initialDataTest.getProdSups().get(initialDataTest.getProdSups().size() -1));
	}

	@Test
	public void testSetProdSups() {
		ArrayList<ProdSup> newProdSup = new ArrayList<ProdSup>();
		initialDataTest.setProdSups(newProdSup);
		assertEquals(newProdSup, initialDataTest.getProdSups());
	}

	@Test
	public void testGetWishListEntries() {
		assertNotNull(initialDataTest.getWishListEntries());
	}

	@Test
	public void testAddWishListEntry() {
		WishListEntry newWLE = new WishListEntry(new Product(0, "a", "a", "a", 1.5, false, "", 0, null, "a", 0, 0), new Date(), new User());
		initialDataTest.addWishListEntry(newWLE);
		assertEquals(newWLE, initialDataTest.getWishListEntries().get(initialDataTest.getWishListEntries().size() -1));
	}

	@Test
	public void testSetWishListEntries() {
		ArrayList<WishListEntry> newWLE = new ArrayList<WishListEntry>();
		initialDataTest.setWishListEntries(newWLE);
		assertEquals(newWLE, initialDataTest.getWishListEntries());
	}

}
