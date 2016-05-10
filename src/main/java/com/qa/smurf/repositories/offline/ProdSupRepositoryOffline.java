package com.qa.smurf.repositories.offline;

/**
 * Author - Omar
 */

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.smurf.InitialData;
import com.qa.smurf.entities.ProdSup;
import com.qa.smurf.repositories.ProdSupRepository;

@Default
@Stateless
class ProdSupRepositoryOffline implements ProdSupRepository{
	@Inject
	private InitialData initialData;
	
	// 
	@Override
	public void persistProdSup (ProdSup prodSup) {
		initialData.addProdSup(prodSup);
	}
		
	// 
	@Override
	public void persistProdSups(List<ProdSup> prodSups) {
		for (ProdSup p: prodSups) {
			initialData.addProdSup(p);
		}
	}
		
	// Fetch the entire list of prodSups
	@Override
	public ArrayList<ProdSup> getProdSups() {
		
		return initialData.getProdSups();
	}
		
	// update Address info
	@Override
	public void updateProdSup(ProdSup prodSup) {
		
	}
		
	// delete
	@Override
	public void removeProdSup(ProdSup prodSup) {
		
	}
}
