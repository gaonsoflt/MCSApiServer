package com.gaonsoft.mcs.workcenter.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * WorkCenter Entity
 *
 * @author WoonSung Baek
 */
@Entity
@IdClass(WorkCenterKey.class)
@Table(name="PD_WC_TB")
public class WorkCenter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COMP_SEQ")
	private Long compSeq;
	
	@Id
	@Column(name="WC_SEQ")
	private Long wcSeq;
	
	@Column(name="WC_NM")
	private String wcName; 
	
	@Column(name="WORK_DEPT_SEQ")
	private Long workDeptSeq;
	
	@Column(name="WC_TYPE")
	private Long wcType;
	
	@Column(name="CAPA_TYPE")
	private Long capaType;
	
	@Column(name="CAPA_RATE")
	private Double capaRate;

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

	public String getWcName() {
		return wcName;
	}

	public void setWcName(String wcName) {
		this.wcName = wcName;
	}

	public Long getWorkDeptSeq() {
		return workDeptSeq;
	}

	public void setWorkDeptSeq(Long workDeptSeq) {
		this.workDeptSeq = workDeptSeq;
	}

	public Long getWcType() {
		return wcType;
	}

	public void setWcType(Long wcType) {
		this.wcType = wcType;
	}

	public Long getCapaType() {
		return capaType;
	}

	public void setCapaType(Long capaType) {
		this.capaType = capaType;
	}

	public Double getCapaRate() {
		return capaRate;
	}

	public void setCapaRate(Double capaRate) {
		this.capaRate = capaRate;
	}

	@Override
	public String toString() {
		return "WorkCenter [compSeq=" + compSeq + ", wcSeq=" + wcSeq + ", wcName=" + wcName + ", workDeptSeq="
				+ workDeptSeq + ", wcType=" + wcType + ", capaType=" + capaType + ", capaRate=" + capaRate + "]";
	}
}