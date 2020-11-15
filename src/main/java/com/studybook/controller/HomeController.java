package com.studybook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	//index, create, store, show, edit, update, destroy
	
	@RequestMapping(value="/")
	public String index(){
		
		return "home";
	}
}
