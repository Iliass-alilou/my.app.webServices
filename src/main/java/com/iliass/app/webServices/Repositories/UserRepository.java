package com.iliass.app.webServices.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iliass.app.webServices.entities.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

	UserEntity findByEmail (String email);
}
