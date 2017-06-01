package com.gaonsoft.mcs.user.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * User Entity
 *
 * @author WoonSung Baek
 */
@Entity
@IdClass(UserKey.class)
@Table(name="CM_USER_TB")
public class User implements Serializable, UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COMP_SEQ")
	private Long compSeq;
	
	@Id
	@Column(name="USER_SEQ")
	private Long userSeq;
	
	@Column(name="USER_ID")
	private String userId; 
	
	@Column(name="USER_TYPE")
	private Long userType;
	
	@Column(name="USER_NM")
	private String userNm;
	
	@Column(name="LOGIN_PWD")
	private String loginPwd;
	
	@Column(name="USE_YN")
	private Long useYn;
	
	@Transient
	private boolean isAccountNonExpired;
	
	@Transient
    private boolean isAccountNonLocked;
	
	@Transient
    private boolean isCredentialsNonExpired;
	
	@Transient
    private boolean isEnabled;
	
	@Transient
	private Collection<? extends GrantedAuthority> authorities;
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	/**
	 * Default protected constructor
	 */
	public User() {}
	
	public Long getCompSeq() {
		return compSeq;
	}

	public void setCompSeq(Long compSeq) {
		this.compSeq = compSeq;
	}

	public Long getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(Long userSeq) {
		this.userSeq = userSeq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getUserType() {
		return userType;
	}

	public void setUserType(Long userType) {
		this.userType = userType;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public Long getUseYn() {
		return useYn;
	}

	public void setUseYn(Long useYn) {
		this.useYn = useYn;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String getPassword() {
		return this.loginPwd;
	}

	@Override
	public String getUsername() {
		return this.userId;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return (useYn.longValue() > 0) ? true : false;
	}

	public void setAccountNonExpired(boolean isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}

	public void setAccountNonLocked(boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}

	public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	public void setUsername(String username) {
        this.userId = username;
	}

	public void setPassword(String password) {
		this.loginPwd = password;
	}
}