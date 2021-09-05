package com.iliass.app.webServices.Controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iliass.app.webServices.Requests.UserRequest;
import com.iliass.app.webServices.Responses.UserResponse;
import com.iliass.app.webServices.Services.UserService;
import com.iliass.app.webServices.shared.dto.UserDto;


@RestController
@RequestMapping("/users")//localhost:8080/users
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUser() {
		return "getUser was called";
	}
	
	
	// derealization (@RequestBody) 
	@PostMapping
	public UserResponse CreatUser(@RequestBody UserRequest userRequest  ) {
		//couche 1 (layer)
		//instanciate userDto object and binding
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userRequest, userDto);
		
		//couche 2 (layer)
		UserDto createUser = userService.CreateUser(userDto);
		
		//crete Response :
	
		UserResponse userResponse =new UserResponse();
		BeanUtils.copyProperties(createUser, userResponse);
		
		return userResponse;
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
