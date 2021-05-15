package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Elevator;

public interface ElevatorRepository extends CrudRepository<Elevator, Long>{
	public Elevator findOneById(Long id);
}
