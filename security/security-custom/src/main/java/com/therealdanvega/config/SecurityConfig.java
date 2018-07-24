package com.therealdanvega.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity( securedEnabled = true ) //  gives you ability to add method level authorizations
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired // autowire this method
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception{
		auth
			.inMemoryAuthentication()
				.withUser("dan")
				.password("password")
				.roles("ADMIN")
			.and()
				.withUser("joe")
				.password("password")
				.roles("USER")
			.and()
				.withUser("gbenga")
				.password("password")
				.roles("USER", "ADMIN"); // add multiple roles
		// in-memory authentication. this should come from prop file or idp
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// restrict based on pattern..out of the box security policy
		//so you don't have to lock down every method. can have global policies
		http
			.authorizeRequests()
				.antMatchers("/allowAll/**").permitAll() // no need to authenticate
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/users/**").hasRole("USER")
				.anyRequest().authenticated() // authenticate all requests
				.and()
			.formLogin() // turns on default login form rather than the popup dialog
				.loginPage("/login") // setting our own path
				.permitAll() // this is important, otherwise it will have an endless loop
				.and()
			.logout() // include logout
				.logoutSuccessUrl("/login?logout") // display nice message
				.logoutSuccessUrl("/login?logout") // display nice message
				.permitAll();
	}


	
}
