package com.iliass.app.webServices.Services;

import java.util.List;

import com.iliass.app.webServices.shared.dto.AdresseDto;

public interface AddressService {

	List<AdresseDto> getAllAddressses(String email);

	AdresseDto CreateAddress(AdresseDto adresseDto, String email);

	AdresseDto getAddress(String addressId);

	AdresseDto UdateAdress(AdresseDto adresseDto, String addressId);

	void deleteAddress(String addressId);
}
