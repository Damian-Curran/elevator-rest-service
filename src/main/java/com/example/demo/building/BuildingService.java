package com.example.demo.building;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingService {
	@Autowired 
	private BuildingRepository br;
	
	public void add(Building b){
		br.save(b);
	}
	
	public Building getById(Long id){
		return br.findOneById(id);
	}
	
	public void delete(long id){
		br.deleteById(id);
	}
	
	public void update(Building u){
		br.save(u);
	}
	
	public List<Building> getAll(){
		List<Building> allBuildings = new ArrayList<Building>();
		br.findAll().forEach(allBuildings:: add);
		
		return allBuildings;
	}
}
