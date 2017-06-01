package com.gaonsoft.mcs.workorder.domain;

import java.io.Serializable;

/**
 * Production Summary Entity
 *
 * @author WoonSung Baek
 */
public class ProductionSum implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public ProductionSum() {
	}
	
	private Long compSeq;
	private String toolId;
	private Long normalQty;
	private Long defectQty;

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
	public Long getNormalQty() {
		return normalQty;
	}
	public void setNormalQty(Long normalQty) {
		this.normalQty = normalQty;
	}
	public Long getDefectQty() {
		return defectQty;
	}
	public void setDefectQty(Long defectQty) {
		this.defectQty = defectQty;
	}
	@Override
	public String toString() {
		return "ProductionSum [compSeq=" + compSeq + ", toolId=" + toolId + ", normalQty=" + normalQty + ", defectQty="
				+ defectQty + "]";
	}
}