package com.example.demo.building;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuildingController {
	@Autowired
	private BuildingService bs;
	
	@RequestMapping(method = RequestMethod.POST, value = "/building/add")
	public ResponseEntity<String> add(@RequestBody Building b){
		try {
			bs.add(b);
		}catch(Exception e) {
			return new ResponseEntity<String>("Adding building unsuccessful. \n " + e.getMessage(), HttpStatus.PARTIAL_CONTENT );
		}
		
		return new ResponseEntity<String>("Adding building successful", HttpStatus.OK );
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/building/{id}")
		public ResponseEntity<Building> get(@PathVariable long id){
		return new ResponseEntity<Building>(bs.getById(id), HttpStatus.OK );
	}

	@RequestMapping(method = RequestMethod.GET, value ="/allBuilding")
	public ResponseEntity<List<Building>> get(){
		return new ResponseEntity<List<Building>>(bs.getAll(), HttpStatus.OK );
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/building/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {
			bs.delete(id);
		}catch(Exception e) {
			return new ResponseEntity<String>("Deleting building unsuccessful. \n" + e.getMessage(), HttpStatus.NOT_FOUND );
		}
		
		return new ResponseEntity<String>("Deleting building successful", HttpStatus.OK );
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/building/update")
	public ResponseEntity<String> update(@RequestBody Building b){
		try {
			bs.update(b);
		}catch(Exception e) {
			return new ResponseEntity<String>("Updating building unsuccessful. \n" + e.getMessage(), HttpStatus.NOT_FOUND );
		}
		
		return new ResponseEntity<String>("Updating building successful", HttpStatus.OK );
	}
}
