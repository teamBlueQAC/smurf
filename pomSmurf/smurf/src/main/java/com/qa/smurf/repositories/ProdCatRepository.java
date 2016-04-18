/* Made By Dean + Nabs */
package com.qa.smurf.repositories;

import java.util.ArrayList;
import java.util.List;

import com.qa.smurf.entities.ProdCat;

public interface ProdCatRepository {

	public void persistProdCat(ProdCat prc);

	public void persistProdCat(List<ProdCat> prc);

	public ProdCat findByID(long id);

	public ArrayList<ProdCat> getProducts();

	public void updateProdCat(ProdCat prc);

	public void removeProdCat(ProdCat prc);

}
