package com.qa.smurf.repositories.offline;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.qa.smurf.InitialData;
import com.qa.smurf.entities.Category;
import com.qa.smurf.repositories.CategoryRepository;

public class CategoryReopsitoryOffline implements CategoryRepository {
	
	@Inject
	private InitialData initialData;

	@Override
	public void persistCategory(Category c) {
		initialData.addCategory(c);
	}

	@Override
	public void persistCategorys(List<Category> c) {
		for(Category cat : c) {
			persistCategory(cat);
		}
	}

	@Override
	public Category findByID(long id) {
		for(Category cat : initialData.getCategories()) {
			if(cat.getID() == id) {
				return cat;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Category> getCategories() {
		return initialData.getCategories();
	}

	@Override
	public void updateCategory(Category c) {
		for(int i = 0; i < initialData.getCategories().size(); i++) {
			if(initialData.getCategories().get(i).getID() == c.getID()) {
				initialData.getCategories().set(i, c);
				break;
			}
		}
	}

	@Override
	public void removeCategory(Category c) {
		initialData.getCategories().remove(c);
	}

}
