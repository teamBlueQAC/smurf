package com.qa.smurf.repositories;
/**
 * Created by Elliot and Sam
 */
import java.util.ArrayList;
import java.util.List;

public interface ProductTypeRepository {
	public void persistProductType(ProductType productType);

	public void persistProductTypes(List<ProductType> productType);

	public ProductType findByID(int id);

	public ArrayList<ProductType> getProductType();

	public void updateProductType(ProductType productType);

	public void removeProductType(ProductType productType);
}
