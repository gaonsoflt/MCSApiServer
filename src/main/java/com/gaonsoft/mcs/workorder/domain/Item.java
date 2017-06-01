package com.gaonsoft.mcs.workorder.domain;

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
@IdClass(ItemKey.class)
@Table(name="MA_ITEM_TB")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Item() {
		
	}
	
	@Id
	@Column(name="COMP_SEQ")
	private Long compSeq; 
	
	@Id
	@Column(name="ITEM_SEQ")
	private Long itemSeq;
	
	@Column(name="ITEM_Nm")
	private String itemName;

	@Column(name="ITEM_NO")
	private String itemNo;
	
	@Column(name="SPEC")
	private String spec;

	
	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public Long getCompSeq() {
		return compSeq;
	}

	public void setCompSeq(Long compSeq) {
		this.compSeq = compSeq;
	}

	public Long getItemSeq() {
		return itemSeq;
	}

	public void setItemSeq(Long itemSeq) {
		this.itemSeq = itemSeq;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public String toString() {
		return "Item [compSeq=" + compSeq + ", itemSeq=" + itemSeq + ", itemName=" + itemName + ", itemNo=" + itemNo
				+ ", spec=" + spec + "]";
	}
}