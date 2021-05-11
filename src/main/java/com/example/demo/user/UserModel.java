package com.example.demo.user;

import java.util.List;

import com.example.demo.building.Building;
import com.example.demo.elevator.Elevator;
import com.example.demo.elevator.Elevator.State;

public class UserModel {
	public List<Elevator> checkUserIsAssigned(UserService us,long id, long buildingId, User user){
		boolean userHasBuildingId = false;
		 
		List<Building> buildings = user.getBuildings(); 
		Building building = new Building();
		  
		for(Building b : buildings){
			if(b.getId() == buildingId) {
				userHasBuildingId = true;
				building = b;
				break;
			}
		}
		  
		if(userHasBuildingId) {
			List<Elevator> elevators = building.getElevators(); 
			return elevators;
		}else
			return null;
	}
	
	public Elevator getLeastBusyElevator(List<Elevator> elevators, int userFloor) {
		Elevator.State state;
		Elevator bestChoice = new Elevator();
		int floorCount = Integer.MAX_VALUE;
		for(Elevator elevator: elevators) {
			state = elevator.getState();
			if(state != State.OUT_OF_SERVICE) {
				if(elevator.getFloors().size() < floorCount) {
					bestChoice = elevator;
				}
			}
			
		}
		
		return bestChoice;
	}
}
