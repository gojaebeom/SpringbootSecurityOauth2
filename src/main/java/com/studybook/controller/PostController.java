package com.studybook.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studybook.model.Post;
import com.studybook.repository.PostRepository;

@RestController
public class PostController {

	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/posts")
	public List<Post> index() {
		List<Post> posts =  postRepository.findAll();
		
		return posts;
	}
	@GetMapping("/posts/{id}")
	public Optional<Post> show(@PathVariable long id) {
		Optional<Post> post = postRepository.findById(id);
		post.orElseThrow(); 
		return post;
	}
	@PostMapping("/posts")
	public Post store(@RequestBody Post post) {
		System.out.println(post);
		post.setCreatedAt(LocalDateTime.now());
		Post createPost = postRepository.save(post);
		return createPost;
	}
	@PatchMapping("/posts/{id}")
	public Post edit(@PathVariable long id, @RequestBody Post post) {
		post.setId(id);
		post.setCreatedAt(LocalDateTime.now());
		Post updatePost = postRepository.save(post);
		return updatePost;
	}
	@DeleteMapping("/posts/{id}")
	public String destroy(@PathVariable long id) {
		try {
			postRepository.deleteById(id);
		}catch(Exception e) {
			e.getStackTrace();
			System.out.println("삭제 실패");
			return "delete false";
		}
		return "delete success";
	}
}
