package com.example.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.building.Building;
import com.example.demo.elevator.Elevator;

@RestController
public class UserController {
	@Autowired
	private UserService us;
	private UserModel um = new UserModel();

	@RequestMapping(method = RequestMethod.POST, value = "/user/add")
	public String add(@RequestBody User u) {
		try {
			us.add(u);
		} catch (Exception e) {
			return "Adding user unsuccessful. \n " + e.getMessage();
		}

		return "Adding user successful";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	public User get(@PathVariable long id) {
		return us.getById(id);
	}

	@RequestMapping("/allUser")
	public List<User> get() {
		return us.getAll();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
	public String delete(@PathVariable long id) {
		try {
			us.delete(id);
		} catch (Exception e) {
			return "Deleting user unsuccessful. \n" + e.getMessage();
		}

		return "Deleting user successful";
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/user/update")
	public String update(@RequestBody User u) {
		try {
			us.update(u);
		} catch (Exception e) {
			return "Updating user unsuccessful. \n" + e.getMessage();
		}

		return "Updating user successful";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}/buildings")
	public List<Building> getUserBuildings(@PathVariable long id) {
		User user = us.getById(id);
		return user.getBuildings();
	}

	
	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}/building/{buildingId}/elevators/statuses") 
	public List<Elevator> getUserBuildingsElevatorStatus(@PathVariable long id,@PathVariable long buildingId){
		User user = us.getById(id);
		return um.checkUserIsAssigned(us,id, buildingId,user);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}/building/{buildingId}/elevator/summon")
	public String UserSummonElevator(@PathVariable long id,@PathVariable long buildingId) {
		User user = us.getById(id);
		List<Elevator> elevators = um.checkUserIsAssigned(us,id, buildingId,user);
		if(elevators == null)
			return null;
		
		Elevator elevator = um.getLeastBusyElevator(elevators,user.getCurrentFloor());
		
		return "Elevator " + elevator.getName() + " Summoned";
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/user/{id}/building/{buildingId}/elevator/floorSelection/{selectedFloor}")
	public String UserSelectFloor(@PathVariable long id,@PathVariable long buildingId, int selectedFloor) {
		User user = us.getById(id);
		List<Elevator> elevators = um.checkUserIsAssigned(us,id, buildingId,user);
		if(elevators == null)
			return null;
		
		Elevator elevator = um.getLeastBusyElevator(elevators,user.getCurrentFloor());
		
		if(elevator.getMaxFloor() < selectedFloor || elevator.getMinFloor() > selectedFloor)
			return "floor not available for selection";
		
		return "Elevator going to floor " + selectedFloor;
	}
	 
}
