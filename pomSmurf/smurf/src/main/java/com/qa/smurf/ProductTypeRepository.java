/* Made By Dean + Nabs */
package com.qa.smurf;

import java.util.ArrayList;
import java.util.List;

public interface ProductTypeRepository {

	public void persistProductType(ProductType pt);

	public void persistProductTypes(List<ProductType> pt);

	public ProductType findByID(long id);

	public ArrayList<ProductType> getProductTypes();

	public void updateProductType(ProductType pt);

	public void removeProductType(ProductType pt);

	
}
