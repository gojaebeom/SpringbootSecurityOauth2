package com.studybook.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Data
@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 100, nullable = false)
	private String title;
	
	@Lob
	@Column(nullable = false)
	private String content;
	
	@CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;  
	
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name="user_id", nullable = false)
	private User user;
}
