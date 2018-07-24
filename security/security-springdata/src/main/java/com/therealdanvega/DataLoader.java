package com.therealdanvega;

// cheat

import com.therealdanvega.domain.Role;
import com.therealdanvega.domain.User;
import com.therealdanvega.repository.RoleRepository;
import com.therealdanvega.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Value("${spring.active.profile}")
    private String profile;

    @PostConstruct
    public void loadData() {

        if("development".equals(profile)) {

            Role adminRole = new Role("ADMIN");
            Role userRole = new Role("USER");

            User user1 = new User("gb@gmail.com", "pass", "Gb Tay");
            user1.addRole(adminRole);
            User user2 = new User("fe@gmail.com", "pass", "fe Tay");
            user2.addRole(userRole);

            userRepository.save(user1);
            userRepository.save(user2);
            roleRepository.save(adminRole);
            roleRepository.save(userRole);
        }

    }
}
