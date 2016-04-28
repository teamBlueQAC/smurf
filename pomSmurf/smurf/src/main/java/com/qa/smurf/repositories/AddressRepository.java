package com.qa.smurf.repositories;

/**
 * Author - Omar
 */

import java.util.ArrayList;
import java.util.List;

import com.qa.smurf.entities.Address;

public interface AddressRepository {

	//
	public void persistAddress(Address address);

	//
	public void persistAddresses(List<Address> address);


	// Search for address by postcode and Line1 to create a composite key
	public Address findByPostCodeAndLine1(String postCode, String line1);
	
	// Search for address by postcode - but return array due to possible multiple results
	public ArrayList<Address> findByPostCode(String postCode);
	
	// Search for address via line one - return as array due to possible multiple results
	public ArrayList<Address> findByLine1(String line1);

	// Fetch the entire list of addresses
	public ArrayList<Address> getAddresses();

	// update Address info
	public void updateAddress(Address address);

	// delete - most likely wouldn't delete address
	public void removeAddress(Address address);

}
