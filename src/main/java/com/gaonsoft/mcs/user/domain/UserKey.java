package com.gaonsoft.mcs.user.domain;

import java.io.Serializable;

public class UserKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long compSeq;
	private  Long userSeq;
	
	public UserKey() {
	}
	
	public UserKey(Long compSeq, Long userSeq) {
		this.compSeq = compSeq;
		this.userSeq = userSeq;
	}

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

	@Override
	public String toString() {
		return "UserKey [compSeq=" + compSeq + ", userSeq=" + userSeq + "]";
	}
}
