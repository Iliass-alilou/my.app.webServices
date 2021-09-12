package com.iliass.app.webServices.Repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.iliass.app.webServices.entities.UserEntity;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

	UserEntity findByEmail (String email);
	UserEntity findByUserId (String userId);
	
}
