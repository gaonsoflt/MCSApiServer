package com.gaonsoft.mcs.equipment.domain;

import java.io.Serializable;

public class EquipmentKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long compSeq;
	private Long toolSeq;
	private String toolId;
	
	public EquipmentKey() {
	}
	
	public EquipmentKey(Long compSeq, Long toolSeq, String toolId) {
		this.compSeq = compSeq;
		this.toolSeq = toolSeq;
		this.toolId = toolId; 
	}

	public String getToolId() {
		return toolId;
	}

	public void setToolId(String toolId) {
		this.toolId = toolId;
	}

	public Long getCompSeq() {
		return compSeq;
	}

	public void setCompSeq(Long compSeq) {
		this.compSeq = compSeq;
	}

	public Long getToolSeq() {
		return toolSeq;
	}

	public void setToolSeq(Long toolSeq) {
		this.toolSeq = toolSeq;
	}

	@Override
	public String toString() {
		return "EquipmentKey [compSeq=" + compSeq + ", toolSeq=" + toolSeq + ", toolId=" + toolId + "]";
	}
}
