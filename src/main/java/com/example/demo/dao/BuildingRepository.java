package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Building;

public interface BuildingRepository extends CrudRepository<Building, Long>{
	public Building findOneById(Long id);
	public Building findOneByName(String name);
	public Building deleteByName(String name);
}
