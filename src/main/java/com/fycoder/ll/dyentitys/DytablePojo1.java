/*******************************************************************************
 * Copyright 2015 
 * Fycoder liuy
 * 
 * 		POJO1
 *******************************************************************************/
package com.fycoder.ll.dyentitys;



import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.ImmutableList;


public class DytablePojo1 {
	
	protected Long dyid;
	private String tablenameid;
	private int tabletype;
	private String tcolumnid;
	private String tcolumntype;
	private String tlineid;
	private String tlinevalue;//值


	public Long getDyid() {
		return dyid;
	}

	public void setDyid(Long dyid) {
		this.dyid = dyid;
	}

	public DytablePojo1() {
	}

	public DytablePojo1(Long dyid) {
		this.dyid = dyid;
	}




	public String getTablenameid() {
		return tablenameid;
	}

	public void setTablenameid(String tablenameid) {
		this.tablenameid = tablenameid;
	}

	public int getTabletype() {
		return tabletype;
	}

	public void setTabletype(int tabletype) {
		this.tabletype = tabletype;
	}

	public String getTcolumnid() {
		return tcolumnid;
	}

	public void setTcolumnid(String tcolumnid) {
		this.tcolumnid = tcolumnid;
	}

	public String getTcolumntype() {
		return tcolumntype;
	}

	public void setTcolumntype(String tcolumntype) {
		this.tcolumntype = tcolumntype;
	}

	public String getTlineid() {
		return tlineid;
	}

	public void setTlineid(String tlineid) {
		this.tlineid = tlineid;
	}

	public String getTlinevalue() {
		return tlinevalue;
	}

	public void setTlinevalue(String tlinevalue) {
		this.tlinevalue = tlinevalue;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	

}