package com.example.demo.elevator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ElevatorController {
	@Autowired
	private ElevatorService es;
	
	@RequestMapping(method = RequestMethod.POST, value = "/elevator/add")
	public String add(@RequestBody Elevator el){
		try {
			es.add(el);
		}catch(Exception e) {
			return "Adding elevator unsuccessful. \n " + e.getMessage();
		}
		
		return "Adding elevator successful";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/elevator/{id}")
	public Elevator get(@PathVariable long id){
		return es.getById(id);
	}

	@RequestMapping("/allElevator")
	public List<Elevator> get(){
		return es.getAll();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/elevator/{id}")
	public String delete(@PathVariable long id){
		try {
			es.delete(id);
		}catch(Exception e) {
			return "Deleting elevator unsuccessful. \n" + e.getMessage();
		}
		
		return "Deleting elevator successful";
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/elevator/update")
	public String update(@RequestBody Elevator b){
		try {
			es.update(b);
		}catch(Exception e) {
			return "Updating elevator unsuccessful. \n" + e.getMessage();
		}
		
		return "Updating elevator successful";
	}
}
