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
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/add")
	public String add(@RequestBody User u){
		return "Testing add user endpoint";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	public User get(@PathVariable Long id){
		return new User("Testing get user endpoint");
	}

	@RequestMapping("/allUser")
	public List<User> get(){
		List<User> users = new ArrayList<User>();
		User user = new User("Testing get all users endpoint");
		users.add(user);
		return users;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
	public void delete(@PathVariable long id){
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/user/update")
	public void update(@RequestBody User u){
		
	}
}
