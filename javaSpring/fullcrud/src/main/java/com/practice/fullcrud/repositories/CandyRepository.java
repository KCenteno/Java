package com.practice.fullcrud.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.fullcrud.models.Candy;


@Repository
public interface CandyRepository extends CrudRepository<Candy, Long>{
	
	
	List<Candy> findAll();
	
	

}
