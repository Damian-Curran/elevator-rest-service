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

import com.example.demo.model.Building;
import com.example.demo.service.BuildingService;

@RestController
public class BuildingController {
	Logger logger = LogManager.getLogger(BuildingController.class);
	@Autowired
	private BuildingService bs;
	
	@RequestMapping(method = RequestMethod.POST, value = "/building/add")
	public ResponseEntity<String> add(@RequestBody Building b){
		try {
			bs.add(b);
		}catch(Exception e) {
			logger.info("Adding building unsuccessful. Building = <>",b);
			return new ResponseEntity<String>("Adding building unsuccessful. \n " + e.getMessage(), HttpStatus.PARTIAL_CONTENT );
		}
		
		logger.info("Adding building successful");
		return new ResponseEntity<String>("Adding building successful", HttpStatus.OK );
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/building/{id}")
		public ResponseEntity<Building> get(@PathVariable long id){
		logger.info("Getting a building");
		return new ResponseEntity<Building>(bs.getById(id), HttpStatus.OK );
	}

	@RequestMapping(method = RequestMethod.GET, value ="/allBuilding")
	public ResponseEntity<List<Building>> get(){
		logger.info("Getting all buildings");
		return new ResponseEntity<List<Building>>(bs.getAll(), HttpStatus.OK );
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/building/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {
			bs.delete(id);
		}catch(Exception e) {
			logger.info("Deleting building unsuccessful. Building ID = <>",id);
			return new ResponseEntity<String>("Deleting building unsuccessful. \n" + e.getMessage(), HttpStatus.NOT_FOUND );
		}
		
		logger.info("Deleting building successful");
		return new ResponseEntity<String>("Deleting building successful", HttpStatus.OK );
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/building/update")
	public ResponseEntity<String> update(@RequestBody Building b){
		try {
			bs.update(b);
		}catch(Exception e) {
			logger.info("Updating building unsuccessful <>",b);
			return new ResponseEntity<String>("Updating building unsuccessful. \n" + e.getMessage(), HttpStatus.NOT_FOUND );
		}
		
		logger.info("Updating building successful");
		return new ResponseEntity<String>("Updating building successful", HttpStatus.OK );
	}
}
