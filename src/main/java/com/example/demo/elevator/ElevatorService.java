package com.example.demo.elevator;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElevatorService {
	Logger logger = LogManager.getLogger(ElevatorService.class);
	@Autowired 
	private ElevatorRepository er;
	
	public void add(Elevator el){
		logger.info("Adding elevator <>", el);
		er.save(el);
	}
	
	public Elevator getById(Long id){
		logger.info("Getting elevator <>", id);
		return er.findOneById(id);
	}
	
	public void delete(long id){
		logger.info("Deleting elevator <>", id);
		er.deleteById(id);
	}
	
	public void update(Elevator el){
		logger.info("Updating elevator <>", el);
		er.save(el);
	}
	
	public List<Elevator> getAll(){
		logger.info("Getting all elevators");
		List<Elevator> allElevators = new ArrayList<Elevator>();
		er.findAll().forEach(allElevators:: add);
		
		return allElevators;
	}
}
