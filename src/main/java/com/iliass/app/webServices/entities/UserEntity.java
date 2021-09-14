package com.iliass.app.webServices.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;





@Entity(name = "users")
public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1090318847312676765L;
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false )
	private String userId;
	
	@Column(nullable = false ,length = 50)
	private String firstName;
	
	@Column(nullable = false ,length = 50)
	private String lastName;
	
	@Column(unique = true,  nullable = false ,length = 120)
	
	private String email;
	
	@Column(nullable = false )
	private String ecryptyPassword;
	
	@Column(nullable = true)
	private String emailVerificationToken;
	
	@Column(nullable = false)
	private Boolean emailVerificationStatus = false;
	
	@OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL)
	private List<AdressesEntity> adressesEntity ;

	
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

	public List<AdressesEntity> getAdressesEntity() {
		return adressesEntity;
	}

	public void setAdressesEntity(List<AdressesEntity> adressesEntity) {
		this.adressesEntity = adressesEntity;
	}
	
	
	
	
}
