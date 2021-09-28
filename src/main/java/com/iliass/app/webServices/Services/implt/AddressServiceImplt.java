package com.iliass.app.webServices.Services.implt;

import java.lang.reflect.Type;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iliass.app.webServices.Services.AddressService;
import com.iliass.app.webServices.Repositories.AddressRepository;
import com.iliass.app.webServices.Repositories.UserRepository;
import com.iliass.app.webServices.entities.AdressesEntity;
import com.iliass.app.webServices.entities.UserEntity;
import com.iliass.app.webServices.shared.Utils;
import com.iliass.app.webServices.shared.dto.AdresseDto;
import com.iliass.app.webServices.shared.dto.UserDto;

@Service
public class AddressServiceImplt implements AddressService {

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Utils utils;
	
	
	@Override
	public List<AdresseDto> getAllAddressses(String email) {
		
		UserEntity user = userRepository.findByEmail(email);
		
		List<AdressesEntity> addresses = user.getAdmin() == true ? (List<AdressesEntity>) addressRepository.findAll() :
			                                                        addressRepository.findByUser(user);
		
		Type listType = new TypeToken<List<AdresseDto>>() {}.getType();
		List<AdresseDto> adresseDto = new  ModelMapper().map(addresses, listType);
		
		return adresseDto;
	}


	@Override
	public AdresseDto CreateAddress(AdresseDto adresseDto, String email) {
		
		UserEntity userEntity = userRepository.findByEmail(email);
		ModelMapper modelMapper = new ModelMapper();
		
		UserDto userDto = modelMapper.map(userEntity, UserDto.class);
		
		adresseDto.setAddressId(utils.generatedValue(30));
		adresseDto.setUser(userDto);
		
		AdressesEntity adressesEntity = modelMapper.map(adresseDto, AdressesEntity.class);
		AdressesEntity newAddress = addressRepository.save(adressesEntity);
		
		AdresseDto adresseDto_Response = modelMapper.map(newAddress, AdresseDto.class);
		
		return adresseDto_Response;
	}


	@Override
	public AdresseDto getAddress(String addressId) {
		
		AdressesEntity adressesEntity = addressRepository.findByAddressId(addressId);
		if(adressesEntity == null) {
			throw new RuntimeException("this address doesn't exist");
		}
		ModelMapper modelMapper = new ModelMapper();
		AdresseDto adressesEntityResult = modelMapper.map(adressesEntity, AdresseDto.class);
		
		return adressesEntityResult;
	}


	@Override
	public AdresseDto UdateAdress(AdresseDto adresseDto, String addressId) {
		
		AdressesEntity addresAdressesEntity = addressRepository.findByAddressId(addressId);
		if(addresAdressesEntity == null) {
			throw new RuntimeException("this address doesn't exist");
		}
		
		addresAdressesEntity.setCity(adresseDto.getCity());
		addresAdressesEntity.setCountry(adresseDto.getCountry());
		addresAdressesEntity.setStreet(adresseDto.getStreet());
		addresAdressesEntity.setPostal(adresseDto.getPostal());
		addresAdressesEntity.setType(adresseDto.getType());
		
		AdressesEntity adressesEntity = addressRepository.save(addresAdressesEntity);
		ModelMapper modelMapper = new ModelMapper();
		
		AdresseDto adresseDto_Response = modelMapper.map(adressesEntity, AdresseDto.class);
		
		return adresseDto_Response ;
	}


	@Override
	public void deleteAddress(String addressId) {
		
		AdressesEntity adressesEntity = addressRepository.findByAddressId(addressId);
		
		if(adressesEntity == null)
			throw new RuntimeException("Address not found");
		
		addressRepository.delete(adressesEntity);
	}
}
