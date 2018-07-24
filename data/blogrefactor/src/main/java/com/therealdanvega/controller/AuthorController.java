package com.therealdanvega.controller;

import com.therealdanvega.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authors")
public class AuthorController {


	private AuthorService authorService;

	@Autowired
	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}

	@RequestMapping("/list")
	public String list(Model model){
		// fixiing model
		model.addAttribute("author", authorService.getAuthors());

		// however this page is blank
		return "author/list";
	}
	
}
