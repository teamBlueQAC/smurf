/* Made By Dean + Nabs */
package com.qa.smurf;

import java.util.ArrayList;
import java.util.List;

public interface AddressRepository {

	public void persistAddress(Address a);

	public void persistAddresss(List<Address> a);

	public Address findByAddressID(String line1, String pc);

	public ArrayList<Address> getAddresss();

	public void updateAddress(Address a);

}
