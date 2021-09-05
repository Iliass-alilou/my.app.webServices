package com.iliass.app.webServices.Controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")//localhost:8080/users
public class UserController {
	
	@GetMapping
	public String getUser() {
		return "getUser was called";
	}
	
	@PostMapping
	public String CreatUser() {
		return "CreatUser was called";
	}
	
	@PutMapping
	public String UpdateUser() {
		return "UpdateUser was called";
	}
	
	@DeleteMapping
	public String DeleteUser() {
		return "DeleteUser was called";
	}

}
