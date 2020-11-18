package com.studybook.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.studybook.domain.PostVO;

@Controller
@RequestMapping(value="/posts")
public class PostController {
	
	
	@Autowired
	private static final Log LOG = LogFactory.getLog(PostController.class);
	
	@RequestMapping(value="/create")
	public String create() {
		return "/post/create";
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public boolean store(@RequestBody PostVO post) {
		
		LOG.info(post);
		
		return true;
	}
}
