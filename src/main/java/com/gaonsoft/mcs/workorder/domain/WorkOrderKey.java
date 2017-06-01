package com.gaonsoft.mcs.workorder.domain;

import java.io.Serializable;

public class WorkOrderKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long compSeq; 
	private String workOrderNo;
//	private Long workOrderSerl;
	
	public WorkOrderKey() {
	}
	
//	public WorkOrderKey(Long compSeq, String workOrderNo, Long workOrderSerl) {
//		this.compSeq = compSeq;
//		this.workOrderNo = workOrderNo;
//		this.workOrderSerl = workOrderSerl; 
//	}

	public Long getCompSeq() {
		return compSeq;
	}

	public void setCompSeq(Long compSeq) {
		this.compSeq = compSeq;
	}

	public String getWorkOrderNo() {
		return workOrderNo;
	}

	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}

//	public Long getWorkOrderSerl() {
//		return workOrderSerl;
//	}
//
//	public void setWorkOrderSerl(Long workOrderSerl) {
//		this.workOrderSerl = workOrderSerl;
//	}
//
//	@Override
//	public String toString() {
//		return "WorkOrderKey [compSeq=" + compSeq + ", workOrderNo=" + workOrderNo + ", workOrderSerl=" + workOrderSerl
//				+ "]";
//	}
	
	
}
