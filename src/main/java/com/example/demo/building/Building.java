package com.example.demo.building;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.example.demo.elevator.Elevator;

@Entity
public class Building {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String location;
	private List<Elevator> elevators;
	
	public Building(String name, String location, List<Elevator> elevators) {
		super();
		this.name = name;
		this.location = location;
		this.elevators = elevators;
	}
	
	public Building(){
		super();
	}

	public long getId(){
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public List<Elevator> getElevators() {
		return elevators;
	}

	public void setElevators(List<Elevator> elevators) {
		this.elevators = elevators;
	}
}
