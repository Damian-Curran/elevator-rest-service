package com.example.demo.building;

import org.springframework.data.repository.CrudRepository;

public interface BuildingRepository extends CrudRepository<Building, Long>{
	public Building findOneById(Long id);
	public Building findOneByName(String name);
	public Building deleteByName(String name);
}
