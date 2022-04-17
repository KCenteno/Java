package com.practice.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.practice.safetravels.models.TravelPlan;
import com.practice.safetravels.repositories.TravelPlanRepository;

@Service
public class TravelPlanService {

	// adding the book repository as a dependency
    private final TravelPlanRepository travelRepo;
    
    public TravelPlanService(TravelPlanRepository travelRepo) {
    	
        this.travelRepo = travelRepo;
    }
    
    
    //returns all the Travel Plans
    public List<TravelPlan> allTravelPlans() {
    	return travelRepo.findAll();
    }
    
    //new Travel Plan
    public TravelPlan createTravelPlan(TravelPlan travelPlan) {
    	return travelRepo.save(travelPlan);
    }
    
    //find one Travel Plan
    public TravelPlan findTravelPlan(Long id) {
//    	return this.travelRepo.findById(id).orElse(null);
    	Optional<TravelPlan> optCandy = travelRepo.findById(id);
		if(optCandy.isPresent()) {
			return optCandy.get();
			
		} else {
			
			return null;
		}
    }
    
    // Delete a candy from Repo
    public void traveldelete(Long id) {
    	travelRepo.deleteById(id);
    }
    
    // Update a candyform Repo
    public TravelPlan updatePlan(TravelPlan travelPlan) {
    	return travelRepo.save(travelPlan);
    }
}
