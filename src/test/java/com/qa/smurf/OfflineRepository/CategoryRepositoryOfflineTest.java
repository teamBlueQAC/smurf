package com.qa.smurf.OfflineRepository;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.smurf.InitialData;
import com.qa.smurf.entities.Category;
import com.qa.smurf.repositories.offline.CategoryReopsitoryOffline;

@RunWith(MockitoJUnitRunner.class)
public class CategoryRepositoryOfflineTest {

	@Mock
	private InitialData initialData;

	@InjectMocks
	private CategoryReopsitoryOffline cro; 
	
	@Test
	public void testPersistCategory() {
		Category category = new Category(0, "a");
		ArrayList<Category> catList = new ArrayList<Category>();
		catList.add(category);
		
		Mockito.when(initialData.getCategories()).thenReturn(catList);
		cro.persistCategory(category);
		assertNotNull(cro.getCategories());
	}

	@Test
	public void testPersistCategorys() {
		Category cat1 = new Category(0, "a");
		Category cat2 = new Category(1, "b");
		Category cat3 = new Category(2, "c");
		ArrayList<Category> catList = new ArrayList<Category>();
		catList.add(cat1);
		catList.add(cat2);
		catList.add(cat3);
		
		Mockito.when(initialData.getCategories()).thenReturn(catList);
		cro.persistCategorys(catList);
		assertNotNull(cro.getCategories());
	}

	@Test
	public void testFindByID() {
		Category category = new Category(0, "a");
		ArrayList<Category> catList = new ArrayList<Category>();
		catList.add(category);
		
		Mockito.when(initialData.getCategories()).thenReturn(catList);
		
		assertEquals(category.getID(), cro.findByID(0).getID());
	}

	@Test
	public void testGetCategories() {
		Category category = new Category(0, "a");
		ArrayList<Category> catList = new ArrayList<Category>();
		catList.add(category);
		
		Mockito.when(initialData.getCategories()).thenReturn(catList);
		
		assertNotNull(cro.getCategories());
	}

	@Test
	public void testUpdateCategory() {
		Category category = new Category(0, "a");
		Category newCategory = new Category(0, "b");
		ArrayList<Category> catList = new ArrayList<Category>();
		catList.add(category);
		
		Mockito.when(initialData.getCategories()).thenReturn(catList);
		cro.updateCategory(newCategory);
		assertEquals(newCategory, cro.getCategories().get(0));
	}

	@Test
	public void testRemoveCategory() {
		Category cat0 = new Category(0, "a");
		Category cat1 = new Category(1, "b");
		Category cat2 = new Category(2, "c");
		ArrayList<Category> catList = new ArrayList<Category>();
		ArrayList<Category> compList = new ArrayList<Category>();
		catList.add(cat0); compList.add(cat0);
		catList.add(cat1); compList.add(cat1);
		catList.add(cat2);
		Mockito.when(initialData.getCategories()).thenReturn(catList);
		cro.removeCategory(cat2);
		assertEquals(cro.getCategories().size(), compList.size());
	}

}
