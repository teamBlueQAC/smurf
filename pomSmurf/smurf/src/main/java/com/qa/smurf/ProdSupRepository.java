package com.qa.smurf;

/**
 * Author - Omar
 */

import java.util.ArrayList;
import java.util.List;

public interface ProdSupRepository {
	
	// 
	public void persistProdSup (ProdSup prodSup);
	
	// 
	public void persistProdSups(List<ProdSup> prodSup);
	
	// Fetch the entire list of prodSups
	public ArrayList<ProdSup> getProdSups();
	
	// update Address info
	public void updateProdSup(ProdSup prodSup);
	
	// delete 
	public void removeProdSup(ProdSup prodSup);
	
}
