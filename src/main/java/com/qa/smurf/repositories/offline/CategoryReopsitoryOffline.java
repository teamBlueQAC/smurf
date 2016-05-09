package com.qa.smurf.repositories.offline;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.qa.smurf.InitialData;
import com.qa.smurf.entities.Category;
import com.qa.smurf.entities.Product;
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
		for (Category cat : c) {
			persistCategory(cat);
		}

	}

	@Override
	public Category findByID(long id) {
		ArrayList<Category> categories = initialData.getCategories();
		for (int i = 0; i < categories.size(); i++) {
			if (categories.get(i).getID() == id) {
				return categories.get(i);
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
		ArrayList<Category> categories = initialData.getCategories();
		for (int i = 0; i < categories.size(); i++) {
			if (categories.get(i).getID() == c.getID()) {
				categories.set(i, c);
				break;
			}
		}
	}

	@Override
	public void removeCategory(Category c) {
		ArrayList<Category> categories = initialData.getCategories();
		for (int i = 0; i < categories.size(); i++) {
			if (categories.get(i).equals(c)) {
				categories.remove(i);
				break;
			}
		}

	}

}
