package com.qa.smurf;

/**
 * Created by Elliot and Sam
 */
import java.util.ArrayList;
import java.util.List;

import com.qa.smurf.entities.ProductType;

public interface ProductTypeRepository {
	public void persistProductType(ProductType productType);

	public void persistProductTypes(List<ProductType> productType);

	public ProductType findByID(int id);

	public ArrayList<ProductType> getProductType();

	public void updateProductType(ProductType productType);

	public void removeProductType(ProductType productType);
}
