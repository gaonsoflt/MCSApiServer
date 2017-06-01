package com.gaonsoft.mcs.workorder.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

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
  TEMPERATURE) 
VALUES (
  1, 
  'SEP01', 
  sysdate, 
  1, 
  0, 
  100.5
);

 */
@Entity
//@FilterDef(name="dateFilter", parameters={@ParamDef(name="startDt", type="Timestamp")})
//@Filter(name="dateFilter", condition="productionDt >= :startDt")
@Table(name="BB_PRODUCTION_INFO")
public class Production implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Production() {
	}
	
	@EmbeddedId
	private ProductionKey id;
	
	@Column(name="PRODUCTION_DT")
	private Timestamp productionDt;
	
	@Column(name="QUANTITY")
	private Long quantity;
	
	@Column(name="DEFECTIVE")
	private Long defective;
	
	@Column(name="TEMPERATURE")
	private Double temperature;

//	@ManyToMany(targetEntity=WorkHistory.class, fetch=FetchType.EAGER)
//	@NotFound(action = NotFoundAction.IGNORE)
//	@JoinColumns({ 
//		@JoinColumn(name="EQUIPMENT_ID", referencedColumnName="EQUIPMENT_ID", insertable=false, updatable=false, nullable=true),
//		@JoinColumn(name="COMP_SEQ", referencedColumnName="COMP_SEQ", insertable=false, updatable=false, nullable=true)
//	})
//	private List<WorkHistory> history;
//
//	public List<WorkHistory> getHistory() {
//		return history;
//	}
//
//	public void setHistory(List<WorkHistory> history) {
//		this.history = history;
//	}

	public ProductionKey getId() {
		return id;
	}

	public void setId(ProductionKey id) {
		this.id = id;
	}

	public Timestamp getProductionDt() {
		return productionDt;
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
		return "Production [id=" + id + ", productionDt=" + productionDt + ", quantity=" + quantity + ", defective="
				+ defective + ", temperature=" + temperature + "]";
	}
}