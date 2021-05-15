package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;

@Service
public class UserService {
	Logger logger = LogManager.getLogger(UserService.class);
	@Autowired 
	private UserRepository ur;
	
	public void add(User u){
		logger.info("Adding user <>", u);
		ur.save(u);
	}
	
	public User getById(Long id){
		logger.info("Getting user <>", id);
		return ur.findOneById(id);
	}
	
	public void delete(long id){
		logger.info("Deleting user <>", id);
		ur.deleteById(id);
	}
	
	public void update(User u){
		logger.info("Updating user <>", u);
		ur.save(u);
	}
	
	public List<User> getAll(){
		logger.info("Getting all users");
		List<User> allUsers = new ArrayList<User>();
		ur.findAll().forEach(allUsers:: add);
		
		return allUsers;
	}
}
