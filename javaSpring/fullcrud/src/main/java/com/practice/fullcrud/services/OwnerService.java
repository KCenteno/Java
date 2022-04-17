package com.practice.fullcrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.practice.fullcrud.models.Owner;
import com.practice.fullcrud.repositories.OwnerRepository;

@Service
public class OwnerService {
	
	// injecting the repo
	private final OwnerRepository ownerRepo;

	public OwnerService(OwnerRepository ownerRepo) {
		super();
		this.ownerRepo = ownerRepo;
	}
	
	// find all the owners
	public List<Owner> allOwners() {
		return ownerRepo.findAll();
	}
	
	//Create an Owner
	public Owner createOwner(Owner owner) {
		
		return ownerRepo.save(owner);
	}
	
	// Find one candy from Repo
	public Owner findOwner(Long id) {
		
		Optional<Owner> optOwner = ownerRepo.findById(id);
		
		if(optOwner.isPresent()) {
			return optOwner.get();
			
			
		} else {
			
			return null;
		}
	}
}