package com.example.demo.elevator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElevatorService {
	@Autowired 
	private ElevatorRepository er;
	
	public void add(Elevator b){
		er.save(b);
	}
	
	public Elevator getById(Long id){
		return er.findOneById(id);
	}
	
	public void delete(long id){
		er.deleteById(id);
	}
	
	public void update(Elevator u){
		er.save(u);
	}
	
	public List<Elevator> getAll(){
		List<Elevator> allElevators = new ArrayList<Elevator>();
		er.findAll().forEach(allElevators:: add);
		
		return allElevators;
	}
}
