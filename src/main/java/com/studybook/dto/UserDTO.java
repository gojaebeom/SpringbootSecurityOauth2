package com.studybook.dto;

import java.util.Date;

public class UserDTO {

	private int id;
	private String account;
	private String password;
	private String nickname;
	private String email;
	private Date createdAt;
	private Date updatedAt;
	
	public UserDTO(){
		
	}
	
	public UserDTO(int id, String account, String password, String nickname, String email, Date createdAt,
			Date updatedAt) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.nickname = nickname;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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
		return "UserDTO [id=" + id + ", account=" + account + ", password=" + password + ", nickname=" + nickname
				+ ", email=" + email + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", getId()=" + getId()
				+ ", getAccount()=" + getAccount() + ", getPassword()=" + getPassword() + ", getNickname()="
				+ getNickname() + ", getEmail()=" + getEmail() + ", getCreatedAt()=" + getCreatedAt()
				+ ", getUpdatedAt()=" + getUpdatedAt() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
