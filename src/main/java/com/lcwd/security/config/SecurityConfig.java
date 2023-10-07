package com.lcwd.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	protected void configure(HttpSecurity http)throws Exception {
		
		http
		.authorizeRequests()
		.antMatchers("/home").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("aman").password(this.passwordEncoder().encode("aman")).roles("Admin");
		auth.inMemoryAuthentication().withUser("jaiswal").password(this.passwordEncoder().encode("jaiswal")).roles("User");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

}
