package com.therealdanvega.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@RequestMapping("/posts/")
	public String list(){
		return "list posts...";
	}

	@RequestMapping("/admin/posts/create")
	public String addPost(){
		return "add posts...";
	}

	@Secured("ROLE_ADMIN") // this is only for users with admin roles
	@RequestMapping("/again/posts/create")
	public String addPostAgain(){
		return "add posts again...";
	}

	@Secured("ROLE_USER") // this is only for users with admin roles
	@RequestMapping("/drafts")
	public String drafts(){
		return "review drafts...";
	}


	@RequestMapping("/free")
	public String free(){
		return "free for all as long as you're authenticated...";
	}

	@RequestMapping("/allowAll") // see pattern in Webconfig
	public String allowAll(){
		return "doesn't matter if you're authenticated...";
	}


	@RequestMapping("/users")
	public String users(){
		return "only users can do this...";
	}

}
