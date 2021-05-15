package com.example.demo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Elevator;
import com.example.demo.service.ElevatorService;

@RestController
public class ElevatorController {
	Logger logger = LogManager.getLogger(ElevatorController.class);
	@Autowired
	private ElevatorService es;
	
	@RequestMapping(method = RequestMethod.POST, value = "/elevator/add")
	public ResponseEntity<String> add(@RequestBody Elevator el){
		try {
			es.add(el);
		}catch(Exception e) {
			logger.info("Adding elevator unsuccessful. Building = <>",el);
			return new ResponseEntity<String>("Adding elevator unsuccessful. \n " + e.getMessage(), HttpStatus.PARTIAL_CONTENT );
		}
		
		logger.info("Adding elevator successful");
		return new ResponseEntity<String>("Adding elevator successful", HttpStatus.OK );
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/elevator/{id}")
	public ResponseEntity<Elevator> get(@PathVariable long id){
		logger.info("Getting an elevator");
		return new ResponseEntity<Elevator>(es.getById(id), HttpStatus.OK );
	}

	@RequestMapping(method = RequestMethod.GET, value = "/allElevator")
	public ResponseEntity<List<Elevator>> get(){
		logger.info("Getting all elevator");
		return new ResponseEntity<List<Elevator>>(es.getAll(), HttpStatus.OK );
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/elevator/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {
			es.delete(id);
		}catch(Exception e) {
			logger.info("Deleting elevator unsuccessful. Elevator ID = <>",id);
			return new ResponseEntity<String>("Deleting elevator unsuccessful. \n" + e.getMessage(), HttpStatus.NOT_FOUND );
		}
		
		logger.info("Deleting elevator successful");
		return new ResponseEntity<String>("Deleting elevator successful", HttpStatus.OK );
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/elevator/update")
	public ResponseEntity<String> update(@RequestBody Elevator el){
		try {
			es.update(el);
		}catch(Exception e) {
			logger.info("Updating elevator unsuccessful <>",el);
			return new ResponseEntity<String>("Updating elevator unsuccessful. \n" + e.getMessage(), HttpStatus.NOT_FOUND );
		}
		
		logger.info("Updating elevator successful");
		return new ResponseEntity<String>("Updating elevator successful", HttpStatus.OK );
	}
	
//	@RequestMapping(method = RequestMethod.PUT, value = "/elevator/summon/{id}")
//	public String summonElevator(@PathVariable long id){
//
//		
//		return "Summoning Elevator";
//	}
//	
//	@RequestMapping(method = RequestMethod.PUT, value = "/elevator/{id}/selection/{floor}")
//	public String selectElevatorFloor(@PathVariable long id, @PathVariable int floor){
//
//		return "Selected Floor " + floor + " for Elevator " + id;
//	}
}
