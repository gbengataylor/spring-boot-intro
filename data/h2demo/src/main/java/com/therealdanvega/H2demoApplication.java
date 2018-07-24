package com.therealdanvega;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.therealdanvega.domain.Post;
import com.therealdanvega.repository.PostRepository;
import com.therealdanvega.service.DataLoader;

@SpringBootApplication
public class H2demoApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(H2demoApplication.class);

	@Autowired 
	PostRepository postRepository;

	/**
	 * adding this here so that the data gets loaded programatically by DataLoaded and results show up in seePosts
	 * PostContruct operation below. if not here will still get loaded but may not be part of see posts
	 */
	@Autowired
	DataLoader dataLoader;
	
    public static void main(String[] args) {
        SpringApplication.run(H2demoApplication.class, args);
    }
    
    @PostConstruct
    void seePosts(){
    	logger.info("see posts..");
    	for(Post post : postRepository.findAll() ){
    		logger.info(post.toString());
    	}
    }
    
}
