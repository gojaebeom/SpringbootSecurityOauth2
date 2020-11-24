package com.studybook.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
	@GetMapping("/categories")
	public void index() {
		
	}
	@GetMapping("/categories/{id}")
	public void show() {
		
	}
	@PostMapping("/categories")
	public void store() {
		
	}
	@PatchMapping("/categories/{id}")
	public void edit() {
		
	}
	@DeleteMapping("/categories/{id}")
	public void destroy() {
		
	}
}
