package com.iliass.app.webServices.Controllers;

import java.lang.reflect.Type;
import java.security.Principal;
import java.util.List;


import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iliass.app.webServices.Requests.AdresseRequest;
import com.iliass.app.webServices.Responses.AddressResponse;
import com.iliass.app.webServices.Services.AddressService;
import com.iliass.app.webServices.shared.dto.AdresseDto;

@Controller
@RequestMapping("/addresses")
public class AddressController {

	@Autowired
	AddressService adrAddressService ;
	
	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<AddressResponse>> getAddresses (Principal principal) {
		
		
	    List<AdresseDto> addresses	= adrAddressService.getAllAddressses(principal.getName());
		
		Type listType = new TypeToken<List<AddressResponse>>() {}.getType();
		List<AddressResponse> addresseResponse = new ModelMapper().map(addresses, listType);
		
		return new ResponseEntity<List<AddressResponse>>(addresseResponse, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}" , 
			    produces = {MediaType.APPLICATION_ATOM_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<AddressResponse> GetOneAddress_ById(@PathVariable(name = "id") String addressId) {
		AdresseDto adresseDto = adrAddressService.getAddress(addressId);
		
		ModelMapper modelMapper = new ModelMapper();
		AddressResponse addressResponse = modelMapper.map(adresseDto, AddressResponse.class);
		return new ResponseEntity<AddressResponse>(addressResponse,HttpStatus.OK);
	}
	
	
	@PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE , MediaType.MULTIPART_FORM_DATA_VALUE},
			    produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<AddressResponse> createAddress (@RequestBody AdresseRequest addressRequest , Principal principal) {
		
		ModelMapper modelMapper = new ModelMapper();
		AdresseDto adresseDto = modelMapper.map(addressRequest, AdresseDto.class);
		
		AdresseDto createdAddress = adrAddressService.CreateAddress(adresseDto,principal.getName());
		AddressResponse addressResponse = modelMapper.map(createdAddress, AddressResponse.class);
		
		return new ResponseEntity<AddressResponse>(addressResponse,HttpStatus.CREATED); 
	}
	
	@PutMapping(path = "/{id}",
			    produces = {MediaType.APPLICATION_ATOM_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
			    consumes = {MediaType.APPLICATION_ATOM_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<AddressResponse> UpdateAddress(@PathVariable(name = "id") String addressId,
			                                             @RequestBody AdresseRequest adresseRequest){
		ModelMapper modelMapper = new ModelMapper();
		AdresseDto adresseDto = modelMapper.map(adresseRequest, AdresseDto.class);
		
		AdresseDto updatedAddress = adrAddressService.UdateAdress(adresseDto,addressId);
		
		AddressResponse addressResponse_updated = modelMapper.map(updatedAddress, AddressResponse.class);
		
		return new ResponseEntity<AddressResponse>(addressResponse_updated , HttpStatus.ACCEPTED); 
	}
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> deletAdress(@PathVariable (name = "id") String addressId){
		adrAddressService.deleteAddress(addressId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
}
