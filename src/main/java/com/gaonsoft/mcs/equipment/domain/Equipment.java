package com.gaonsoft.mcs.equipment.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
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
@IdClass(EquipmentKey.class)
@Table(name="PD_TOOL_TB")
public class Equipment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COMP_SEQ")
	private Long compSeq; 
	
	@Id
	@Column(name="TOOL_SEQ")
	private Long toolSeq;

	@Id
	@Column(name="TOOL_NO")
	private String toolId;
	
	@Column(name="TOOL_NAME")
	private String toolName;
	
	@Column(name="TOOL_SPEC")
	private String toolSpec;
	
	@Column(name="TOOL_STATUS", nullable=false)
	private Long toolStatus;
	
	@Column(name="TOOL_KIND")
	private Long toolKind;
	
	@Column(name="TOOL_USERS")
	private String toolUsers;
	
	@Column(name="TOOL_SERIAL_NO")
	private String toolSerialNo;

	@OneToOne(targetEntity=CodeMinor.class, fetch=FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({ 
		@JoinColumn(name="TOOL_STATUS", referencedColumnName="MINOR_SEQ", insertable=false, updatable=false, nullable=true),
		@JoinColumn(name="COMP_SEQ", referencedColumnName="COMP_SEQ", insertable=false, updatable=false, nullable=true)
	})
	private CodeMinor status;

	public CodeMinor getStatus() {
		return status;
	}

	public void setStatus(CodeMinor status) {
		this.status = status;
	}

	public Equipment() {
		
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

	public String getToolId() {
		return toolId;
	}

	public void setToolId(String toolId) {
		this.toolId = toolId;
	}

	public String getToolName() {
		return toolName;
	}

	public void setToolName(String toolName) {
		this.toolName = toolName;
	}

	public String getToolSpec() {
		return toolSpec;
	}

	public void setToolSpec(String toolSpec) {
		this.toolSpec = toolSpec;
	}

	public Long getToolStatus() {
		return toolStatus;
	}

	public void setToolStatus(Long toolStatus) {
		this.toolStatus = toolStatus;
	}

	public Long getToolKind() {
		return toolKind;
	}

	public void setToolKind(Long toolKind) {
		this.toolKind = toolKind;
	}

	public String getToolUsers() {
		return toolUsers;
	}

	public void setToolUsers(String toolUsers) {
		this.toolUsers = toolUsers;
	}

	public String getToolSerialNo() {
		return toolSerialNo;
	}

	public void setToolSerialNo(String toolSerialNo) {
		this.toolSerialNo = toolSerialNo;
	}

	@Override
	public String toString() {
		return "Equipment [compSeq=" + compSeq + ", toolSeq=" + toolSeq + ", toolId=" + toolId + ", toolName="
				+ toolName + ", toolSpec=" + toolSpec + ", toolStatus=" + toolStatus + ", toolKind=" + toolKind
				+ ", toolUsers=" + toolUsers + ", toolSerialNo=" + toolSerialNo + "]";
	}
}