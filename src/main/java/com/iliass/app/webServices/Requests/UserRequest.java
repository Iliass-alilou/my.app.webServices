package com.iliass.app.webServices.Requests;

import java.util.List;

public class UserRequest {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private List <AdresseRequest> adresses ;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<AdresseRequest> getAdresses() {
		return adresses;
	}
	public void setAdresses(List<AdresseRequest> adresses) {
		this.adresses = adresses;
	}
	
	
}
