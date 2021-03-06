/*******************************************************************************
 * Copyright 2015 
 * liuy
 * 索引表
 *******************************************************************************/
package com.fycoder.ll.dyentity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fycoder.ll.entity.IdEntity;
import com.google.common.collect.ImmutableList;

@Entity
@Table(name = "tls")
public class Tls extends IdEntity {
	
	private String tablename;
	//private String tablenameid; //唯一值	
	private int tabletype;//表的值     1 正式表 ， 2 选项表 
	private String tablenameremark;
	private int tablebakcol1;
	private int tablebakcol2;
	private String tablebakcol3;
	private String tablebakcol4;
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private String tcolumnid;	
//	private String tcolumnname;
//	private String tcolumntype; 
//	private String tcolumndefvalue;
//	private String tcolumnisnull;
//	private String tcolumnremark;
//	private int    tcolbak1;
//	private int    tcolbak2;
//	private String	tcolbak3;
//	private String	tcolbak4;
	
	public Tls() {
	}

	public Tls(Long id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
//	@Transient
//	@JsonIgnore
//	@NotBlank
//	public int getTableType() {
//		return tableType;
//	}

//	public String getTablenameid() {
//		return tablenameid;
//	}
//
//	public void setTablenameid(String tablenameid) {
//		this.tablenameid = tablenameid;
//	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public int getTabletype() {
		return tabletype;
	}

	public void setTabletype(int tabletype) {
		this.tabletype = tabletype;
	}

	public String getTablenameremark() {
		return tablenameremark;
	}

	public void setTablenameremark(String tablenameremark) {
		this.tablenameremark = tablenameremark;
	}

	public int getTablebakcol1() {
		return tablebakcol1;
	}

	public void setTablebakcol1(int tablebakcol1) {
		this.tablebakcol1 = tablebakcol1;
	}

	public int getTablebakcol2() {
		return tablebakcol2;
	}

	public void setTablebakcol2(int tablebakcol2) {
		this.tablebakcol2 = tablebakcol2;
	}

	public String getTablebakcol3() {
		return tablebakcol3;
	}

	public void setTablebakcol3(String tablebakcol3) {
		this.tablebakcol3 = tablebakcol3;
	}

	public String getTablebakcol4() {
		return tablebakcol4;
	}

	public void setTablebakcol4(String tablebakcol4) {
		this.tablebakcol4 = tablebakcol4;
	}


	
	
}