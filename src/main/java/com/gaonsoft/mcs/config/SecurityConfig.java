package com.gaonsoft.mcs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

import com.gaonsoft.mcs.user.service.UserService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserService userService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
				.and()
			.authorizeRequests()
				.antMatchers("/api/users/login").permitAll()
				.antMatchers("/api/workcenters").permitAll()
				.antMatchers("/api/equipments").permitAll()
				.antMatchers("/api/workorders").permitAll()
				.antMatchers("/api/workorders/**").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll() // allow preflight(like chrome)
//				.antMatchers("/api/users/**").hasAuthority(String.valueOf(UserType.ADMIN.getType()))
				// .antMatchers("/users").hasAuthority("USER")
				// .antMatchers("/admin").hasAuthority("ADMIN")
				.anyRequest().authenticated()
				.and()
			.logout();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
		// auth.userDetailsService(userService).passwordEncoder(userService.passwordEncoder());
		// // PasswordEncoder 사용시 사용
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public HttpSessionStrategy httpSessionStrategy() {
		return new HeaderHttpSessionStrategy();
	}
}
