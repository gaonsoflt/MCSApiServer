package com.gaonsoft.mcs.workorder.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * WorkCenter Entity
 *
 * @author WoonSung Baek
 */

/* testdata
INSERT INTO BB_PRODUCTION_INFO(
  COMP_SEQ, 
  EQUIPMENT_ID, 
  PRODUCTION_DT, 
  QUANTITY, 
  DEFECTIVE,
  TEMPERATURE,
  PRODUCTION_SEQ) 
VALUES (
  1, 
  'SEP01', 
  sysdate, 
  1, 
  0, 
  100.5,
  BB_PRODUCTION_INFO_SEQUENCE.NEXTVAL
);

 */
@Entity
@Table(name="BB_PRODUCTION_INFO")
public class Production implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Production() {
	}
	
	@Column(name = "COMP_SEQ")
	private Long compSeq;
	
	@Column(name = "EQUIPMENT_ID")
	private String toolId;
	
	@Id
	@SequenceGenerator(name="sqBbProductionInfo", sequenceName="BB_PRODUCTION_INFO_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="sqBbProductionInfo")
	@Column(name="PRODUCTION_SEQ")
	private Long proudctionSeq; 
	
	@Column(name="PRODUCTION_DT")
	private Timestamp productionDt;
	
	@Column(name="QUANTITY")
	private Long quantity;
	
	@Column(name="DEFECTIVE")
	private Long defective;
	
	@Column(name="TEMPERATURE")
	private Double temperature;

	
	public Timestamp getProductionDt() {
		return productionDt;
	}

	public Long getProudctionSeq() {
		return proudctionSeq;
	}

	public void setProudctionSeq(Long proudctionSeq) {
		this.proudctionSeq = proudctionSeq;
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

	public void setProductionDt(Timestamp productionDt) {
		this.productionDt = productionDt;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getDefective() {
		return defective;
	}

	public void setDefective(Long defective) {
		this.defective = defective;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		return "\nProduction [compSeq=" + compSeq + ", toolId=" + toolId + ", productionDt=" + productionDt
				+ ", quantity=" + quantity + ", defective=" + defective + ", temperature=" + temperature + "]";
	}
}