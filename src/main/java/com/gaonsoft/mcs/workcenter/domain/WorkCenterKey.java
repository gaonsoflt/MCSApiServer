package com.gaonsoft.mcs.workcenter.domain;

import java.io.Serializable;

public class WorkCenterKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long compSeq;
	private Long wcSeq;
	
	public WorkCenterKey() {
	}
	
	public WorkCenterKey(Long compSeq, Long wcSeq) {
		this.compSeq = compSeq;
		this.wcSeq = wcSeq;
	}

	public Long getCompSeq() {
		return compSeq;
	}

	public void setCompSeq(Long compSeq) {
		this.compSeq = compSeq;
	}

	public Long getWcSeq() {
		return wcSeq;
	}

	public void setWcSeq(Long wcSeq) {
		this.wcSeq = wcSeq;
	}

	@Override
	public String toString() {
		return "WorkCenterKey [compSeq=" + compSeq + ", wcSeq=" + wcSeq + "]";
	}

}
