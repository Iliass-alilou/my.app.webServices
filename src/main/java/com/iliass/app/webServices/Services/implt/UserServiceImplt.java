package com.iliass.app.webServices.Services.implt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.iliass.app.webServices.Repositories.UserRepository;
import com.iliass.app.webServices.Responses.UserResponse;
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
		// check exiting user
		UserEntity checkExisting_User = userRepository.findByEmail(userDto.getEmail());
		if (checkExisting_User != null)
			throw new RuntimeException("user already exist !");

		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity);

		userEntity.setEcryptyPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		userEntity.setUserId(util.generatedValue(32));

		UserEntity newUser = userRepository.save(userEntity);

		UserDto userDto1 = new UserDto();

		BeanUtils.copyProperties(newUser, userDto1);
		return userDto1;

	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		UserEntity userEntity = userRepository.findByEmail(email);

		if (userEntity == null)
			throw new UsernameNotFoundException(email);
		return new User(userEntity.getEmail(), userEntity.getEcryptyPassword(), new ArrayList<>());
	}

	@Override
	public UserDto getUser(String email) {

		UserEntity userEntity = userRepository.findByEmail(email);

		if (userEntity == null)
			throw new UsernameNotFoundException(email);

		UserDto userDto = new UserDto();

		BeanUtils.copyProperties(userEntity, userDto);

		return userDto;
	}

	@Override
	public UserDto getUserByUserId(String userId) {

		UserEntity userEntity = userRepository.findByUserId(userId);
		if (userEntity == null)
			throw new UsernameNotFoundException(userId);
		UserDto userDto = new UserDto();

		BeanUtils.copyProperties(userEntity, userDto);
		return userDto;
	}

	@Override
	public UserDto UpdateUser(String id, UserDto userDto) {

		UserEntity userEntity = userRepository.findByUserId(id);
		if (userEntity == null)
			throw new UsernameNotFoundException(id);

		userEntity.setFirstName(userDto.getFirstName());
		userEntity.setLastName(userDto.getLastName());

		UserEntity userUpdtaed = userRepository.save(userEntity);

		UserDto userDto1 = new UserDto();

		BeanUtils.copyProperties(userUpdtaed, userDto1);
		return userDto1;
	}

	@Override
	public void DeleteUser(String id) {
		UserEntity userEntity = userRepository.findByUserId(id);
		if (userEntity == null)
			throw new UsernameNotFoundException(id);
		userRepository.delete(userEntity);
	}

	@Override
	public List<UserDto> getUsers(int page, int limit) {
		//l'indice commence de 0
		if (page > 0) page -= 1 ;
		List <UserDto> usersDto = new ArrayList<>();

		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<UserEntity> userPage = userRepository.findAll(pageableRequest);
		
		//list dans la page on doit prendre le contenu
		List<UserEntity> users = userPage.getContent();
		
		for (UserEntity userEntity : users) {
			UserDto user = new UserDto();
			BeanUtils.copyProperties(userEntity, user);
			usersDto.add(user);
		}
		
		return usersDto ;
	}

}
