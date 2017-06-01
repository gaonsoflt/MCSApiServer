package com.gaonsoft.mcs.user.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.gaonsoft.mcs.user.domain.User;

public interface UserService extends UserDetailsService {
	 List<User> getAllUsers();
	 User getUserByUserId(String userId);
	 Collection<GrantedAuthority> getAuthorities(String userId);
}
