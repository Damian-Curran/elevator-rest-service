package com.example.demo.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserService us;
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/add")
	public String add(@RequestBody User u){
		try {
			us.add(u);
		}catch(Exception e) {
			return "Adding user unsuccessful. \n " + e.getMessage();
		}
		
		return "Adding user successful";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	public User get(@PathVariable long id){
		return us.getById(id);
	}

	@RequestMapping("/allUser")
	public List<User> get(){
		return us.getAll();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
	public String delete(@PathVariable long id){
		try {
			us.delete(id);
		}catch(Exception e) {
			return "Deleting user unsuccessful. \n" + e.getMessage();
		}
		
		return "Deleting user successful";
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/user/update")
	public String update(@RequestBody User u){
		try {
			us.update(u);
		}catch(Exception e) {
			return "Updating user unsuccessful. \n" + e.getMessage();
		}
		
		return "Updating user successful";
	}
}
