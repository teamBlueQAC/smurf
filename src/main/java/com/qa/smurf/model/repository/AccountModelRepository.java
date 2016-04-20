package com.qa.smurf.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.smurf.model.AccountTypeModel;

@Repository
public interface AccountModelRepository extends JpaRepository<AccountTypeModel, Long> {

	@Query("SELECT gt FROM AccountTypeModel gt WHERE gt.name = ?1")
	public List<AccountTypeModel> getByName(String name);	
	
}
