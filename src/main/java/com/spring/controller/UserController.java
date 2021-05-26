package com.spring.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.model.UserDTO;
import com.spring.dto.response.Response;
import com.spring.service.user.UserService;


@RestController
@RequestMapping("/rest-api/user")
public class UserController {

	
	UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
//	@Autowired
//	private UserRepository userReposiroty;
//	
	@GetMapping()
	public ResponseEntity<Response<List<UserDTO>>> findAll() {

		Response<List<UserDTO>> response = new Response<>();
		
		response.setData(userService.findAll());
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	
	@GetMapping(value="/id/{id}")
	public ResponseEntity<Response<Optional<UserDTO>>> findById(@PathVariable("id") long id){
		
		Response<Optional<UserDTO>> response = new Response<>();

		Optional<UserDTO> user = userService.findById(id);
		response.setData(user);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
