package com.gaonsoft.mcs.user.service;

public enum UserType {
	ADMIN(10070001),
	USER(10070002),
	SYSTEM(10070003);
	
	private long type;
	UserType(long type) {
		this.type = type;
	}
	public long getType() {
		return type;
	}
	public void setType(long type) {
		this.type = type;
	}
}
