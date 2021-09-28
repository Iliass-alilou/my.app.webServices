package com.iliass.app.webServices.Controllers;

import java.util.ArrayList;
import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iliass.app.webServices.Exceptions.UserException;
import com.iliass.app.webServices.Requests.UserRequest;
import com.iliass.app.webServices.Responses.ErrorMessages;
import com.iliass.app.webServices.Responses.UserResponse;
import com.iliass.app.webServices.Services.UserService;
import com.iliass.app.webServices.shared.dto.UserDto;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users") // localhost:8080/users
public class UserController {

	//Response Entity for server status 
	@Autowired
	UserService userService;

	//   produces = MediaType.APPLICATION_XML_VALUE => for defing type of manipulating data
	@GetMapping(
			path = "/{id}" ,
			produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}
			)
	public ResponseEntity<UserResponse> getUser(@PathVariable String id) {
		UserDto userDto = userService.getUserByUserId(id);
		UserResponse userResponse = new UserResponse();
		BeanUtils.copyProperties(userDto, userResponse);
		return  new ResponseEntity<UserResponse>(userResponse,HttpStatus.OK);
	}
	
//	@CrossOrigin(origins = "*")
	@CrossOrigin(origins = {"http://localhost:3000" , "http://localhost:4200"})
	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<UserResponse>> getAllUsers (
			@RequestParam(value = "page" , defaultValue = "1") int page ,
			@RequestParam(value = "limit", defaultValue = "15")  int limit,
			@RequestParam(value = "search", defaultValue = "")  String  search,
			@RequestParam(value = "status", defaultValue = "0")  int  status
			) {
		
		List<UserResponse> userResponses = new ArrayList<>();
		List<UserDto> users =userService.getUsers(page , limit , search , status);
		
		for (UserDto userDto : users) {
			ModelMapper modelMapper = new ModelMapper();
			UserResponse user = modelMapper.map(userDto, UserResponse.class);
			/*
			 * UserResponse user = new UserResponse(); BeanUtils.copyProperties(userDto,
			 * user);
			 */
			userResponses.add(user);
		}
		
		return new ResponseEntity<List<UserResponse>>(userResponses,HttpStatus.OK);
	}
 
	@PostMapping(
			consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}
			)
	public ResponseEntity<UserResponse> CreatUser(@RequestBody UserRequest userRequest) 
			throws Exception {
				if(userRequest.getFirstName().isEmpty()) {
					throw new UserException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
				}
				
				//UserDto userDto = new UserDto();
				//BeanUtils.copyProperties(userRequest, userDto);
				ModelMapper modelMapper = new ModelMapper();
				UserDto userDto = modelMapper.map(userRequest, UserDto.class);
				
				UserDto createUser = userService.CreateUser(userDto);
				
				UserResponse userResponse = modelMapper.map(createUser, UserResponse.class);
		
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
