package com.iliass.app.webServices.Controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/users") // localhost:8080/users
public class UserController {

	@Autowired
	UserService userService;

	//   produces = MediaType.APPLICATION_XML_VALUE => for defing type of manipulating data
	@GetMapping(path = "/{id}" , produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserResponse> getUser(@PathVariable String id) {
		UserDto userDto = userService.getUserByUserId(id);
		UserResponse userResponse = new UserResponse();
		BeanUtils.copyProperties(userDto, userResponse);
		return  new ResponseEntity<UserResponse>(userResponse,HttpStatus.OK);
	}

	// diserialization (@RequestBody)
	//consomer media type => add consumes,  
	@PostMapping(
			consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserResponse> CreatUser(@RequestBody UserRequest userRequest) {
		// couche 1 (layer)
		// instanciate userDto object and binding
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userRequest, userDto);

		// couche 2 (layer)
		UserDto createUser = userService.CreateUser(userDto);

		// crete Response :

		UserResponse userResponse = new UserResponse();
		BeanUtils.copyProperties(createUser, userResponse);

		return   new ResponseEntity<UserResponse>(userResponse,HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<UserResponse> UpdateUser(@PathVariable String id , @RequestBody UserRequest userRequest) {

		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userRequest, userDto);

		UserDto user = userService.UpdateUser(id, userDto);

		UserResponse userResponse = new UserResponse();
		BeanUtils.copyProperties(user, userResponse);

		return  new ResponseEntity<UserResponse>(userResponse,HttpStatus.ACCEPTED);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> DeleteUser(@PathVariable String id ) {
		
		userService.DeleteUser(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
