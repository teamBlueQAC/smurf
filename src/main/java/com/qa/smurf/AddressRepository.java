package com.qa.smurf;

/**
 * Author - Omar
 */

import java.util.ArrayList;
import java.util.List;

import com.qa.smurf.entities.Address;

public interface AddressRepository {
	
	// 
	public void persistAddress (Address address);
	
	// 
	public void persistAddresses(List<Address> address);
	
	// Search for address by postcode - may not be possible based on format
	public Address findByPostCode(long postCode);
	
	// Search for address via line one
	// - not a Primary Key, may have multiple results - check if allowed
	public ArrayList<Address> findByLine1(String line1);
	
	// Fetch the entire list of addresses
	public ArrayList<Address> getAddresses();
	
	// update Address info
	public void updateAddress(Address address);
	
	// delete - most likely wouldn't delete address
	public void removeAddress(Address address);
	
}
