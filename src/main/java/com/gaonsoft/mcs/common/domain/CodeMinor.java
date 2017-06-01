package com.gaonsoft.mcs.common.domain;

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
@IdClass(CodeMinorKey.class)
@Table(name="CM_MINOR_TB")
public class CodeMinor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COMP_SEQ") 
	private Long compSeq;
	
	@Id
	@Column(name="MINOR_SEQ")
	private Long minorSeq;
	
	@Column(name="MAJOR_SEQ")
	private Long majorSeq;

	@Column(name="MINOR_NM")
	private String minorName;
	
	@Column(name="USE_YN")
	private Long useYn;

	@Column(name="DELIMITER")
	private String delimiter;
	
	public CodeMinor() {
		
	}
	
	public Long getMajorSeq() {
		return majorSeq;
	}

	public void setMajorSeq(Long majorSeq) {
		this.majorSeq = majorSeq;
	}

	public Long getCompSeq() {
		return compSeq;
	}

	public void setCompSeq(Long compSeq) {
		this.compSeq = compSeq;
	}

	public Long getMinorSeq() {
		return minorSeq;
	}

	public void setMinorSeq(Long minorSeq) {
		this.minorSeq = minorSeq;
	}

	public String getMinorName() {
		return minorName;
	}

	public void setMinorName(String minorName) {
		this.minorName = minorName;
	}

	public Long getUseYn() {
		return useYn;
	}

	public void setUseYn(Long useYn) {
		this.useYn = useYn;
	}

	public String getDelimiter() {
		return delimiter;
	}

	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}

	@Override
	public String toString() {
		return "CodeMinor [compSeq=" + compSeq + ", minorSeq=" + minorSeq + ", majorSeq=" + majorSeq + ", minorName="
				+ minorName + ", useYn=" + useYn + ", delimiter=" + delimiter + "]";
	}
}