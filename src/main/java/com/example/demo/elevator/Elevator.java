package com.example.demo.elevator;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.demo.building.Building;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Elevator {
	@Id
	@GeneratedValue
	@JsonIgnore
	private long id;
	private String name;
	@JsonIgnore
	@javax.persistence.Transient
	private List<Integer> floors;
	private int currentFloor;
	private State state;
	private int minFloor;
	private int maxFloor;
	@ManyToOne
	private Building building;
	
	public enum State {
		  UP,
		  DOWN,
		  STOPPED,
		  OUT_OF_SERVICE
		}
	
	public Elevator(String name,List<Integer> floors, int currentFloor, State state, int minFloor, int maxFloor) {
		super();
		this.name = name;
		this.floors = floors;
		this.currentFloor = currentFloor;
		this.state = state;
		this.minFloor = minFloor;
		this.maxFloor = maxFloor;
	}
	
	public Elevator(){
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
	
	public List<Integer> getFloors() {
		return floors;
	}

	public void setFloors(List<Integer> floors) {
		this.floors = floors;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getMinFloor() {
		return minFloor;
	}

	public void setMinFloor(int minFloor) {
		this.minFloor = minFloor;
	}

	public int getMaxFloor() {
		return maxFloor;
	}

	public void setMaxFloor(int maxFloor) {
		this.maxFloor = maxFloor;
	}
}
