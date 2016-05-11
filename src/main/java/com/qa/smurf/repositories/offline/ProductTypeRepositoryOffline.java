package com.qa.smurf.repositories.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.smurf.InitialData;
import com.qa.smurf.entities.ProductType;
import com.qa.smurf.repositories.ProductTypeRepository;

/**
 * 
 * @author Nathan Orme
 *
 *         Offline Repository for the ProductType Repository
 *
 */
@Default
@Stateless
public class ProductTypeRepositoryOffline implements ProductTypeRepository {

	@Inject
	private InitialData initialData;

	/**
	 * Iterates through the passed list of product types, Then adds them to the
	 * system.
	 * 
	 * @param productType
	 *            - productTypes that gets added
	 */
	@Override
	public void persistProductType(ProductType productType) {
		initialData.addProductType(productType);
	}

	/**
	 * Iterates through the passed list of product types, Then adds them to the
	 * system.
	 * 
	 * @param productType
	 *            - productTypes that gets added
	 */
	@Override
	public void persistProductTypes(List<ProductType> productType) {
		for (ProductType p : productType) {
			initialData.addProductType(p);
		}

	}

	/**
	 * Gets the product type from the storage
	 * 
	 * @param id
	 *            - id of the product type
	 */
	@Override
	public ProductType findByID(int id) {
		for (ProductType p : initialData.getProductTypes()) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	@Override
	public ArrayList<ProductType> getProductType() {
		return initialData.getProductTypes();
	}

	/**
	 * Iterates through the existing list of product types, Then updated the
	 * specified product type from the list.
	 * 
	 * @param productType
	 *            - productType that gets updated
	 */
	@Override
	public void updateProductType(ProductType productType) {
		ArrayList<ProductType> productTypes = initialData.getProductTypes();
		for (int i = 0; i < productTypes.size(); i++) {
			if (productTypes.get(i).getId() == productType.getId())
				productTypes.set(i, productType);
		}
		initialData.setProductTypes(productTypes);

	}

	/**
	 * Iterates through the existing list of product types, Then removes the
	 * specified product type from the list.
	 * 
	 * @param productType
	 *            - productType that gets removed
	 */
	@Override
	public void removeProductType(ProductType productType) {
		ArrayList<ProductType> productTypes = initialData.getProductTypes();
		for (int i = 0; i < productTypes.size(); i++) {
			if (productTypes.get(i).equals(productType))
				productTypes.remove(i);
		}
		initialData.setProductTypes(productTypes);

	}

}
