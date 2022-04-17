package com.practice.safetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.safetravels.models.TravelPlan;

@Repository
public interface TravelPlanRepository extends CrudRepository<TravelPlan, Long>{
	List<TravelPlan> findAll();
}
