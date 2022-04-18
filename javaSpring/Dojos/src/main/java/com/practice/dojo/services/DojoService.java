package com.practice.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.practice.dojo.models.Dojo;
import com.practice.dojo.repositories.DojoRepository;

@Service
public class DojoService {
	
private final DojoRepository dojoRepo;
	
	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	//find all
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	// save
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	//find one
	public Dojo findDojo(Long id) {
		Optional<Dojo> optDojo = dojoRepo.findById(id);
		if(optDojo.isPresent()) {
			return optDojo.get();
			
		} else {
			
			return null;
		}
	}
	//delete
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}
	//update
	public Dojo updateDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}

}
