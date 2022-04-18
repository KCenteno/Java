package com.practice.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.practice.dojo.models.Ninja;
import com.practice.dojo.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	private final NinjaRepository ninjaRepo;
	
	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	//find all
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}
	// save
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	//find one
	public Ninja findNinja(Long id) {
		Optional<Ninja> optNinja = ninjaRepo.findById(id);
		if(optNinja.isPresent()) {
			return optNinja.get();
			
		} else {
			
			return null;
		}
	}
	//delete
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
	//update
	public Ninja updateNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	

}
