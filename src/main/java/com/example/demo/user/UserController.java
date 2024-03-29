package com.example.demo.user;

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

import com.example.demo.building.Building;
import com.example.demo.elevator.Elevator;

@RestController
public class UserController {
	Logger logger = LogManager.getLogger(UserController.class);
	@Autowired
	private UserService us;
	private UserModel um = new UserModel();

	@RequestMapping(method = RequestMethod.POST, value = "/user/add")
	public ResponseEntity<String> add(@RequestBody User u) {
		try {
			us.add(u);
		} catch (Exception e) {
			logger.info("Adding user unsuccessful. User = <>",u);
			return new ResponseEntity<String>("Adding user unsuccessful. \n " + e.getMessage(), HttpStatus.PARTIAL_CONTENT );
		}
		
		logger.info("Adding user successful");
		return new ResponseEntity<String>("Adding user successful", HttpStatus.OK );
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	public ResponseEntity<User> get(@PathVariable long id) {
		logger.info("Getting a user");
		return new ResponseEntity<User>(us.getById(id), HttpStatus.OK );
	}

	@RequestMapping(method = RequestMethod.GET, value = "/allUser")
	public ResponseEntity<List<User>> get() {
		logger.info("Getting all users");
		return new ResponseEntity<List<User>>(us.getAll(), HttpStatus.OK );
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		try {
			us.delete(id);
		} catch (Exception e) {
			logger.info("Deleting user unsuccessful. User ID = <>",id);
			return new ResponseEntity<String>("Deleting user unsuccessful. \n" + e.getMessage(), HttpStatus.NOT_FOUND );
		}

		logger.info("Deleting user successful");
		return new ResponseEntity<String>("Deleting user successful", HttpStatus.OK );
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/user/update")
	public ResponseEntity<String> update(@RequestBody User u) {
		try {
			us.update(u);
		} catch (Exception e) {
			logger.info("Updating user unsuccessful. User = <>",u);
			return new ResponseEntity<String>("Updating user unsuccessful. \n" + e.getMessage(), HttpStatus.NOT_FOUND );
		}
		logger.info("Updating user successful.");
		return new ResponseEntity<String>("Updating user successful", HttpStatus.OK );
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}/buildings")
	public ResponseEntity<List<Building>> getUserBuildings(@PathVariable long id) {
		logger.info("Getting list of buildings for a user.");
		return new ResponseEntity<List<Building>>(us.getById(id).getBuildings(), HttpStatus.OK );
	}

	
	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}/building/{buildingId}/elevators/statuses") 
	public ResponseEntity<List<Elevator>> getUserBuildingsElevatorStatus(@PathVariable long id,@PathVariable long buildingId){
		logger.info("Getting list of elevator statuses for a user.");
		User user = us.getById(id);
		return new ResponseEntity<List<Elevator>>(um.checkUserIsAssigned(us,id, buildingId,user), HttpStatus.OK );
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}/building/{buildingId}/elevator/summon")
	public ResponseEntity<String> summonElevator(@PathVariable long id,@PathVariable long buildingId) {
		logger.info("Summoning elevator for user.");
		User user = us.getById(id);
		List<Elevator> elevators = um.checkUserIsAssigned(us,id, buildingId,user);
		if(elevators == null)
			return null;
		
		Elevator elevator = um.getLeastBusyElevator(elevators,user.getCurrentFloor());
		
		return new ResponseEntity<String>("Elevator " + elevator.getName() + " Summoned",HttpStatus.OK );
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/user/{id}/building/{buildingId}/elevator/floorSelection/{selectedFloor}")
	public ResponseEntity<String> selectFloor(@PathVariable long id,@PathVariable long buildingId, int selectedFloor) {
		logger.info("Selecting floor number for elevator for user.");
		User user = us.getById(id);
		List<Elevator> elevators = um.checkUserIsAssigned(us,id, buildingId,user);
		if(elevators == null)
			return null;
		
		Elevator elevator = um.getLeastBusyElevator(elevators,user.getCurrentFloor());
		
		if(elevator.getMaxFloor() < selectedFloor || elevator.getMinFloor() > selectedFloor)
			return new ResponseEntity<String>("floor not available for elevator selected",HttpStatus.OK );
		
		return new ResponseEntity<String>("Elevator going to floor " + selectedFloor,HttpStatus.OK );
	}
	 
}
