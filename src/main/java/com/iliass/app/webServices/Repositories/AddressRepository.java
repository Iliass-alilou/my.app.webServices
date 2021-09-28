package com.iliass.app.webServices.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iliass.app.webServices.entities.AdressesEntity;
import com.iliass.app.webServices.entities.UserEntity;

@Repository
public interface AddressRepository extends JpaRepository<AdressesEntity, Long> {

	List<AdressesEntity> findByUser(UserEntity user);

	AdressesEntity findByAddressId(String addressId);
}
