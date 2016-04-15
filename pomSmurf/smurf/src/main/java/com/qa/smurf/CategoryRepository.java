/* Made By Dean + Nabs */
package com.qa.smurf;

import java.util.ArrayList;
import java.util.List;

public interface CategoryRepository {
	
	public void persistCategory(Category c);

	public void persistCategorys(List<Category> c);

	public Category findByID(long id);

	public ArrayList<Category> getCategories();

	public void updateCategory(Category c);

	public void removeCategory(Category c);

}
