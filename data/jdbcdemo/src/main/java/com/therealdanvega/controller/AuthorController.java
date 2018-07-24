package com.therealdanvega.controller;

import com.therealdanvega.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private static final Logger logger = LoggerFactory.getLogger(AuthorController.class);

    private AuthorService authorService;

    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }



    @RequestMapping("/list")
    public String listAuthors(Model model) {
        logger.info ("getting list of authors");
        model.addAttribute("authors", authorService.getAuthors());
        return "author/list";
    }
}
