package com.studybook.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(length = 100, nullable = false)
	private String password;
	
	@Column(length = 20, nullable = false)
	private String nickname;
	
	@Column(length = 50, nullable = false)
	private String email;
	
	@Column(length = 10, nullable = false)
	private String role;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	@Column
	private String provider;
	
	@Column
	private String providerId;

	@Builder
	public User(String username, String password, String nickname, String email, String role,
			LocalDateTime createdAt, LocalDateTime updatedAt, String provider, String providerId) {
		super();
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.email = email;
		this.role = role;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.provider = provider;
		this.providerId = providerId;
	}	
}
