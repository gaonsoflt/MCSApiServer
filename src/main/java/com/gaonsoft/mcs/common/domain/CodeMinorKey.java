	package com.gaonsoft.mcs.common.domain;

import java.io.Serializable;

public class CodeMinorKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long compSeq;
	private Long minorSeq;
	
	public CodeMinorKey() {
	}
	
	public CodeMinorKey(Long compSeq, Long minorSeq, String toolId) {
		this.compSeq = compSeq; 
		this.minorSeq = minorSeq;
	}

	public Long getCompSeq() {
		return compSeq;
	}

	public void setCompSeq(Long compSeq) {
		this.compSeq = compSeq;
	}

	public Long getMinorSeq() {
		return minorSeq;
	}

	public void setMinorSeq(Long minorSeq) {
		this.minorSeq = minorSeq;
	}

	@Override
	public String toString() {
		return "CodeMinorKey [compSeq=" + compSeq + ", minorSeq=" + minorSeq + "]";
	}

}
