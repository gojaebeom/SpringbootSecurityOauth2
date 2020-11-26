package com.studybook.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
	
//	@ManyToOne(targetEntity = Category.class)
//	@JoinColumn(name="category_id", nullable = false)
//	private Category category;
	
	@ManyToMany
	@JoinTable(
			name="post_hashtag",
			joinColumns = @JoinColumn(name = "post_id"),        // 회원과 매핑할 조인 컬럼 정보를 지정
			inverseJoinColumns = @JoinColumn(name = "hashtag_id") // 상품과 매핑할 조인 컬럼 정보를 지정
			
	)
	private List<HashTag> hashtags = new ArrayList<>();
}
