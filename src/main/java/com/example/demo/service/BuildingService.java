package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BuildingRepository;
import com.example.demo.model.Building;

@Service
public class BuildingService {
	
	Logger logger = LogManager.getLogger(BuildingService.class);
	
	@Autowired 
	private BuildingRepository br;
	
	public void add(Building b){
		logger.info("Adding building <>", b);
		br.save(b);
	}
	
	public Building getById(Long id){
		logger.info("Getting building <>", id);
		return br.findOneById(id);
	}
	
	public void delete(long id){
		logger.info("Deleting building <>", id);
		br.deleteById(id);
	}
	
	public void update(Building b){
		logger.info("Updating building <>", b);
		br.save(b);
	}
	
	public List<Building> getAll(){
		logger.info("Getting all buildings");
		List<Building> allBuildings = new ArrayList<Building>();
		br.findAll().forEach(allBuildings:: add);
		
		return allBuildings;
	}
}
