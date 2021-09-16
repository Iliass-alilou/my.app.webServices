package com.iliass.app.webServices.shared.dto;

public class ContactDto {

	private long id;
	private String contactId;
	private String mobile;
	private String gmail;
	private String facebook;
	private String linkendin;
	private UserDto user;
	
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
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	
	
}
