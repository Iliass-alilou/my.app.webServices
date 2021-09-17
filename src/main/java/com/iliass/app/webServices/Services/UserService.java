package com.iliass.app.webServices.Services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.iliass.app.webServices.shared.dto.UserDto;

public interface UserService extends UserDetailsService {

	UserDto CreateUser(UserDto userDto) ;

	UserDto getUser(String email);
	
	UserDto getUserByUserId(String userId);

	UserDto UpdateUser(String id, UserDto userDto);

	void DeleteUser(String id);

	List<UserDto> getUsers(int page, int limit , String search , int status);

}
