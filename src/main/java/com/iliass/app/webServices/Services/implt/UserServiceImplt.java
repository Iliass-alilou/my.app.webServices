package com.iliass.app.webServices.Services.implt;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.iliass.app.webServices.Repositories.UserRepository;
import com.iliass.app.webServices.Services.UserService;
import com.iliass.app.webServices.entities.UserEntity;
import com.iliass.app.webServices.shared.Utils;
import com.iliass.app.webServices.shared.dto.UserDto;



@Service
public class UserServiceImplt implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Utils util;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDto CreateUser(UserDto userDto) {
		//check exiting user
		UserEntity checkExisting_User = userRepository.findByEmail(userDto.getEmail());
		if(checkExisting_User != null) throw new RuntimeException("user already exist !"); 
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity);
		
		userEntity.setEcryptyPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		userEntity.setUserId(util.generatedValue(32));

		
		UserEntity newUser =  userRepository.save(userEntity);
		
		UserDto userDto1 = new UserDto();
		
		BeanUtils.copyProperties(newUser, userDto1);
		return userDto1;
		 
	}

}
