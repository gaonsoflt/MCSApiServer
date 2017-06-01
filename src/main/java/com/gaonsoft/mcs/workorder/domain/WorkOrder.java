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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.gaonsoft.mcs.common.domain.CodeMinor;

/**
 * WorkCenter Entity
 *
 * @author WoonSung Baek
 */
@Entity
@IdClass(WorkOrderKey.class)
@Table(name="PD_WORK_ORDER_TB")
public class WorkOrder implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public WorkOrder() {
		
	}
	
	@Id
	@Column(name="COMP_SEQ")
	private Long compSeq; 
	
	@Id
	@Column(name="WORK_ORDER_NO")
	private String workOrderNo;

	@Column(name="WORK_ORDER_SERL")
	private Long workOrderSerl;
	
	@Column(name="WORK_ORDER_DATE")
	private String workOrderDate;
	
//	@Column(name="PROD_PLAN_NO")
//	private String prodPlanNo;
	@OneToOne(targetEntity=Plan.class, fetch=FetchType.EAGER, optional=true)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({ 
		@JoinColumn(name="PROD_PLAN_NO", referencedColumnName="PROD_PLAN_NO", insertable=false, updatable=false, nullable=true),
		@JoinColumn(name="COMP_SEQ", referencedColumnName="COMP_SEQ", insertable=false, updatable=false, nullable=true)
	})
	private Plan plan;
	
//	@Column(name="PROC_SEQ")
//	private Long procSeq;
	@ManyToOne(targetEntity=CodeMinor.class, fetch=FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({ 
		@JoinColumn(name="PROC_SEQ", referencedColumnName="MINOR_SEQ", insertable=false, updatable=false),
		@JoinColumn(name="COMP_SEQ", referencedColumnName="COMP_SEQ", insertable=false, updatable=false)
	})
	private CodeMinor proc;
	
//	@Column(name="GOOD_ITEM_SEQ")
//	private Long goodItemSeq;
	@ManyToOne(targetEntity=Item.class, fetch=FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({ 
		@JoinColumn(name="GOOD_ITEM_SEQ", referencedColumnName="ITEM_SEQ", insertable=false, updatable=false, nullable=true),
		@JoinColumn(name="COMP_SEQ", referencedColumnName="COMP_SEQ", insertable=false, updatable=false, nullable=true)
	})
	private Item item;
	
	@Column(name="ORDER_QTY")
	private Long orderQty;
	
	@Column(name="WORK_DATE")
	private String workDate;
	
	@Column(name="EMP_SEQ")
	private Long empSeq;
	
	@Column(name="DELV_TYPE")
	private Long delvType;
	
	@Transient
	private ProductionSum prodSummary;

	public ProductionSum getProdSummary() {
		return prodSummary;
	}

	public void setProdSummary(ProductionSum prodSummary) {
		this.prodSummary = prodSummary;
	}
	
	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public CodeMinor getProc() {
		return proc;
	}

	public void setProc(CodeMinor proc) {
		this.proc = proc;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

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

	public Long getWorkOrderSerl() {
		return workOrderSerl;
	}

	public void setWorkOrderSerl(Long workOrderSerl) {
		this.workOrderSerl = workOrderSerl;
	}

	public String getWorkOrderDate() {
		return workOrderDate;
	}

	public void setWorkOrderDate(String workOrderDate) {
		this.workOrderDate = workOrderDate;
	}

//	public String getProdPlanNo() {
//		return prodPlanNo;
//	}
//
//	public void setProdPlanNo(String prodPlanNo) {
//		this.prodPlanNo = prodPlanNo;
//	}
//
//	public Long getGoodItemSeq() {
//		return goodItemSeq;
//	}
//
//	public void setGoodItemSeq(Long goodItemSeq) {
//		this.goodItemSeq = goodItemSeq;
//	}
//
//	public Long getProcSeq() {
//		return procSeq;
//	}
//
//	public void setProcSeq(Long procSeq) {
//		this.procSeq = procSeq;
//	}

	public Long getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(Long orderQty) {
		this.orderQty = orderQty;
	}

	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

	public Long getEmpSeq() {
		return empSeq;
	}

	public void setEmpSeq(Long empSeq) {
		this.empSeq = empSeq;
	}
	
	public Long getDelvType() {
		return delvType;
	}

	public void setDelvType(Long delvType) {
		this.delvType = delvType;
	}

	@Override
	public String toString() {
		return "WorkOrder [compSeq=" + compSeq + ", workOrderNo=" + workOrderNo + ", workOrderSerl=" + workOrderSerl
				+ ", workOrderDate=" + workOrderDate + ", plan=" + plan + ", proc=" + proc + ", item=" + item
				+ ", orderQty=" + orderQty + ", workDate=" + workDate + ", empSeq=" + empSeq + ", delvType=" + delvType
				+ ", prodSummary=" + prodSummary + "]";
	}
}