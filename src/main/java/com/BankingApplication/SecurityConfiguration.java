package com.BankingApplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
	http.authorizeHttpRequests().antMatchers("/balance").authenticated().antMatchers("/home").permitAll()
	.antMatchers("/about").permitAll()
	.antMatchers("/contact").permitAll()
	.and().formLogin()
	.and().httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		auth.inMemoryAuthentication()
		     .withUser("amulya").password("root").authorities("admin").and()
		     .withUser("sahithi").password("sahi").authorities("user").and()
		     .withUser("meghana").password("mega").authorities("user").and()
		     .withUser("kavitha").password("kavi").authorities("user").and()
		     .withUser("apoorva").password("appu").authorities("user").and()
		     .passwordEncoder(NoOpPasswordEncoder.getInstance());
		
		
	}
	

}
