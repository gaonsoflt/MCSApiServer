package com.gaonsoft.mcs.workorder.domain;

import java.io.Serializable;

public class ItemKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long compSeq; 
	private Long itemSeq;
	
	public ItemKey() {
	}
	
	public ItemKey(long compSeq, long itemSeq) {
		this.compSeq = compSeq;
		this.itemSeq = itemSeq;
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

	@Override
	public String toString() {
		return "ItemKey [compSeq=" + compSeq + ", itemSeq=" + itemSeq + "]";
	}
}
