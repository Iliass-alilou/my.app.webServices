package com.iliass.app.webServices.shared.dto;

import java.io.Serializable;
import java.util.List;

public class UserDto implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9048007327668760232L;
	
	
	private long id;
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private Boolean admin;
	private String password;
	private String ecryptyPassword;
	private String emailVerificationToken;
	private Boolean emailVerificationStatus = false ;
	private List<AdresseDto> addresses ;
	private ContactDto contact;
	
	
	public ContactDto getContact() {
		return contact;
	}
	public void setContact(ContactDto contact) {
		this.contact = contact;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
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
	public String getEcryptyPassword() {
		return ecryptyPassword;
	}
	public void setEcryptyPassword(String ecryptyPassword) {
		this.ecryptyPassword = ecryptyPassword;
	}
	public String getEmailVerificationToken() {
		return emailVerificationToken;
	}
	public void setEmailVerificationToken(String emailVerificationToken) {
		this.emailVerificationToken = emailVerificationToken;
	}
	public Boolean getEmailVerificationStatus() {
		return emailVerificationStatus;
	}
	public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
		this.emailVerificationStatus = emailVerificationStatus;
	}
	
	public List<AdresseDto> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AdresseDto> addresses) {
		this.addresses = addresses;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	
	
}
