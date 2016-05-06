package com.qa.smurf.repositories.offline;

/**
 * Author - Omar
 */

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.qa.smurf.InitialData;
import com.qa.smurf.entities.Address;
import com.qa.smurf.repositories.AddressRepository;

public class AddressRepositoryOffline implements AddressRepository {
	@Inject
	InitialData initialData;

	//
	@Override
	public void persistAddress(Address address) {
		initialData.addAddress(address);
	}

	//
	@Override
	public void persistAddresses(List<Address> addresses) {
		for (Address a : addresses) {
			initialData.addAddress(a);
		}
	}

	// Search for address by postcode and Line1 to create a composite key
	@Override
	public Address findByPostCodeAndLine1(String postCode, String line1) {
		for (Address a : initialData.getAddresses()) {
			if ((a.getPostcode().equals(postCode)) && (a.getLine1().equals(line1))) {
				return a;
			}
		}
		return null;
	}

	// Search for address by postcode - but return array due to possible
	// multiple results
	@Override
	public ArrayList<Address> findByPostCode(String postCode) {
		ArrayList<Address> tempArray = new ArrayList<Address>();

		for (Address a : initialData.getAddresses()) {
			if (a.getPostcode().equals(postCode)) {
				tempArray.add(a);
			}
		}
		return tempArray;
	}

	// Search for address via line one - return as array due to possible
	// multiple results
	@Override
	public ArrayList<Address> findByLine1(String line1) {
		ArrayList<Address> tempArray = new ArrayList<Address>();

		for (Address a : initialData.getAddresses()) {
			if (a.getLine1().equals(line1)) {
				tempArray.add(a);
			}
		}
		return tempArray;
	}

	// Fetch the entire list of addresses
	@Override
	public ArrayList<Address> getAddresses() {
		return initialData.getAddresses();
	}

	// update Address info
	@Override
	public void updateAddress(Address address) {

	}

	// delete - most likely wouldn't delete address
	@Override
	public void removeAddress(Address address) {

	}
}
