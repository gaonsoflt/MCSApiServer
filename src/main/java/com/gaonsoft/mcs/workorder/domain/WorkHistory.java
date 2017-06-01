package com.gaonsoft.mcs.workorder.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
 
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

/**
 * WorkCenter Entity
 *
 * @author WoonSung Baek
 */
@Entity 
//@IdClass(WorkHistoryKey.class)
@Table(name="BB_WORK_HISTORY")
public class WorkHistory implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public WorkHistory() {
		
	}
	
	public WorkHistory(Long workHisSeq, String workOrderNo, String toolId, Timestamp startDt) {
		this.workHisSeq = workHisSeq;
		this.workOrderNo = workOrderNo;
		this.toolId = toolId;
		this.startDt = startDt;
	} 
	
	@Column(name="COMP_SEQ", nullable=false)
	private Long compSeq;
	
	@Id
	@SequenceGenerator(name="sqBbWorkHistory", sequenceName="BB_WORK_HISTORY_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="sqBbWorkHistory")
	@Column(name="WORK_HIS_SEQ")
	private Long workHisSeq; 
	
	@Column(name="WORK_ORDER_NO")
	private String workOrderNo;
	
	@Column(name="EQUIPMENT_ID")
	private String toolId;
	
	@Column(name="WORKER_ID")
	private String workerId;
	

	@Column(name="START_DT")
//	@OrderBy("startDt DESC")
	private Timestamp startDt;

	@ManyToOne(targetEntity=WorkOrder.class, fetch=FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({ 
		@JoinColumn(name="WORK_ORDER_NO", referencedColumnName="WORK_ORDER_NO", insertable=false, updatable=false, nullable=true),
		@JoinColumn(name="COMP_SEQ", referencedColumnName="COMP_SEQ", insertable=false, updatable=false, nullable=true)
	})
	private WorkOrder workOrder;
	
	@OneToMany(targetEntity=Production.class, fetch=FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
//	@Where(clause="PRODUCTION_DT >= PRODUCTION_DT")
	@JoinColumns({ 
		@JoinColumn(name="EQUIPMENT_ID", referencedColumnName="EQUIPMENT_ID", insertable=false, updatable=false, nullable=true),
		@JoinColumn(name="COMP_SEQ", referencedColumnName="COMP_SEQ", insertable=false, updatable=false, nullable=true)
	})
	private List<Production> production;

	public void setProduction(List<Production> production) {
		this.production = production;
	}
	
	public List<Production> getProduction() {
		return production;
	}
	
	public Long getCompSeq() {
		return compSeq;
	}

	public void setCompSeq(Long compSeq) {
		this.compSeq = compSeq;
	}

	public WorkOrder getWorkOrder() {
		return workOrder;
	}

	public void setWorkOrder(WorkOrder workOrder) {
		this.workOrder = workOrder;
	}

	public void setStartDt(Timestamp startDt) {
		this.startDt = startDt;
	}

	public Long getWorkHisSeq() {
		return workHisSeq;
	}

	public void setWorkHisSeq(Long workHisSeq) {
		this.workHisSeq = workHisSeq;
	}

	public String getWorkOrderNo() {
		return workOrderNo;
	}

	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}

	public String getToolId() {
		return toolId;
	}

	public void setToolId(String toolId) {
		this.toolId = toolId;
	}

	public String getWorkerId() {
		return workerId;
	}

	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}

	public Timestamp getStartDt() {
		return startDt;
	}

	public void setStar(Timestamp startDt) {
		this.startDt = startDt;
	}

	@Override
	public String toString() {
		return "WorkHistory [compSeq=" + compSeq + ", workHisSeq=" + workHisSeq + ", workOrderNo=" + workOrderNo
				+ ", toolId=" + toolId + ", workerId=" + workerId + ", startDt=" + startDt + ", workOrder=" + workOrder
				+ ", production=" + production + "]\n";
	}
}