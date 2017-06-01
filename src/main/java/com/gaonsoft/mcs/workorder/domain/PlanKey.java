package com.gaonsoft.mcs.workorder.domain;

import java.io.Serializable;

public class PlanKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long compSeq; 
	private String prodPlanNo;
//	private Long prodPlanSeq;
	
	public PlanKey() {
	}

	public Long getCompSeq() {
		return compSeq;
	}

	public void setCompSeq(Long compSeq) {
		this.compSeq = compSeq;
	}

	public String getProdPlanNo() {
		return prodPlanNo;
	}

	public void setProdPlanNo(String prodPlanNo) {
		this.prodPlanNo = prodPlanNo;
	}

	@Override
	public String toString() {
		return "PlanKey [compSeq=" + compSeq + ", prodPlanNo=" + prodPlanNo + "]";
	}

//	public Long getProdPlanSeq() {
//		return prodPlanSeq;
//	}
//
//	public void setProdPlanSeq(Long prodPlanSeq) {
//		this.prodPlanSeq = prodPlanSeq;
//	}
//
//	@Override
//	public String toString() {
//		return "PlanKey [compSeq=" + compSeq + ", prodPlanNo=" + prodPlanNo + ", prodPlanSeq=" + prodPlanSeq + "]";
//	}
}
