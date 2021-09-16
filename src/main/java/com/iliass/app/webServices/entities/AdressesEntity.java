package com.iliass.app.webServices.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity(name = "adresses")
public class AdressesEntity implements Serializable {


	private static final long serialVersionUID = -6849052118150230539L;

	@Id
	@GeneratedValue
	private long id ;
	
	@Column(length = 30,nullable = false)
	private String adresseId;
	
	@Column(length = 30,nullable = false)
	private String city;
	
	@Column(length = 30,nullable = false)
	private String country;
	
	@Column(length = 30,nullable = false)
	private String street;
	
	@Column(length = 30,nullable = false)
	private String postal;
	
	@Column(length = 30,nullable = false)
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "users_id")
	private UserEntity userEtity;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdresseId() {
		return adresseId;
	}

	public void setAdresseId(String adresseId) {
		this.adresseId = adresseId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public UserEntity getUserEtity() {
		return userEtity;
	}

	public void setUserEtity(UserEntity userEtity) {
		this.userEtity = userEtity;
	}


	
	
}
