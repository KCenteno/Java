package com.practice.fullcrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.practice.fullcrud.models.Candy;
import com.practice.fullcrud.repositories.CandyRepository;

@Service
public class CandyService {

	// injecting the repo
	private final CandyRepository candyRepo;

	public CandyService(CandyRepository candyRepo) {
		super();
		this.candyRepo = candyRepo;
	}
	
	// Find all candy from Repo
	public List<Candy> allCandys(){
		return candyRepo.findAll();
	}
	
	// Create a candy from Repo
	public Candy createCandy(Candy candy) {
		return candyRepo.save(candy);
	}
	
	
	// Find one candy from Repo
	public Candy findCandy(Long id) {
		Optional<Candy> optCandy = candyRepo.findById(id);
		if(optCandy.isPresent()) {
			return optCandy.get();
			
		} else {
			
			return null;
		}

	}
	
	
	// Delete a candy from Repo
	public void candymMan(Long id) {
		candyRepo.deleteById(id);
	}
	
	
	// Update a candy from Repo
	public Candy updateCandy(Candy candy) {
		return candyRepo.save(candy);
	}
	
}