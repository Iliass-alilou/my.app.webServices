package com.iliass.app.webServices.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;



@Entity(name = "contacts")
public class ContactEntity implements Serializable {

	
	private static final long serialVersionUID = -3608253997316597299L;

	@Id
	@GeneratedValue
	private long id ;
	
	@NotBlank
	@Column(length = 30)
	private String contactId;
	
	@Column(nullable = false)
	private String mobile;
	
	@Column(nullable = false)
	private String gmail;
	
	private String facebook;
	private String linkendin;
	
	
	@OneToOne
	@JoinColumn(name = "users_id")
	private UserEntity user;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContactId() {
		return contactId;
	}
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getLinkendin() {
		return linkendin;
	}
	public void setLinkendin(String linkendin) {
		this.linkendin = linkendin;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	
	
}
