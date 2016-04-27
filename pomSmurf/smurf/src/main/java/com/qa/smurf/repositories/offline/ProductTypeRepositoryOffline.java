package com.qa.smurf.repositories.offline;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.qa.smurf.InitialData;
import com.qa.smurf.entities.ProductType;
import com.qa.smurf.repositories.ProductTypeRepository;

public class ProductTypeRepositoryOffline implements ProductTypeRepository {

	@Inject
	private InitialData initialData;

	@Override
	public void persistProductType(ProductType productType) {
		initialData.addProductType(productType);
	}

	@Override
	public void persistProductTypes(List<ProductType> productType) {
		for(ProductType p: productType){
			initialData.addProductType(p);
		}

	}

	@Override
	public ProductType findByID(int id) {
		for(ProductType p: initialData.getProductTypes()){
			if(p.getId() == id){
				return p;
			}
		}
		return null;
	}

	@Override
	public ArrayList<ProductType> getProductType() {
		return initialData.getProductTypes();
	}

	@Override
	public void updateProductType(ProductType productType) {
		ArrayList<ProductType> productTypes = initialData.getProductTypes();
		for(int i=0; i<productTypes.size(); i++) {
			if(productTypes.get(i).getId() == productType.getId())
				productTypes.set(i, productType);
		}
		initialData.setProductTypes(productTypes);

	}

	@Override
	public void removeProductType(ProductType productType) {
		ArrayList<ProductType> productTypes = initialData.getProductTypes();
		for(int i=0; i<productTypes.size(); i++) {
			if(productTypes.get(i).equals(productType))
				productTypes.remove(i);
		}
		initialData.setProductTypes(productTypes);

	}

}
