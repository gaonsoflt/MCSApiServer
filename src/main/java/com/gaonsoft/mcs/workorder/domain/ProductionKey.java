package com.gaonsoft.mcs.workorder.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductionKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "COMP_SEQ")
	private Long compSeq;
	@Column(name = "EQUIPMENT_ID")
	private String toolId;
	
	
	public ProductionKey() {
	}
	
	public ProductionKey(Long compSeq, String toolId) {
		this.compSeq = compSeq;
		this.toolId = toolId;
	}

	public Long getCompSeq() {
		return compSeq;
	}

	public void setCompSeq(Long compSeq) {
		this.compSeq = compSeq;
	}

	public String getToolId() {
		return toolId;
	}

	public void setToolId(String toolId) {
		this.toolId = toolId;
	}

	@Override
	public String toString() {
		return "ProductionKey [compSeq=" + compSeq + ", toolId=" + toolId + "]";
	}
}
