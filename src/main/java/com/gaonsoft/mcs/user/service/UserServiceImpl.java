package com.gaonsoft.mcs.user.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gaonsoft.mcs.user.dao.UserDAO;
import com.gaonsoft.mcs.user.domain.User;

@Service
public class UserServiceImpl implements UserService {

    protected Log logger = LogFactory.getLog(UserServiceImpl.class);
    
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Override
	public User getUserByUserId(String userId) {
		User user = userDAO.getUserByUserId(userId);
		if(user.getUserId() == null) {
			return null;
		}
		// 나중에 권한이 생기면 아래 주석코드를 사용하고 자체권한 사용부분을 주석처리
		//user.setAuthorities(getAuthorities(userId));
				
		// 자체권한 사용
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(user.getUserType().toString()));
		user.setAuthorities(authorities);
		return user;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities(String userId) {
		List<User> user_authorities = userDAO.readAuthority(userId);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (User user : user_authorities) {
        	authorities.add(new SimpleGrantedAuthority(user.getUserType().toString()));
        }
        return authorities;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// username = userId
		User user = userDAO.getUserByUserId(username);
		if(user.getUserId() == null) {
			return null;
		}
		// DB에 해당 컬럼이 없어서 강제 입력
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
//		user.setEnabled(true);
		user.setCredentialsNonExpired(true);
		return user;
	}
}