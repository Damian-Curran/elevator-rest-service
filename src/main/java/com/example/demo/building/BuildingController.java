package com.example.demo.building;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String add(@RequestBody Building b){
		try {
			bs.add(b);
		}catch(Exception e) {
			return "Adding building unsuccessful. \n " + e.getMessage();
		}
		
		return "Adding building successful";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/building/{id}")
	public Building get(@PathVariable long id){
		return bs.getById(id);
	}

	@RequestMapping("/allBuilding")
	public List<Building> get(){
		return bs.getAll();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/building/{id}")
	public String delete(@PathVariable long id){
		try {
			bs.delete(id);
		}catch(Exception e) {
			return "Deleting building unsuccessful. \n" + e.getMessage();
		}
		
		return "Deleting building successful";
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/building/update")
	public String update(@RequestBody Building b){
		try {
			bs.update(b);
		}catch(Exception e) {
			return "Updating building unsuccessful. \n" + e.getMessage();
		}
		
		return "Updating building successful";
	}
}
