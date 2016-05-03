/* Made By Dean + Nabs */
package com.qa.smurf.repositories;

import java.util.ArrayList;
import java.util.List;

import com.qa.smurf.entities.Category;

public interface CategoryRepository {
	
	public void persistCategory(Category c);

	public void persistCategorys(List<Category> c);

	public Category findByID(long id);

	public ArrayList<Category> getCategories();

	public void updateCategory(Category c);

	public void removeCategory(Category c);

}
