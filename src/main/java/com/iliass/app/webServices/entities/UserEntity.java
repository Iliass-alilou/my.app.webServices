package com.iliass.app.webServices.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;





@Entity(name = "users")
public class UserEntity implements Serializable {

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
	
	@Column(nullable = true)
	private Boolean admin = false;
	
	@Column(unique = true,  nullable = false ,length = 120)
	private String email;
	
	@Column(nullable = false )
	private String ecryptyPassword;
	
	@Column(nullable = true)
	private String emailVerificationToken;
	
	@Column(nullable = false)
	private Boolean emailVerificationStatus = false;
	
	@OneToMany(mappedBy="user", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private List<AdressesEntity> addresses ;
	
	public Set<GroupEntity> getGroups() {
		return groups;
	}

	public void setGroups(Set<GroupEntity> groups) {
		this.groups = groups;
	}

	@OneToOne(mappedBy="user", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private ContactEntity contact ;
	
	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "users")
	private  Set<GroupEntity> groups  = new HashSet<>() ;
	
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

	

	public List<AdressesEntity> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AdressesEntity> addresses) {
		this.addresses = addresses;
	}

	public ContactEntity getContact() {
		return contact;
	}

	public void setContact(ContactEntity contact) {
		this.contact = contact;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	

	
}
