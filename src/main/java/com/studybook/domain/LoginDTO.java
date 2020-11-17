package com.studybook.domain;

public class LoginDTO {
	private String account;
	private String password;
	private boolean remember;
	
	public LoginDTO() {
		
	}
	
	public LoginDTO(String account, String password, boolean remember) {
		super();
		this.account = account;
		this.password = password;
		this.remember = remember;
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
	public boolean isRemember() {
		return remember;
	}
	public void setRemember(boolean remember) {
		this.remember = remember;
	}

	@Override
	public String toString() {
		return "LoginDTO [account=" + account + ", password=" + password + ", remember=" + remember + "]";
	}
}
