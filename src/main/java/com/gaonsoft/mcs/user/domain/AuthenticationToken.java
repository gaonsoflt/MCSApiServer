package com.gaonsoft.mcs.user.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class AuthenticationToken {
	private String userId;
	private String userNm;
    private Collection<? extends GrantedAuthority> authorities;
    private String token;
    
    public AuthenticationToken(String userId, String userNm, Collection<? extends GrantedAuthority> collection, String token) {
         this.userId = userId;
         this.userNm = userNm;
         this.authorities = collection;
         this.token = token;
    }
    
    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
         return authorities;
    }
    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
         this.authorities = authorities;
    }
    public String getToken() {
         return token;
    }
    public void setToken(String token) {
         this.token = token;
    }  
}
