package com.studybook.dto;

import java.util.Date;

public class UserDTO {

	private int id;
	private String account;
	private String password;
	private String name;
	private String email;
	private Date createdAt;
	private Date updatedAt;
	
	public UserDTO(){
		
	}
	
	public UserDTO(int id, String account, String password, String name, String email, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.name = name;
		this.email = email;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", account=" + account + ", password=" + password + ", name=" + name + ", email="
				+ email + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
}
