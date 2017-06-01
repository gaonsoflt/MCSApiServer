package com.gaonsoft.mcs.workorder.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.gaonsoft.mcs.common.domain.CodeMinor;

/**
 * WorkCenter Entity
 *
 * @author WoonSung Baek
 */
@Entity
@IdClass(PlanKey.class)
@Table(name="PD_PROD_PLAN_TB")
public class Plan implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Plan() {
		
	}
	
	@Id
	@Column(name="COMP_SEQ")
	private Long compSeq; 
	
	@Id
	@Column(name="PROD_PLAN_NO")
	private String prodPlanNo;
	
//	@Id
	@Column(name="PROD_PLAN_SEQ")
	private Long prodPlanSeq;
	
	@Column(name="PROD_PLAN_DATE")
	private String prodPlanDate;
	
//	@Column(name="ASSET_TYPE")
//	private Long assetType;
	@ManyToOne(targetEntity=CodeMinor.class, fetch=FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({ 
		@JoinColumn(name="ASSET_TYPE", referencedColumnName="MINOR_SEQ", insertable=false, updatable=false),
		@JoinColumn(name="COMP_SEQ", referencedColumnName="COMP_SEQ", insertable=false, updatable=false)
	})
	private CodeMinor assetType;
	
//	@Column(name="UNIT_SEQ")
//	private Long unitSeq;
	@ManyToOne(targetEntity=CodeMinor.class, fetch=FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({ 
		@JoinColumn(name="UNIT_SEQ", referencedColumnName="MINOR_SEQ", insertable=false, updatable=false),
		@JoinColumn(name="COMP_SEQ", referencedColumnName="COMP_SEQ", insertable=false, updatable=false)
	})
	private CodeMinor unit;
	
	@Column(name="PROD_PLAN_QTY")
	private Long prodPlanQty;
	
	@Column(name="END_DATE")
	private String endDate;
	
//	@Column(name="PROGRESS_STATUS")
//	private Long progressStatus;
	@ManyToOne(targetEntity=CodeMinor.class, fetch=FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({ 
		@JoinColumn(name="PROGRESS_STATUS", referencedColumnName="MINOR_SEQ", insertable=false, updatable=false),
		@JoinColumn(name="COMP_SEQ", referencedColumnName="COMP_SEQ", insertable=false, updatable=false)
	})
	private CodeMinor status;

	@Column(name="PLAN_GBN")
	private String planGBN;
	
	@Column(name="ORDER_SERL")
	private Long orderSerl;

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

	public Long getProdPlanSeq() {
		return prodPlanSeq;
	}

	public void setProdPlanSeq(Long prodPlanSeq) {
		this.prodPlanSeq = prodPlanSeq;
	}

	public String getProdPlanDate() {
		return prodPlanDate;
	}

	public void setProdPlanDate(String prodPlanDate) {
		this.prodPlanDate = prodPlanDate;
	}

	public CodeMinor getAssetType() {
		return assetType;
	}

	public void setAssetType(CodeMinor assetType) {
		this.assetType = assetType;
	}

	public CodeMinor getUnit() {
		return unit;
	}

	public void setUnit(CodeMinor unit) {
		this.unit = unit;
	}

	public Long getProdPlanQty() {
		return prodPlanQty;
	}

	public void setProdPlanQty(Long prodPlanQty) {
		this.prodPlanQty = prodPlanQty;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public CodeMinor getStatus() {
		return status;
	}

	public void setStatus(CodeMinor status) {
		this.status = status;
	}

	public String getPlanGBN() {
		return planGBN;
	}

	public void setPlanGBN(String planGBN) {
		this.planGBN = planGBN;
	}

	public Long getOrderSerl() {
		return orderSerl;
	}

	public void setOrderSerl(Long orderSerl) {
		this.orderSerl = orderSerl;
	}

	@Override
	public String toString() {
		return "Plan [compSeq=" + compSeq + ", prodPlanNo=" + prodPlanNo + ", prodPlanSeq=" + prodPlanSeq
				+ ", prodPlanDate=" + prodPlanDate + ", assetType=" + assetType + ", unit=" + unit + ", prodPlanQty="
				+ prodPlanQty + ", endDate=" + endDate + ", status=" + status + ", planGBN=" + planGBN + ", orderSerl="
				+ orderSerl + "]";
	}
}