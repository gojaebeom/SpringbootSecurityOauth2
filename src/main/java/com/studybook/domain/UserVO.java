package com.studybook.domain;

import java.util.Date;

public class UserVO {

	private int id;
	private String account;
	private String password;
	private String nickname;
	private String email;
	private String sessionKey;
	private Date sessionLimit;
	private Date loginedAt;
	private Date createdAt;
	private Date updatedAt;
	
	public UserVO(){
		
	}
	
	public UserVO(int id, String account, String password, String nickname, String email, String sessionKey,
			Date sessionLimit, Date loginedAt, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.nickname = nickname;
		this.email = email;
		this.sessionKey = sessionKey;
		this.sessionLimit = sessionLimit;
		this.loginedAt = loginedAt;
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
	

	public String getSessionKey() {
		return sessionKey;
	}


	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}


	public Date getSessionLimit() {
		return sessionLimit;
	}


	public void setSessionLimit(Date sessionLimit) {
		this.sessionLimit = sessionLimit;
	}


	public Date getLoginedAt() {
		return loginedAt;
	}


	public void setLoginedAt(Date loginedAt) {
		this.loginedAt = loginedAt;
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
				+ ", email=" + email + ", sessionKey=" + sessionKey + ", sessionLimit=" + sessionLimit + ", loginedAt="
				+ loginedAt + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}


	
	
}
