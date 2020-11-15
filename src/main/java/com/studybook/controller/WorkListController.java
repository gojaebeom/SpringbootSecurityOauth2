package com.studybook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WorkListController {
	
	@RequestMapping(value="/works",method=RequestMethod.GET)
	public String index(){
		return "/work/work-list";
	}

}
