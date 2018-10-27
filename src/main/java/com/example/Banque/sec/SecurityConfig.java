package com.example.Banque.sec;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
	@Bean
	 public PasswordEncoder passwordEncoder() {
	  return new BCryptPasswordEncoder();
	 }
	
	@SuppressWarnings("deprecation")
	@Autowired
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
		.withUser("admin").password("1234").roles("ADMIN","USER");
	     auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
		.withUser("user").password("1234").roles("USER");
//		auth.jdbcAuthentication().dataSource(dataSource)
//		.usersByUsernameQuery("Select username as principal, password as credentials, active from users where username=? ")
//		.authoritiesByUsernameQuery("Select username as principal, roles as role from users_role where username=? ")
//		.rolePrefix("ROLE_")
//		.passwordEncoder(passwordEncoder());
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login");
		http.authorizeRequests().antMatchers("/consultercompte" , "/operations").hasRole("USER");
		http.authorizeRequests().antMatchers("/saveoperation").hasRole("ADMIN");
		http.exceptionHandling().accessDeniedPage("/403");
	
	}

}
