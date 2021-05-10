package com.example.demo.elevator;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Elevator {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	@javax.persistence.Transient
	private List<Integer> floors;
	private int currentFloor;
	@javax.persistence.Transient
	private State state;
	
	private enum State {
		  UP,
		  DOWN,
		  STOPPED,
		  OUT_OF_SERVICE
		}
	
	public Elevator(String name,List<Integer> floors, int currentFloor, State state) {
		super();
		this.name = name;
		this.floors = floors;
		this.currentFloor = currentFloor;
		this.state = state;
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
}
