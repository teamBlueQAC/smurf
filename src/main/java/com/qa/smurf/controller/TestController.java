package com.qa.smurf.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.smurf.model.AccountTypeModel;
import com.qa.smurf.model.repository.AccountModelRepository;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	public AccountModelRepository accountRepository;
	
	/*@RequestMapping("/all")
	public List<AccountTypeModel> findAll() {
		return accountRepository.findAll();
	}*/
	
	@RequestMapping("/all")
	public Map<String,Object> home() {
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("id", 420);
		model.put("name", "VapeNation");
		return model;
	}


}
