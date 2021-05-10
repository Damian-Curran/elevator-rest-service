package com.example.demo.user;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.example.demo.building.Building;

@Entity
public class User {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private List<Building> buildings;
	private int currentFloor;
	
	public User(String name, int currentFloor, List<Building> buildings) {
		super();
		this.name = name;
		this.currentFloor = currentFloor;
		this.buildings = buildings;
	}
	
	public User(){
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
	
	public List<Building> getBuildings() {
		return buildings;
	}

	public void setBuildings(List<Building> buildings) {
		this.buildings = buildings;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
}
