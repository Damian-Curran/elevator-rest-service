package com.example.demo.elevator;

import org.springframework.data.repository.CrudRepository;

public interface ElevatorRepository extends CrudRepository<Elevator, Long>{
	public Elevator findOneById(Long id);
}
