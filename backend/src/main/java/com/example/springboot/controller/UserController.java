package com.example.springboot.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.ResourceNotFoundException;
import com.example.springboot.dao.UserRespository;
import com.example.springboot.model.User;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:3000")
public class UserController {
@Autowired
private UserRespository repo;
@GetMapping("/user")
public List<User>getAllUser(){
return repo.findAll();
}
@PostMapping("/user")
public User createUser(@RequestBody User user) {
return repo.save(user);
}
@GetMapping("/user/{id}")
public ResponseEntity <User> getUserById(@PathVariable int id)
{
	User user=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("User data doesnot Exists+id"));
	return ResponseEntity.ok(user);
	}
	@PutMapping("/user/{id}")

	public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User userDetails )
	{
	User user=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("User not Exits" +id));
	user.setFirstName(userDetails.getFirstName());
	user.setLastName(userDetails.getLastName());
	user.setEmailId(userDetails.getEmailId());
	User updateUser=repo.save(user);
	return ResponseEntity.ok(updateUser);

	}
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Map<String,Boolean>>deleteUser(@PathVariable int id)
	{
	User user=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("user data nit Exists"+id));
	repo.delete(user);
	Map<String,Boolean>response=new HashMap();
	response.put("deleted", Boolean.TRUE);
	return ResponseEntity.ok(response);
	}
	}





