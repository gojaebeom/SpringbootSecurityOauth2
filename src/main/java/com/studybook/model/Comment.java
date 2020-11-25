package com.studybook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 255, nullable = false)
	private String content;
	
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name="user_id", nullable = false)
	private User user;
	
	@ManyToOne(targetEntity = Post.class)
	@JoinColumn(name="post_id", nullable = false)
	private Post post;
	
	
}
