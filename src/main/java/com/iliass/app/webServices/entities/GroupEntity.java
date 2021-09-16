package com.iliass.app.webServices.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class GroupEntity implements Serializable {

	private static final long serialVersionUID = 6691167671830220024L;
	
	@Id
	@GeneratedValue
	private long id ;
	
	@Column(length = 30)
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinTable(name = "groups_users" ,
	           joinColumns = {@JoinColumn(name = "groups_id")} ,
	           inverseJoinColumns = {@JoinColumn(name = "users_id")})
	private Set<UserEntity> users = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<UserEntity> users) {
		this.users = users;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
	
	
	

}
