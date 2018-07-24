package com.therealdanvega.service;

import com.therealdanvega.controller.AuthorController;
import com.therealdanvega.domain.Author;
import com.therealdanvega.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    public List<Author> getAuthors() {
        return (List<Author>) authorRepository.findAll();
    }
}
